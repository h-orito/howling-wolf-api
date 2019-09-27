package com.ort.wolf4busy.fw.security

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Wolf4busyAuthenticationFailureHandler : AuthenticationFailureHandler {

    // 403とデフォルトメッセージを返すだけ
    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(request: HttpServletRequest,
                                         response: HttpServletResponse,
                                         exception: AuthenticationException) {
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.reasonPhrase)
    }
}
