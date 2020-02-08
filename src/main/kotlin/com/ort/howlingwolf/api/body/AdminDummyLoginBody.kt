package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class AdminDummyLoginBody(
    @field:NotNull(message = "targetIdは必須")
    val targetId: Int?
) {
    constructor() : this(null) {}
}
