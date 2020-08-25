package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.reserved.ReservedVillage
import com.ort.howlingwolf.domain.model.reserved.ReservedVillages
import com.ort.howlingwolf.infrastructure.datasource.reserved.ReservedVillageDataSource
import org.springframework.stereotype.Service

@Service
class ReservedVillageService(
    val reservedVillageDataSource: ReservedVillageDataSource
) {

    fun findReservedVillages(limit: Int? = null): ReservedVillages {
        return reservedVillageDataSource.findReservedVillages(true, limit)
    }

    fun findReservedVillagesIncludePast(): ReservedVillages {
        return reservedVillageDataSource.findReservedVillages(false)
    }

    fun registerReservedVillage(reservedVillage: ReservedVillage): ReservedVillage {
        return reservedVillageDataSource.registerReservedVillage(reservedVillage)
    }

    fun deleteReservedVillage(id: Int) = reservedVillageDataSource.deleteReservedVillage(id)
}