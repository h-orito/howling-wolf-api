package com.ort.wolf4busy.domain.model.message

data class Messages(
    val messageList: List<Message>
) {

    fun add(message: Message): Messages {
        val list = mutableListOf<Message>()
        list.addAll(messageList)
        list.add(message)
        return this.copy(messageList = list)
    }

    fun existsDifference(messages: Messages): Boolean {
        return messageList.size != messages.messageList.size
    }
}