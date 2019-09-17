package com.ort.wolf4busy.domain.model.village.participant

data class VillageVisitors(
        val count: Int,
        val memberList: List<VillageVisitor> = listOf()
) {
}