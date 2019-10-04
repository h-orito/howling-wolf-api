package com.ort.wolf4busy.fw.config


import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.format.DateTimeFormatter


@Configuration
class Wolf4busyAppConfig {

    /**
     * レスポンスのプロパティのスネークケース変換、日時のフォーマットを行う
     * see http://www.ne.jp/asahi/hishidama/home/tech/java/spring/boot/rest/jackson.html
     */
    @Bean
    fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
        val builder = Jackson2ObjectMapperBuilder()
        builder.simpleDateFormat(dateTimeFormat)
        builder.serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)))
        builder.serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
        builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        return builder
    }

    companion object {

        const val dateFormat = "yyyy/MM/dd"
        const val dateTimeFormat = "yyyy/MM/dd HH:mm:ss"
    }
}
