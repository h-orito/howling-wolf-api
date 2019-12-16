package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object NormalSay {

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // エピローグ以外で死亡している場合は不可
        return participant.alive() || village.status.code == CDef.VillageStatus.エピローグ.code()
    }

}