package com.ort.howlingwolf.domain.model.commit

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

data class Commit(
    val villageDayId: Int,
    val myselfId: Int,
    val isCommitting: Boolean
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
            if (!village.isAvailableCommit()) return false
            // 参加者として可能か
            participant ?: return false
            return participant.isAvailableCommit(village.dummyChara().id)
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
            if (!isAvailableCommit(village, participant)) throw HowlingWolfBusinessException("コミットできません")
        }

        /**
         * コミットメッセージ
         * @param chara chara
         * @param doCommit コミット/取り消し
         * @param villageDayId 村日付ID
         * @return コミット時のメッセージ e.g. "{キャラ名}がコミットしました。"
         */
        fun createCommitMessage(chara: Chara, doCommit: Boolean, villageDayId: Int): Message =
            Message.createPrivateSystemMessage(getCommitSetMessage(doCommit, chara), villageDayId)

        // ===================================================================================
        //                                                                        Assist Logic
        //                                                                        ============
        private fun getCommitSetMessage(doCommit: Boolean, chara: Chara): String =
            if (doCommit) "${chara.charaName.name}がコミットしました。" else "${chara.charaName.name}がコミットを取り消しました。"
    }

}