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

    fun findPlayer(id: Int): Player {
        return playerDataSource.findPlayer(id)
    }

    fun findPlayer(user: Wolf4busyUser): Player {
        return playerDataSource.selectPlayer(user.uid)
    }

    fun findPlayers(villageId: Int): Players {
        return playerDataSource.selectPlayerList(villageId)
    }

    fun updateNickname(user: Wolf4busyUser, nickname: String, twitterUserName: String) {
        playerDataSource.updateNickname(user.uid, nickname, twitterUserName)
    }

    fun isRestrictedParticipatePlayer(user: Wolf4busyUser): Boolean {
        return playerDataSource.isRestrictedParticipatePlayer(user.uid)
    }

    fun hasProgressMyselfVillage(uid: String): Boolean {
        return playerDataSource.hasProgressMyselfVillage(uid)
    }

    /**
     * どこかの村に参加しているか
     *
     * @param uid
     */
    fun isParticipatingAnyProgressVillage(uid: String): Boolean = playerDataSource.isParticipatingAnyProgressVillage(uid)
}