package com.ort.howlingwolf.api.view.reserved

import com.ort.howlingwolf.domain.model.reserved.ReservedVillage
import java.time.LocalTime

data class ReservedVillageView(
    val startTime: LocalTime,
    val organization: String,
    val silentHours: Int,
    val sayableStart: LocalTime,
    val sayableEnd: LocalTime,
    val availableDummySkill: Boolean,
    val forBeginner: Boolean
) {
    constructor(
        reservedVillage: ReservedVillage
    ) : this(
        startTime = reservedVillage.startTime,
        organization = reservedVillage.organization,
        silentHours = reservedVillage.silentHours,
        sayableStart = reservedVillage.startTime.plusHours(reservedVillage.silentHours.toLong()),
        sayableEnd = reservedVillage.startTime,
        availableDummySkill = reservedVillage.availableDummySkill,
        forBeginner = reservedVillage.forBeginner
    )
}