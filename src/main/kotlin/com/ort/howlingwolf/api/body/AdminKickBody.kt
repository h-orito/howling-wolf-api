package com.ort.howlingwolf.api.body

import org.jetbrains.annotations.NotNull

data class AdminKickBody(
    @field:NotNull
    var targetId: Int? = null
)