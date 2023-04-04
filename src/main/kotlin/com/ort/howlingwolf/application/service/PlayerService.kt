package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import com.ort.howlingwolf.infrastructure.datasource.player.PlayerDataSource
import com.ort.howlingwolf.infrastructure.repository.TweetRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerDataSource: PlayerDataSource,
    private val tweetRepository: TweetRepository
) {

    fun findPlayer(id: Int): Player = playerDataSource.findPlayer(id)

    fun findPlayer(user: HowlingWolfUser): Player = playerDataSource.findPlayer(user.uid)

    fun findPlayers(villageId: Int): Players = playerDataSource.findPlayers(villageId)

    fun findPlayers(playerIdList: List<Int>): Players = playerDataSource.findPlayers(playerIdList)

    fun updateNickname(user: HowlingWolfUser, nickname: String, twitterUserName: String?) {
        // API有料化に伴い機能停止
//        val twitterUserId = tweetRepository.getUserIdByUsername(twitterUserName)
        val twitterUserId = null
        playerDataSource.update(user.uid, nickname, twitterUserName, twitterUserId)
    }

    fun updateDetail(
        uid: String,
        nickname: String,
        otherSiteName: String?,
        introduction: String?
    ) {
        playerDataSource.updateDetail(uid, nickname, otherSiteName, introduction)
    }

    fun registerBlacklist(uid: String, targetPlayerId: Int) {
        playerDataSource.registerBlacklist(uid, targetPlayerId)
    }

    fun deleteBlacklist(uid: String, targetPlayerId: Int) {
        playerDataSource.deleteBlacklist(uid, targetPlayerId)
    }

    fun registerIntroduce(uid: String, targetPlayerId: Int) {
        val player = playerDataSource.findPlayer(uid)
        if (!player.canIntroduce()) return
        if (player.id == targetPlayerId) return
        playerDataSource.registerIntroduce(uid, targetPlayerId)
    }

    fun deleteIntroduce(uid: String, targetPlayerId: Int) {
        playerDataSource.deleteIntroduce(uid, targetPlayerId)
    }

    fun updateDifference(before: Players, after: Players) = playerDataSource.updateDifference(before, after)
}