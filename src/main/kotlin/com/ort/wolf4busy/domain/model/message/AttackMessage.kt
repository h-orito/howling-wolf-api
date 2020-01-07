package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object AttackMessage {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 参加していて生存していて襲撃可能職なら開放
        if (participant == null) return false
        if (!participant.isAlive()) return false
        return participant.skill?.toCdef()?.isHasAttackAbility ?: false
    }
}
