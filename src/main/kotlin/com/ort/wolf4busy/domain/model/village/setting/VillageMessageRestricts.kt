package com.ort.wolf4busy.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.MessageType

data class VillageMessageRestricts(
    val existRestricts: Boolean = true,
    val restrictList: List<VillageMessageRestrict> = listOf(
        VillageMessageRestrict(
            type = MessageType(CDef.MessageType.通常発言),
            count = 20,
            length = 200
        ),
        VillageMessageRestrict(
            type = MessageType(CDef.MessageType.人狼の囁き),
            count = 40,
            length = 200
        )
    )
)