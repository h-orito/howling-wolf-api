package com.ort.howlingwolf.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

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
    fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageParticipant? {
        if (!canUseAbility(village, participant)) return null

        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.getSelectingTarget(village, participant, villageAbilities)
            CDef.AbilityType.占い.code() -> Divine.getSelectingTarget(village, participant, villageAbilities)
            CDef.AbilityType.護衛.code() -> Guard.getSelectingTarget(village, participant, villageAbilities)
            else -> null
        }
    }

    /**
     * 能力セットメッセージ
     * @param village village
     * @param myChara セットするキャラ
     * @param targetChara セットされるキャラ
     * @return 能力セット時のメッセージ e.g. "{キャラ名}が襲撃対象を{キャラ名}に設定しました。"
     */
    fun createAbilitySetMessage(
        village: Village,
        myChara: Chara,
        targetChara: Chara?
    ): Message {
        val text = getAbilitySetMessage(myChara, targetChara)
        return Message.createPrivateSystemMessage(text, village.day.latestDay().id)
    }

    fun assertAbility(village: Village, participant: VillageParticipant?, targetId: Int?) {
        participant?.skill ?: throw HowlingWolfBusinessException("能力セットできません")
        // その能力を持っていない
        if (Abilities(participant.skill).list.none { it.code == code }) throw HowlingWolfBusinessException("能力セットできません")
        // 使えない状況
        if (!isUsable(village, participant)) throw HowlingWolfBusinessException("能力セットできません")
        // 対象指定がおかしい
        if (targetId == null && !canNoTarget(village)) throw HowlingWolfBusinessException("能力セットできません")
        if (targetId != null && getSelectableTargetList(
                village,
                participant
            ).none { it.id == targetId }
        ) throw HowlingWolfBusinessException("能力セットできません")
    }

    fun isUsable(village: Village, participant: VillageParticipant?): Boolean {
        participant ?: return false
        // 進行中でないと使えない
        if (!village.status.isProgress()) return false
        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.isUsable(participant)
            CDef.AbilityType.占い.code() -> Divine.isUsable(participant)
            CDef.AbilityType.護衛.code() -> Guard.isUsable(village, participant)
            else -> false
        }
    }

    fun canNoTarget(village: Village): Boolean {
        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.isAvailableNoTarget(village)
            CDef.AbilityType.占い.code() -> Divine.isAvailableNoTarget()
            CDef.AbilityType.護衛.code() -> Guard.isAvailableNoTarget()
            else -> false
        }
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

    // 能力セット時のシステムメッセージ
    private fun getAbilitySetMessage(myChara: Chara, targetChara: Chara?): String {
        return when (code) {
            CDef.AbilityType.襲撃.code() -> Attack.getSetMessage(myChara, targetChara)
            CDef.AbilityType.占い.code() -> Divine.getSetMessage(myChara, targetChara)
            CDef.AbilityType.護衛.code() -> Guard.getSetMessage(myChara, targetChara)
            else -> throw IllegalStateException("想定外の能力")
        }
    }
}