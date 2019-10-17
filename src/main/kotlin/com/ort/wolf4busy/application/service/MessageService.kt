package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.infrastructure.datasource.message.MessageDataSource
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(
    val messageSource: MessageSource,
    val messageDataSource: MessageDataSource
) {
    /**
     * 村作成時のシステムメッセージ登録
     * @param villageId villageId
     * @param villageDayId 村日付id
     */
    fun registerInitialMessage(villageId: Int, villageDayId: Int) {
        val initialMessage: String = messageSource.getMessage(
            "village.initial.message",
            null,
            Locale.JAPANESE
        )
        messageDataSource.insertMessage(
            villageId = villageId,
            dayId = villageDayId,
            messageType = CDef.MessageType.公開システムメッセージ.code(),
            text = initialMessage
        )
    }

    fun registerParticipateMessage(
        villageId: Int,
        villageDayId: Int,
        villagePlayerId: Int,
        charaName: String,
        firstRequestSkillName: String,
        secondRequestSkillName: String,
        message: String,
        participateNumber: Int,
        isSpectate: Boolean
    ) {
        // {N}人目、{キャラ名}。
        messageDataSource.insertMessage(
            villageId = villageId,
            dayId = villageDayId,
            messageType = CDef.MessageType.公開システムメッセージ.code(),
            text = (if (isSpectate) "（見学） " else "") + "${participateNumber}人目、$charaName"
        )
        // 参加発言
        messageDataSource.insertMessage(
            villageId = villageId,
            dayId = villageDayId,
            messageType = CDef.MessageType.通常発言.code(),
            text = message,
            villagePlayerId = villagePlayerId,
            faceType = CDef.FaceType.通常.code()
        )
    }
}