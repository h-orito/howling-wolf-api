package com.ort.howlingwolf.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

data class VillageMessageRestrict(
    val type: MessageType,
    val count: Int,
    val length: Int,
    val line: Int = MessageContent.lineMax
) {
    fun assertSay(messageContent: MessageContent, cdefVillageStatus: CDef.VillageStatus, latestDayMessageList: List<Message>) {
        // 回数
        if (remainingCount(cdefVillageStatus, latestDayMessageList) <= 0) throw HowlingWolfBusinessException("発言残り回数が0回です")
        // 文字数
        messageContent.assertMessageLength(length)
    }

    fun remainingCount(cdefVillageStatus: CDef.VillageStatus, latestDayMessageList: List<Message>): Int {
        if (cdefVillageStatus == CDef.VillageStatus.プロローグ || cdefVillageStatus == CDef.VillageStatus.エピローグ) {
            return count // プロローグ、エピローグでは制限なし状態にする
        }
        val alreadySayCount = latestDayMessageList.count { it.content.type.toCdef() == type.toCdef() }
        return count - alreadySayCount
    }
}
