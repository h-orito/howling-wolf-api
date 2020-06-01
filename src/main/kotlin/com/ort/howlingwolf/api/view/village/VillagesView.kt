package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.domain.model.village.Villages

data class VillagesView(
    val list: List<SimpleVillageView>
) {
    constructor(
        villages: Villages
    ) : this(
        list = villages.list.map { SimpleVillageView(it) }
    )
}
