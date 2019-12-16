package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef

data class VillageDays(
    val dayList: List<VillageDay>
) {
    fun latestDay(): VillageDay {
        return dayList.last()
    }

    fun prologue(): VillageDay {
        return dayList.find { it.day == 0 && it.noonnight == CDef.Noonnight.昼.code() }!!
    }
}
