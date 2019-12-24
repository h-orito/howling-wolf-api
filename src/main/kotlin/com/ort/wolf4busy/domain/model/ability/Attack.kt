package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object Attack {

    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        return if (village.day.latestDay().day == 1) {
            // ダミーキャラ固定
            listOf(village.dummyChara())
        } else {
            // 襲撃対象に選べる & 生存している
            village.participant.memberList.filter {
                !it.skill!!.toCdef().isNotSelectableAttack && it.isAlive()
            }
        }
    }

    fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageParticipant? {
        participant ?: return null

        // 襲撃能力のある参加者のID
        val attackableParticipantIdList =
            village.participant.memberList.filter { it.skill!!.toCdef().isHasAttackAbility }.map { it.id }

        val targetVillageParticipantId = villageAbilities.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.ability.code == CDef.AbilityType.占い.code()
                && attackableParticipantIdList.contains(it.myselfId)
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.memberList.find { it.id == targetVillageParticipantId }
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が襲撃対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }

    fun getDefaultAbility(village: Village): VillageAbility? {
        // 最新日id
        val latestVillageDay = village.day.latestDay()
        // 襲撃者は生存している人狼からランダムに
        val wolf = village.participant.filterAlive().findRandom {
            it.skill!!.toCdef().isHasAttackAbility
        } ?: return null // 生存している人狼がいないので襲撃なし

        return if (latestVillageDay.day == 1) { // 1日目はダミー固定
            VillageAbility(
                villageDayId = latestVillageDay.id,
                myselfId = wolf.id,
                targetId = village.dummyChara().id,
                ability = Ability(CDef.AbilityType.襲撃)
            )
        } else { // 2日目以降は生存者からランダム
            val target = village.participant.filterAlive().findRandom {
                !it.skill!!.toCdef().isHasAttackAbility
            } ?: return null // 生存している対象がいないので襲撃なし
            return VillageAbility(
                villageDayId = latestVillageDay.id,
                myselfId = wolf.id,
                targetId = target.id,
                ability = Ability(CDef.AbilityType.襲撃)
            )
        }
    }

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        val aliveWolf = dayChange.village.participant.findRandom {
            it.isAlive() && it.skill!!.toCdef().isHasAttackAbility
        } ?: return dayChange

        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.abilities.list.find {
            it.ability.code == CDef.AbilityType.襲撃.code() && it.targetId != null && it.villageDayId == village.day.yesterday().id
        }?.let { ability ->
            // 襲撃メッセージ
            val fromCharaName = charas.list.find { it.id == aliveWolf.charaId }!!.charaName.name
            val toCharaName = charas.list.find { it.id == ability.targetId }!!.charaName.name
            val text = "${fromCharaName}達は、${toCharaName}を襲撃した。"
            messages = messages.add(DayChange.createAttackPrivateMessage(text, latestDay.day))
            // 襲撃成功したら死亡
            if (isAttackSuccess(dayChange, ability.targetId!!)) village = village.attackParticipant(ability.targetId!!, latestDay)
        } ?: return dayChange

        return dayChange.copy(
            village = village,
            messages = messages
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAttackSuccess(dayChange: DayChange, targetId: Int): Boolean {
        // 対象が既に死亡していたら失敗
        if (!dayChange.village.participant.memberList.find { it.id == targetId }!!.isAlive()) return false
        // 対象が護衛されていたら失敗
        if (dayChange.abilities.list.any {
                it.ability.code == CDef.AbilityType.護衛.code() && it.targetId == targetId && it.villageDayId == dayChange.village.day.yesterday().id
            }) {
            return false
        }
        // TODO 襲撃を耐える役職
        return true
    }
}