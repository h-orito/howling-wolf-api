package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.message.MessageView
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.player.Player

data class VillageAnchorMessageView(
    val message: MessageView?
) {
    constructor(
        message: Message?,
        playerList: List<Player>,
        charas: Charas
    ) : this(
        message = if (message == null) null else MessageView(
            message, playerList, charas
        )
    )
}