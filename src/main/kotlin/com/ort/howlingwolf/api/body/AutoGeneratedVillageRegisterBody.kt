package com.ort.howlingwolf.api.body

import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class AutoGeneratedVillageRegisterBody(
    @field:NotNull(message = "構成は必須")
    val organization: String?,

    @field:NotNull(message = "開始日時は必須")
    val startDatetime: LocalDateTime?,

    val silentHours: Int?
) {
    constructor() : this(null, null, null) {}
}