package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object PsychicMessage {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewablePsychicMessage()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewablePsychicMessage()
    }
}
