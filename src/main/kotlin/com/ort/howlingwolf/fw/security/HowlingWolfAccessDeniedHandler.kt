package com.ort.howlingwolf.fw.security

import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.web.access.AccessDeniedHandler
import java.io.IOException

class HowlingWolfAccessDeniedHandler : AccessDeniedHandler {

    // 403とデフォルトメッセージを返すだけにしておく
    @Throws(IOException::class, ServletException::class)
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        exception: org.springframework.security.access.AccessDeniedException
    ) {
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.reasonPhrase)
    }
}
