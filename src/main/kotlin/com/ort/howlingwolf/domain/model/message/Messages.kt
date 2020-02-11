package com.ort.howlingwolf.domain.model.message


data class Messages(
    val list: List<Message>,
    val allPageCount: Int? = null,
    val isExistPrePage: Boolean? = null,
    val isExistNextPage: Boolean? = null,
    val currentPageNum: Int? = null,
    val pageNumList: List<Int>? = null
) {

    constructor(
        list: List<Message>,
        allPageCount: Int,
        isExistPrePage: Boolean,
        isExistNextPage: Boolean,
        currentPageNum: Int
    ) : this(
        list = list,
        allPageCount = allPageCount,
        isExistPrePage = isExistPrePage,
        isExistNextPage = isExistNextPage,
        currentPageNum = currentPageNum,
        pageNumList = createCurrentPageNum(allPageCount, currentPageNum)
    )

    fun add(message: Message): Messages {
        return this.copy(list = list + message)
    }

    fun existsDifference(messages: Messages): Boolean {
        return list.size != messages.list.size
    }

    companion object {

        private fun createCurrentPageNum(allPageCount: Int, currentPageNum: Int): List<Int> {
            var startPage = currentPageNum - 2
            var endPage = currentPageNum + 2
            if (startPage < 1) {
                startPage = 1
                endPage = 5
            }
            if (endPage > allPageCount) {
                endPage = allPageCount
                startPage = allPageCount - 4
                if (startPage < 1) startPage = 1
            }
            return (startPage..endPage).map { it }
        }
    }
}