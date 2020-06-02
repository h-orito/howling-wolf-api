package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBadRequestException
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

/**
 * 発言
 */
object Say {

    /**
     * @param village village
     * @param participant 参加者
     * @return 発言できるか
     */
    fun isAvailableSay(village: Village, participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        if (!participant.isAvailableSay(village.status.toCdef() == CDef.VillageStatus.エピローグ)) return false
        // 村として可能か
        if (!village.isAvailableSay()) return false
        return true
    }

    fun assertSay(
        village: Village,
        participant: VillageParticipant?,
        chara: Chara?,
        latestDayMessageList: List<Message>,
        messageContent: MessageContent
    ) {
        // 事前チェック
        if (!isAvailableSay(village, participant)) throw HowlingWolfBusinessException("発言できません")
        // 発言種別ごとのチェック
        when (messageContent.type.toCdef()) {
            CDef.MessageType.通常発言 -> NormalSay.assertSay(village, participant!!)
            CDef.MessageType.人狼の囁き -> WerewolfSay.assertSay(village, participant!!)
            CDef.MessageType.死者の呻き -> GraveSay.assertSay(village, participant!!)
            CDef.MessageType.独り言 -> MonologueSay.isSayable(village, participant!!)
            CDef.MessageType.見学発言 -> SpectateSay.isSayable(village, participant!!)
            else -> throw HowlingWolfBadRequestException("不正な発言種別です")
        }
        // 表情種別チェック
        if (!isSelectableFaceType(chara!!, messageContent)) throw HowlingWolfBadRequestException("不正な表情種別です")
        // 発言回数、長さ、行数チェック
        village.assertMessageRestrict(messageContent, latestDayMessageList)
    }

    fun assertParticipateSay(
        village: Village,
        chara: Chara?,
        messageContent: MessageContent
    ) {
        // 事前チェック
        if (!village.isAvailableSay()) throw HowlingWolfBusinessException("入村発言できません")
        // 表情種別チェック
        if (!isSelectableFaceType(chara!!, messageContent)) throw HowlingWolfBadRequestException("不正な表情種別です")
        // 発言長さ、行数チェック
        village.assertMessageRestrict(messageContent, listOf())
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isSelectableFaceType(chara: Chara, messageContent: MessageContent): Boolean =
        chara.faceList.any { it.type == messageContent.faceCode }
}