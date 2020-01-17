package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.player.PlayerView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus

data class VillageView(
    val id: Int,
    val name: String,
    val creatorPlayer: PlayerView,
    val status: VillageStatus,
    val setting: VillageSettingsView,
    val participant: VillageParticipantsView,
    val spectator: VillageParticipantsView,
    val day: VillageDays
) {

    constructor(
        village: Village,
        charas: Charas,
        players: Players,
        createPlayer: Player
    ) : this(
        id = village.id,
        name = village.name,
        creatorPlayer = PlayerView(createPlayer),
        status = village.status,
        setting = VillageSettingsView(village.setting),
        participant = VillageParticipantsView(
            village = village,
            charas = charas,
            players = players,
            shouldHidePlayer = !village.status.isSolved()
        ),
        spectator = VillageParticipantsView(
            village = village,
            charas = charas,
            players = players,
            shouldHidePlayer = !village.status.isSolved()
        ),
        day = village.day
    )
}