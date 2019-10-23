package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageSayMessageTypeSituation(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    val isDefault: Boolean,
    // 秘話用
    val targetList: List<VillageParticipant>
) {
}
