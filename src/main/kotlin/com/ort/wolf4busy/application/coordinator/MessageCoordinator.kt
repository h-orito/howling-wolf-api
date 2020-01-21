package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.MessageService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service

@Service
class MessageCoordinator(
    val dayChangeCoordinator: DayChangeCoordinator,

    val messageService: MessageService,
    val villageService: VillageService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun findMessageList(village: Village, day: Int, noonnight: String, user: Wolf4busyUser?, from: Long?): Messages {
        val participant: VillageParticipant? = villageService.findParticipantByUid(village.id, user?.uid)
        val messageTypeList = village.viewableMessageTypeList(participant, day, user?.authority)
        val villageDayId = village.day.dayList.first { it.day == day && it.noonnight == noonnight }.id
        val messages = messageService.findMessageList(village.id, villageDayId, messageTypeList, participant, from)
        dayChangeCoordinator.dayChangeIfNeeded(village)
        return messages
    }

    fun findMessage(village: Village, messageType: String, messageNumber: Int, user: Wolf4busyUser?): Message? {
        val participant: VillageParticipant? = villageService.findParticipantByUid(village.id, user?.uid)
        if (!village.isViewableMessage(participant, messageType)) {
            return null
        }
        return messageService.findMessage(village.id, CDef.MessageType.codeOf(messageType), messageNumber) ?: return null
    }
}
