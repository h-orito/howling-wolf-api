package com.ort.howlingwolf.api.view.charachip

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.CharaDefaultMessage
import com.ort.howlingwolf.domain.model.charachip.CharaFace
import com.ort.howlingwolf.domain.model.charachip.CharaSize

data class CharaView(
    val id: Int,
    val charaName: CharaNameView,
    val charachipId: Int,
    val defaultMessage: CharaDefaultMessage,
    val display: CharaSize,
    val faceList: List<CharaFace>
) {

    constructor(
        chara: Chara
    ) : this(
        id = chara.id,
        charaName = CharaNameView(chara.charaName),
        charachipId = chara.charachipId,
        defaultMessage = chara.defaultMessage,
        display = chara.display,
        faceList = chara.faceList
    )
}