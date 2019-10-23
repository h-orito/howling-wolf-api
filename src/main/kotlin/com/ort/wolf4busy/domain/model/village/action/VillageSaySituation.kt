package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.charachip.CharaFace

data class VillageSaySituation(
    val isAvailableSay: Boolean,
    val selectableMessageTypeList: List<VillageSayMessageTypeSituation> = listOf(),
    val selectableFaceTypeList: List<CharaFace>
) {
}
