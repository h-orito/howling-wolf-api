package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.domain.model.village.message.VillageMessages
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.message.MessageDataSource

class MessageCoordinator(
        val messageDataSource: MessageDataSource
) {
    fun findMessageList(villageId: Int, day: Int, time: String, user: Wolf4busyUser?): VillageMessages {
        // TODO implement
        return VillageMessages(listOf())
    }
}