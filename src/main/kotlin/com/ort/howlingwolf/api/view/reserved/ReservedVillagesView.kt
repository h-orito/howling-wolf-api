package com.ort.howlingwolf.api.view.reserved

import com.ort.howlingwolf.domain.model.reserved.ReservedVillages

data class ReservedVillagesView(
    val list: List<ReservedVillageView>
) {
    constructor(
        reservedVillages: ReservedVillages
    ) : this(
        list = reservedVillages.list.map { ReservedVillageView(it) }
    )
}