package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.ability.Abilities
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

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

    fun assertAbility(targetId: Int?, abilityType: String) {
        val available = list.find { it.type.code == abilityType } ?: throw Wolf4busyBusinessException("能力セットできません")
        if (targetId == null && !available.type.isAvailableNoTarget()) throw Wolf4busyBusinessException("能力セットできません")
        if (targetId != null && available.targetList.none { it.id == targetId }) throw Wolf4busyBusinessException("能力セットできません")
    }
}
