package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.ability.Abilities
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageAbilitySituations(
    val list: List<VillageAbilitySituation>
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        abilities: VillageAbilities
    ) : this(
        list = convertToAbilityList(village, participant, abilities)
    )

    companion object {

        private fun convertToAbilityList(
            village: Village,
            participant: VillageParticipant?,
            villageAbilities: VillageAbilities
        ): List<VillageAbilitySituation> {
            participant?.skill ?: return listOf()
            val abilities = Abilities(participant.skill)
            return abilities.list.map {
                VillageAbilitySituation(
                    village, participant, it, villageAbilities
                )
            }
        }
    }

    fun isSettableAbility(targetId: Int?, abilityType: String): Boolean {
        val situation = list.find { it.type.code == abilityType } ?: return false
        return if (targetId == null) return situation.type.isAvailableNoTarget()
        else situation.targetList.any { it.id == targetId }
    }
}
