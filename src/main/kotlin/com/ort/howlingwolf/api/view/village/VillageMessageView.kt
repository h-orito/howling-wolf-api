package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.api.view.message.MessageView
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

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

