package com.ort.wolf4busy.fw.security

import com.ort.dbflute.exbhv.PlayerBhv
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class Wolf4busyCustomAuthenticationProvider(
        private val playerBhv: PlayerBhv
) : AuthenticationProvider {

    private val logger = LoggerFactory.getLogger(AuthenticationProvider::class.java)

    override fun authenticate(authentication: Authentication?): Authentication {
        val principal: Wolf4busyPrincipal? = authentication?.principal as Wolf4busyPrincipal

        principal ?: throw BadCredentialsException("認証情報がありません")

        val optPlayer = playerBhv.selectEntity { cb -> cb.query().setPlayerName_Equal(principal.username) }

        if (!optPlayer.isPresent) throw BadCredentialsException("ユーザが存在しません")

        val player = optPlayer.get()


        if (!BCryptPasswordEncoder().matches(principal.password, player.playerPassword)) {
            throw BadCredentialsException("パスワードが間違っています")
        }

        val user: Wolf4busyUser = Wolf4busyUser(
                userName = player.playerName,
                pass = player.playerPassword,
                authority = player.authorityCodeAsAuthority
        )

        return UsernamePasswordAuthenticationToken(
                user,
                principal.password,
                mutableListOf(SimpleGrantedAuthority(user.authority.code()))
        )
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}