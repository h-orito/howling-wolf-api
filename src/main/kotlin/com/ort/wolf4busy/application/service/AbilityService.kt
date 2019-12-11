package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.infrastructure.datasource.ability.AbilityDataSource
import org.springframework.stereotype.Service

@Service
class AbilityService(
    val abilityDataSource: AbilityDataSource
) {

    fun findVillageAbilities(villageId: Int): VillageAbilities {
        return abilityDataSource.selectAbilities(villageId)
    }
}
