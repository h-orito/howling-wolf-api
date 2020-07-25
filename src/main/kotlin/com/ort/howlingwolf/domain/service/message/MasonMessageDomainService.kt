package com.ort.howlingwolf.domain.service.message

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

/**
 * 共有の相互確認用メッセージ
 * 共鳴発言ではないので注意
 */
@Service
class MasonMessageDomainService {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // いずれかを満たせばok
        // 村として可能か
        if (village.isViewableMasonMessage()) return true
        // 参加者として可能か
        participant ?: return false
        return participant.isViewableMasonMessage()
    }
}
