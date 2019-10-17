package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class Message(
    val from: VillageParticipant?,
    val to: VillageParticipant?,
    val time: MessageTime,
    val content: MessageContent
) {
}