package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.player.PlayerDataSource
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerDataSource: PlayerDataSource
) {

    fun findPlayer(id: Int): Player = playerDataSource.findPlayer(id)

    fun findPlayer(user: Wolf4busyUser): Player = playerDataSource.findPlayer(user.uid)

    fun findPlayers(villageId: Int): Players = playerDataSource.findPlayers(villageId)

    fun updateNickname(user: Wolf4busyUser, nickname: String, twitterUserName: String) {
        playerDataSource.update(user.uid, nickname, twitterUserName)
    }
}