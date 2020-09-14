package com.ort.howlingwolf.domain.model.myself.participant

data class SituationAsParticipant(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val commit: VillageCommitSituation,
    val comingOut: VillageComingOutSituation,
    val say: VillageSaySituation,
    val ability: VillageAbilitySituations,
    val vote: VillageVoteSituation,
    val admin: VillageAdminSituation
)