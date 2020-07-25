package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageSayMessageTypeSituation(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    // 秘話用
    val targetList: List<VillageParticipant>
)