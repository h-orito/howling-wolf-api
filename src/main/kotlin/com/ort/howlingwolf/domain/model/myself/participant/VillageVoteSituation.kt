package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageVoteSituation(
    val isAvailableVote: Boolean,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant?
)