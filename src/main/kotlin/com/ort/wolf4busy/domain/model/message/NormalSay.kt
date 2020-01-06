package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object NormalSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        return true
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        if (participant.isSpectator) return false
        // エピローグ以外で死亡している場合は不可
        return participant.isAlive() || village.status.code == CDef.VillageStatus.エピローグ.code()
    }

}