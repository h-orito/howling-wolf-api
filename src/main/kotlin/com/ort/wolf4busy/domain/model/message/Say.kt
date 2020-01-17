package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

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
        if (!isAvailableSay(village, participant)) throw Wolf4busyBusinessException("発言できません")
        // 発言種別ごとのチェック
        when (messageContent.type.toCdef()) {
            CDef.MessageType.通常発言 -> NormalSay.assertSay(village, participant!!)
            CDef.MessageType.人狼の囁き -> WerewolfSay.assertSay(village, participant!!)
            CDef.MessageType.死者の呻き -> GraveSay.assertSay(village, participant!!)
            CDef.MessageType.独り言 -> MonologueSay.isSayable(village, participant!!)
            CDef.MessageType.見学発言 -> SpectateSay.isSayable(village, participant!!)
            else -> throw Wolf4busyBusinessException("発言できません")
        }
        // 表情種別チェック
        if (!isSelectableFaceType(chara!!, participant!!, messageContent)) throw Wolf4busyBusinessException("発言できません")
        // 発言回数、長さ、行数チェック
        village.assertMessageRestrict(messageContent, latestDayMessageList)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isSelectableFaceType(chara: Chara, participant: VillageParticipant, messageContent: MessageContent): Boolean =
        chara.faceList.any { it.type == messageContent.faceCode }
}