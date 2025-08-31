package com.ort.howlingwolf.api.body

import jakarta.validation.constraints.NotNull

data class VillageVoteBody(
    @field:NotNull(message = "対象IDは必須")
    val targetId: Int?
) {
    constructor() : this(null)
}
