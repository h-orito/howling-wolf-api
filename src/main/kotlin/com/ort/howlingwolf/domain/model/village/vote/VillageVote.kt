package com.ort.howlingwolf.domain.model.village.vote

data class VillageVote(
    val villageDayId: Int,
    val myselfId: Int,
    val targetId: Int
)