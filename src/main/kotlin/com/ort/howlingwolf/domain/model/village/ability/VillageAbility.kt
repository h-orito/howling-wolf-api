package com.ort.howlingwolf.domain.model.village.ability

import com.ort.howlingwolf.domain.model.ability.Ability

data class VillageAbility(
    val villageDayId: Int,
    val myselfId: Int,
    val targetId: Int?,
    val ability: Ability
) {
}