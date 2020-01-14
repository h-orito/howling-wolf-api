package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants

data class VillageParticipantsView(
    val count: Int,
    val memberList: List<VillageParticipantView>
) {
    constructor(
        villageParticipants: VillageParticipants,
        charas: Charas,
        players: Players,
        shouldHidePlayer: Boolean
    ) : this(
        count = villageParticipants.count,
        memberList = villageParticipants.memberList.map {
            VillageParticipantView(
                villageParticipant = it,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        }
    )
}
