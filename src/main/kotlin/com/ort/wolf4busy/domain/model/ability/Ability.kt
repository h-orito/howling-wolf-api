package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

class Ability(
    val code: String,
    val name: String
) {
    // 選択可能な対象
    fun getSelectableTargetList(village: Village, participant: VillageParticipant?): List<VillageParticipant> {
        if (!canUseAbility(village, participant)) return listOf()

        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.getSelectableTargetList(village, participant)
            CDef.AbilityType.占い.code() -> Divine.getSelectableTargetList(village, participant)
            CDef.AbilityType.護衛.code() -> Guard.getSelectableTargetList(village, participant)
            else -> listOf()
        }
    }

    // 選択中の対象
    fun getSelectingTarget(village: Village, participant: VillageParticipant?, villageAbilities: VillageAbilities): VillageParticipant? {
        if (!canUseAbility(village, participant)) return null

        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.getSelectingTarget(village, participant, villageAbilities)
            CDef.AbilityType.占い.code() -> Divine.getSelectingTarget(village, participant, villageAbilities)
            CDef.AbilityType.護衛.code() -> Guard.getSelectingTarget(village, participant, villageAbilities)
            else -> null
        }
    }

    // 能力セット時のシステムメッセージ
    fun getAbilitySetMessage(myChara: Chara, targetChara: Chara?): String {
        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.getSetMessage(myChara, targetChara)
            CDef.AbilityType.占い.code() -> Divine.getSetMessage(myChara, targetChara)
            CDef.AbilityType.護衛.code() -> Guard.getSetMessage(myChara, targetChara)
            else -> throw IllegalStateException("想定外の能力")
        }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun canUseAbility(village: Village, participant: VillageParticipant?): Boolean {
        participant ?: return false
        if (!village.status.isProgress()) return false
        return !participant.isSpectator
    }
}