package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.domain.model.vote.Vote

data class VillageVoteSituation(
    val isAvailableVote: Boolean,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant?
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        votes: VillageVotes
    ) : this(
        isAvailableVote = Vote.isAvailableVote(village, participant),
        targetList = Vote.getSelectableTargetList(village, participant),
        target = Vote.getSelectingTarget(village, participant, votes)
    )
}
