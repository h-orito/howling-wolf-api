package com.ort.howlingwolf.domain.model.message

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

object WerewolfSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewableWerewolfSay()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewableWerewolfSay()
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 参加者として可能か
        if (!participant.isSayableWerewolfSay()) return false
        // 村として可能か
        return village.isSayableWerewolfSay()
    }

    fun assertSay(village: Village, participant: VillageParticipant) {
        if (!isSayable(village, participant)) throw HowlingWolfBusinessException("発言できません")
    }
}
