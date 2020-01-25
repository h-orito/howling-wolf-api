package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

object MonologueSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewableMonologueSay()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewableMonologueSay()
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 参加者として可能か
        if (!participant.isSayableMonologueSay()) return false
        // 村として可能か
        return village.isSayableMonologueSay()
    }

    fun assertSay(village: Village, participant: VillageParticipant) {
        if (!isSayable(village, participant)) throw Wolf4busyBusinessException("発言できません")
    }
}
