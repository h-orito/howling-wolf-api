package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object WerewolfSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 参加していて人狼なら開放
        return participant?.skill?.toCdef()?.isViewableWerewolfSay ?: false
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 進行中以外は不可
        if (!village.status.isProgress()) return false
        // 死亡していたら不可
        if (!participant.isAlive()) return false
        // 囁ける役職でなければ不可
        return participant.skill?.toCdef()?.isAvailableWerewolfSay ?: false
    }
}
