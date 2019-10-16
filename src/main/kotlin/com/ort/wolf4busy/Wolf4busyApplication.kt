package com.ort.wolf4busy

import com.ort.dbflute.allcommon.DBFluteBeansJavaConfig
import com.ort.wolf4busy.fw.config.FirebaseConfig
import com.ort.wolf4busy.fw.config.Wolf4busyAppConfig
import com.ort.wolf4busy.fw.config.Wolf4busyWebMvcConfigurer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(DBFluteBeansJavaConfig::class, Wolf4busyAppConfig::class, Wolf4busyWebMvcConfigurer::class, FirebaseConfig::class)
class Wolf4busyApplication

fun main(args: Array<String>) {
    runApplication<Wolf4busyApplication>(*args)
}