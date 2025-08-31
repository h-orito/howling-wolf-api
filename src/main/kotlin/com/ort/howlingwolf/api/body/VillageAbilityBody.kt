package com.ort.howlingwolf.api.body

import jakarta.validation.constraints.NotNull

data class VillageAbilityBody(
    val myselfId: Int? = null,
    val targetId: Int? = null,

    @field:NotNull(message = "能力種別は必須")
    val abilityType: String? = null
)
