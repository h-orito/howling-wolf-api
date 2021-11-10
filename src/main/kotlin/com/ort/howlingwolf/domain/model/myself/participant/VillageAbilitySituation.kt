package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageAbilitySituation(
    val type: AbilityType,
    val attackerList: List<VillageParticipant>,
    val attacker: VillageParticipant?,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant?,
    val usable: Boolean,
    val isAvailableNoTarget: Boolean
)
