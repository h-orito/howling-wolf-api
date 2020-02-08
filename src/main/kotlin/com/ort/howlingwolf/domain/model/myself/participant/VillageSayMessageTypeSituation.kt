package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageSayMessageTypeSituation(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    // 秘話用
    val targetList: List<VillageParticipant>
) {
    constructor(
        village: Village,
        latestDayMessageList: List<Message>,
        messageType: CDef.MessageType
    ) : this(
        messageType = MessageType(messageType),
        restrict = VillageSayRestrictSituation(village, latestDayMessageList, messageType),
        targetList = listOf() // todo
    )
}
