package com.ort.wolf4busy.domain.model.dead

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.VillageDay

data class Dead(
    val code: String,
    val reason: String,
    val villageDay: VillageDay
) {

    constructor(
        cdefDeadReason: CDef.DeadReason,
        villageDay: VillageDay
    ) : this(
        code = cdefDeadReason.code(),
        reason = cdefDeadReason.alias(),
        villageDay = villageDay
    )
}