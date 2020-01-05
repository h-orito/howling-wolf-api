package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.infrastructure.datasource.vote.VoteDataSource
import org.springframework.stereotype.Service

@Service
class VoteService(
    val voteDataSource: VoteDataSource
) {

    fun findVillageVotes(villageId: Int): VillageVotes {
        return voteDataSource.selectVotes(villageId)
    }

    fun updateVote(villageDayId: Int, participant: VillageParticipant, targetId: Int) {
        voteDataSource.updateVote(villageDayId, participant.id, targetId)
    }

    fun updateDifference(before: VillageVotes, after: VillageVotes) {
        voteDataSource.updateDifference(before, after)
    }
}
