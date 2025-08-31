package com.ort.howlingwolf

import com.ort.dbflute.allcommon.DBFluteBeansJavaConfig
import com.ort.howlingwolf.fw.config.FirebaseConfig
import com.ort.howlingwolf.fw.config.HowlingWolfAppConfig
import com.ort.howlingwolf.fw.config.HowlingWolfWebMvcConfigurer
import com.ort.howlingwolf.fw.security.HowlingWolfSecurityConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
    DBFluteBeansJavaConfig::class,
    HowlingWolfAppConfig::class,
    HowlingWolfWebMvcConfigurer::class,
    FirebaseConfig::class,
    HowlingWolfSecurityConfig::class
)
class HowlingWolfApplication

fun main(args: Array<String>) {
    runApplication<HowlingWolfApplication>(*args)
}