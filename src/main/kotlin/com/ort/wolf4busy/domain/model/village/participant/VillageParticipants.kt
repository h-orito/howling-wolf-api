package com.ort.wolf4busy.domain.model.village.participant

data class VillageParticipants(
        val count: Int,
        val memberList: List<VillageParticipant> = listOf()
) {


}