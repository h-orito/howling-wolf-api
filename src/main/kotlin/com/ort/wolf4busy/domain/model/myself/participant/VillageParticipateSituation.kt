package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.Village
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
        isAvailableParticipate = village.isAvailableParticipate(player),
        isAvailableSpectate = village.isAvailableSpectate(player, charachipCharaNum),
        isAvailableLeave = village.isAvailableLeave(participant),
        myself = participant
    )
}
