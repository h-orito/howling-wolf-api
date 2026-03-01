package com.ort.howlingwolf.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.service.message.MessageDomainService
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.stereotype.Service

@Service
class MessageCoordinator(
    val dayChangeCoordinator: DayChangeCoordinator,
    val villageCoordinator: VillageCoordinator,
    val playerService: PlayerService,
    val messageService: MessageService,
    val messageDomainService: MessageDomainService
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
        isLatest: Boolean,
        fromParticipantIdList: List<Int>?,
        toParticipantIdList: List<Int>?
    ): Messages {
        val player = user?.let { playerService.findPlayer(it) }
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        val query = messageDomainService.createQuery(
            village = village,
            participant = participant,
            player = player,
            day = day,
            authority = user?.authority,
            messageTypeList = messageTypeList,
            from = from,
            pageSize = pageSize,
            pageNum = pageNum,
            keyword = keyword,
            isLatest = isLatest,
            fromParticipantIdList = fromParticipantIdList,
            toParticipantIdList = toParticipantIdList,
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
        val player = user?.let { playerService.findPlayer(it) }
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        return if (!messageDomainService.isViewableMessage(
                village = village,
                myself = participant,
                player = player,
                messageType = CDef.MessageType.codeOf(messageType)
            )
        ) null
        else messageService.findMessage(village.id, CDef.MessageType.codeOf(messageType), messageNumber) ?: return null
    }

    fun findLatestMessagesUnixTimeMilli(
        village: Village,
        user: HowlingWolfUser?,
        from: Long?
    ): Long {
        val player = user?.let { playerService.findPlayer(it) }
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        val query = messageDomainService.createQuery(
            village = village,
            participant = participant,
            player = player,
            day = village.day.latestDay().day,
            authority = user?.authority,
            messageTypeList = null,
            from = from,
            pageSize = null,
            pageNum = null,
            keyword = null,
            isLatest = false,
            fromParticipantIdList = null,
            toParticipantIdList = null,
        )
        dayChangeCoordinator.dayChangeIfNeeded(village)

        return messageService.findLatestMessagesUnixTimeMilli(village.id, village.day.latestDay().id, query)
    }
}
