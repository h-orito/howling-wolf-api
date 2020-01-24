package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.message.Say
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.Leave
import com.ort.wolf4busy.domain.model.village.participant.Participate
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
            Participate.createParticipateMessage(village, chara, isSpectate)
        )
        // 参加発言
        val messageContent = MessageContent.invoke(
            CDef.MessageType.通常発言.code(),
            message,
            CDef.FaceType.通常.code()
        )
        Say.assertSay(village, participant, chara, listOf(), messageContent)
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
        messageDataSource.registerMessage(village.id, Leave.createLeaveMessage(village, chara))

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
        val myChara: Chara = charas.chara(participant.charaId)
        val targetChara: Chara? = if (targetId == null) null else charas.chara(village.participant, targetId)
        val message: Message = ability.createAbilitySetMessage(village, myChara, targetChara)
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
            Commit.createCommitMessage(chara, doCommit, village.day.latestDay().id)
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