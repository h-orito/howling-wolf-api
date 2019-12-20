package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant


object Divine {

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
        return village.participant.memberList.find { it.id == targetVillageParticipantId }
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が占い対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }

    fun getDefaultAbilityList(village: Village): List<VillageAbility> {
        // 最新日id
        val latestVillageDay = village.day.latestDay()
        // 生存している占い能力持ちごとに
        return village.participant.filterAlive().memberList.filter {
            it.skill!!.toCdef().isHasDivineAbility
        }.mapNotNull { seer ->
            // 対象は自分以外の生存者からランダム
            village.participant.filterAlive()
                .findRandom { it.id != seer.id }?.let {
                    VillageAbility(
                        villageDayId = latestVillageDay.id,
                        myselfId = seer.id,
                        targetId = it.id,
                        ability = Ability(CDef.AbilityType.占い)
                    )
                } ?: null // 自分しかいない場合
        }
    }

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        var messages = dayChange.messages.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasDivineAbility
        }.forEach { seer ->
            dayChange.abilities.list.find { it.myselfId == seer.id && it.villageDayId == latestDay.id }?.let { ability ->
                val fromCharaName = charas.list.find { it.id == ability.myselfId }!!.charaName.name
                val toCharaName = charas.list.find { it.id == ability.targetId }!!.charaName.name
                val isWolf = dayChange.village.participant.memberList.find { it.id == ability.targetId }!!.skill!!.toCdef().isDivineResultWolf
                val text = "${fromCharaName}は、${toCharaName}を占った。\n${toCharaName}は${if (isWolf) "人狼" else "人間"}のようだ。"
                messages = messages.add(DayChange.createSeerPrivateMessage(text, latestDay.day, seer))
            }
        }
        // TODO 呪殺、逆呪殺

        return dayChange.copy(
            messages = messages
        )
    }
}