package com.ort.wolf4busy.api.view.charachip

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charachip
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.charachip.Designer

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
        charaList = charas.list
    )
}