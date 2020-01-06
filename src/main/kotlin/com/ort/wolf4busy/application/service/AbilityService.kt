package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.infrastructure.datasource.ability.AbilityDataSource
import org.springframework.stereotype.Service

@Service
class AbilityService(
    val abilityDataSource: AbilityDataSource
) {

    fun findVillageAbilities(villageId: Int): VillageAbilities {
        return abilityDataSource.selectAbilities(villageId)
    }

    /**
     * 能力セット
     *
     * @param villageDayId 村日付id
     * @param participant 村参加者
     * @param targetId 対象村参加者id
     * @param abilityType 能力種別
     */
    fun updateAbility(villageDayId: Int, participant: VillageParticipant, targetId: Int?, abilityType: String) {
        abilityDataSource.updateAbility(villageDayId, participant.id, targetId, abilityType)
    }

    fun updateDifference(before: VillageAbilities, after: VillageAbilities) {
        abilityDataSource.updateDifference(before, after)
    }
}
