package com.ort.howlingwolf.domain.model.village.ability

import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageDay

data class VillageAbilities(
    val list: List<VillageAbility>
) {

    fun filterLatestday(village: Village): VillageAbilities = filterByDay(village.day.latestDay())

    fun filterYesterday(village: Village): VillageAbilities = filterByDay(village.day.yesterday())

    fun filterByType(abilityType: AbilityType): VillageAbilities {
        return this.copy(
            list = list.filter { it.abilityType.code == abilityType.code }
        )
    }

    fun existsDifference(abilities: VillageAbilities): Boolean {
        return list.size != abilities.list.size
    }

    fun add(ability: VillageAbility): VillageAbilities {
        return this.copy(list = list + ability)
    }

    fun addAll(abilityList: List<VillageAbility>): VillageAbilities {
        if (abilityList.isEmpty()) return this
        return this.copy(list = list + abilityList)
    }

    private fun filterByDay(villageDay: VillageDay): VillageAbilities {
        return this.copy(
            list = list.filter { it.villageDayId == villageDay.id }
        )
    }
}