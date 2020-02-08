package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.infrastructure.datasource.vote.VoteDataSource
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
