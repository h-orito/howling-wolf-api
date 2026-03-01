package com.ort.howlingwolf.domain.service.message.say

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

@Service
class GraveSayDomainService : SayTypeDomainService {

    override fun isViewable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?,
        day: Int
    ): Boolean {
        return village.isViewableGraveSay() || myself?.isViewableGraveSay() ?: false
    }

    override fun isSayable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?
    ): Boolean {
        return village.isSayableGraveSay() && myself?.isSayableGraveSay() ?: false
    }
}
