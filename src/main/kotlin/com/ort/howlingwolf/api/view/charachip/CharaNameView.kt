package com.ort.howlingwolf.api.view.charachip

import com.ort.howlingwolf.domain.model.charachip.CharaName

data class CharaNameView(
    val name: String,
    val shortName: String,
    val fullName: String
) {
    constructor(
        charaName: CharaName
    ) : this(
        name = charaName.name,
        shortName = charaName.shortName,
        fullName = charaName.fullName()
    )
}