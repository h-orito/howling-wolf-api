package com.ort.howlingwolf.domain.model.reserved

data class ReservedVillages(
    val list: List<ReservedVillage>
) {
    // 作成日時を過ぎていて、登録されてほしい予約村
    fun filterShouldCreate(): ReservedVillages {
        return ReservedVillages(list.filter { it.shouldCreate() })
    }
}