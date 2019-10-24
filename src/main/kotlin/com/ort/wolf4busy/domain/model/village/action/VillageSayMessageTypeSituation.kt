package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageSayMessageTypeSituation(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    val isDefault: Boolean,
    // 秘話用
    val targetList: List<VillageParticipant>
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        messageType: CDef.MessageType
    ) : this(
        messageType = MessageType(
            code = messageType.code(),
            name = messageType.name
        ),
        restrict = VillageSayRestrictSituation(
            maxCount = 99, // todo
            remainingCount = 99, // todo
            maxLength = 200 // todo
        ),
        isDefault = false, // todo
        targetList = listOf() // todo
    )
}
