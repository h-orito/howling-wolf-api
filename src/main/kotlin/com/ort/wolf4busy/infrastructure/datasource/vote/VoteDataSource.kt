package com.ort.wolf4busy.infrastructure.datasource.vote

import com.ort.dbflute.exbhv.VoteBhv
import com.ort.dbflute.exentity.Vote
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import org.springframework.stereotype.Repository

@Repository
class VoteDataSource(
    val voteBhv: VoteBhv
) {

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    fun selectVotes(villageId: Int): VillageVotes {
        val voteList = voteBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageVotes(voteList.map { convertToVoteToVillageVote(it) })
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    fun updateVote(villageDayId: Int, myselfId: Int, targetId: Int) {
        deleteVote(villageDayId, myselfId)
        insertVote(villageDayId, myselfId, targetId)
    }

    private fun deleteVote(villageDayId: Int, myselfId: Int) {
        voteBhv.queryDelete {
            it.query().setVillageDayId_Equal(villageDayId)
            it.query().setVillagePlayerId_Equal(myselfId)
        }
    }

    private fun insertVote(villageDayId: Int, myselfId: Int, targetId: Int) {
        val vote = Vote()
        vote.villageDayId = villageDayId
        vote.villagePlayerId = myselfId
        vote.targetVillagePlayerId = targetId
        voteBhv.insert(vote)
    }

    fun updateDifference(before: VillageVotes, after: VillageVotes) {
        // 追加のみ
        after.list.drop(before.list.size).forEach {
            insertVote(
                villageDayId = it.villageDayId,
                myselfId = it.myselfId,
                targetId = it.targetId
            )
        }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertToVoteToVillageVote(vote: Vote): VillageVote {
        return VillageVote(
            villageDayId = vote.villageDayId,
            myselfId = vote.villagePlayerId,
            targetId = vote.targetVillagePlayerId
        )
    }
}