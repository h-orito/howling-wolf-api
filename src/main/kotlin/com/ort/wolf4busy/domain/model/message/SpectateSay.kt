package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object SpectateSay {

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 見学していなかったら不可
        return participant.isSpectator
    }
}
