package com.ort.wolf4busy.domain.model.village.setting

import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class VillageMessageRestrict(
    val type: MessageType,
    val count: Int,
    val length: Int,
    val line: Int = MessageContent.lineMax
) {
    fun assertSay(messageContent: MessageContent, latestDayMessageList: List<Message>) {
        // 回数
        if (remainingCount(latestDayMessageList) <= 0) throw Wolf4busyBusinessException("発言残り回数が0回です")
        // 文字数
        messageContent.assertMessageLength(length)
    }

    fun remainingCount(latestDayMessageList: List<Message>): Int {
        val alreadySayCount = latestDayMessageList.count { it.content.type.toCdef() == type.toCdef() }
        return count - alreadySayCount
    }
}
