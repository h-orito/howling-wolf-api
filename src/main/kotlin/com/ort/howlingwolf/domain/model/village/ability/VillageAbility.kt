package com.ort.howlingwolf.domain.model.village.ability

import com.ort.howlingwolf.domain.model.ability.AbilityType

data class VillageAbility(
    val villageDayId: Int,
    val myselfId: Int,
    val targetId: Int?,
    val abilityType: AbilityType
) {
}