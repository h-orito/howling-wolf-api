package com.ort.howlingwolf.fw.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class HowlingWolfBadRequestException(override val message: String) : RuntimeException() {
}