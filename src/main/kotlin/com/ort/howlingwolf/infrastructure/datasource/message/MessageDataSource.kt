package com.ort.howlingwolf.infrastructure.datasource.message

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.cbean.MessageCB
import com.ort.dbflute.exbhv.MessageBhv
import com.ort.dbflute.exentity.Message
import com.ort.howlingwolf.api.controller.VillageController
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.message.MessageTime
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.apache.commons.collections4.CollectionUtils
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
     * @param query query
     * @return 発言
     */
    fun findMessages(
        villageId: Int,
        villageDayId: Int,
        query: MessageQuery
    ): Messages {
        if (query.messageTypeList.isEmpty() && !query.includeMonologue && !query.includeSecret) {
            return Messages(listOf())
        }

        return if (query.isPaging()) {
            val messageList = messageBhv.selectPage {
                queryMessage(
                    cb = it,
                    villageId = villageId,
                    villageDayId = villageDayId,
                    query = query
                )
                it.query().addOrderBy_MessageUnixtimestampMilli_Asc()
                it.paging(query.pageSize!!, query.pageNum!!)
            }
            Messages(
                list = messageList.map { convertMessageToMessage(it) },
                allRecordCount = messageList.allRecordCount,
                allPageCount = messageList.allPageCount,
                isExistPrePage = messageList.existsPreviousPage(),
                isExistNextPage = messageList.existsNextPage(),
                currentPageNum = messageList.currentPageNumber
            )

        } else {
            val messageList = messageBhv.selectList {
                queryMessage(
                    cb = it,
                    villageId = villageId,
                    villageDayId = villageDayId,
                    query = query
                )
                it.query().addOrderBy_MessageUnixtimestampMilli_Asc()
            }
            Messages(
                list = messageList.map { convertMessageToMessage(it) }
            )
        }
    }

    /**
     * 最新発言日時取得
     *
     * @param villageId villageId
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @return 最新発言日時(unix_datetime_milli)
     */
    fun findLatestMessagesUnixTimeMilli(
        villageId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant?
    ): Long {
        val query = MessageQuery(
            from = null,
            pageSize = null,
            pageNum = null,
            keyword = null,
            participant = participant,
            messageTypeList = messageTypeList,
            participantIdList = null,
            includeMonologue = false,
            includeSecret = false,
            includePrivateAbility = false
        )
        return messageBhv.selectEntityWithDeletedCheck() {
            queryMessage(it, villageId, null, query)
            it.query().addOrderBy_MessageUnixtimestampMilli_Desc()
            it.fetchFirst(1)
        }.messageUnixtimestampMilli
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
        val messageTypeCode = message.content.type.code
        mes.villageId = villageId
        mes.villageDayId = message.time.villageDayId
        mes.messageTypeCode = messageTypeCode
        mes.messageContent = message.content.text
        mes.villagePlayerId = message.fromVillageParticipantId
        mes.toVillagePlayerId = message.toVillageParticipantId
        mes.playerId = null // TODO プレイヤー発言を実装する際に実装する
        mes.faceTypeCode = message.content.faceCode
        mes.isConvertDisable = true
        val now = HowlingWolfDateUtil.currentLocalDateTime()
        mes.messageDatetime = now
        mes.messageUnixtimestampMilli = now.toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()

        // 何回目の発言か
        if (message.content.type.shouldSetCount()) {
            val count: Int = selectMessageTypeCount(villageId, message.time.villageDayId, messageTypeCode, message.fromVillageParticipantId)
            mes.messageCount = count + 1
        }

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

    private fun selectMessageTypeCount(
        villageId: Int,
        villageDayId: Int,
        messageTypeCode: String,
        villageParticipantId: Int?
    ): Int {
        return messageBhv.selectCount {
            it.query().setVillageId_Equal(villageId)
            it.query().setVillageDayId_Equal(villageDayId)
            it.query().setMessageTypeCode_Equal(messageTypeCode)
            it.query().setVillagePlayerId_Equal(villageParticipantId)
        }
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
                count = message.messageCount,
                text = message.messageContent,
                faceCode = message.faceTypeCode
            )
        )
    }

    private fun queryMessage(
        cb: MessageCB,
        villageId: Int,
        villageDayId: Int?,
        query: MessageQuery
    ) {
        cb.query().setVillageId_Equal(villageId)
        if (villageDayId != null) cb.query().setVillageDayId_Equal(villageDayId)
        // 参加していない場合は特に考慮不要
        if (query.participant == null) {
            cb.query().setMessageTypeCode_InScope(query.messageTypeList.map { type -> type.code() })
        } else {
            val participantId = query.participant.id
            // 進行中で独り言や秘話だけを見たい場合
            if (query.messageTypeList.isEmpty()) {
                if (!query.includeMonologue && !query.includeSecret && !query.includePrivateAbility) {
                    // 何もしない
                } else {
                    cb.orScopeQuery { orCB ->
                        if (query.includeMonologue) orCB.orScopeQueryAndPart { andCB -> queryMyMonologue(andCB, participantId) }
                        if (query.includeSecret) orCB.orScopeQueryAndPart { andCB -> querySecretSayToMe(andCB, participantId) }
                        if (query.includePrivateAbility) orCB.orScopeQueryAndPart { andCB -> queryMyPrivateAbility(andCB, participantId) }
                    }
                }
            }
            // エピローグなど、全部見える状況の場合はorでなくて良い
            else if (!query.includeMonologue && !query.includeSecret && !query.includePrivateAbility) {
                cb.query().setMessageTypeCode_InScope(query.messageTypeList.map { type -> type.code() })
            }
            // その他
            else {
                cb.orScopeQuery { orCB ->
                    orCB.query().setMessageTypeCode_InScope(query.messageTypeList.map { type -> type.code() })
                    if (query.includeMonologue) orCB.orScopeQueryAndPart { andCB -> queryMyMonologue(andCB, participantId) }
                    if (query.includeSecret) orCB.orScopeQueryAndPart { andCB -> querySecretSayToMe(andCB, participantId) }
                    if (query.includePrivateAbility) orCB.orScopeQueryAndPart { andCB -> queryMyPrivateAbility(andCB, participantId) }
                }
            }
        }
        query.from?.let { cb.query().setMessageUnixtimestampMilli_GreaterThan(it) }
        query.keyword?.let { cb.query().setMessageContent_LikeSearch(it) { op -> op.splitByBlank().likeContain().asOrSplit() } }
        if (CollectionUtils.isNotEmpty(query.participantIdList)) cb.query().setVillagePlayerId_InScope(query.participantIdList)
    }

    private fun queryMyMonologue(cb: MessageCB, id: Int) {
        cb.query().setVillagePlayerId_Equal(id)
        cb.query().setMessageTypeCode_Equal(CDef.MessageType.独り言.code())
    }

    private fun queryMyPrivateAbility(cb: MessageCB, id: Int) {
        cb.query().setVillagePlayerId_Equal(id)
        cb.query().setMessageTypeCode_InScope(MessageQuery.personalPrivateAbilityList.map { it.code() })
    }

    private fun querySecretSayToMe(cb: MessageCB, id: Int) {
        cb.query().setToVillagePlayerId_Equal(id)
        cb.query().setMessageTypeCode_Equal(CDef.MessageType.秘話.code())
    }
}
