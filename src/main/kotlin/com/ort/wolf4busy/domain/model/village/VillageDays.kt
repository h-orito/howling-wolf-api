package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef

data class VillageDays(
    val dayList: List<VillageDay>
) {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private val extendHours: Long = 24L

    // ===================================================================================
//                                                                             Execute
//                                                                           =========
    fun latestDay(): VillageDay {
        return dayList.last()
    }

    fun yesterday(): VillageDay {
        if (dayList.size < 2) throw IllegalStateException("no exists yesterday")
        return dayList[dayList.size - 2]
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

    fun extendLatestDay(): VillageDays {
        return this.copy(dayList = dayList.map {
            if (it.id == latestDay().id) latestDay().copy(dayChangeDatetime = yesterday().dayChangeDatetime.plusHours(extendHours))
            else it
        })
    }
}
