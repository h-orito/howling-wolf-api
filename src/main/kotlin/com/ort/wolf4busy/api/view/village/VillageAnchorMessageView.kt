package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.message.MessageView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village

data class VillageAnchorMessageView(
    val message: MessageView?
) {
    constructor(
        message: Message?,
        village: Village,
        players: Players,
        charas: Charas
    ) : this(
        message = if (message == null) null else MessageView(
            message = message,
            players = players,
            charas = charas,
            shouldHidePlayer = !village.status.isSolved()
        )
    )
}