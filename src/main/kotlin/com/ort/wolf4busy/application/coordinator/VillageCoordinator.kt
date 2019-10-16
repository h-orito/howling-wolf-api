package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.api.body.VillageRegisterBody
import com.ort.wolf4busy.infrastructure.datasource.message.MessageDataSource
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource

class VillageCoordinator(
    val villageDataSource: VillageDataSource,
    val messageDataSource: MessageDataSource
) {
    fun registerVillage() {
        TODO("not implemented")
    }
}