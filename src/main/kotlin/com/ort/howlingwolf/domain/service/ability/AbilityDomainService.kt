package com.ort.howlingwolf.domain.service.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.ability.AbilityTypes
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.myself.participant.VillageAbilitySituation
import com.ort.howlingwolf.domain.model.myself.participant.VillageAbilitySituations
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBadRequestException
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service

@Service
class AbilityDomainService(
    private val attackDomainService: AttackDomainService,
    private val divineDomainService: DivineDomainService,
    private val guardDomainService: GuardDomainService
) {

    // 選択可能な対象
    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?,
        abilityType: AbilityType
    ): List<VillageParticipant> {
        if (!canUseAbility(village, participant)) return listOf()
        return detectDomainService(abilityType)?.getSelectableTargetList(village, participant) ?: listOf()
    }

    // 選択中の対象
    fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities,
        abilityType: AbilityType
    ): VillageParticipant? {
        if (!canUseAbility(village, participant)) return null
        return detectDomainService(abilityType)?.getSelectingTarget(village, participant, villageAbilities)
    }

    // 能力セットメッセージ
    fun createAbilitySetMessage(
        village: Village,
        myChara: Chara,
        targetChara: Chara?,
        abilityType: AbilityType
    ): Message {
        return detectDomainService(abilityType)?.createSetMessage(myChara, targetChara)?.let {
            Message.createPrivateSystemMessage(it, village.day.latestDay().id)
        } ?: throw IllegalStateException("想定外の能力")
    }

    fun assertAbility(
        village: Village,
        participant: VillageParticipant?,
        targetId: Int?,
        abilityType: AbilityType
    ) {
        participant?.skill ?: throw HowlingWolfBadRequestException("役職なし")
        // その能力を持っていない
        if (AbilityTypes(participant.skill).list.none { it.code == abilityType.code }) {
            throw HowlingWolfBadRequestException("${abilityType.name}の能力を持っていません")
        }
        // 使えない状況
        if (!isUsable(village, participant, abilityType)) throw HowlingWolfBusinessException("${abilityType.name}能力を使えない状態です")
        // 対象指定がおかしい
        if (targetId == null && !canNoTarget(village, abilityType)) throw HowlingWolfBusinessException("対象指定が必要です")
        if (targetId != null && getSelectableTargetList(village, participant, abilityType).none { it.id == targetId }) {
            throw HowlingWolfBusinessException("指定できない対象を指定しています")
        }
    }

    fun isUsable(
        village: Village,
        participant: VillageParticipant?,
        abilityType: AbilityType
    ): Boolean {
        participant ?: return false
        // 進行中でないと使えない
        if (!village.status.isProgress()) return false
        return detectDomainService(abilityType)?.isUsable(village, participant) ?: false
    }

    fun canNoTarget(village: Village, abilityType: AbilityType): Boolean =
        detectDomainService(abilityType)?.isAvailableNoTarget(village) ?: false

    fun convertToSituationList(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageAbilitySituations {
        participant?.skill ?: return VillageAbilitySituations(listOf())
        val abilityTypes = AbilityTypes(participant.skill)
        return VillageAbilitySituations(
            list = abilityTypes.list.map { convertToSituation(village, participant, it, villageAbilities) }
        )
    }

    // 日付更新時のデフォルト能力行使を追加
    fun addDefaultAbilities(dayChange: DayChange): DayChange {
        val village = dayChange.village
        var abilities = dayChange.abilities

        // 襲撃
        abilities = abilities.addAll(attackDomainService.getDefaultAbilityList(village, abilities))
        // 占い
        abilities = abilities.addAll(divineDomainService.getDefaultAbilityList(village, abilities))
        // 護衛
        abilities = abilities.addAll(guardDomainService.getDefaultAbilityList(village, abilities))

        return dayChange.copy(abilities = abilities).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun detectDomainService(abilityType: AbilityType): IAbilityDomainService? {
        return when (abilityType.code) {
            CDef.AbilityType.襲撃.code() -> attackDomainService
            CDef.AbilityType.占い.code() -> divineDomainService
            CDef.AbilityType.護衛.code() -> guardDomainService
            else -> null
        }
    }

    private fun canUseAbility(village: Village, participant: VillageParticipant?): Boolean {
        // 村として可能か
        if (!village.canUseAbility()) return false
        // 参加者として可能か
        participant ?: return false
        return participant.canUseAbility()
    }

    private fun convertToSituation(
        village: Village,
        participant: VillageParticipant?,
        abilityType: AbilityType,
        villageAbilities: VillageAbilities
    ): VillageAbilitySituation {
        return VillageAbilitySituation(
            type = abilityType,
            targetList = this.getSelectableTargetList(village, participant, abilityType),
            target = this.getSelectingTarget(village, participant, villageAbilities, abilityType),
            usable = this.isUsable(village, participant, abilityType),
            isAvailableNoTarget = this.canNoTarget(village, abilityType)
        )
    }
}