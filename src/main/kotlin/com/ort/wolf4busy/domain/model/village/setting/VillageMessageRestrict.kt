package com.ort.wolf4busy.domain.model.village.setting

import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageType

data class VillageMessageRestrict(
    val type: MessageType,
    val count: Int,
    val length: Int,
    val line: Int = MessageContent.lineMax
)
