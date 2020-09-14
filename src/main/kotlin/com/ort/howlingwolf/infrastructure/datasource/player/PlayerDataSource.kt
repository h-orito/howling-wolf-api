package com.ort.howlingwolf.infrastructure.datasource.player

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exbhv.PlayerDetailBhv
import com.ort.dbflute.exentity.Player
import com.ort.dbflute.exentity.PlayerDetail
import com.ort.howlingwolf.domain.model.player.Players
import org.springframework.stereotype.Repository

@Repository
class PlayerDataSource(
    private val playerBhv: PlayerBhv,
    private val playerDetailBhv: PlayerDetailBhv
) {

    fun findPlayer(id: Int): com.ort.howlingwolf.domain.model.player.Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.setupSelect_PlayerDetailAsOne()
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
            it.setupSelect_PlayerDetailAsOne()
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
            it.setupSelect_PlayerDetailAsOne()
            it.query().existsVillagePlayer {
                it.query().setVillageId_Equal(villageId)
            }
        }
        return Players(list = playerList.map { convertPlayerToSimplePlayer(it) })
    }

    fun findPlayers(playerIdList: List<Int>): Players {
        if (playerIdList.isEmpty()) return Players(listOf())
        val playerList = playerBhv.selectList {
            it.setupSelect_PlayerDetailAsOne()
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

    fun updateDetail(uid: String, otherSiteName: String?, introduction: String?) {
        val detail = PlayerDetail()
        detail.otherSiteName = otherSiteName
        detail.introduction = introduction
        val entity = playerDetailBhv.selectEntity {
            it.query().queryPlayer().setUid_Equal(uid)
        }
        if (entity.isPresent) {
            playerDetailBhv.queryUpdate(detail) {
                it.query().queryPlayer().setUid_Equal(uid)
            }
        } else {
            val player = playerBhv.selectByUniqueOf(uid)
            detail.playerId = player.get().playerId
            playerDetailBhv.insert(detail)
        }
    }

    fun updateDifference(before: Players, after: Players) {
        // player
        after.list.forEach {
            val beforePlayer = before.list.first { bP -> bP.id == it.id }
            if (it.existsDifference(beforePlayer)) {
                val player = Player()
                player.playerId = it.id
                player.isRestrictedParticipation = it.isRestrictedParticipation
                playerBhv.update(player)
            }
        }
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertPlayerToPlayer(player: Player): com.ort.howlingwolf.domain.model.player.Player {
        return com.ort.howlingwolf.domain.model.player.Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserName,
            otherSiteName = player.playerDetailAsOne.map { it.otherSiteName }.orElse(null),
            introduction = player.playerDetailAsOne.map { it.introduction }.orElse(null),
            isRestrictedParticipation = player.isRestrictedParticipation,
            participateProgressVillageIdList = player.villagePlayerList.filter {
                !it.village.get().villageStatusCodeAsVillageStatus.isSolvedVillage
            }.map { it.villageId },
            participateFinishedVillageIdList = player.villagePlayerList.filter {
                val status = it.village.get().villageStatusCodeAsVillageStatus
                status == CDef.VillageStatus.エピローグ || status == CDef.VillageStatus.終了
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
            otherSiteName = player.playerDetailAsOne.map { it.otherSiteName }.orElse(null),
            introduction = player.playerDetailAsOne.map { it.introduction }.orElse(null),
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
