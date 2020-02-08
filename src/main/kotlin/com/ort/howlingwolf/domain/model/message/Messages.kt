package com.ort.howlingwolf.domain.model.message

data class Messages(
    val messageList: List<Message>
) {

    fun add(message: Message): Messages {
        return this.copy(messageList = messageList + message)
    }

    fun existsDifference(messages: Messages): Boolean {
        return messageList.size != messages.messageList.size
    }
}