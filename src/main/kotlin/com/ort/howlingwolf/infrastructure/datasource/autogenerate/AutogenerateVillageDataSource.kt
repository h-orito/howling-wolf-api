package com.ort.howlingwolf.infrastructure.datasource.autogenerate

import com.ort.dbflute.exbhv.AutogenerateOrganizeBhv
import com.ort.dbflute.exbhv.AutogenerateTimeBhv
import com.ort.dbflute.exentity.AutogenerateOrganize
import com.ort.dbflute.exentity.AutogenerateTime
import com.ort.howlingwolf.domain.model.reserved.ReservedVillage
import com.ort.howlingwolf.domain.model.reserved.ReservedVillages
import org.springframework.stereotype.Repository
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Repository
class AutogenerateVillageDataSource(
    private val autogenerateOrganizeBhv: AutogenerateOrganizeBhv,
    private val autogenerateTimeBhv: AutogenerateTimeBhv
) {

    fun findReservedVillages(latestVillageId: Int, limit: Int = 3): ReservedVillages {
        val autogenerateOrganizeMap = autogenerateOrganizeBhv.selectList {}.groupBy { it.villageIdMod }
        val autogenerateTimeMap = autogenerateTimeBhv.selectList {}.groupBy { it.villageIdMod }

        return ReservedVillages(
            list = MutableList(limit) { it }.map { index ->
                val currentVillageId = latestVillageId + index
                val organize =
                    autogenerateOrganizeMap[currentVillageId % autogenerateOrganizeMap.size]!!.first()
                val time = autogenerateTimeMap[currentVillageId % autogenerateTimeMap.size]!!.first()
                convertToReservedVillage(organize, time, currentVillageId)
            }
        )
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertToReservedVillage(
        organize: AutogenerateOrganize,
        time: AutogenerateTime,
        currentVillageId: Int
    ): ReservedVillage {
        return ReservedVillage(
            startTime = LocalTime.parse(time.startTime, DateTimeFormatter.ofPattern("HHmm")),
            organization = organize.organization,
            silentHours = time.silentHours,
            availableDummySkill = organize.isAvailableDummySkill,
            forBeginner = currentVillageId % 3 == 0
        )
    }
}