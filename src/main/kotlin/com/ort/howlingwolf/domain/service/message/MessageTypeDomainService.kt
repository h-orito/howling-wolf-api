package com.ort.howlingwolf.domain.service.message

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

interface MessageTypeDomainService {

    fun isViewable(village: Village, myself: VillageParticipant?, player: Player?, day: Int): Boolean
}