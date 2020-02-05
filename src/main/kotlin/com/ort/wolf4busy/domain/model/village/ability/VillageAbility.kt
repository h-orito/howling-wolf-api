package com.ort.wolf4busy.domain.model.village.ability

import com.ort.wolf4busy.domain.model.ability.Ability

data class VillageAbility(
    val villageDayId: Int,
    val myselfId: Int,
    val targetId: Int?,
    val ability: Ability
) {
}