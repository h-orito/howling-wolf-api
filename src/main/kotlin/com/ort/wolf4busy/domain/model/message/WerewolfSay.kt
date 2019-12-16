package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object WerewolfSay {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 参加していて人狼なら開放
        val cdefSkill = CDef.Skill.codeOf(participant?.skill?.code) ?: return false
        return cdefSkill.isViewableWerewolfSay
    }

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 囁ける役職でなければ不可
        val skill = CDef.Skill.codeOf(participant.skill?.code)
        if (skill == null || !skill.isAvailableWerewolfSay) return false
        // 死亡していたら不可
        if (!participant.alive()) return false
        // 進行中以外は不可
        return village.status.isProgress()
    }
}
