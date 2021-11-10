package com.ort.howlingwolf.domain.service.message

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

/**
 * 狂信者の人狼確認用メッセージ
 */
@Service
class FanaticMessageDomainService {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewableFanaticMessage()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewableFanaticMessage()
    }
}
