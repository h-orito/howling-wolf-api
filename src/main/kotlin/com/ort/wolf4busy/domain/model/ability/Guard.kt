package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object Guard {

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
                && it.ability.code == CDef.AbilityType.護衛.code()
                && it.myselfId == participant.id
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.memberList.find { it.id == targetVillageParticipantId }
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が護衛対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }
}