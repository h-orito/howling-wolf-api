package com.ort.howlingwolf.domain.model.myself.participant

data class VillageAdminSituation(
    val admin: Boolean,
    val availableKick: Boolean,
    val participantList: List<VillageParticipantSituation>
)
