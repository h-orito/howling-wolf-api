package com.ort.howlingwolf.domain.service.message.say

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.service.message.MessageTypeDomainService

interface SayTypeDomainService : MessageTypeDomainService {

    fun isSayable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?
    ): Boolean
}