package com.ort.wolf4busy.fw.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class Wolf4busyBusinessException(override val message: String) : Exception() {
}