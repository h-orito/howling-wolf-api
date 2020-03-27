package com.ort.howlingwolf.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.stereotype.Service

@Service
class MessageCoordinator(
    val dayChangeCoordinator: DayChangeCoordinator,
    val villageCoordinator: VillageCoordinator,

    val messageService: MessageService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun findMessageList(
        village: Village,
        day: Int,
        noonnight: String,
        user: HowlingWolfUser?,
        from: Long?,
        pageSize: Int?,
        pageNum: Int?,
        keyword: String?,
        messageTypeList: List<CDef.MessageType>?,
        participantIdList: List<Int>?
    ): Messages {
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        val query = MessageQuery.invoke(
            village = village,
            participant = participant,
            day = day,
            authority = user?.authority,
            messageTypeList = messageTypeList,
            from = from,
            pageSize = pageSize,
            pageNum = pageNum,
            keyword = keyword,
            participantIdList = participantIdList
        )
        val villageDayId: Int = village.day.dayList.first { it.day == day && it.noonnight == noonnight }.id
        val messages: Messages = messageService.findMessages(
            villageId = village.id,
            villageDayId = villageDayId,
            query = query
        )
        dayChangeCoordinator.dayChangeIfNeeded(village)
        return messages
    }

    fun findMessage(village: Village, messageType: String, messageNumber: Int, user: HowlingWolfUser?): Message? {
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        return if (!village.isViewableMessage(participant, messageType)) null
        else messageService.findMessage(village.id, CDef.MessageType.codeOf(messageType), messageNumber) ?: return null
    }

    fun findLatestMessagesUnixTimeMilli(
        village: Village,
        user: HowlingWolfUser?
    ): Long {
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        val messageTypeList: List<CDef.MessageType> =
            village.viewableMessageTypeList(participant, village.day.latestDay().day, user?.authority)
        return messageService.findLatestMessagesUnixTimeMilli(village.id, messageTypeList, participant)
    }
}
