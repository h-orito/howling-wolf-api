package com.ort.wolf4busy.domain.model.village.action

data class VillageSayRestrictSituation(
    val maxCount: Int,
    val remainingCount: Int,
    val maxLength: Int
) {
}
