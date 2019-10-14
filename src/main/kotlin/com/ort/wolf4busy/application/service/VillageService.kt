package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service

@Service
class VillageService(
        val villageDataSource: VillageDataSource
) {

    fun findVillageList(): Villages {
        return villageDataSource.selectVillages()
    }

    fun findVillage(villageId: Int): Village {
        return villageDataSource.selectVillage(villageId)
    }
}