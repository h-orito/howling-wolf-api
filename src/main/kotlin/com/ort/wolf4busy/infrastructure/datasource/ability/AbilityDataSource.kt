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
    fun selectAbilities(villageId: Int): VillageAbilities {
        val abilityList = abilityBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageAbilities(abilityList.map { convertToAbilityToVillageAbility(it) })
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    fun updateAbility(villageDayId: Int, myselfId: Int, targetId: Int?, abilityType: String) {
        deleteAbility(villageDayId, myselfId, targetId, abilityType)
        insertAbility(villageDayId, myselfId, targetId, abilityType)
    }

    private fun deleteAbility(villageDayId: Int, myselfId: Int, targetId: Int?, abilityType: String) {
        abilityBhv.queryDelete {
            it.query().setVillageDayId_Equal(villageDayId)
            if (abilityType != CDef.AbilityType.襲撃.code()) {
                it.query().setVillagePlayerId_Equal(myselfId)
            }
            it.query().setTargetVillagePlayerId_Equal(targetId)
            it.query().setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType.codeOf(abilityType))
        }
    }

    private fun insertAbility(villageDayId: Int, myselfId: Int, targetId: Int?, abilityType: String) {
        val ability = Ability()
        ability.villageDayId = villageDayId
        ability.villagePlayerId = myselfId
        ability.targetVillagePlayerId = targetId
        ability.abilityTypeCodeAsAbilityType = CDef.AbilityType.codeOf(abilityType)
        abilityBhv.insert(ability)
    }

    fun updateDifference(before: VillageAbilities, after: VillageAbilities) {
        after.list.drop(before.list.size).forEach {
            insertAbility(
                villageDayId = it.villageDayId,
                myselfId = it.myselfId,
                targetId = it.targetId,
                abilityType = it.ability.code
            )
        }
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