package com.ort.howlingwolf.domain.model.village.participant

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

object Leave {

    /**
     * @param village village
     * @param participant 参加者
     * @return 退村可能か
     */
    fun isAvailableLeave(
        village: Village,
        participant: VillageParticipant?
    ): Boolean {
        // 村として退村可能か
        if (!village.isAvailableLeave()) return false
        // 参加していない
        participant ?: return false

        return true
    }

    /**
     * 退村チェック
     * @param village village
     * @param participant 参加者
     */
    fun assertLeave(
        village: Village,
        participant: VillageParticipant?
    ) {
        if (!isAvailableLeave(village, participant)) throw HowlingWolfBusinessException("退村できません")
    }


    /**
     * 退村メッセージ
     * @param village village
     * @param chara chara
     * @return 退村時のメッセージ e.g. {キャラ名}は村を去った。
     */
    fun createLeaveMessage(village: Village, chara: Chara): Message =
        Message.createPublicSystemMessage(createLeaveMessageString(chara), village.day.latestDay().id)


    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createLeaveMessageString(chara: Chara): String =
        "${chara.charaName.name}は村を去った。"
}