package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.Leave
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.infrastructure.datasource.message.MessageDataSource
import org.springframework.stereotype.Service

@Service
class MessageService(
    val messageDataSource: MessageDataSource
) {
    /**
     * 発言取得
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param messageTypeList 発言種別
     * @param participant 参加情報
     * @param from これ以降の発言を取得する unixtimemilli
     * @return 発言
     */
    fun findMessageList(
        villageId: Int,
        villageDayId: Int,
        messageTypeList: List<CDef.MessageType>,
        participant: VillageParticipant? = null,
        from: Long? = null
    ): Messages {
        return messageDataSource.findMessages(villageId, villageDayId, messageTypeList, participant, from)
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
        villageDay: com.ort.wolf4busy.domain.model.village.VillageDay,
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
     * @param villageId villageId
     * @param villageDayId 村日付ID
     */
    fun registerInitialMessage(villageId: Int, villageDayId: Int) {
        val text = Village.getInitialMessage()
        val message = Message.createPublicSystemMessage(text, villageDayId)
        messageDataSource.registerMessage(villageId, message)
    }

    /**
     * 村に参加する際の発言を登録
     *
     * @param villageId villageId
     * @param villageDayId 村日付ID
     * @param villagePlayerId 村参加者ID
     * @param charaName 自分のキャラ名
     * @param firstRequestSkillName 役職第1希望
     * @param secondRequestSkillName 役職第2希望
     * @param message 入村時発言
     * @param participateNumber 何人目の入村か
     * @param isSpectate 見学か
     */
    fun registerParticipateMessage(
        villageId: Int,
        villageDayId: Int,
        villagePlayerId: Int,
        charaName: String,
        firstRequestSkillName: String,
        secondRequestSkillName: String,
        message: String,
        participateNumber: Int,
        isSpectate: Boolean
    ) {
        // {N}人目、{キャラ名}。
        messageDataSource.registerMessage(
            villageId = villageId,
            dayId = villageDayId,
            messageType = CDef.MessageType.公開システムメッセージ.code(),
            text = (if (isSpectate) "（見学） " else "") + "${participateNumber}人目、$charaName。"
        )
        // 参加発言
        messageDataSource.registerMessage(
            villageId = villageId,
            dayId = villageDayId,
            messageType = CDef.MessageType.通常発言.code(),
            text = message,
            villagePlayerId = villagePlayerId,
            faceType = CDef.FaceType.通常.code()
        )
    }

    /**
     * 退村する際のシステムメッセージを登録
     * @param villageId villageId
     * @param chara chara
     * @param villageDayId 村日付ID
     */
    fun registerLeaveMessage(villageId: Int, chara: Chara, villageDayId: Int) {
        val text = Leave.getLeaveMessage(chara)
        val message = Message.createPublicSystemMessage(text, villageDayId)
        messageDataSource.registerMessage(villageId, message)
    }

    /**
     * 能力セットする際のシステムメッセージを登録
     * @param village village
     * @param participant 村参加者
     * @param targetId 対象の村参加者ID
     * @param ability ability
     * @param charas キャラ
     */
    fun registerAbilitySetMessage(
        village: Village,
        participant: VillageParticipant,
        targetId: Int?,
        ability: Ability,
        charas: Charas
    ) {
        val myChara = charas.chara(participant.charaId)
        val targetChara = if (targetId == null) null else charas.chara(village.participant.member(targetId).charaId)
        val text = ability.getAbilitySetMessage(myChara, targetChara)
        val message = Message.createPrivateSystemMessage(text, village.day.latestDay().id)
        messageDataSource.registerMessage(village.id, message)
    }

    /**
     * コミットする際のシステムメッセージを登録
     *
     * @param villageId villageId
     * @param villageDayId villageDayId
     * @param participant 村参加者
     * @param charas キャラ
     * @param doCommit コミット/取り消し
     */
    fun registerCommitMessage(villageId: Int, villageDayId: Int, participant: VillageParticipant, charas: Charas, doCommit: Boolean) {
        // 自分のキャラ
        val chara = charas.chara(participant.charaId)
        val text = Commit.getCommitSetMessage(doCommit, chara)
        val message = Message.createPrivateSystemMessage(text, villageDayId)
        messageDataSource.registerMessage(villageId, message)
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