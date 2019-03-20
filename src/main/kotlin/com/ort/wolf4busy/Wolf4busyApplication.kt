package com.ort.wolf4busy

import com.ort.dbflute.allcommon.DBFluteBeansJavaConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@EnableAutoConfiguration
@ComponentScan
@Import(DBFluteBeansJavaConfig::class)
class Wolf4busyApplication

fun main(args: Array<String>) {
	runApplication<Wolf4busyApplication>(*args)
}
