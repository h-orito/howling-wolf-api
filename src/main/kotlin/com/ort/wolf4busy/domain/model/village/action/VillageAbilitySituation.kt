package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageAbilitySituation(
    val type: Ability,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant
) {
}
