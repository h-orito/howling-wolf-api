package com.ort.howlingwolf.domain.model.reserved

import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import java.time.LocalDateTime

data class ReservedVillage(
    val id: Int,
    val villageCreateDatetime: LocalDateTime,
    val villageStartDatetime: LocalDateTime,
    val organization: String,
    val silentHours: Int,
    val availableDummySkill: Boolean,
    val forBeginner: Boolean
) {
    fun shouldCreate(): Boolean = villageCreateDatetime.isBefore(HowlingWolfDateUtil.currentLocalDateTime())
}