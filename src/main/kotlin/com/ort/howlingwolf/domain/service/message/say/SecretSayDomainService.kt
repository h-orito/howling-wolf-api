package com.ort.howlingwolf.domain.service.message.say

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

@Service
class SecretSayDomainService : SayTypeDomainService {

    override fun isViewable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?,
        day: Int
    ): Boolean =
        village.isViewableSecretSay() || myself?.isViewableSecretSay() ?: false

    override fun isSayable(
        village: Village,
        myself: VillageParticipant?,
        player: Player?
    ): Boolean {
        return if (myself?.isAdmin() == true) true
        else if (village.isCreator(player)) true
        else village.isSayableSecretSay() && myself?.isSayableSecretSay() ?: false
    }
}
