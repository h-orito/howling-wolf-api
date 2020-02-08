package com.ort.howlingwolf.domain.model.message

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

object AttackMessage {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewableAttackMessage()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewableAttackMessage()
    }
}
