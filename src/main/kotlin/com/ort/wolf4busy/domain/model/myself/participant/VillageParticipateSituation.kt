package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.Leave
import com.ort.wolf4busy.domain.model.village.participant.Participate
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageParticipateSituation(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val isAvailableLeave: Boolean,
    val myself: VillageParticipant?
) {

    constructor(
        village: Village,
        participant: VillageParticipant?,
        player: Player?,
        charachipCharaNum: Int
    ) : this(
        isParticipating = participant != null,
        isAvailableParticipate = Participate.isAvailableParticipate(player, village),
        isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum),
        isAvailableLeave = Leave.isAvailableLeave(village, participant),
        myself = participant
    )
}
