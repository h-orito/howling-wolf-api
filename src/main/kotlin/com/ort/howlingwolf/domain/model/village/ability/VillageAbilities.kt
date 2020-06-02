package com.ort.howlingwolf.domain.model.village.ability

import com.ort.howlingwolf.domain.model.ability.Attack
import com.ort.howlingwolf.domain.model.ability.Divine
import com.ort.howlingwolf.domain.model.ability.Guard
import com.ort.howlingwolf.domain.model.village.Village

data class VillageAbilities(
    val list: List<VillageAbility>
) {

    // 日付更新時のデフォルト能力行使を追加
    fun addDefaultAbilities(village: Village): VillageAbilities {
        val abilityList = mutableListOf<VillageAbility>()
        abilityList.addAll(this.list)

        // 襲撃
        Attack.getDefaultAbility(village)?.let { abilityList.add(it) }
        // 占い
        val divineAbilityList = Divine.getDefaultAbilityList(village)
        if (divineAbilityList.isNotEmpty()) abilityList.addAll(divineAbilityList)
        // 護衛
        val guardAbilityList = Guard.getDefaultAbilityList(village)
        if (guardAbilityList.isNotEmpty()) abilityList.addAll(guardAbilityList)

        return VillageAbilities(abilityList)
    }

    fun existsDifference(abilities: VillageAbilities): Boolean {
        return list.size != abilities.list.size
    }
}