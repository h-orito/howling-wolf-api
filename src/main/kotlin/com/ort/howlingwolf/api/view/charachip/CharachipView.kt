package com.ort.howlingwolf.api.view.charachip

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charachip
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.charachip.Designer

data class CharachipView(
    val id: Int,
    val name: String,
    val designer: Designer,
    val descriptionUrl: String,
    val charaList: List<Chara> // domainとの違い
) {

    constructor(
        charachip: Charachip,
        charas: Charas
    ) : this(
        id = charachip.id,
        name = charachip.name,
        designer = charachip.designer,
        descriptionUrl = charachip.descriptionUrl,
        charaList = charas.list.filter { it.charachipId == charachip.id }
    )
}