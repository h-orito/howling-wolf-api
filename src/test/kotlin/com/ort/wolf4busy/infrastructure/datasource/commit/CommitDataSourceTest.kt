package com.ort.wolf4busy.infrastructure.datasource.commit

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.CommitBhv
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exentity.Commit
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource
import org.assertj.core.api.Assertions.assertThat
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
class CommitDataSourceTest : Wolf4busyTest() {

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
    lateinit var commitBhv: CommitBhv
    @Autowired
    lateinit var commitDataSource: CommitDataSource
    @Autowired
    lateinit var villageDataSource: VillageDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findCommit() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        val villagePlayerId = insertVillagePlayer(village.id)
        village = villageDataSource.findVillage(village.id)
        insertCommit(village.day.latestDay().id, villagePlayerId)
        val participant = village.participant.memberList[0]

        // ## Act ##
        val commit = commitDataSource.findCommit(village, participant)

        // ## Assert ##
        assertThat(commit).isNotNull
    }

    @Test
    fun test_findCommits() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertCommit(villageDayId, villagePlayerId)

        // ## Act ##
        val commits = commitDataSource.findCommits(villageId)

        // ## Assert ##
        assertThat(commits.list).isNotEmpty
    }

    @Test
    fun test_updateCommit() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertCommit(villageDayId, villagePlayerId)
        val commit = com.ort.wolf4busy.domain.model.commit.Commit(
            villageDayId = villageDayId,
            myselfId = villagePlayerId,
            isCommitting = false
        )

        // ## Act ##
        commitDataSource.updateCommit(commit)
        val commits = commitDataSource.findCommits(villageId)

        // ## Assert ##
        assertThat(commits.list).isEmpty()

        // ## Act ##
        val recommit = commit.copy(isCommitting = true)
        commitDataSource.updateCommit(recommit)
        val recommits = commitDataSource.findCommits(villageId)

        // ## Assert ##
        assertThat(recommits.list).isNotEmpty
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

    private fun insertCommit(villageDayId: Int, villagePlayerId: Int) {
        val commit = Commit()
        commit.villageDayId = villageDayId
        commit.villagePlayerId = villagePlayerId
        commitBhv.insert(commit)
    }

    private fun createDummyVillageParam(): com.ort.wolf4busy.domain.model.village.Village {
        return com.ort.wolf4busy.domain.model.village.Village(
            id = 1,
            name = "dummy_village_name",
            creatorPlayerId = 1,
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = VillageSettings(
                capacity = PersonCapacity(
                    min = 10,
                    max = 16
                ),
                time = VillageTime(
                    termType = CDef.Term.長期.code(),
                    startDatetime = LocalDateTime.now().plusDays(1L).withNano(0),
                    dayChangeIntervalSeconds = 24 * 60 * 60
                ),
                charachip = VillageCharachip(
                    dummyCharaId = 1,
                    charachipId = 1
                ),
                organizations = VillageOrganizations(),
                rules = VillageRules(
                    openVote = false,
                    availableSkillRequest = true,
                    availableSpectate = false,
                    openSkillInGrave = false,
                    visibleGraveMessage = false,
                    availableSuddenlyDeath = true,
                    availableCommit = false,
                    messageRestrict = VillageMessageRestricts()
                ),
                password = VillagePassword(
                    joinPasswordRequired = false,
                    joinPassword = null
                )
            ),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf()
            ),
            spectator = VillageParticipants(
                count = 0,
                memberList = listOf()
            ),
            day = VillageDays(
                dayList = listOf()
            ),
            winCamp = null
        )
    }
}