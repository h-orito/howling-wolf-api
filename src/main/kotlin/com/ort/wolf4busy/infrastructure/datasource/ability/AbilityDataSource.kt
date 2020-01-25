package com.ort.wolf4busy.infrastructure.datasource.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.AbilityBhv
import com.ort.dbflute.exentity.Ability
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import org.springframework.stereotype.Repository

@Repository
class AbilityDataSource(
    val abilityBhv: AbilityBhv
) {

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    fun findAbilities(villageId: Int): VillageAbilities {
        val abilityList = abilityBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageAbilities(abilityList.map { convertToAbilityToVillageAbility(it) })
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    fun updateAbility(villageAbility: VillageAbility) {
        deleteAbility(villageAbility)
        insertAbility(villageAbility)
    }

    fun updateDifference(before: VillageAbilities, after: VillageAbilities) {
        after.list.drop(before.list.size).forEach {
            insertAbility(it)
        }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun deleteAbility(villageAbility: VillageAbility) {
        abilityBhv.queryDelete {
            it.query().setVillageDayId_Equal(villageAbility.villageDayId)
            if (villageAbility.ability.toCdef() != CDef.AbilityType.襲撃) {
                it.query().setVillagePlayerId_Equal(villageAbility.myselfId)
            }
            it.query().setAbilityTypeCode_Equal_AsAbilityType(villageAbility.ability.toCdef())
        }
    }

    private fun insertAbility(villageAbility: VillageAbility) {
        val ability = Ability()
        ability.villageDayId = villageAbility.villageDayId
        ability.villagePlayerId = villageAbility.myselfId
        ability.targetVillagePlayerId = villageAbility.targetId
        ability.abilityTypeCodeAsAbilityType = villageAbility.ability.toCdef()
        abilityBhv.insert(ability)
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertToAbilityToVillageAbility(ability: Ability): VillageAbility {
        return VillageAbility(
            villageDayId = ability.villageDayId,
            myselfId = ability.villagePlayerId,
            targetId = ability.targetVillagePlayerId,
            ability = com.ort.wolf4busy.domain.model.ability.Ability(ability.abilityTypeCodeAsAbilityType)
        )
    }
}