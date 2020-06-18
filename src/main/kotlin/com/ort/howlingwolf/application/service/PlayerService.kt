package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import com.ort.howlingwolf.infrastructure.datasource.player.PlayerDataSource
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerDataSource: PlayerDataSource
) {

    fun findPlayer(id: Int): Player = playerDataSource.findPlayer(id)

    fun findPlayer(user: HowlingWolfUser): Player = playerDataSource.findPlayer(user.uid)

    fun findPlayers(villageId: Int): Players = playerDataSource.findPlayers(villageId)

    fun findPlayers(playerIdList: List<Int>): Players = playerDataSource.findPlayers(playerIdList)

    fun updateNickname(user: HowlingWolfUser, nickname: String, twitterUserName: String) {
        playerDataSource.update(user.uid, nickname, twitterUserName)
    }

    fun updateDetail(uid: String, otherSiteName: String?, introduction: String?) {
        playerDataSource.updateDetail(uid, otherSiteName, introduction)
    }

    fun updateDifference(before: Players, after: Players) = playerDataSource.updateDifference(before, after)
}