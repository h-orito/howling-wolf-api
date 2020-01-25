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
            requireNotNull(dummyCharaId)
            requireNotNull(charachipId)
            return VillageCharachip(
                dummyCharaId = dummyCharaId,
                charachipId = charachipId
            )
        }
    }
}