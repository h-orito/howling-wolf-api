package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.charachip.CharaFace

data class MessageContent(
    val type: MessageType,
    val text: String,
    val face: CharaFace?
) {
}