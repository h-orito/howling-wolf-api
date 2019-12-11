package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.message.MessageView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.player.Player

data class VillageMessageView(
    val messageList: List<MessageView>
) {
    constructor(
        messageList: List<Message>,
        playerList: List<Player>,
        charas: Charas
    ) : this(
        messageList = messageList.map { MessageView(it, playerList, charas) }
    )
}

