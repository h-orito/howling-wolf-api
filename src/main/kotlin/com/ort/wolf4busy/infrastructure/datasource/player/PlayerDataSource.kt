package com.ort.wolf4busy.infrastructure.datasource.player

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import com.ort.wolf4busy.domain.model.player.Players
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
    private val playerBhv: PlayerBhv
) {

    fun findPlayer(id: Int): com.ort.wolf4busy.domain.model.player.Player {
        val player = playerBhv.selectByPK(id).get()
        return convertPlayerToPlayer(player)
    }

    fun selectPlayer(uid: String): com.ort.wolf4busy.domain.model.player.Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.query().setUid_Equal(uid)
        }
        return convertPlayerToPlayer(player)
    }

    fun selectPlayerList(villageId: Int): Players {
        val playerList = playerBhv.selectList {
            it.query().existsVillagePlayer {
                it.query().setVillageId_Equal(villageId)
            }
        }
        return Players(list = playerList.map { convertPlayerToPlayer(it) })
    }

    fun updateNickname(uid: String, nickname: String, twitterUserName: String) {
        val player = Player()
        player.uniqueBy(uid)
        player.nickname = nickname
        player.twitterUserName = twitterUserName
        playerBhv.update(player)
    }

    fun isRestrictedParticipatePlayer(uid: String): Boolean {
        return playerBhv.selectEntityWithDeletedCheck {
            it.query().setUid_Equal(uid)
        }.isRestrictedParticipation
    }

    fun hasProgressMyselfVillage(uid: String): Boolean {
        return playerBhv.selectEntity {
            it.query().existsVillage { villageCB ->
                villageCB.query().setVillageStatusCode_Equal_進行中()
            }
            it.fetchFirst(1)
        }.isPresent
    }

    /**
     * いずれかの進行中の村に参加しているか
     * @param uid uid
     * @return いずれかの進行中の村に参加しているか
     */
    fun isParticipatingAnyProgressVillage(uid: String): Boolean {
        return playerBhv.selectEntity {
            it.query().setUid_Equal(uid)
            it.query().existsVillagePlayer { vpCB ->
                vpCB.query().queryVillage().setVillageStatusCode_InScope_AsVillageStatus(
                    listOf(CDef.VillageStatus.プロローグ, CDef.VillageStatus.進行中)
                )
            }
            it.fetchFirst(1)
        }.isPresent
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertPlayerToPlayer(player: Player): com.ort.wolf4busy.domain.model.player.Player {
        return com.ort.wolf4busy.domain.model.player.Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName,
            isRestrictedParticipation = player.isRestrictedParticipation
        )
    }
}
