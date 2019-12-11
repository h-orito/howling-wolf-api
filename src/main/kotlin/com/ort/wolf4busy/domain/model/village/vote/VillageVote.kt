package com.ort.wolf4busy.domain.model.village.vote

data class VillageVote(
    val villageDayId: Int,
    val myselfId: Int, // 投票元villageParticipantId
    val targetId: Int // 投票先villageParticipantId
)