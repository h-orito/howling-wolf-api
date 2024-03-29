package com.ort.howlingwolf.infrastructure.datasource.player

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.*
import com.ort.dbflute.exentity.BlacklistPlayer
import com.ort.dbflute.exentity.PlayerDetail
import com.ort.dbflute.exentity.PlayerIntroduce
import com.ort.dbflute.exentity.TwitterUser
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.blacklist.BlacklistPlayers
import org.springframework.stereotype.Repository
import com.ort.dbflute.exentity.Player as DbPlayer

@Repository
class PlayerDataSource(
    private val playerBhv: PlayerBhv,
    private val playerDetailBhv: PlayerDetailBhv,
    private val blacklistPlayerBhv: BlacklistPlayerBhv,
    private val playerIntroduceBhv: PlayerIntroduceBhv,
    private val twitterUserBhv: TwitterUserBhv
) {

    fun findPlayer(id: Int): Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.setupSelect_TwitterUserAsOne()
            it.setupSelect_PlayerDetailAsOne()
            it.query().setPlayerId_Equal(id)
        }
        playerBhv.load(player) {
            it.loadVillage { } // creator village
            it.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Village()
                vpCB.query().setIsGone_Equal(false) // participant village
            }
            it.loadBlacklistPlayerByFromPlayerId { }
            it.loadPlayerIntroduceByFromPlayerId { }
            it.loadPlayerIntroduceByToPlayerId { }
        }
        return convertPlayerToPlayer(player)
    }

    fun findPlayer(uid: String): Player {
        val player = playerBhv.selectEntityWithDeletedCheck {
            it.setupSelect_TwitterUserAsOne()
            it.setupSelect_PlayerDetailAsOne()
            it.query().setUid_Equal(uid)
        }
        playerBhv.load(player) {
            it.loadVillage { } // creator village
            it.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Village()
                vpCB.query().setIsGone_Equal(false) // participant village
            }
            it.loadBlacklistPlayerByFromPlayerId { }
            it.loadPlayerIntroduceByFromPlayerId { }
            it.loadPlayerIntroduceByToPlayerId { }
        }
        return convertPlayerToPlayer(player)
    }

    fun findPlayers(villageId: Int): Players {
        val playerList = playerBhv.selectList {
            it.setupSelect_TwitterUserAsOne()
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
            it.setupSelect_TwitterUserAsOne()
            it.setupSelect_PlayerDetailAsOne()
            it.query().setPlayerId_InScope(playerIdList)
        }
        return Players(list = playerList.map { convertPlayerToSimplePlayer(it) })
    }

    fun update(uid: String, nickname: String, twitterUserName: String?, twitterUserId: String?) {
        val existingPlayer = findPlayer(uid)
        // 既に自分で変更している可能性があるので、名無しのままの場合のみ変更する
        if (existingPlayer.nickname == "名無し") {
            val player = com.ort.dbflute.exentity.Player()
            player.uniqueBy(uid)
            player.nickname = nickname.ifEmpty { "名無し" }
            twitterUserId?.let { player.registerTrace = "twitterId: $it" }
            playerBhv.update(player)
        }
        twitterUserName?.let {
            val twitterUser = TwitterUser()
            twitterUser.playerId = existingPlayer.id
            twitterUser.twitterUserName = twitterUserName

            val existing = twitterUserBhv.selectByPK(existingPlayer.id)
            if (existing.isPresent) {
                twitterUserBhv.update(twitterUser)
            } else {
                twitterUserBhv.insert(twitterUser)
            }
        }
    }

    fun updateDetail(
        uid: String,
        nickname: String,
        otherSiteName: String?,
        introduction: String?
    ) {
        val player = com.ort.dbflute.exentity.Player()
        player.uniqueBy(uid)
        player.nickname = nickname.ifEmpty { "名無し" }
        playerBhv.update(player)

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

    fun registerBlacklist(uid: String, targetPlayerId: Int) {
        val entity = blacklistPlayerBhv.selectEntity {
            it.query().queryPlayerByFromPlayerId().setUid_Equal(uid)
            it.query().setToPlayerId_Equal(targetPlayerId)
        }
        if (entity.isPresent) return
        val player = playerBhv.selectEntity {
            it.query().setUid_Equal(uid)
        }
        if (!player.isPresent) return
        val blacklist = BlacklistPlayer()
        blacklist.fromPlayerId = player.get().playerId
        blacklist.toPlayerId = targetPlayerId
        blacklistPlayerBhv.insert(blacklist)
    }

    fun deleteBlacklist(uid: String, targetPlayerId: Int) {
        blacklistPlayerBhv.queryDelete {
            it.query().queryPlayerByFromPlayerId().setUid_Equal(uid)
            it.query().setToPlayerId_Equal(targetPlayerId)
        }
    }

    fun registerIntroduce(uid: String, targetPlayerId: Int) {
        val entity = playerIntroduceBhv.selectEntity {
            it.query().queryPlayerByFromPlayerId().setUid_Equal(uid)
            it.query().setToPlayerId_Equal(targetPlayerId)
        }
        if (entity.isPresent) return
        val player = playerBhv.selectEntity {
            it.query().setUid_Equal(uid)
        }
        if (!player.isPresent) return
        val introduce = PlayerIntroduce()
        introduce.fromPlayerId = player.get().playerId
        introduce.toPlayerId = targetPlayerId
        playerIntroduceBhv.insert(introduce)
    }

    fun deleteIntroduce(uid: String, targetPlayerId: Int) {
        playerIntroduceBhv.queryDelete {
            it.query().queryPlayerByFromPlayerId().setUid_Equal(uid)
            it.query().setToPlayerId_Equal(targetPlayerId)
        }
    }

    fun updateDifference(before: Players, after: Players) {
        // player
        after.list.forEach {
            val beforePlayer = before.list.first { bP -> bP.id == it.id }
            if (it.existsDifference(beforePlayer)) {
                val player = DbPlayer()
                player.playerId = it.id
                player.isRestrictedParticipation = it.isRestrictedParticipation
                playerBhv.update(player)
            }
        }
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertPlayerToPlayer(player: DbPlayer): Player {
        return Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserAsOne.map { it.twitterUserName }.orElse(null),
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
            }.map { it.villageId },
            blacklistPlayers = BlacklistPlayers(player.blacklistPlayerByFromPlayerIdList.map { it.toPlayerId }),
            introducePlayerIds = player.playerIntroduceByFromPlayerIdList.map { it.toPlayerId },
            introducedPlayerIds = player.playerIntroduceByToPlayerIdList.map { it.fromPlayerId }
        )
    }

    private fun convertPlayerToSimplePlayer(player: DbPlayer): Player {
        return Player(
            id = player.playerId,
            nickname = player.nickname,
            twitterUserName = player.twitterUserAsOne.map { it.twitterUserName }.orElse(null),
            otherSiteName = player.playerDetailAsOne.map { it.otherSiteName }.orElse(null),
            introduction = player.playerDetailAsOne.map { it.introduction }.orElse(null),
            isRestrictedParticipation = player.isRestrictedParticipation
        )
    }
}
