package com.ort.wolf4busy.api.view.message

import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.village.VillageDay
import java.time.LocalDateTime

data class MessageTimeView(
    val villageDayId: Int,
    val day: Int,
    val datetime: LocalDateTime,
    val unixTimeMilli: Long
) {
    constructor(
        messageTime: MessageTime,
        villageDay: VillageDay
    ) : this(
        villageDayId = messageTime.villageDayId,
        day = villageDay.day,
        datetime = messageTime.datetime,
        unixTimeMilli = messageTime.unixTimeMilli
    )
}
