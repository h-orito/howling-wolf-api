package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.Message
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
        latestDayMessageList: List<Message>,
        messageType: CDef.MessageType
    ) : this(
        messageType = MessageType(
            code = messageType.code(),
            name = messageType.name
        ),
        restrict = VillageSayRestrictSituation(
            village.setting.rules.messageRestrict.restrictList.find { it.type.code == messageType.code() },
            latestDayMessageList.filter { it.content.type.code == messageType.code() }
        ),
        isDefault = false, // todo
        targetList = listOf() // todo
    )
}
