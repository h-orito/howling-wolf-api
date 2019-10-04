package com.ort.wolf4busy.infrastructure.datasource.charachip

import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
        private val playerBhv: PlayerBhv
) {

    fun updateNickname(uid: String, nickname: String) {
        val player = Player()
        player.uniqueBy(uid)
        player.nickname = nickname
        playerBhv.update(player)
    }
}