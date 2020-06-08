package com.ort.howlingwolf.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant


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
        var village = dayChange.village.copy()

        dayChange.village.participant.memberList.filter {
            it.isAlive() && it.skill!!.toCdef().isHasDivineAbility
        }.forEach { seer ->
            dayChange.abilities.list.find {
                it.myselfId == seer.id && it.villageDayId == dayChange.village.day.yesterday().id
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

    fun isAvailableNoTarget(): Boolean = false

    fun isUsable(participant: VillageParticipant): Boolean {
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