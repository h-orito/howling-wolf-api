package com.ort.howlingwolf.fw.config

import com.ort.howlingwolf.fw.interceptor.HowlingWolfAccessContextInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class HowlingWolfWebMvcConfigurer : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(HowlingWolfAccessContextInterceptor()).addPathPatterns("/**")
    }
}