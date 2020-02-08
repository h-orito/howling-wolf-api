package com.ort.howlingwolf.fw.security

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HowlingWolfAuthenticationEntryPoint : AuthenticationEntryPoint {

    private val logger = LoggerFactory.getLogger(HowlingWolfAuthenticationEntryPoint::class.java)

    // 401とデフォルトメッセージを返すだけにしておく
    @Throws(IOException::class, ServletException::class)
    override fun commence(request: HttpServletRequest,
                          response: HttpServletResponse,
                          exception: AuthenticationException) {
        if (response.isCommitted) {
            logger.info("Response has already been committed.")
            return
        }
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.reasonPhrase)
    }
}
