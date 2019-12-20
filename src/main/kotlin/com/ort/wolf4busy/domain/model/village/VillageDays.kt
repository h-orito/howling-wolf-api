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

    fun existsDifference(villageDays: VillageDays): Boolean {
        if (dayList.size != villageDays.dayList.size) return true
        return dayList.any { day1 ->
            villageDays.dayList.none { day2 ->
                // TODO 日時比較大丈夫か？
                day1.day == day2.day && day1.dayChangeDatetime == day2.dayChangeDatetime
            }
        }

    }
}
