package com.ort.howlingwolf.api.body

import jakarta.validation.constraints.NotNull

data class VillageSayBody(
    @field:NotNull(message = "発言内容は必須")
    val message: String?,

    @field:NotNull(message = "発言種別は必須")
    val messageType: String?,

    @field:NotNull(message = "表情種別は必須")
    val faceType: String?
) {
    constructor() : this(null, null, null)
}
