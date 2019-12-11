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

    fun selectVotes(villageId: Int): VillageVotes {
        val voteList = voteBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageVotes(voteList.map { convertToVoteToVillageVote(it) })
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