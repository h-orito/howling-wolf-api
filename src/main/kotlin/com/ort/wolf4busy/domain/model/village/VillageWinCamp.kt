package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef

data class VillageWinCamp(
    val code: String,
    val name: String
) {
    constructor(
        cdefCamp: CDef.Camp
    ) : this(
        code = cdefCamp.code(),
        name = cdefCamp.name
    )

    fun toCdef(): CDef.Camp = CDef.Camp.codeOf(code)
}
