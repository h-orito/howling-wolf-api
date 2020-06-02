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

    companion object {
        val requiredCountTypeList: List<CDef.MessageType> = listOf(
            CDef.MessageType.通常発言,
            CDef.MessageType.死者の呻き,
            CDef.MessageType.独り言,
            CDef.MessageType.人狼の囁き,
            CDef.MessageType.見学発言,
            CDef.MessageType.共鳴発言
        )
    }


    fun toCdef(): CDef.MessageType = CDef.MessageType.codeOf(code)

    // 何回目の発言かを登録すべきか
    fun shouldSetCount(): Boolean {
        val cdefMessageType = this.toCdef()
        return requiredCountTypeList.contains(cdefMessageType)
    }
}