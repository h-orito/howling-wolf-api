package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class AdminParticipateBody(
    @field:NotNull(message = "participate_countは必須")
    val participateCount: Int?
) {
    constructor() : this(null) {}
}
