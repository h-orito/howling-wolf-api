package com.ort.howlingwolf.infrastructure.datasource.vote

import com.ort.dbflute.exbhv.VoteBhv
import com.ort.dbflute.exentity.Vote
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import org.springframework.stereotype.Repository

@Repository
class VoteDataSource(
    val voteBhv: VoteBhv
) {

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    fun findVotes(villageId: Int): VillageVotes {
        val voteList = voteBhv.selectList {
            it.query().queryVillageDay().setVillageId_Equal(villageId)
        }
        return VillageVotes(voteList.map { convertToVoteToVillageVote(it) })
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    fun updateVote(villageVote: VillageVote) {
        deleteVote(villageVote)
        insertVote(villageVote)
    }

    private fun deleteVote(villageVote: VillageVote) {
        voteBhv.queryDelete {
            it.query().setVillageDayId_Equal(villageVote.villageDayId)
            it.query().setVillagePlayerId_Equal(villageVote.myselfId)
        }
    }

    private fun insertVote(villageVote: VillageVote) {
        val vote = Vote()
        vote.villageDayId = villageVote.villageDayId
        vote.villagePlayerId = villageVote.myselfId
        vote.targetVillagePlayerId = villageVote.targetId
        voteBhv.insert(vote)
    }

    fun updateDifference(before: VillageVotes, after: VillageVotes) {
        // 削除
        before.list.filterNot { beforeVote ->
            after.list.any { afterVote ->
                beforeVote.villageDayId == afterVote.villageDayId
                    && beforeVote.myselfId == afterVote.myselfId
            }
        }.forEach { deleteVote(it) }
        // 更新
        after.list.filter { afterVote ->
            before.list.any { beforeVote ->
                beforeVote.villageDayId == afterVote.villageDayId
                    && beforeVote.myselfId == afterVote.myselfId
            }
        }.forEach { updateVote(it) }
        // 追加
        after.list.filterNot { afterVote ->
            before.list.any { beforeVote ->
                beforeVote.villageDayId == afterVote.villageDayId
                    && beforeVote.myselfId == afterVote.myselfId
            }
        }.forEach { insertVote(it) }
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