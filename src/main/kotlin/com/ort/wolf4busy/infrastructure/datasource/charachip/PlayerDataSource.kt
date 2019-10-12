package com.ort.wolf4busy.infrastructure.datasource.charachip

import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
        private val playerBhv: PlayerBhv
) {

    fun selectPlayer(uid: String): com.ort.wolf4busy.domain.model.player.Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.query().setUid_Equal(uid)
        }
        return convertPlayerToPlayer(player)
    }

    fun updateNickname(uid: String, nickname: String, twitterUserName: String) {
        val player = Player()
        player.uniqueBy(uid)
        player.nickname = nickname
        player.twitterUserName = twitterUserName
        playerBhv.update(player)
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertPlayerToPlayer(player: Player): com.ort.wolf4busy.domain.model.player.Player {
        return com.ort.wolf4busy.domain.model.player.Player(
            id= player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName
        )
    }
}
