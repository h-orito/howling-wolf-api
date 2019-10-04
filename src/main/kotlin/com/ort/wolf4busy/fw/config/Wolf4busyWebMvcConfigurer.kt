package com.ort.wolf4busy.fw.config

import com.ort.wolf4busy.fw.interceptor.Wolf4busyAccessContextInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class Wolf4busyWebMvcConfigurer : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry!!.addInterceptor(Wolf4busyAccessContextInterceptor()).addPathPatterns("/**")
    }
}