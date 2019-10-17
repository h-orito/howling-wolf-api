package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.message.MessageDataSource
import org.springframework.stereotype.Service

@Service
class MessageCoordinator(
    val messageDataSource: MessageDataSource
) {
    fun findMessageList(villageId: Int, day: Int, time: String, user: Wolf4busyUser?): Messages {
        // TODO implement
        return Messages(listOf())
    }
}