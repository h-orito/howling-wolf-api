package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.api.view.player.PlayerView
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus

data class VillageView(
    val id: Int,
    val name: String,
    val creatorPlayer: PlayerView,
    val status: VillageStatus,
    val winCamp: Camp?,
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
        winCamp = village.winCamp,
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