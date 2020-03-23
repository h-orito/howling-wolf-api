package com.ort.howlingwolf.domain.model.player.record

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class ParticipateVillage(
    val village: Village,
    val participant: VillageParticipant
) {
    constructor(
        player: Player,
        village: Village
    ) : this(
        village = village,
        participant = village.participant.memberList.first { !it.isGone && it.playerId == player.id }
    )
}