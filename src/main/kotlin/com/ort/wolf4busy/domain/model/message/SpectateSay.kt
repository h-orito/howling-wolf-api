package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object SpectateSay {

    fun isViewable(village: Village, participant: VillageParticipant?, day: Int): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 進行中以外は開放
        if (CDef.VillageStatus.進行中.code() != village.status.code) return true
        // 見られる設定なら開放
        if (village.setting.rules.visibleGraveMessage) return true
        // 進行中でも0日目なら開放
        if (CDef.VillageStatus.進行中.code() == village.status.code && day == 0) return true
        // 参加していなければNG
        if (participant == null) return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return !participant.isAlive() && CDef.DeadReason.突然.code() != participant.dead?.code
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 見学していなかったら不可
        return participant.isSpectator
    }
}
