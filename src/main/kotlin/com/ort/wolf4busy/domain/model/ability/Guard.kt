package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object Guard {

    private val ABILITY_TYPE = Ability(CDef.AbilityType.護衛)

    fun getSelectableTargetList(
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

    fun getSelectingTarget(village: Village, participant: VillageParticipant?, villageAbilities: VillageAbilities): VillageParticipant? {
        participant ?: return null

        val targetVillageParticipantId = villageAbilities.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.ability.code == ABILITY_TYPE.code
                && it.myselfId == participant.id
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.member(targetVillageParticipantId)
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が護衛対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }

    fun getDefaultAbilityList(village: Village): List<VillageAbility> {
        // 進行中のみ
        if (!village.status.isProgress()) return listOf()
        // 1日目は護衛できない
        if (village.day.latestDay().day == 1) {
            return listOf()
        }

        // 最新日id
        val latestVillageDay = village.day.latestDay()
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
                        ability = ABILITY_TYPE
                    )
                } ?: null // 自分しかいない場合
        }
    }

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        var messages = dayChange.messages.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasGuardAbility
        }.forEach { hunter ->
            dayChange.abilities.list.find {
                it.myselfId == hunter.id && it.villageDayId == dayChange.village.day.yesterday().id
            }?.let { ability ->
                val myself = dayChange.village.participant.member(ability.myselfId)
                val fromCharaName = charas.chara(myself!!.charaId).charaName.name
                val target = dayChange.village.participant.member(ability.targetId!!)
                val toCharaName = charas.chara(target!!.charaId).charaName.name
                val text = "${fromCharaName}は、${toCharaName}を護衛している。"
                messages = messages.add(DayChange.createPrivateSystemMessage(text, latestDay))
            }
        }

        return dayChange.copy(
            messages = messages
        ).setIsChange(dayChange)
    }

    fun isAvailableNoTarget(): Boolean = false
}