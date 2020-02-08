package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef

data class MessageType(
    val code: String,
    val name: String
) {

    constructor(
        cdefMessageType: CDef.MessageType
    ) : this(
        code = cdefMessageType.code(),
        name = cdefMessageType.alias()
    )

    fun toCdef(): CDef.MessageType = CDef.MessageType.codeOf(code)
}