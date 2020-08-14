package com.ort.howlingwolf.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.skill.Skills
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.service.ability.AbilityDomainService
import com.ort.howlingwolf.domain.service.coming_out.ComingOutDomainService
import com.ort.howlingwolf.domain.service.commit.CommitDomainService
import com.ort.howlingwolf.domain.service.participate.ParticipateDomainService
import com.ort.howlingwolf.infrastructure.datasource.message.MessageDataSource
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageDataSource: MessageDataSource,
    private val abilityDomainService: AbilityDomainService,
    private val participateDomainService: ParticipateDomainService,
    private val commitDomainService: CommitDomainService,
    private val comingOutDomainService: ComingOutDomainService
) {
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
        return messageDataSource.findMessages(villageId, villageDayId, query)
    }

    /**
     * 最新発言日時取得
     *
     * @param villageId villageId
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @return 発言
     */
    fun findLatestMessagesUnixTimeMilli(
        villageId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant? = null
    ): Long {
        return messageDataSource.findLatestMessagesUnixTimeMilli(villageId, messageTypeList, participant)
    }

    /**
     * アンカー発言取得
     *
     * @param villageId villageId
     * @param messageType 発言種別
     * @param messageNumber 発言番号
     * @return 発言
     */
    fun findMessage(villageId: Int, messageType: CDef.MessageType, messageNumber: Int): Message? {
        return messageDataSource.findMessage(villageId, messageType, messageNumber)
    }


    /**
     * 参加者のその日の発言を取得
     *
     * @param villageId villageId
     * @param villageDay 村日付
     * @param participant 参加情報
     * @return 発言
     */
    fun findParticipateDayMessageList(
        villageId: Int,
        villageDay: com.ort.howlingwolf.domain.model.village.VillageDay,
        participant: VillageParticipant?
    ): List<Message> {
        participant ?: return listOf()
        return messageDataSource.selectParticipateDayMessageList(villageId, villageDay.id, participant)
    }

    /**
     * 発言登録
     *
     * @param villageId villageId
     * @param message 発言内容
     */
    fun registerSayMessage(villageId: Int, message: Message) = messageDataSource.registerMessage(villageId, message)

    /**
     * 村作成時のシステムメッセージ登録
     * @param village village
     */
    fun registerInitialMessage(village: Village) = messageDataSource.registerMessage(village.id, village.createVillagePrologueMessage())

    /**
     * 村に参加する際の発言を登録
     * @param village village
     * @param participant 参加者
     * @param chara chara
     * @param message message text
     * @param isSpectate 見学か
     */
    fun registerParticipateMessage(
        village: Village,
        participant: VillageParticipant,
        chara: Chara,
        message: String,
        isSpectate: Boolean
    ) {
        // {N}人目、{キャラ名}。
        messageDataSource.registerMessage(
            village.id,
            participateDomainService.createParticipateMessage(village, chara, isSpectate)
        )
        // 参加発言
        val messageContent = MessageContent.invoke(
            CDef.MessageType.通常発言.code(),
            message,
            CDef.FaceType.通常.code()
        )
        messageDataSource.registerMessage(
            village.id,
            Message.createSayMessage(participant, village.day.prologueDay().id, messageContent)
        )
    }

    /**
     * 退村する際のシステムメッセージを登録
     * @param village village
     * @param chara chara
     */
    fun registerLeaveMessage(village: Village, chara: Chara) =
        messageDataSource.registerMessage(
            village.id,
            participateDomainService.createLeaveMessage(village, chara)
        )

    /**
     * 能力セットする際のシステムメッセージを登録
     * @param village village
     * @param participant 村参加者
     * @param targetId 対象の村参加者ID
     * @param abilityType abilityType
     * @param charas キャラ
     */
    fun registerAbilitySetMessage(
        village: Village,
        participant: VillageParticipant,
        targetId: Int?,
        abilityType: AbilityType,
        charas: Charas
    ) {
        val myChara: Chara = charas.chara(participant.charaId)
        val targetChara: Chara? = if (targetId == null) null else charas.chara(village.participant, targetId)
        val message: Message = abilityDomainService.createAbilitySetMessage(village, myChara, targetChara, abilityType)
        messageDataSource.registerMessage(village.id, message)
    }

    /**
     * コミットする際のシステムメッセージを登録
     *
     * @param village village
     * @param chara キャラ
     * @param doCommit コミット/取り消し
     */
    fun registerCommitMessage(village: Village, chara: Chara, doCommit: Boolean) {
        messageDataSource.registerMessage(
            village.id,
            commitDomainService.createCommitMessage(chara, doCommit, village.day.latestDay().id)
        )
    }

    fun registerComingOutMessage(village: Village, chara: Chara, skills: Skills) {
        messageDataSource.registerMessage(
            village.id,
            comingOutDomainService.createComingOutMessage(chara, skills, village.day.latestDay().id)
        )
    }

    /**
     * 差分更新
     * @param villageId villageId
     * @param before messages
     * @param after messages
     */
    fun updateDifference(villageId: Int, before: Messages, after: Messages) {
        messageDataSource.updateDifference(villageId, before, after)
    }
}