package com.ort.howlingwolf.fw

import java.time.LocalDate
import java.time.LocalDateTime


class HowlingWolfDateUtil private constructor() {
    companion object {
        fun currentLocalDateTime(): LocalDateTime {
            return LocalDateTime.now()
        }

        fun currentLocalDate(): LocalDate {
            return LocalDate.now()
        }
    }
}