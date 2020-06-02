package com.ort.howlingwolf.infrastructure.datasource.vote

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exbhv.VoteBhv
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.dbflute.exentity.Vote
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class VoteDataSourceTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageBhv: VillageBhv
    @Autowired
    lateinit var villagePlayerBhv: VillagePlayerBhv
    @Autowired
    lateinit var villageDayBhv: VillageDayBhv
    @Autowired
    lateinit var voteBhv: VoteBhv
    @Autowired
    lateinit var voteDataSource: VoteDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findVotes() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villagePlayerId2 = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertVote(villageDayId, villagePlayerId, villagePlayerId2)

        // ## Act ##
        val votes = voteDataSource.findVotes(villageId)

        // ## Assert ##
        Assertions.assertThat(votes.list.size).isEqualTo(1)
    }

    @Test
    fun test_updateVote() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villagePlayerId2 = insertVillagePlayer(villageId)
        val villagePlayerId3 = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertVote(villageDayId, villagePlayerId, villagePlayerId2)

        // ## Act ##
        val villageVote = VillageVote(
            villageDayId = villageDayId,
            myselfId = villagePlayerId,
            targetId = villagePlayerId3
        )
        voteDataSource.updateVote(villageVote)

        // ## Assert ##
        val abilities = voteDataSource.findVotes(villageId)
        Assertions.assertThat(abilities.list.size).isEqualTo(1)
        Assertions.assertThat(abilities.list[0].myselfId).isEqualTo(villagePlayerId)
        Assertions.assertThat(abilities.list[0].targetId).isEqualTo(villagePlayerId3)
    }

    @Test
    fun test_updateDifference() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villagePlayerId2 = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertVote(villageDayId, villagePlayerId, villagePlayerId2)
        val before = voteDataSource.findVotes(villageId)
        val after = before.copy(
            list = before.list + VillageVote(
                villageDayId = villageDayId,
                myselfId = villagePlayerId2,
                targetId = villagePlayerId
            )
        )
        println(villagePlayerId)
        println(villagePlayerId2)
        println(before.list.first().myselfId)
        println(before.list.first().targetId)
        println(after.list.last().myselfId)
        println(after.list.last().targetId)

        // ## Act ##
        voteDataSource.updateDifference(before, after)

        // ## Assert ##
        val votes = voteDataSource.findVotes(villageId)
        Assertions.assertThat(votes.list.size).isEqualTo(2)
        Assertions.assertThat(votes.list[0].myselfId).isEqualTo(villagePlayerId)
        Assertions.assertThat(votes.list[0].targetId).isEqualTo(villagePlayerId2)
        Assertions.assertThat(votes.list[1].myselfId).isEqualTo(villagePlayerId2)
        Assertions.assertThat(votes.list[1].targetId).isEqualTo(villagePlayerId)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun insertVillage(): Int {
        val village = Village()
        village.villageDisplayName = "name"
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.プロローグ
        village.createPlayerId = 1
        villageBhv.insert(village)
        return village.villageId
    }

    private fun insertVillagePlayer(villageId: Int): Int {
        val villagePlayer = VillagePlayer()
        villagePlayer.villageId = villageId
        villagePlayer.playerId = 1
        villagePlayer.charaId = 1
        villagePlayer.requestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.secondRequestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.isSpectator = false
        villagePlayer.isGone = false
        villagePlayer.isDead = false
        villagePlayerBhv.insert(villagePlayer)
        return villagePlayer.villagePlayerId
    }

    private fun insertVillageDay(villageId: Int): Int {
        val villageDay = VillageDay()
        villageDay.villageId = villageId
        villageDay.day = 1
        villageDay.noonnightCodeAsNoonnight = CDef.Noonnight.昼
        villageDay.daychangeDatetime = LocalDateTime.now()
        villageDayBhv.insert(villageDay)
        return villageDay.villageDayId
    }

    private fun insertVote(villageDayId: Int, villagePlayerId: Int, targetVillagePlayerId: Int) {
        val vote = Vote()
        vote.villageDayId = villageDayId
        vote.villagePlayerId = villagePlayerId
        vote.targetVillagePlayerId = targetVillagePlayerId
        voteBhv.insert(vote)
    }
}