package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object MonologueSay {

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        return true
    }
}
