package com.ort.howlingwolf.domain.model.myself.participant

data class VillageSayRestrictSituation(
    val isRestricted: Boolean,
    val maxCount: Int?,
    val remainingCount: Int?,
    val maxLength: Int,
    val maxLine: Int
)
