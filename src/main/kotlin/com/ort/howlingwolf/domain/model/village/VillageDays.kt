package com.ort.howlingwolf.domain.model.village

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
        check(dayList.size >= 2) { "no exists yesterday" }
        return dayList[dayList.size - 2]
    }

    fun prologueDay(): VillageDay {
        return dayList.find { it.day == 0 && it.noonnight == CDef.Noonnight.昼.code() }!!
    }

    fun existsDifference(villageDays: VillageDays): Boolean {
        if (dayList.size != villageDays.dayList.size) return true
        return dayList.any { day1 ->
            villageDays.dayList.none { day2 -> !day1.existsDifference(day2) }
        }

    }

    fun extendPrologue(): VillageDays {
        return this.copy(dayList = dayList.map {
            if (it.id == latestDay().id) latestDay().copy(dayChangeDatetime = latestDay().dayChangeDatetime.plusDays(1L))
            else it
        })
    }

    fun extendLatestDay(): VillageDays {
        return this.copy(dayList = dayList.map {
            if (it.id == latestDay().id) latestDay().copy(dayChangeDatetime = yesterday().dayChangeDatetime.plusHours(extendHours))
            else it
        })
    }
}
