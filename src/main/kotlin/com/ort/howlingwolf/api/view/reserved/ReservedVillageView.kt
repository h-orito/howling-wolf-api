package com.ort.howlingwolf.api.view.reserved

import com.ort.howlingwolf.domain.model.reserved.ReservedVillage
import java.time.LocalDateTime
import java.time.LocalTime

data class ReservedVillageView(
    val id: Int,
    val villageCreateDatetime: LocalDateTime,
    val villageStartDatetime: LocalDateTime,
    val organization: String,
    val silentHours: Int,
    val sayableStart: LocalTime,
    val sayableEnd: LocalTime,
    val availableDummySkill: Boolean
) {
    constructor(
        reservedVillage: ReservedVillage
    ) : this(
        id = reservedVillage.id,
        villageCreateDatetime = reservedVillage.villageCreateDatetime,
        villageStartDatetime = reservedVillage.villageStartDatetime,
        organization = reservedVillage.organization,
        silentHours = reservedVillage.silentHours,
        sayableStart = reservedVillage.villageStartDatetime.plusHours(reservedVillage.silentHours.toLong()).toLocalTime(),
        sayableEnd = reservedVillage.villageStartDatetime.toLocalTime(),
        availableDummySkill = reservedVillage.availableDummySkill
    )
}