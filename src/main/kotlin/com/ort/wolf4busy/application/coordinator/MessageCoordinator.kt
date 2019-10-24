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
    val messageService: MessageService,
    val villageService: VillageService

) {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private val everyoneAllowedMessageTypeList = listOf(CDef.MessageType.公開システムメッセージ, CDef.MessageType.通常発言, CDef.MessageType.村建て発言)

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun findMessageList(villageId: Int, day: Int, noonnight: String, user: Wolf4busyUser?, from: Long?): Messages {
        val participant: VillageParticipant? = villageService.findParticipantByUid(
            villageId, user?.uid
        )
        val village = villageService.findVillage(villageId)
        val messageTypeList = makeViewAllowedMessageTypeList(village, participant, day, user?.authority)
        val villageDayId = villageService.findVillageDay(villageId, day, noonnight).id
        val messageList: List<Message> = messageService.findMessageList(villageId, villageDayId, messageTypeList, participant, from)
        return Messages(
            messageList = messageList.map { complementMessage(it, village, day) }
        )
    }

    fun findMessage(villageId: Int, messageType: String, messageNumber: Int, user: Wolf4busyUser?): Message? {
        val participant: VillageParticipant? = villageService.findParticipantByUid(
            villageId, user?.uid
        )
        val village = villageService.findVillage(villageId)
        if (!isViewAllowed(village, participant, messageType)) {
            return null
        }
        val message: Message =
            messageService.findMessage(villageId, participant, CDef.MessageType.codeOf(messageType), messageNumber) ?: return null
        return complementMessage(message, village, message.time.day)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun makeViewAllowedMessageTypeList(
        village: Village,
        participant: VillageParticipant?,
        day: Int,
        authority: CDef.Authority?
    ): List<CDef.MessageType> {
        // 管理者は全て見られる
        if (authority != null && authority == CDef.Authority.管理者) return CDef.MessageType.listAll()
        // 村が終了していたら全て見られる
        if (village.isCompleted()) return CDef.MessageType.listAll()

        val allowedTypeList: MutableList<CDef.MessageType> = mutableListOf()
        allowedTypeList.addAll(everyoneAllowedMessageTypeList)
        // 権限に応じて追加していく（独り言と秘話はここでは追加しない）
        if (village.isViewableGraveMessage(participant)) allowedTypeList.add(CDef.MessageType.死者の呻き)
        if (village.isViewableSpectateMessage(participant, day)) allowedTypeList.add(CDef.MessageType.見学発言)
        if (village.isViewableMasonMessage(participant)) allowedTypeList.add(CDef.MessageType.共鳴発言)
        if (village.isViewableWerewolfMessage(participant)) allowedTypeList.add(CDef.MessageType.人狼の囁き)
        if (village.isViewableSeerMessage(participant)) allowedTypeList.add(CDef.MessageType.白黒占い結果)
        if (village.isViewableWiseMessage(participant)) allowedTypeList.add(CDef.MessageType.役職占い結果)
        if (village.isViewablePsychicMessage(participant)) allowedTypeList.add(CDef.MessageType.白黒霊視結果)
        if (village.isViewableGuruMessage(participant)) allowedTypeList.add(CDef.MessageType.役職霊視結果)
        return allowedTypeList
    }


    private fun isViewAllowed(village: Village, participant: VillageParticipant?, messageType: String): Boolean {
        val type: CDef.MessageType = CDef.MessageType.codeOf(messageType) ?: return false
        if (type == CDef.MessageType.通常発言 || type == CDef.MessageType.村建て発言) return true
        if (type == CDef.MessageType.人狼の囁き) return village.isViewableWerewolfMessage(participant)
        if (type == CDef.MessageType.共鳴発言) return village.isViewableMasonMessage(participant)
        if (type == CDef.MessageType.死者の呻き) return village.isViewableGraveMessage(participant)
        if (type == CDef.MessageType.見学発言) return village.isViewableSpectateMessage(participant, 1)
        if (type == CDef.MessageType.独り言) return village.isViewableMonologueMessage()
        if (type == CDef.MessageType.秘話) return village.isViewableSecretMessage()
        return false
    }

    private fun complementMessage(message: Message, village: Village, day: Int): Message {
        return message.copy(
            from = if (message.from == null) null else village.participant.memberList.find { participant -> participant.id == message.from.id },
            to = if (message.to == null) null else village.participant.memberList.find { participant -> participant.id == message.to.id },
            time = message.time.copy(day = day)
        )
    }
}
