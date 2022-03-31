package com.ort.howlingwolf.api.controller

import org.springframework.core.annotation.Order
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.InitBinder


@ControllerAdvice
@Order(10000)
class GlobalControllerAdvice {

    @InitBinder
    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("class.*", "Class.*", "*.class.*", "*.Class.*")
    }
}