package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.infrastructure.datasource.vote.VoteDataSource
import org.springframework.stereotype.Service

@Service
class VoteService(
    val voteDataSource: VoteDataSource
) {

    fun findVillageVotes(villageId: Int): VillageVotes = voteDataSource.findVotes(villageId)

    fun updateVote(villageVote: VillageVote) {
        voteDataSource.updateVote(villageVote)
    }

    fun updateDifference(before: VillageVotes, after: VillageVotes) {
        voteDataSource.updateDifference(before, after)
    }
}
