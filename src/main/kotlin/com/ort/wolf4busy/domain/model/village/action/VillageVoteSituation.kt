package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageVoteSituation(
    val isAvailableVote: Boolean,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant?
) {
}
