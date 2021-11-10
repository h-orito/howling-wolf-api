package com.ort.howlingwolf.domain.model.dead

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.village.VillageDay

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

    fun toCdef(): CDef.DeadReason {
        return CDef.DeadReason.codeOf(code)
    }

    fun isSuddenly(): Boolean = toCdef() == CDef.DeadReason.突然
}