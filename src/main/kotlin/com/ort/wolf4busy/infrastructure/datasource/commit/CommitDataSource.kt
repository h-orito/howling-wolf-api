package com.ort.wolf4busy.infrastructure.datasource.commit

import com.ort.dbflute.exbhv.CommitBhv
import com.ort.dbflute.exentity.Commit
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Repository

@Repository
class CommitDataSource(
    val commitBhv: CommitBhv
) {
    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    /**
     * コミットを取得
     * @param village village
     * @param participant 村参加情報
     * @return コミット
     */
    fun selectCommit(village: com.ort.wolf4busy.domain.model.village.Village, participant: VillageParticipant)
        : com.ort.wolf4busy.domain.model.commit.Commit? {
        val latestDay: com.ort.wolf4busy.domain.model.village.VillageDay = village.day.latestDay()

        val optCommit = commitBhv.selectEntity {
            it.query().setVillageDayId_Equal(latestDay.id)
            it.query().setVillagePlayerId_Equal(participant.id)
        }
        return optCommit.map {
            com.ort.wolf4busy.domain.model.commit.Commit(
                isCommiting = true
            )
        }.orElse(null)
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    /**
     * コミット/取り消し
     *
     * @param villageDayId 村日付id
     * @param myselfId 村参加者id
     * @param commit コミットするか
     */
    fun updateCommit(villageDayId: Int, myselfId: Int, commit: Boolean) {
        deleteCommit(villageDayId, myselfId)
        if (commit) insertCommit(villageDayId, myselfId)
    }

    private fun deleteCommit(villageDayId: Int, myselfId: Int) {
        commitBhv.queryDelete {
            it.query().setVillageDayId_Equal(villageDayId)
            it.query().setVillagePlayerId_Equal(myselfId)
        }
    }

    private fun insertCommit(villageDayId: Int, myselfId: Int) {
        val commit = Commit()
        commit.villageDayId = villageDayId
        commit.villagePlayerId = myselfId
        commitBhv.insert(commit)
    }
}
