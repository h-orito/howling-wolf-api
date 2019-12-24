package com.ort.wolf4busy.domain.model.village.ability

import com.ort.wolf4busy.domain.model.ability.Ability

data class VillageAbility(
    val villageDayId: Int,
    val myselfId: Int, // 行使元villageParticipantId
    val targetId: Int?, // 行使先villageParticipantId
    val ability: Ability
) {
}