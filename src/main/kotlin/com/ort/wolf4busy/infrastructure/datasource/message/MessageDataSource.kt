package com.ort.wolf4busy.infrastructure.datasource.message

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.MessageBhv
import com.ort.dbflute.exentity.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import org.springframework.stereotype.Repository
import java.time.ZoneOffset

@Repository
class MessageDataSource(
    val messageBhv: MessageBhv
) {

    /**
     * 発言取得
     * partitionを切っているので関連テーブルの情報は別途取得して埋めること
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @param from これ以降の発言を取得
     * @return 発言
     */
    fun selectMessageList(
        villageId: Int,
        villageDayId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant?,
        from: Long?
    ): List<com.ort.wolf4busy.domain.model.message.Message> {
        val messageList = messageBhv.selectList {
            it.query().setVillageId_Equal(villageId)
            it.query().setVillageDayId_Equal(villageDayId)
            if (participant != null) {
                it.orScopeQuery { orCB ->
                    orCB.query().setMessageTypeCode_InScope(messageTypeList.map { type -> type.code() })
                    orCB.orScopeQueryAndPart { andCB ->
                        andCB.query().setMessageTypeCode_Equal(CDef.MessageType.独り言.code())
                        andCB.query().setVillagePlayerId_Equal(participant.id)
                    }
                    orCB.orScopeQueryAndPart { andCB ->
                        andCB.query().setMessageTypeCode_Equal(CDef.MessageType.秘話.code())
                        andCB.query().setVillagePlayerId_Equal(participant.id)
                    }
                    orCB.orScopeQueryAndPart { andCB ->
                        andCB.query().setMessageTypeCode_Equal(CDef.MessageType.秘話.code())
                        andCB.query().setToVillagePlayerId_Equal(participant.id)
                    }
                }
            } else {
                it.query().setMessageTypeCode_InScope(messageTypeList.map { type -> type.code() })
            }
            if (from != null) {
                it.query().setMessageUnixtimestampMilli_GreaterThan(from)
            }
            it.query().addOrderBy_MessageUnixtimestampMilli_Asc()
        }
        return messageList.map { convertMessageToMessage(it) }
    }

    /**
     * アンカー発言取得
     *
     * @param villageId villageId
     * @param messageType 発言種別
     * @param messageNumber 発言番号
     * @return 発言
     */
    fun selectMessage(villageId: Int, messageType: CDef.MessageType, messageNumber: Int): com.ort.wolf4busy.domain.model.message.Message? {
        val optMessage = messageBhv.selectEntity {
            it.query().setVillageId_Equal(villageId)
            it.query().setMessageNumber_Equal(messageNumber)
            it.query().setMessageTypeCode_Equal(messageType.code())
        }
        return optMessage.map { convertMessageToMessage(it) }.orElse(null)
    }

    /**
     * 参加者のその日の発言を取得
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param participant 参加情報
     * @return 発言
     */
    fun selectParticipateDayMessageList(
        villageId: Int,
        villageDayId: Int,
        participant: VillageParticipant
    ): List<com.ort.wolf4busy.domain.model.message.Message> {
        val messageList = messageBhv.selectList {
            it.query().setVillageId_Equal(villageId)
            it.query().setVillagePlayerId_Equal(participant.id)
            it.query().setVillageDayId_Equal(villageDayId)
        }
        return messageList.map { convertMessageToMessage(it) }
    }

    fun insertMessage(
        villageId: Int,
        dayId: Int,
        messageType: String,
        text: String,
        villagePlayerId: Int? = null,
        targetVillagePlayerId: Int? = null,
        playerId: Int? = null,
        faceType: String? = null
    ) {
        val mes = Message()
        mes.villageId = villageId
        mes.villageDayId = dayId
        mes.messageTypeCode = messageType
        mes.messageContent = text
        mes.villagePlayerId = villagePlayerId
        mes.toVillagePlayerId = targetVillagePlayerId
        mes.playerId = playerId
        mes.faceTypeCode = faceType
        mes.isConvertDisable = true
        val now = Wolf4busyDateUtil.currentLocalDateTime()
        mes.messageDatetime = now
        mes.messageUnixtimestampMilli = now.toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()

        // 発言番号の採番 & insert (3回チャレンジする)
        for (i in 1..3) {
            try {
                mes.messageNumber = selectNextMessageNumber(villageId, messageType)
                messageBhv.insert(mes)
                return
            } catch (e: RuntimeException) {
                e.printStackTrace()
                // 握りつぶす
            }
        }
        throw Wolf4busyBusinessException("混み合っているため発言に失敗しました。再度発言してください。")
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun selectNextMessageNumber(villageId: Int, messageType: String): Int {
        val maxNumber: Int = messageBhv.selectScalar(Int::class.java).max {
            it.specify().columnMessageNumber()
            it.query().setVillageId_Equal(villageId)
            it.query().setMessageTypeCode_Equal(messageType)
        }.orElse(0)
        return maxNumber + 1
    }

    private fun convertMessageToMessage(message: Message): com.ort.wolf4busy.domain.model.message.Message {
        return com.ort.wolf4busy.domain.model.message.Message(
            from = if (message.villagePlayerId == null) null else VillageParticipant(
                id = message.villagePlayerId,
                charaId = 1, // dummy
                dead = null, // dummy
                isSpectator = false, // dummy
                playerId = message.playerId,
                skill = null // dummy
            ),
            to = if (message.toVillagePlayerId == null) null else VillageParticipant(
                id = message.toVillagePlayerId,
                charaId = 1, // dummy
                dead = null, // dummy
                isSpectator = false, // dummy
                playerId = null,
                skill = null // dummy
            ),
            time = MessageTime(
                day = 1, // dummy
                datetime = message.messageDatetime,
                unixTimeMilli = message.messageUnixtimestampMilli
            ),
            content = MessageContent(
                type = MessageType(
                    code = message.messageTypeCode,
                    name = CDef.MessageType.codeOf(message.messageTypeCode).alias()
                ),
                num = message.messageNumber,
                text = message.messageContent,
                faceCode = message.faceTypeCode
            )
        )
    }
}
