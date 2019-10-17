package com.ort.wolf4busy.domain.model.message

import java.time.LocalDateTime

data class MessageTime(
    val day: Int,
    val datetime: LocalDateTime,
    val unixtimeMilli: Long
) {
}