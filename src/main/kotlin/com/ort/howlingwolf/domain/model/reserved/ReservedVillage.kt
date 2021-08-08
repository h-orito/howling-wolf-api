package com.ort.howlingwolf.domain.model.reserved

import java.time.LocalTime

data class ReservedVillage(
    val startTime: LocalTime,
    val organization: String,
    val silentHours: Int,
    val availableDummySkill: Boolean,
    val forBeginner: Boolean
)