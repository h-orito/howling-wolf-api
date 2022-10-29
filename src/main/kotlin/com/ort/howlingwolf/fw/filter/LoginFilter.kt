package com.ort.howlingwolf.fw.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.firebase.auth.FirebaseAuth
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import com.ort.howlingwolf.fw.security.HowlingWolfUserDetailService
import com.ort.howlingwolf.fw.security.getIpAddress
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwsHeader
import io.jsonwebtoken.SigningKeyResolverAdapter
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.filter.OncePerRequestFilter
import java.io.ByteArrayInputStream
import java.security.Key
import java.security.cert.CertificateFactory
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * see https://qiita.com/mr-hisa-child/items/5ed2ae2fe4c86d4bb5c7
 */
@Component
class LoginFilter(
    private val userService: HowlingWolfUserDetailService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest, response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        // コンテキストにログインユーザ情報をセット
        val token = PreAuthenticatedAuthenticationToken(auth(request), null)
        SecurityContextHolder.getContext().authentication = token
        filterChain.doFilter(request, response)
    }

    // ログインユーザ情報を取得
    private fun auth(request: HttpServletRequest): UserDetails? {

        // リクエストヘッダからJWTを取り出す
        val token: String? = getToken(request)
        token ?: return null

        try {
            // JWTを検証、uid取得
            val uid: String? = FirebaseAuth.getInstance().verifyIdToken(token)?.uid
            uid ?: throw BadCredentialsException("改竄リクエストまたはトークン有効期限切れです")

            // ユーザ情報を検索
            return try {
                val user: HowlingWolfUser = userService.loadUserByUsername(uid) as HowlingWolfUser
                val clientToken = getClientToken(request)
                user.copy(
                    ipAddress = request.getIpAddress(),
                    clientToken = clientToken
                )
            } catch (e: UsernameNotFoundException) {
                // uidまで取得できているのでユーザを新規作成
                userService.insertUser(uid)
            }
        } catch (e: Exception) {
            throw BadCredentialsException(e.message, e)
        }
    }

    private fun getClientToken(request: HttpServletRequest): String? {
        val clientToken = request.getHeader("Client")
        if (clientToken == null || !clientToken.startsWith("Client ")) {
            return null
        }
        return clientToken.substring("Client ".length)
    }

    // リクエストヘッダからトークンを取得
    private fun getToken(request: HttpServletRequest): String? {
        val token: String? = request.getHeader("Authorization")
        if (token == null || !token.startsWith("Bearer ")) {
            return null
        }
        return token.substring("Bearer ".length)
    }

    /**
     * 署名に利用する公開鍵を返却
     */
    open class GoogleSigningKeyResolver(
        private val objectMapper: ObjectMapper
    ) : SigningKeyResolverAdapter() {

        private val TOKEN_URL: String =
            "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com"

        override fun resolveSigningKey(jwsHeader: JwsHeader<*>, claims: Claims): Key? {

            try {
                val map: Map<String, String> = getJwks()

                if (map.isEmpty()) {
                    return null
                }

                var keyValue: String? = map[jwsHeader.getKeyId()]
                keyValue ?: return null

                // 開始（BEGIN）と終了（END）のラベルを除去する。
                keyValue = keyValue
                    .replace("-----BEGIN CERTIFICATE-----\n", "")
                    .replace("-----END CERTIFICATE-----\n", "")
                    .replace("\n", "")
                val inputStream = ByteArrayInputStream(Base64.getDecoder().decode(keyValue.toByteArray()))
                val certificate = CertificateFactory.getInstance("X.509")
                    .generateCertificate(inputStream)
                return certificate.publicKey
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }

        /**
         * GoogleからJWKSを取得
         *
         * @return JWKS
         */
        private fun getJwks(): Map<String, String> {
            val restTemplate = RestTemplate()
            val response: String? = restTemplate.getForObject(TOKEN_URL, String::class)
            response ?: throw IllegalStateException("failed to call google api.")
            return objectMapper.readValue(response, HashMap<String, String>()::class.java)
        }
    }
}