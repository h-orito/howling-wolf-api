package com.ort.wolf4busy.domain.model.message

data class MessageContent(
    val type: MessageType,
    val num: Int?,
    val text: String,
    val faceCode: String?
) {
}