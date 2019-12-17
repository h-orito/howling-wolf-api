package com.ort.wolf4busy.api.body

import javax.validation.constraints.NotNull

data class VillageVoteBody(
    @field:NotNull(message = "対象IDは必須")
    val targetId: Int?
) {
    constructor() : this(null)
}
