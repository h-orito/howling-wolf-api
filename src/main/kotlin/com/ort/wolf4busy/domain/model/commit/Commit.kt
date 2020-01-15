package com.ort.wolf4busy.domain.model.commit

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class Commit(
    val villageDayId: Int,
    val isCommiting: Boolean
) {

    companion object {

        /**
         * @param village village
         * @param participant 参加者
         * @return コミットできるか
         */
        fun isAvailableCommit(
            village: Village,
            participant: VillageParticipant?
        ): Boolean {
            // 村として可能か
            village.isAvailableCommit()
            // 参加者として可能か
            participant ?: return false
            participant.isAvailableCommit(village.dummyChara().id)

            return true
        }

        /**
         * コミットチェック
         * @param village village
         * @param participant 参加者
         */
        fun assertCommit(
            village: Village,
            participant: VillageParticipant?
        ) {
            if (!isAvailableCommit(village, participant)) throw Wolf4busyBusinessException("コミットできません")
        }
    }

}