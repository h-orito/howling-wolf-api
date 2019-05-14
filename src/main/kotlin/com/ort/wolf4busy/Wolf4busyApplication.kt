package com.ort.wolf4busy

import com.ort.dbflute.allcommon.DBFluteBeansJavaConfig
import com.ort.wolf4busy.fw.Wolf4busyAppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(DBFluteBeansJavaConfig::class, Wolf4busyAppConfig::class)
class Wolf4busyApplication

fun main(args: Array<String>) {
    runApplication<Wolf4busyApplication>(*args)
}


