package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class VillageAbilityBody(
    val targetId: Int?,

    @field:NotNull(message = "能力種別は必須")
    val abilityType: String?
) {
    constructor() : this(null, null)
}
