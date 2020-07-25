package com.ort.howlingwolf.domain.service.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

@Service
class DivineDomainService : IAbilityDomainService {

    override fun getAbilityType(): AbilityType = AbilityType(CDef.AbilityType.占い)

    override fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        // 自分以外の生存者全員
        return village.participant.memberList.filter {
            it.id != participant.id && it.isAlive()
        }
    }

    override fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageParticipant? {
        participant ?: return null

        val targetVillageParticipantId = villageAbilities
            .filterLatestday(village)
            .filterByType(getAbilityType()).list
            .find { it.myselfId == participant.id }
            ?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.member(targetVillageParticipantId)
    }

    override fun createSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.fullName()}が占い対象を${targetChara?.charaName?.fullName() ?: "なし"}に設定しました。"
    }

    override fun getDefaultAbilityList(
        village: Village,
        villageAbilities: VillageAbilities
    ): List<VillageAbility> {
        // 進行中のみ
        if (!village.status.isProgress()) return listOf()
        // 生存している占い能力持ちごとに
        return village.participant.filterAlive().memberList.filter {
            it.skill!!.toCdef().isHasDivineAbility
        }.mapNotNull { seer ->
            // 対象は自分以外の生存者からランダム
            village.participant
                .filterAlive()
                .findRandom { it.id != seer.id }
                ?.let {
                    VillageAbility(
                        villageDayId = village.day.latestDay().id,
                        myselfId = seer.id,
                        targetId = it.id,
                        abilityType = getAbilityType()
                    )
                }
        }
    }

    override fun processDayChangeAction(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        var messages = dayChange.messages.copy()
        var village = dayChange.village.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasDivineAbility
        }.forEach { seer ->
            dayChange.abilities.filterYesterday(village).list.find {
                it.myselfId == seer.id
            }?.let { ability ->
                messages = messages.add(createDivineMessage(dayChange.village, charas, ability, seer))
                // 呪殺対象なら死亡
                if (isDivineKill(dayChange, ability.targetId!!)) village = village.divineKillParticipant(ability.targetId, latestDay)
            }
        }

        return dayChange.copy(
            messages = messages,
            village = village
        ).setIsChange(dayChange)
    }

    override fun isAvailableNoTarget(village: Village): Boolean = false

    override fun isUsable(village: Village, participant: VillageParticipant): Boolean {
        // 生存していたら行使できる
        return participant.isAlive()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createDivineMessage(
        village: Village,
        charas: Charas,
        ability: VillageAbility,
        seer: VillageParticipant
    ): Message {
        val myself = village.participant.member(ability.myselfId)
        val myChara = charas.chara(myself.charaId)
        val targetChara = charas.chara(village.participant, ability.targetId!!)
        val isWolf = village.participant.member(ability.targetId).skill!!.toCdef().isDivineResultWolf
        val text = createDivineMessageString(myChara, targetChara, isWolf)
        return Message.createSeerPrivateMessage(text, village.day.latestDay().id, seer)
    }

    private fun createDivineMessageString(chara: Chara, targetChara: Chara, isWolf: Boolean): String =
        "${chara.charaName.fullName()}は、${targetChara.charaName.fullName()}を占った。\n${targetChara.charaName.fullName()}は人狼${if (isWolf) "の" else "ではない"}ようだ。"

    private fun isDivineKill(dayChange: DayChange, targetId: Int): Boolean {
        // 対象が既に死亡していたら呪殺ではない
        if (!dayChange.village.participant.member(targetId).isAlive()) return false
        // 対象が呪殺対象でなければ呪殺ではない
        return dayChange.village.participant.member(targetId).skill!!.toCdef().isDeadByDivine
    }
}