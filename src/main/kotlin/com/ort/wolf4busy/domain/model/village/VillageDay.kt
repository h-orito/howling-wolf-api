package com.ort.wolf4busy.domain.model.village

import java.time.LocalDateTime

data class VillageDay(
    val id: Int,
    val day: Int,
    val noonnight: String,
    val dayChangeDatetime: LocalDateTime,
    val isUpdating: Boolean,
    val isPrologue: Boolean = false,
    val isEpilogue: Boolean = false
) {
}