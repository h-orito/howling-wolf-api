package com.ort.wolf4busy.domain.model.village

data class VillageDays(
    val dayList: List<VillageDay>
) {
    fun latestDay(): VillageDay {
        return dayList.last()
    }
}
