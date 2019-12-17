package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.infrastructure.datasource.commit.CommitDataSource
import org.springframework.stereotype.Service

@Service
class CommitService(
    val commitDataSource: CommitDataSource
) {
    fun findCommit(village: Village, participant: VillageParticipant?): Commit? {
        participant ?: return null
        return commitDataSource.selectCommit(village, participant)
    }

    /**
     * コミット/取り消し
     *
     * @param villageDayId 村日付id
     * @param participant 村参加者
     * @param commit コミットするか
     */
    fun updateCommit(villageDayId: Int, participant: VillageParticipant, commit: Boolean) {
        commitDataSource.updateCommit(villageDayId, participant.id, commit)
    }
}