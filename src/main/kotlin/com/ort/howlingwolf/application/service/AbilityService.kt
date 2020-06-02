package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.infrastructure.datasource.ability.AbilityDataSource
import org.springframework.stereotype.Service

@Service
class AbilityService(
    val abilityDataSource: AbilityDataSource
) {

    fun findVillageAbilities(villageId: Int): VillageAbilities = abilityDataSource.findAbilities(villageId)

    /**
     * 能力セット
     * @param villageAbility ability
     */
    fun updateAbility(villageAbility: VillageAbility) = abilityDataSource.updateAbility(villageAbility)

    fun updateDifference(before: VillageAbilities, after: VillageAbilities) = abilityDataSource.updateDifference(before, after)
}
