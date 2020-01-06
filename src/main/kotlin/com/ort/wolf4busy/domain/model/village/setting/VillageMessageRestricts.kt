package com.ort.wolf4busy.domain.model.village.setting

data class VillageMessageRestricts(
    val existRestricts: Boolean = false,
    val restrictList: List<VillageMessageRestrict> = listOf()
) {
}