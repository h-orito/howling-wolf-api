package com.ort.howlingwolf.domain.model.myself.participant

data class SituationAsParticipant(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: VillageAbilitySituations,
    val vote: VillageVoteSituation
)