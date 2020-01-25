package com.ort.wolf4busy.api.view.message

import com.ort.wolf4busy.api.view.village.VillageParticipantView
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village

class MessageView(
    val from: VillageParticipantView?,
    val to: VillageParticipantView?,
    val time: MessageTimeView,
    val content: MessageContent
) {
    constructor(
        message: Message,
        village: Village,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        from = if (message.fromVillageParticipantId == null) null else VillageParticipantView(village, message.fromVillageParticipantId, players, charas, shouldHidePlayer),
        to = if (message.toVillageParticipantId == null) null else VillageParticipantView(village, message.toVillageParticipantId, players, charas, shouldHidePlayer),
        time = MessageTimeView(message.time, village.day.dayList.first { it.id == message.time.villageDayId }),
        content = message.content
    )
}