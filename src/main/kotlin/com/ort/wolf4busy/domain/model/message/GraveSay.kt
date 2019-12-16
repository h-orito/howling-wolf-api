package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object GraveSay {

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 死亡していなかったら不可
        if (participant.alive()) return false
        // 進行中以外は不可
        return village.status.isProgress()
    }
}
