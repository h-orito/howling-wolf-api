package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.message.MessageView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village

data class VillageMessageView(
    val messageList: List<MessageView>
) {
    constructor(
        messageList: List<Message>,
        village: Village,
        players: Players,
        charas: Charas
    ) : this(
        messageList = messageList.map {
            MessageView(
                message = it,
                village = village,
                players = players,
                charas = charas,
                shouldHidePlayer = !village.status.isSolved()
            )
        }
    )
}

