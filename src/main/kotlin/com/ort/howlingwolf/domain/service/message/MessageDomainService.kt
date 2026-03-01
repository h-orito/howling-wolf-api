package com.ort.howlingwolf.domain.service.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.service.message.say.SayDomainService
import com.ort.howlingwolf.domain.service.message.system.AttackMessageDomainService
import com.ort.howlingwolf.domain.service.message.system.FanaticMessageDomainService
import com.ort.howlingwolf.domain.service.message.system.FoxMessageDomainService
import com.ort.howlingwolf.domain.service.message.system.MasonMessageDomainService
import com.ort.howlingwolf.domain.service.message.system.PrivateSystemMessageDomainService
import com.ort.howlingwolf.domain.service.message.system.PsychicMessageDomainService
import org.springframework.stereotype.Service

@Service
class MessageDomainService(
    private val sayDomainService: SayDomainService,
    private val psychicMessageDomainService: PsychicMessageDomainService,
    private val attackMessageDomainService: AttackMessageDomainService,
    private val masonMessageDomainService: MasonMessageDomainService,
    private val foxMessageDomainService: FoxMessageDomainService,
    private val fanaticMessageDomainService: FanaticMessageDomainService,
    private val privateSystemMessageDomainService: PrivateSystemMessageDomainService
) {
    /**
     * 閲覧できる発言種別リスト
     */
    fun viewableMessageTypeList(
        village: Village,
        participant: VillageParticipant?,
        player: Player?,
        day: Int,
        authority: CDef.Authority?
    ): List<CDef.MessageType> {
        // 管理者は全て見られる
        if (authority == CDef.Authority.管理者) return CDef.MessageType.listAll()
        // 村が終了していたら全て見られる
        if (village.status.isSolved()) return CDef.MessageType.listAll()

        val allowedTypeList: MutableList<CDef.MessageType> = mutableListOf()
        allowedTypeList.addAll(MessageType.everyoneAllowedMessageTypeList)
        // 権限に応じて追加していく（独り言と秘話はここでは追加しない）
        (MessageType.sayTypeList + MessageType.commonSystemTypeList).forEach {
            if (isViewableMessage(village, participant, player, it, day)) allowedTypeList.add(it)
        }
        return allowedTypeList
    }

    fun isViewableMessage(
        village: Village,
        myself: VillageParticipant?,
        player: Player?,
        messageType: CDef.MessageType,
        day: Int = 1
    ): Boolean {
        return if (messageType == CDef.MessageType.村建て発言) true
        else detectMessageTypeDomainService(messageType).isViewable(village, myself, player, day)
    }

    fun createQuery(
        village: Village,
        participant: VillageParticipant?,
        player: Player?,
        day: Int,
        authority: CDef.Authority?,
        messageTypeList: List<CDef.MessageType>?,
        from: Long?,
        pageSize: Int?,
        pageNum: Int?,
        keyword: String?,
        isLatest: Boolean,
        fromParticipantIdList: List<Int>?,
        toParticipantIdList: List<Int>?
    ): MessageQuery {
        val availableMessageTypeList = viewableMessageTypeList(village, participant, player, day, authority)
        val requestMessageTypeList =
            if (messageTypeList.isNullOrEmpty()) CDef.MessageType.listAll() else messageTypeList
        val queryMessageTypeList = requestMessageTypeList.filter { availableMessageTypeList.contains(it) }
        return MessageQuery(
            from = from,
            pageSize = pageSize,
            pageNum = pageNum,
            keyword = if (keyword.isNullOrBlank()) null else keyword,
            participant = participant,
            messageTypeList = queryMessageTypeList,
            fromParticipantIdList = fromParticipantIdList,
            toParticipantIdList = toParticipantIdList,
            includeMonologue = isIncludeMonologue(
                participant,
                fromParticipantIdList,
                requestMessageTypeList,
                queryMessageTypeList
            ),
            includeSecret = isIncludeSecret(
                participant,
                fromParticipantIdList,
                toParticipantIdList,
                requestMessageTypeList,
                queryMessageTypeList
            ),
            includePrivateAbility = isIncludePrivateAbility(participant, requestMessageTypeList),
            isLatest = isLatest
        )
    }

    private fun isIncludeMonologue(
        participant: VillageParticipant?,
        participantIdList: List<Int>?,
        requestMessageTypeList: List<CDef.MessageType>,
        queryMessageTypeList: List<CDef.MessageType>
    ): Boolean {
        // 既に取得対象になっていれば不要
        if (queryMessageTypeList.contains(CDef.MessageType.独り言)) return false
        // 自分が取得対象になっていなければ不要
        participant ?: return false
        if (participantIdList != null && !participantIdList.contains(participant.id)) return false
        // 求めていなければ不要
        if (!requestMessageTypeList.contains(CDef.MessageType.独り言)) return false

        return true
    }

    private fun isIncludeSecret(
        participant: VillageParticipant?,
        fromParticipantIdList: List<Int>?,
        toParticipantIdList: List<Int>?,
        requestMessageTypeList: List<CDef.MessageType>,
        queryMessageTypeList: List<CDef.MessageType>
    ): Boolean {
        // 既に取得対象になっていれば不要
        if (queryMessageTypeList.contains(CDef.MessageType.秘話)) return false
        // 自分が取得対象になっていなければ不要
        participant ?: return false
        val containFrom = fromParticipantIdList.isNullOrEmpty() || fromParticipantIdList.contains(participant.id)
        val containTo = toParticipantIdList.isNullOrEmpty() || toParticipantIdList.contains(participant.id)
        if (!containFrom && !containTo) return false
        // 求めていなければ不要
        if (!requestMessageTypeList.contains(CDef.MessageType.秘話)) return false

        return true
    }

    // 霊視や襲撃でなく、占いなどの個別のが対象
    private fun isIncludePrivateAbility(
        participant: VillageParticipant?,
        requestMessageTypeList: List<CDef.MessageType>
    ): Boolean {
        participant ?: return false
        return requestMessageTypeList.contains(CDef.MessageType.公開システムメッセージ)
    }

    private fun detectMessageTypeDomainService(messageType: CDef.MessageType): MessageTypeDomainService {
        if (MessageType(messageType).isSayType()) return sayDomainService.detectSayTypeService(messageType)
        return when (messageType) {
            CDef.MessageType.白黒霊視結果 -> psychicMessageDomainService
            CDef.MessageType.襲撃結果 -> attackMessageDomainService
            CDef.MessageType.共有相互確認メッセージ -> masonMessageDomainService
            CDef.MessageType.妖狐メッセージ -> foxMessageDomainService
            CDef.MessageType.狂信者人狼確認メッセージ -> fanaticMessageDomainService
            CDef.MessageType.非公開システムメッセージ -> privateSystemMessageDomainService
            else -> throw IllegalStateException("service not found.")
        }
    }
}