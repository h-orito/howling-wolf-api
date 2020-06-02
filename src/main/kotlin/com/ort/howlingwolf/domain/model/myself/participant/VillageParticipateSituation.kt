package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.Leave
import com.ort.howlingwolf.domain.model.village.participant.Participate
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageParticipateSituation(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val selectableCharaList: List<Chara>,
    val isAvailableLeave: Boolean,
    val myself: VillageParticipant?
) {

    constructor(
        village: Village,
        participant: VillageParticipant?,
        player: Player?,
        charas: Charas
    ) : this(
        isParticipating = participant != null,
        isAvailableParticipate = Participate.isAvailableParticipate(player, village),
        isAvailableSpectate = Participate.isAvailableSpectate(player, village, charas.list.size),
        selectableCharaList = Participate.getSelectableCharaList(village, charas),
        isAvailableLeave = Leave.isAvailableLeave(village, participant),
        myself = participant
    )
}
