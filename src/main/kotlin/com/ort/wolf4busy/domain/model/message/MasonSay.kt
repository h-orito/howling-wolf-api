package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object MasonSay {

    fun isSayable(village: Village, participant: VillageParticipant): Boolean {
        // 共鳴発言ができる役職でなければ不可
        // TODO 共鳴
        val skill = CDef.Skill.codeOf(participant.skill?.code)
        skill ?: return false
        // 死亡していたら不可
        if (!participant.isAlive()) return false
        // 進行中以外は不可
        return village.status.isProgress()
    }
}
