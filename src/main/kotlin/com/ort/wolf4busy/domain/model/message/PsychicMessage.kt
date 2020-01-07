package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object PsychicMessage {

    fun isViewable(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.status.isCompleted()) return true
        // 参加していて生存していて霊能者なら開放
        if (participant == null || !participant.isAlive()) return false
        return participant.skill?.toCdef() == CDef.Skill.霊能者
    }
}
