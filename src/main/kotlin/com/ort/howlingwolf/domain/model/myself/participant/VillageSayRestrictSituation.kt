package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.village.Village

data class VillageSayRestrictSituation(
    val isRestricted: Boolean,
    val maxCount: Int?,
    val remainingCount: Int?,
    val maxLength: Int,
    val maxLine: Int
) {
    constructor(
        village: Village,
        latestDayMessageList: List<Message>,
        messageType: CDef.MessageType
    ) : this(
        isRestricted = village.setting.rules.messageRestrict.restrict(messageType) != null,
        maxCount = village.setting.rules.messageRestrict.restrict(messageType)?.count,
        remainingCount = village.setting.rules.messageRestrict.restrict(messageType)?.remainingCount(village.status.toCdef(), latestDayMessageList),
        maxLength = village.setting.rules.messageRestrict.restrict(messageType)?.length ?: MessageContent.defaultLengthMax,
        maxLine = village.setting.rules.messageRestrict.restrict(messageType)?.line ?: MessageContent.lineMax
    )
}
