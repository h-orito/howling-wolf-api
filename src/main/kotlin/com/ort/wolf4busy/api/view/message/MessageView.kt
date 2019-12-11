package com.ort.wolf4busy.api.view.message

import com.ort.wolf4busy.api.view.village.VillageParticipantView
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.player.Player

class MessageView(
    val from: VillageParticipantView?,
    val to: VillageParticipantView?,
    val time: MessageTime,
    val content: MessageContent
) {
    constructor(
        message: Message,
        playerList: List<Player>,
        charas: Charas
    ) : this(
        from = if (message.from == null) null else VillageParticipantView(message.from, playerList, charas),
        to = if (message.to == null) null else VillageParticipantView(message.to, playerList, charas),
        time = message.time,
        content = message.content
    )
}