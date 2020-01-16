package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

class Ability(
    val code: String,
    val name: String
) {

    constructor(
        cdefAbilityType: CDef.AbilityType
    ) : this(
        code = cdefAbilityType.code(),
        name = cdefAbilityType.alias()
    )

    companion object {
        operator fun invoke(abilityTypeCode: String): Ability {
            val cdefAbility = checkNotNull(CDef.AbilityType.codeOf(abilityTypeCode))
            return Ability(cdefAbility)
        }
    }

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

    fun assertAbility(village: Village, participant: VillageParticipant?, targetId: Int?) {
        participant?.skill ?: throw Wolf4busyBusinessException("能力セットできません")
        // その能力を持っていない
        if (Abilities(participant.skill).list.none { it.code == code }) throw Wolf4busyBusinessException("能力セットできません")
        // 対象指定がおかしい
        if (targetId == null && !isAvailableNoTarget()) throw Wolf4busyBusinessException("能力セットできません")
        if (targetId != null && getSelectableTargetList(village, participant).none { it.id == targetId }) throw Wolf4busyBusinessException("能力セットできません")
    }

    fun toCdef(): CDef.AbilityType = CDef.AbilityType.codeOf(code)

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun canUseAbility(village: Village, participant: VillageParticipant?): Boolean {
        // 村として可能か
        if (!village.canUseAbility()) return false
        // 参加者として可能か
        participant ?: return false
        return participant.canUseAbility()
    }

    private fun isAvailableNoTarget(): Boolean {
        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.isAvailableNoTarget()
            CDef.AbilityType.占い.code() -> Divine.isAvailableNoTarget()
            CDef.AbilityType.護衛.code() -> Guard.isAvailableNoTarget()
            else -> throw IllegalStateException("想定外の能力")
        }
    }
}