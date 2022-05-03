package com.ort.howlingwolf.domain.model.village

import java.time.LocalDateTime

data class VillageDay(
    val id: Int,
    val day: Int,
    val noonnight: String,
    val startDatetime: LocalDateTime,
    val dayChangeDatetime: LocalDateTime
) {

    fun existsDifference(villageDay: VillageDay): Boolean {
        return day != villageDay.day
            || noonnight != villageDay.noonnight
            || dayChangeDatetime != villageDay.dayChangeDatetime
    }
}