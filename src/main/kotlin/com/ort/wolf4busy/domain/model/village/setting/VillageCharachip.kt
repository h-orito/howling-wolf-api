package com.ort.wolf4busy.domain.model.village.setting

data class VillageCharachip(
    val dummyCharaId: Int,
    val charachipId: Int
) {
    companion object {
        operator fun invoke(
            dummyCharaId: Int?,
            charachipId: Int?
        ): VillageCharachip {
            dummyCharaId ?: throw IllegalArgumentException("dummyCharaId is required.")
            charachipId ?: throw IllegalArgumentException("charachipId is required.")
            return VillageCharachip(
                dummyCharaId = dummyCharaId,
                charachipId = charachipId
            )
        }

    }
}