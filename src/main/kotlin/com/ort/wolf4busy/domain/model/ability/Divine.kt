package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object Divine {

    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        // 自分以外の生存者全員
        return village.participant.memberList.filter {
            it.id != participant.id && it.alive()
        }
    }

    fun getSelectingTarget(village: Village, participant: VillageParticipant?, villageAbilities: VillageAbilities): VillageParticipant? {
        participant ?: return null

        val targetVillageParticipantId = villageAbilities.list.find {
            it.villageDayId == village.day.latestDay().id
                    && it.ability.code == CDef.AbilityType.占い.code()
                    && it.myselfId == participant.id
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.memberList.find { it.id == targetVillageParticipantId }
    }
}