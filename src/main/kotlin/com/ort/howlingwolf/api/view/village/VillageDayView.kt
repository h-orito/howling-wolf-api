package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.domain.model.village.VillageDay
import java.time.LocalDateTime
import java.time.LocalTime

data class VillageDayView(
    val id: Int,
    val day: Int,
    val noonnight: String,
    val startDatetime: LocalDateTime,
    val dayChangeDatetime: LocalDateTime,
    val sayableStartTime: LocalTime
) {

    constructor(
        villageDay: VillageDay,
        silentHours: Int?
    ): this(
        id = villageDay.id,
        day = villageDay.day,
        noonnight = villageDay.noonnight,
        startDatetime = villageDay.startDatetime,
        dayChangeDatetime = villageDay.dayChangeDatetime,
        sayableStartTime =
            if (silentHours == null) villageDay.startDatetime.toLocalTime()
            else villageDay.startDatetime.plusHours(silentHours.toLong()).toLocalTime()
    )
}