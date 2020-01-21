package com.ort.wolf4busy.infrastructure.datasource.player

import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import com.ort.wolf4busy.domain.model.player.Players
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
    private val playerBhv: PlayerBhv
) {

    fun findPlayer(id: Int): com.ort.wolf4busy.domain.model.player.Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.query().setPlayerId_Equal(id)
        }
        playerBhv.load(player) {
            it.loadVillage { } // creator village
            it.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Village()
                vpCB.query().setIsGone_Equal(false) // participant village
            }
        }
        return convertPlayerToPlayer(player)
    }

    fun findPlayer(uid: String): com.ort.wolf4busy.domain.model.player.Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.query().setUid_Equal(uid)
        }
        playerBhv.load(player) {
            it.loadVillage { } // creator village
            it.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Village()
                vpCB.query().setIsGone_Equal(false) // participant village
            }
        }
        return convertPlayerToPlayer(player)
    }

    fun findPlayers(villageId: Int): Players {
        val playerList = playerBhv.selectList {
            it.query().existsVillagePlayer {
                it.query().setVillageId_Equal(villageId)
            }
        }
        return Players(list = playerList.map { convertPlayerToSimplePlayer(it) })
    }

    fun update(uid: String, nickname: String, twitterUserName: String) {
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
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName,
            isRestrictedParticipation = player.isRestrictedParticipation,
            participateProgressVillageIdList = player.villagePlayerList.filter {
                !it.village.get().villageStatusCodeAsVillageStatus.isSolvedVillage
            }.map { it.villageId },
            participateFinishedVillageIdList = player.villagePlayerList.filter {
                it.village.get().villageStatusCodeAsVillageStatus.isSolvedVillage
            }.map { it.villageId },
            createProgressVillageIdList = player.villageList.filter {
                !it.villageStatusCodeAsVillageStatus.isSolvedVillage
            }.map { it.villageId },
            createFinishedVillageIdList = player.villageList.filter {
                it.villageStatusCodeAsVillageStatus.isSolvedVillage
            }.map { it.villageId }
        )
    }

    private fun convertPlayerToSimplePlayer(player: Player): com.ort.wolf4busy.domain.model.player.Player {
        return com.ort.wolf4busy.domain.model.player.Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName,
            isRestrictedParticipation = player.isRestrictedParticipation
        )
    }
}
