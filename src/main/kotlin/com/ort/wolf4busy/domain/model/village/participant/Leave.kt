package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

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
        village.isAvailableLeave()
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
        if (!isAvailableLeave(village, participant)) throw Wolf4busyBusinessException("退村できません")
    }

    fun getLeaveMessage(chara: Chara): String = "${chara.charaName.name}は村を去った。"
}