package com.ort.howlingwolf.api.body

import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class ReservedVillageRegisterBody(
    @field:NotNull(message = "構成は必須")
    val organization: String?,

    @field:NotNull(message = "作成日時は必須")
    val createDatetime: LocalDateTime?,

    @field:NotNull(message = "開始日時は必須")
    val startDatetime: LocalDateTime?,

    @field:NotNull(message = "沈黙時間は必須")
    val silentHours: Int?
) {
    constructor() : this(null, null, null, null)
}
