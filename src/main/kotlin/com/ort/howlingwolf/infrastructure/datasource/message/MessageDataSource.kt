package com.ort.howlingwolf.infrastructure.datasource.message

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.cbean.MessageCB
import com.ort.dbflute.exbhv.MessageBhv
import com.ort.dbflute.exentity.Message
import com.ort.howlingwolf.api.controller.VillageController
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageTime
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import java.time.ZoneOffset

@Repository
class MessageDataSource(
    val messageBhv: MessageBhv
) {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private val logger = LoggerFactory.getLogger(VillageController::class.java)

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    /**
     * 発言取得
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @param from これ以降の発言を取得
     * @return 発言
     */
    fun findMessages(
        villageId: Int,
        villageDayId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant?,
        from: Long?,
        pageSize: Int? = null,
        pageNum: Int? = null
    ): Messages {
        return if (pageSize == null || pageNum == null) {
            val messageList = messageBhv.selectList {
                specifyMessage(it, villageId, villageDayId, messageTypeList, participant, from)
            }
            Messages(
                list = messageList.map { convertMessageToMessage(it) }
            )
        } else {
            val messageList = messageBhv.selectPage {
                specifyMessage(it, villageId, villageDayId, messageTypeList, participant, from)
                it.paging(pageSize, pageNum)
            }
            Messages(
                list = messageList.map { convertMessageToMessage(it) },
                allPageCount = messageList.allPageCount,
                isExistPrePage = messageList.existsPreviousPage(),
                isExistNextPage = messageList.existsNextPage(),
                currentPageNum = messageList.currentPageNumber
            )
        }
    }

    private fun specifyMessage(
        cb: MessageCB,
        villageId: Int,
        villageDayId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant?,
        from: Long?
    ) {
        cb.query().setVillageId_Equal(villageId)
        cb.query().setVillageDayId_Equal(villageDayId)
        if (participant != null) {
            cb.orScopeQuery { orCB ->
                orCB.query().setMessageTypeCode_InScope(messageTypeList.map { type -> type.code() })
                orCB.query().setVillagePlayerId_Equal(participant.id)
                orCB.query().setToVillagePlayerId_Equal(participant.id)
            }
        } else {
            cb.query().setMessageTypeCode_InScope(messageTypeList.map { type -> type.code() })
        }
        if (from != null) {
            cb.query().setMessageUnixtimestampMilli_GreaterThan(from)
        }
        cb.query().addOrderBy_MessageUnixtimestampMilli_Asc()
    }

    /**
     * アンカー発言取得
     *
     * @param villageId villageId
     * @param messageType 発言種別
     * @param messageNumber 発言番号
     * @return 発言
     */
    fun findMessage(
        villageId: Int,
        messageType: CDef.MessageType,
        messageNumber: Int
    ): com.ort.howlingwolf.domain.model.message.Message? {
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
    ): List<com.ort.howlingwolf.domain.model.message.Message> {
        val messageList = messageBhv.selectList {
            it.query().setVillageId_Equal(villageId)
            it.query().setVillagePlayerId_Equal(participant.id)
            it.query().setVillageDayId_Equal(villageDayId)
        }
        return messageList.map { convertMessageToMessage(it) }
    }

    fun registerMessage(villageId: Int, message: com.ort.howlingwolf.domain.model.message.Message) {
        val mes = Message()
        mes.villageId = villageId
        mes.villageDayId = message.time.villageDayId
        mes.messageTypeCode = message.content.type.code
        mes.messageContent = message.content.text
        mes.villagePlayerId = message.fromVillageParticipantId
        mes.toVillagePlayerId = message.toVillageParticipantId
        mes.playerId = null // TODO プレイヤー発言を実装する際に実装する
        mes.faceTypeCode = message.content.faceCode
        mes.isConvertDisable = true
        val now = HowlingWolfDateUtil.currentLocalDateTime()
        mes.messageDatetime = now
        mes.messageUnixtimestampMilli = now.toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()

        // 発言番号の採番 & insert (3回チャレンジする)
        for (i in 1..3) {
            try {
                mes.messageNumber = selectNextMessageNumber(villageId, message.content.type.code)
                messageBhv.insert(mes)
                return
            } catch (e: RuntimeException) {
                logger.error(e.message, e)
            }
        }
        throw HowlingWolfBusinessException("混み合っているため発言に失敗しました。再度発言してください。")
    }

    /**
     * 差分更新
     * @param villageId villageId
     * @param before messages
     * @param after messages
     */
    fun updateDifference(villageId: Int, before: Messages, after: Messages) {
        // 追加しかないのでbeforeにないindexから追加していく
        after.list.drop(before.list.size).forEach {
            registerMessage(villageId, it)
        }
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

    private fun convertMessageToMessage(message: Message): com.ort.howlingwolf.domain.model.message.Message {
        return com.ort.howlingwolf.domain.model.message.Message(
            fromVillageParticipantId = message.villagePlayerId,
            toVillageParticipantId = message.toVillagePlayerId,
            time = MessageTime(
                villageDayId = message.villageDayId,
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
