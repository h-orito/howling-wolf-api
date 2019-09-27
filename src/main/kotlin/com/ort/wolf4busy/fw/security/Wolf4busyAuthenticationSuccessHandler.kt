package com.ort.wolf4busy.fw.security

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Wolf4busyAuthenticationSuccessHandler : AuthenticationSuccessHandler {

    private val logger = LoggerFactory.getLogger(Wolf4busyAuthenticationSuccessHandler::class.java)

    // 200を返すだけ
    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(request: HttpServletRequest,
                                         response: HttpServletResponse,
                                         auth: Authentication) {
        if (response.isCommitted) {
            logger.info("Response has already been committed.")
            return
        }

        response.status = HttpStatus.OK.value()
        clearAuthenticationAttributes(request)
    }

    /**
     * Removes temporary authentication-related data which may have been stored in the
     * session during the authentication process.
     */
    private fun clearAuthenticationAttributes(request: HttpServletRequest) {
        val session = request.getSession(false) ?: return

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)
    }
}
