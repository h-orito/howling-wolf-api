package com.ort.wolf4busy.domain.model.message

import java.time.LocalDateTime

data class MessageTime(
    val villageDayId: Int,
    val datetime: LocalDateTime,
    val unixTimeMilli: Long
) {
}