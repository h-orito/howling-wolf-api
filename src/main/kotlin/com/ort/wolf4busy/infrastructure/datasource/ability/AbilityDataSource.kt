package com.ort.wolf4busy.infrastructure.datasource.ability

import com.ort.dbflute.exbhv.AbilityBhv
import com.ort.dbflute.exentity.Ability
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import org.springframework.stereotype.Repository

@Repository
class AbilityDataSource(
    val abilityBhv: AbilityBhv
) {

    fun selectAbilities(villageId: Int): VillageAbilities {
        val abilityList = abilityBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageAbilities(abilityList.map { convertToAbilityToVillageAbility(it) })
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertToAbilityToVillageAbility(ability: Ability): VillageAbility {
        return VillageAbility(
            villageDayId = ability.villageDayId,
            myselfId = ability.villagePlayerId,
            targetId = ability.targetVillagePlayerId,
            ability = com.ort.wolf4busy.domain.model.ability.Ability(
                code = ability.abilityTypeCodeAsAbilityType.code(),
                name = ability.abilityTypeCodeAsAbilityType.alias()
            )
        )
    }
}