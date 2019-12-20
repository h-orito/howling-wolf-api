package com.ort.wolf4busy.domain.model.village.vote

import com.ort.wolf4busy.domain.model.village.Village

data class VillageVotes(
    val list: List<VillageVote>
) {

    fun addDefaultVote(village: Village): VillageVotes {
        // 最新日
        val latestVillageDayId = village.day.latestDay().id
        // 生存している人だけ自分に投票
        val newVoteList = village.participant.filterAlive().memberList.map { member ->
            VillageVote(
                villageDayId = latestVillageDayId,
                myselfId = member.id,
                targetId = member.id
            )
        }
        val voteList = mutableListOf<VillageVote>()
        voteList.addAll(list)
        voteList.addAll(newVoteList)
        return VillageVotes(
            list = voteList
        )
    }

    fun existsDifference(votes: VillageVotes): Boolean {
        return list.size != votes.list.size
    }
}