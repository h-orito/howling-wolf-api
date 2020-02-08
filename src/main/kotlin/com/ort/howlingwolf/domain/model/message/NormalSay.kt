package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

object NormalSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        return true
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 参加者として可能か
        if (!participant.isSayableNormalSay(village.status.toCdef() == CDef.VillageStatus.エピローグ)) return false
        // 村として可能か
        return village.isSayableNormalSay()
    }

    fun assertSay(village: Village, participant: VillageParticipant) {
        if (!isSayable(village, participant)) throw HowlingWolfBusinessException("発言できません")
    }
}