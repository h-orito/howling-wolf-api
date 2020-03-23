package com.ort.howlingwolf.infrastructure.datasource.player

import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import com.ort.howlingwolf.domain.model.player.Players
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
    private val playerBhv: PlayerBhv
) {

    fun findPlayer(id: Int): com.ort.howlingwolf.domain.model.player.Player {
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

    fun findPlayer(uid: String): com.ort.howlingwolf.domain.model.player.Player {
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

    fun findPlayers(playerIdList: List<Int>): Players {
        val playerList = playerBhv.selectList {
            it.query().existsVillagePlayer {
                it.query().setPlayerId_InScope(playerIdList)
            }
        }
        return Players(list = playerList.map { convertPlayerToSimplePlayer(it) })
    }

    fun update(uid: String, nickname: String, twitterUserName: String) {
        val player = Player()
        player.uniqueBy(uid)
        player.nickname = removeSurrogate(nickname)
        player.twitterUserName = twitterUserName
        playerBhv.update(player)
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertPlayerToPlayer(player: Player): com.ort.howlingwolf.domain.model.player.Player {
        return com.ort.howlingwolf.domain.model.player.Player(
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

    private fun convertPlayerToSimplePlayer(player: Player): com.ort.howlingwolf.domain.model.player.Player {
        return com.ort.howlingwolf.domain.model.player.Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName,
            isRestrictedParticipation = player.isRestrictedParticipation
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * 絵文字を除く文字列を返す
     * @param text
     * @return 4byte文字を除いた文字列
     */
    private fun removeSurrogate(text: String): String {
        return text.chunked(1).filter { c ->
            !c.matches("[\\uD800-\\uDFFF]".toRegex())
        }.joinToString(separator = "")
    }
}
