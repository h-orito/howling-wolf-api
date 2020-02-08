package com.ort.howlingwolf.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.domain.model.message.Message
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
    fun findMessageList(village: Village, day: Int, noonnight: String, user: HowlingWolfUser?, from: Long?): Messages {
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        val messageTypeList: List<CDef.MessageType> = village.viewableMessageTypeList(participant, day, user?.authority)
        val villageDayId: Int = village.day.dayList.first { it.day == day && it.noonnight == noonnight }.id
        val messages: Messages = messageService.findMessages(village.id, villageDayId, messageTypeList, participant, from)
        dayChangeCoordinator.dayChangeIfNeeded(village)
        return messages
    }

    fun findMessage(village: Village, messageType: String, messageNumber: Int, user: HowlingWolfUser?): Message? {
        val participant: VillageParticipant? = villageCoordinator.findParticipant(village, user)
        return if (!village.isViewableMessage(participant, messageType)) null
        else messageService.findMessage(village.id, CDef.MessageType.codeOf(messageType), messageNumber) ?: return null
    }
}
