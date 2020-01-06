package com.ort.wolf4busy.api.view.message

import com.ort.wolf4busy.api.view.village.VillageParticipantView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.player.Players

class MessageView(
    val from: VillageParticipantView?,
    val to: VillageParticipantView?,
    val time: MessageTime,
    val content: MessageContent
) {
    constructor(
        message: Message,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        from = if (message.from == null) null else VillageParticipantView(message.from, players, charas, shouldHidePlayer),
        to = if (message.to == null) null else VillageParticipantView(message.to, players, charas, shouldHidePlayer),
        time = message.time,
        content = message.content
    )
}