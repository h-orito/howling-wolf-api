package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.MessageService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.application.util.MessageAuthorizationUtil
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
            messageList = complementMessageList(messageList, village, day)
        )
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
        if (MessageAuthorizationUtil.isViewableGraveMessage(village, participant)) allowedTypeList.add(CDef.MessageType.死者の呻き)
        if (MessageAuthorizationUtil.isViewableSpectateMessage(village, participant, day)) allowedTypeList.add(CDef.MessageType.見学発言)
        if (MessageAuthorizationUtil.isViewableMasonMessage(village, participant)) allowedTypeList.add(CDef.MessageType.共鳴発言)
        if (MessageAuthorizationUtil.isViewableWolfMessage(village, participant)) allowedTypeList.add(CDef.MessageType.人狼の囁き)
        if (MessageAuthorizationUtil.isViewableSeerMessage(village, participant)) allowedTypeList.add(CDef.MessageType.白黒占い結果)
        if (MessageAuthorizationUtil.isViewableWiseMessage(village, participant)) allowedTypeList.add(CDef.MessageType.役職占い結果)
        if (MessageAuthorizationUtil.isViewablePsychicMessage(village, participant)) allowedTypeList.add(CDef.MessageType.白黒霊視結果)
        if (MessageAuthorizationUtil.isViewableGuruMessage(village, participant)) allowedTypeList.add(CDef.MessageType.役職霊視結果)
        return allowedTypeList
    }


    private fun complementMessageList(messageList: List<Message>, village: Village, day: Int): List<Message> {
        return messageList.map { message ->
            message.copy(
                from = if (message.from == null) null else village.participant.memberList.find { participant -> participant.id == message.from.id },
                to = if (message.to == null) null else village.participant.memberList.find { participant -> participant.id == message.to.id },
                time = message.time.copy(day = day)
            )
        }
    }
}
