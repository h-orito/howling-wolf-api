package com.ort.howlingwolf.api.body

import jakarta.validation.constraints.NotNull

data class VillageCommitBody(
    @field:NotNull(message = "コミット有無は必須")
    val commit: Boolean?
) {
    constructor() : this(null)
}
