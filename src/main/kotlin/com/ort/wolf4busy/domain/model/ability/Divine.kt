package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant


object Divine {

    private val ABILITY_TYPE = Ability(CDef.AbilityType.占い)

    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        // 自分以外の生存者全員
        return village.participant.memberList.filter {
            it.id != participant.id && it.isAlive()
        }
    }

    fun getSelectingTarget(village: Village, participant: VillageParticipant?, villageAbilities: VillageAbilities): VillageParticipant? {
        participant ?: return null

        val targetVillageParticipantId = villageAbilities.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.ability.code == CDef.AbilityType.占い.code()
                && it.myselfId == participant.id
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.member(targetVillageParticipantId)
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が占い対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }

    fun getDefaultAbilityList(village: Village): List<VillageAbility> {
        // 進行中のみ
        if (!village.status.isProgress()) return listOf()
        // 最新日id
        val latestVillageDay = village.day.latestDay()
        // 生存している占い能力持ちごとに
        return village.participant.filterAlive().memberList.filter {
            it.skill!!.toCdef().isHasDivineAbility
        }.mapNotNull { seer ->
            // 対象は自分以外の生存者からランダム
            village.participant
                .filterAlive()
                .findRandom { it.id != seer.id }?.let {
                    VillageAbility(
                        villageDayId = latestVillageDay.id,
                        myselfId = seer.id,
                        targetId = it.id,
                        ability = ABILITY_TYPE
                    )
                }
        }
    }

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        var messages = dayChange.messages.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasDivineAbility
        }.forEach { seer ->
            dayChange.abilities.list.find {
                it.myselfId == seer.id && it.villageDayId == dayChange.village.day.yesterday().id
            }?.let { ability ->
                val myself = dayChange.village.participant.member(ability.myselfId)
                val fromCharaName = charas.chara(myself.charaId).charaName.name
                val target = dayChange.village.participant.member(ability.targetId!!)
                val toCharaName = charas.chara(target.charaId).charaName.name
                val isWolf =
                    dayChange.village.participant.member(ability.targetId).skill!!.toCdef().isDivineResultWolf
                val text = "${fromCharaName}は、${toCharaName}を占った。\n${toCharaName}は人狼${if (isWolf) "の" else "ではない"}ようだ。"
                messages = messages.add(Message.createSeerPrivateMessage(text, latestDay, seer))
            }
        }
        // TODO 呪殺、逆呪殺

        return dayChange.copy(
            messages = messages
        ).setIsChange(dayChange)
    }

    fun isAvailableNoTarget(): Boolean = false
}