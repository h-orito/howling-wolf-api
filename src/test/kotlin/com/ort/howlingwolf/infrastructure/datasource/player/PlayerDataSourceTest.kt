package com.ort.howlingwolf.infrastructure.datasource.player

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.howlingwolf.HowlingWolfTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class PlayerDataSourceTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var playerBhv: PlayerBhv
    @Autowired
    lateinit var villageBhv: VillageBhv
    @Autowired
    lateinit var villagePlayerBhv: VillagePlayerBhv
    @Autowired
    lateinit var playerDataSource: PlayerDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findPlayer() {
        // ## Arrange ##
        val playerId = 2
        val villageId = insertVillage(playerId)
        insertVillage(3)
        insertVillage(playerId)
        insertVillagePlayer(villageId, playerId)

        // ## Act ##
        val player = playerDataSource.findPlayer(playerId)

        // ## Assert ##
        assertThat(player.createFinishedVillageIdList.size).isEqualTo(0)
        assertThat(player.createProgressVillageIdList.size).isEqualTo(2)
        assertThat(player.participateFinishedVillageIdList.size).isEqualTo(0)
        assertThat(player.participateProgressVillageIdList.size).isEqualTo(1)
    }

    @Test
    fun test_findPlayerByUid() {
        // ## Arrange ##
        val playerId = 2
        val villageId = insertVillage(playerId)
        insertVillage(3)
        insertVillage(playerId)
        insertVillagePlayer(villageId, playerId)
        val player = playerBhv.selectEntityWithDeletedCheck { it.query().setPlayerId_Equal(playerId) }

        // ## Act ##
        val playerByUid = playerDataSource.findPlayer(player.uid)

        // ## Assert ##
        assertThat(playerByUid.createFinishedVillageIdList.size).isEqualTo(0)
        assertThat(playerByUid.createProgressVillageIdList.size).isEqualTo(2)
        assertThat(playerByUid.participateFinishedVillageIdList.size).isEqualTo(0)
        assertThat(playerByUid.participateProgressVillageIdList.size).isEqualTo(1)
    }

    @Test
    fun test_findPlayers() {
        // ## Arrange ##
        val playerId = 2
        val villageId = insertVillage(playerId)
        insertVillagePlayer(villageId, playerId)
        insertVillagePlayer(villageId, 3)
        insertVillagePlayer(villageId, 4)

        // ## Act ##
        val players = playerDataSource.findPlayers(villageId)

        // ## Assert ##
        assertThat(players.list.size).isEqualTo(3)
    }

    @Test
    fun test_update() {
        // ## Arrange ##
        val player = playerBhv.selectEntityWithDeletedCheck { it.query().setPlayerId_Equal(2) }
        val nickname = "after_n_n"
        val twitterUserName = "after_u_n"

        // ## Act ##
        playerDataSource.update(player.uid, nickname, twitterUserName)

        // ## Assert ##
        val playerByUid = playerDataSource.findPlayer(player.uid)
        assertThat(playerByUid.nickname).isEqualTo(nickname)
        assertThat(playerByUid.twitterUserName).isEqualTo(twitterUserName)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun insertVillage(playerId: Int): Int {
        val village = Village()
        village.villageDisplayName = "name"
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.プロローグ
        village.createPlayerId = playerId
        villageBhv.insert(village)
        return village.villageId
    }

    private fun insertVillagePlayer(villageId: Int, playerId: Int): Int {
        val villagePlayer = VillagePlayer()
        villagePlayer.villageId = villageId
        villagePlayer.playerId = playerId
        villagePlayer.charaId = 1
        villagePlayer.requestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.secondRequestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.isSpectator = false
        villagePlayer.isGone = false
        villagePlayer.isDead = false
        villagePlayerBhv.insert(villagePlayer)
        return villagePlayer.villagePlayerId
    }
}