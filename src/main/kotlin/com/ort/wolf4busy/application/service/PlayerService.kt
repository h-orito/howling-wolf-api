package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.charachip.PlayerDataSource
import org.springframework.stereotype.Service

@Service
class PlayerService(
        private val playerDataSource: PlayerDataSource
) {

    fun updateNickname(user: Wolf4busyUser, nickname: String) {
        playerDataSource.updateNickname(user.uid, nickname)
    }
}