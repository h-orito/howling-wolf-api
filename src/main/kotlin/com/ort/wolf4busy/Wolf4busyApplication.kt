package com.ort.wolf4busy

import com.ort.dbflute.allcommon.DBFluteBeansJavaConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(DBFluteBeansJavaConfig::class)
class Wolf4busyApplication {

    // @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(Wolf4busyApplication::class.java, *args)
    }
}
