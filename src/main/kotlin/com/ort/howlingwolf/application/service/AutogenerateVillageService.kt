package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.reserved.ReservedVillages
import com.ort.howlingwolf.infrastructure.datasource.autogenerate.AutogenerateVillageDataSource
import com.ort.howlingwolf.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service

@Service
class AutogenerateVillageService(
    val autogenerateVillageDataSource: AutogenerateVillageDataSource,
    val villageDataSource: VillageDataSource
) {

    fun findReservedVillages(limit: Int = 3): ReservedVillages {
        val maxVillageId = villageDataSource.findLatestVillageId()
        return autogenerateVillageDataSource.findReservedVillages(maxVillageId, limit)
    }
}