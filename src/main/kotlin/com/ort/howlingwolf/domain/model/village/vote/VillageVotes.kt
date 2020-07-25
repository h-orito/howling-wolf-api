package com.ort.howlingwolf.domain.model.village.vote

data class VillageVotes(
    val list: List<VillageVote>
) {

    fun addAll(voteList: List<VillageVote>): VillageVotes {
        if (voteList.isEmpty()) return this
        return this.copy(
            list = list + voteList
        )
    }

    fun existsDifference(votes: VillageVotes): Boolean {
        return list.size != votes.list.size
    }
}