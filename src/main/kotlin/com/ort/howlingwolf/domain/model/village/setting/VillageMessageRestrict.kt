package com.ort.howlingwolf.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

data class VillageMessageRestrict(
    val type: MessageType,
    val count: Int,
    val length: Int,
    val line: Int = MessageContent.defaultLineMax
) {
    fun assertSay(
        messageContent: MessageContent,
        cdefVillageStatus: CDef.VillageStatus,
        latestDayMessageCountMap: Map<CDef.MessageType, Int>
    ) {
        // 回数
        if (remainingCount(
                cdefVillageStatus,
                latestDayMessageCountMap
            ) <= 0
        ) throw HowlingWolfBusinessException("発言残り回数が0回です")
        // 文字数
        messageContent.assertMessageLength(length)
    }

    fun remainingCount(
        cdefVillageStatus: CDef.VillageStatus,
        latestDayMessageCountMap: Map<CDef.MessageType, Int>
    ): Int {
        if (cdefVillageStatus == CDef.VillageStatus.プロローグ || cdefVillageStatus == CDef.VillageStatus.エピローグ) {
            return count // プロローグ、エピローグでは制限なし状態にする
        }
        val alreadySayCount = latestDayMessageCountMap.getOrDefault(type.toCdef(), 0)
        return count - alreadySayCount
    }
}
