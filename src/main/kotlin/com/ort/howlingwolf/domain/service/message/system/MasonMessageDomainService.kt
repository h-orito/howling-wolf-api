package com.ort.howlingwolf.domain.service.message.system

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.service.message.MessageTypeDomainService
import org.springframework.stereotype.Service

/**
 * 共有の相互確認用メッセージ
 * 共鳴発言ではないので注意
 */
@Service
class MasonMessageDomainService : MessageTypeDomainService {

    override fun isViewable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?,
        day: Int
    ): Boolean = village.isViewableMasonMessage() || myself?.isViewableMasonMessage() ?: false
}
