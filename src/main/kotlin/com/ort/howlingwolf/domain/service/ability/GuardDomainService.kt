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
class GuardDomainService : IAbilityDomainService {

    override fun getAbilityType(): AbilityType = AbilityType(CDef.AbilityType.護衛)

    override fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        // 1日目は護衛できない
        if (village.day.latestDay().day <= 1) return listOf()

        // 連続護衛可能なら自分以外の生存者全員
        // TODO 連続護衛なし
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
        return "${myChara.charaName.fullName()}が護衛対象を${targetChara?.charaName?.fullName() ?: "なし"}に設定しました。"
    }

    override fun getDefaultAbilityList(
        village: Village,
        villageAbilities: VillageAbilities
    ): List<VillageAbility> {
        // 進行中のみ
        if (!village.status.isProgress()) return listOf()
        // 最新日id
        val latestVillageDay = village.day.latestDay()
        // 1日目は護衛できない
        if (latestVillageDay.day == 1) {
            return listOf()
        }

        // 生存している護衛能力持ちごとに
        return village.participant.filterAlive().memberList.filter {
            it.skill!!.toCdef().isHasGuardAbility
        }.mapNotNull { seer ->
            // 対象は自分以外の生存者からランダム
            // TODO 連続護衛なし
            village.participant.filterAlive()
                .findRandom { it.id != seer.id }?.let {
                    VillageAbility(
                        villageDayId = latestVillageDay.id,
                        myselfId = seer.id,
                        targetId = it.id,
                        abilityType = getAbilityType()
                    )
                } // 自分しかいない場合
        }
    }

    override fun processDayChangeAction(dayChange: DayChange, charas: Charas): DayChange {
        var messages = dayChange.messages.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasGuardAbility
        }.forEach { hunter ->
            dayChange.abilities.list.find {
                it.myselfId == hunter.id && it.villageDayId == dayChange.village.day.yesterday().id
            }?.let { ability ->
                messages = messages.add(createGuardMessage(dayChange.village, charas, ability))
            }
        }

        return dayChange.copy(
            messages = messages
        ).setIsChange(dayChange)
    }

    override fun isAvailableNoTarget(village: Village): Boolean = false

    override fun isUsable(village: Village, participant: VillageParticipant): Boolean {
        // 2日目以降、生存していたら行使できる
        return village.day.latestDay().day > 1 && participant.isAlive()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createGuardMessage(village: Village, charas: Charas, ability: VillageAbility): Message {
        val myChara = charas.chara(village.participant, ability.myselfId)
        val targetChara = charas.chara(village.participant, ability.targetId!!)
        val text = createGuardMessageString(myChara, targetChara)
        return Message.createPrivateSystemMessage(text, village.day.latestDay().id)
    }

    private fun createGuardMessageString(myChara: Chara, targetChara: Chara): String =
        "${myChara.charaName.fullName()}は、${targetChara.charaName.fullName()}を護衛している。"
}