package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageSayMessageTypeSituation(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    // 秘話用
    val targetList: List<VillageParticipant>
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        latestDayMessageList: List<Message>,
        messageType: CDef.MessageType
    ) : this(
        messageType = MessageType(messageType),
        restrict = VillageSayRestrictSituation(
            village.setting.rules.messageRestrict.restrictList.find { it.type.toCdef() == messageType },
            latestDayMessageList.filter { it.content.type.toCdef() == messageType }
        ),
        targetList = listOf() // todo
    )
}
