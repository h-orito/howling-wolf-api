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
                val canSkillRequest = currentVillageId % 3 != 0
                convertToReservedVillage(organize, time, currentVillageId, canSkillRequest)
            }
        )
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertToReservedVillage(
        organize: AutogenerateOrganize,
        time: AutogenerateTime,
        currentVillageId: Int,
        canSkillRequest: Boolean
    ): ReservedVillage {
        // 実験で強制的に編成を調整
        val organization = """
            狼占村村村村
            狼狂占狩村村村
            狼狼占霊狩村村村
            狼狼狂占霊狩聖村村
            狼狼狂占霊狩村村村村
            狼狼Ｃ占霊狩村村村村村
            狼狼狂占霊狩狐村村村村村
            狼狼狼狂占霊狩村村村村村村
            狼狼狼狂占霊狩狐村村村村村村
            狼狼狼Ｃ占霊狩聖村村村村村村村
            狼狼狼狂占霊狩狐共共村村村村村村
        """.trimIndent()

        return ReservedVillage(
            startTime = LocalTime.parse(time.startTime, DateTimeFormatter.ofPattern("HHmm")),
//            organization = organize.organization,
            organization = organization,
            silentHours = time.silentHours,
//            availableDummySkill = organize.isAvailableDummySkill,
            availableDummySkill = false,
            forBeginner = currentVillageId % 4 == 0,
            canSkillRequest = canSkillRequest
        )
    }
}