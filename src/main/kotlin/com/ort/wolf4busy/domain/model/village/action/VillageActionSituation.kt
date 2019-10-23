package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageActionSituation(
    val myself: VillageParticipant,
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val isAvailableLeave: Boolean,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: List<VillageAbilitySituation>,
    val vote: VillageVoteSituation
) {
}