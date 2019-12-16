package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object GraveSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 見られる設定なら開放
        if (village.setting.rules.visibleGraveMessage) return true
        // 参加していなければNG
        participant ?: return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return !participant.alive() && CDef.DeadReason.突然.code() != participant.dead!!.code
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 死亡していなかったら不可
        if (participant.alive()) return false
        // 進行中以外は不可
        return village.status.isProgress()
    }
}
