package com.ort.howlingwolf.domain.model.message


data class Messages(
    val list: List<Message>,
    val allRecordCount: Int? = null,
    val allPageCount: Int? = null,
    val isExistPrePage: Boolean? = null,
    val isExistNextPage: Boolean? = null,
    val currentPageNum: Int? = null
) {

    fun add(message: Message): Messages {
        return this.copy(list = list + message)
    }

    fun existsDifference(messages: Messages): Boolean {
        return list.size != messages.list.size
    }
}