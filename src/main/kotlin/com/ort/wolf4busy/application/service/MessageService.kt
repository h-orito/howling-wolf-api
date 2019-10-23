package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
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
     * 発言取得
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @param from これ以降の発言を取得する unixtimemilli
     */
    fun findMessageList(
        villageId: Int,
        villageDayId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant?,
        from: Long?
    ): List<Message> {
        return messageDataSource.selectMessageList(villageId, villageDayId, messageTypeList, participant, from)
    }

    fun findMessage(villageId: Int, participant: VillageParticipant?, messageType: CDef.MessageType, messageNumber: Int): Message? {
        return messageDataSource.selectMessage(villageId, messageType, messageNumber)
    }

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

    /**
     * 村に参加する際の発言を登録
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param villagePlayerId 村参加者ID
     * @param charaName 自分のキャラ名
     * @param firstRequestSkillName 役職第1希望
     * @param secondRequestSkillName 役職第2希望
     * @param message 入村時発言
     * @param participateNumber 何人目の入村か
     * @param isSpectate 見学か
     */
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
            text = (if (isSpectate) "（見学） " else "") + "${participateNumber}人目、$charaName。"
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