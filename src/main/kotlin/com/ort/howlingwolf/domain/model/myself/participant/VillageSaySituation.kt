package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.charachip.CharaFace
import com.ort.howlingwolf.domain.model.message.MessageType

data class VillageSaySituation(
    val isAvailableSay: Boolean,
    val selectableMessageTypeList: List<VillageSayMessageTypeSituation> = listOf(),
    val selectableFaceTypeList: List<CharaFace>,
    val defaultMessageType: MessageType?
)
