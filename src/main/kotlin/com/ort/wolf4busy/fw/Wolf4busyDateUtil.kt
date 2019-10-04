package com.ort.wolf4busy.fw

import java.time.LocalDate
import java.time.LocalDateTime


class Wolf4busyDateUtil private constructor() {
    companion object {
        fun currentLocalDateTime(): LocalDateTime {
            return LocalDateTime.now()
        }

        fun currentLocalDate(): LocalDate {
            return LocalDate.now()
        }
    }
}