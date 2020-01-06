package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.setting.VillageMessageRestrict

data class VillageSayRestrictSituation(
    val isRestricted: Boolean,
    val maxCount: Int?,
    val remainingCount: Int?,
    val maxLength: Int?
) {
    constructor(
        restrictSetting: VillageMessageRestrict?,
        messageList: List<Message>
    ) : this(
        isRestricted = restrictSetting != null,
        maxCount = restrictSetting?.count,
        remainingCount = if (restrictSetting == null) null else restrictSetting.count - messageList.size,
        maxLength = restrictSetting?.length
    )
}
