package com.ort.howlingwolf.domain.model.myself.participant

data class VillageAdminSituation(
    val isAdmin: Boolean,
    val participantList: List<VillageParticipantSituation>
)
