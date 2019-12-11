package com.ort.wolf4busy.api.view.charachip

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charachips
import com.ort.wolf4busy.domain.model.charachip.Charas

data class CharachipListView(
    val charachipList: List<CharachipView>
) {
    constructor(
        charachips: Charachips,
        charas: Charas
    ) : this(
        charachipList = charachips.list.map { charachip ->
            CharachipView(
                charachip = charachip,
                charas = charas
            )
        }
    )
}