package com.ort.howlingwolf.fw.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        var body = body
        if (body !is HowlingWolfErrorResponse) {
            body = HowlingWolfErrorResponse(statusCode.value(), "Error occurred")
        }
        return ResponseEntity(body, headers, statusCode)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val message = ex.bindingResult.allErrors.mapNotNull { it.defaultMessage }.joinToString("\n")
        val newHeaders = HttpHeaders()
        val body = HowlingWolfErrorResponse(499, message)
        val statusCode = HttpStatusCode.valueOf(404)
        return handleExceptionInternal(ex, body, newHeaders, statusCode, request)
    }

    @ExceptionHandler(HowlingWolfBusinessException::class)
    fun handleBusinessException(ex: HowlingWolfBusinessException, request: WebRequest?): ResponseEntity<Any>? {
        val headers = HttpHeaders()
        val body = HowlingWolfErrorResponse(499, ex.message)
        val statusCode = HttpStatus.NOT_FOUND // dummy
        return handleExceptionInternal(ex, body, headers, statusCode, request!!)
    }

    @ExceptionHandler(HowlingWolfBadRequestException::class)
    fun handle400(ex: HowlingWolfBadRequestException, request: WebRequest?): ResponseEntity<Any>? {
        val headers = HttpHeaders()
        val body = HowlingWolfErrorResponse(400, ex.message)
        val statusCode = HttpStatus.BAD_REQUEST
        return handleExceptionInternal(ex, body, headers, statusCode, request!!)
    }

    @ExceptionHandler(Exception::class)
    fun handle500(ex: Exception, request: WebRequest?): ResponseEntity<Any>? {
        val headers = HttpHeaders()
        val body = null
        val statusCode = HttpStatus.INTERNAL_SERVER_ERROR
        return handleExceptionInternal(ex, body, headers, statusCode, request!!)
    }
}