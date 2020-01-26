package com.ort.wolf4busy.api.view.myself.participant

import com.ort.wolf4busy.api.view.village.VillageParticipantView
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.myself.participant.VillageParticipateSituation
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village

data class VillageParticipateSituationView(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val selectableCharaList: List<Chara>,
    val isAvailableLeave: Boolean,
    val myself: VillageParticipantView?
) {
    constructor(
        situation: VillageParticipateSituation,
        village: Village,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        isParticipating = situation.isParticipating,
        isAvailableParticipate = situation.isAvailableParticipate,
        isAvailableSpectate = situation.isAvailableSpectate,
        selectableCharaList = situation.selectableCharaList,
        isAvailableLeave = situation.isAvailableLeave,
        myself = situation.myself?.let {
            VillageParticipantView(
                village = village,
                villageParticipantId = it.id,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        }
    )
}
