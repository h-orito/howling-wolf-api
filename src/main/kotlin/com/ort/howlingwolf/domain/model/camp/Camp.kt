package com.ort.howlingwolf.domain.model.camp

import com.ort.dbflute.allcommon.CDef

data class Camp(
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