package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class VillageCommitSituation(
    val isAvailableCommit: Boolean,
    val isCommitting: Boolean
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        commit: Commit?
    ) : this(
        isAvailableCommit = isAvailableCommit(village, participant),
        isCommitting = commit != null
    )

    companion object {

        private fun isAvailableCommit(village: Village, participant: VillageParticipant?): Boolean {
            // コミットできない設定ならNG
            if (!village.setting.rules.availableCommit) return false
            // 参加していなかったり死亡していたらNG
            participant ?: return false
            if (participant.isSpectator) return false
            if (participant.dead != null) return false
            // 進行中以外はNG
            if (CDef.VillageStatus.codeOf(village.status.code) != CDef.VillageStatus.進行中) return false
            // ダミーはコミットできない
            if (village.dummyChara().id == participant.id) return false

            return true
        }
    }

    fun assertCommit() {
        if (!isAvailableCommit) throw Wolf4busyBusinessException("コミットできません")
    }
}
