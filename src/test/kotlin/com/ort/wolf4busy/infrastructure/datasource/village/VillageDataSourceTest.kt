package com.ort.wolf4busy.infrastructure.datasource.village

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.*
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
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
class VillageDataSourceTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageDataSource: VillageDataSource
    @Autowired
    lateinit var villageBhv: VillageBhv
    @Autowired
    lateinit var villagePlayerBhv: VillagePlayerBhv
    @Autowired
    lateinit var villageSettingBhv: VillageSettingBhv
    @Autowired
    lateinit var messageRestrictionBhv: MessageRestrictionBhv
    @Autowired
    lateinit var villageDayBhv: VillageDayBhv

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_registerVillage() {
        // ## Arrange ##
        val villageName = "village_name"
        val createPlayerId = 1
        val capacityMin = 10
        val capacityMax = 16
        val startDatetime = LocalDateTime.now().plusDays(2L).withNano(0)
        val interval = 24 * 60 * 60
        val dummyCharaId = 2
        val charachipId = 3

        val paramVillage = com.ort.wolf4busy.domain.model.village.Village(
            id = 1,
            name = villageName,
            creatorPlayerId = createPlayerId,
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = VillageSettings(
                capacity = PersonCapacity(
                    min = capacityMin,
                    max = capacityMax
                ),
                time = VillageTime(
                    termType = CDef.Term.長期.code(),
                    startDatetime = startDatetime,
                    dayChangeIntervalSeconds = interval
                ),
                charachip = VillageCharachip(
                    dummyCharaId = dummyCharaId,
                    charachipId = charachipId
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

        // ## Act ##
        val registeredVillage = villageDataSource.registerVillage(paramVillage)
        val villageId = registeredVillage.id

        // ## Assert ##
        // village
        val village = villageBhv.selectByPK(villageId).get()
        assertThat(village.villageDisplayName).isEqualTo(villageName)
        assertThat(village.createPlayerId).isEqualTo(createPlayerId)
        assertThat(village.villageStatusCodeAsVillageStatus).isEqualTo(CDef.VillageStatus.プロローグ)
        assertThat(village.epilogueDay as Int?).isNull()
        assertThat(village.winCampCodeAsCamp).isNull()
        // village_day
        val villageDayList = villageDayBhv.selectList { it.query().setVillageId_Equal(villageId) }
        assertThat(villageDayList.size).isEqualTo(1)
        assertThat(villageDayList.first()).satisfies { firstDay ->
            assertThat(firstDay.day).isEqualTo(0)
            assertThat(firstDay.noonnightCodeAsNoonnight).isEqualTo(CDef.Noonnight.昼)
            assertThat(firstDay.daychangeDatetime).isEqualTo(startDatetime)
        }
        // village_settings
        val settingList = villageSettingBhv.selectList { it.query().setVillageId_Equal(villageId) }
        assertThat(settingList).isNotEmpty
        assertThat(settingList.first { it.isVillageSettingItemCodeキャラクターグループid }.villageSettingText).isEqualTo(charachipId.toString())
        assertThat(settingList.first { it.isVillageSettingItemCodeコミット可能か }.villageSettingText).isEqualTo("0")
        assertThat(settingList.first { it.isVillageSettingItemCodeダミーキャラid }.villageSettingText).isEqualTo(dummyCharaId.toString())
        assertThat(settingList.first { it.isVillageSettingItemCode役職希望可能か }.villageSettingText).isEqualTo("1")
        assertThat(settingList.first { it.isVillageSettingItemCode更新間隔秒 }.villageSettingText).isEqualTo(interval.toString())
        assertThat(settingList.first { it.isVillageSettingItemCode最低人数 }.villageSettingText).isEqualTo(capacityMin.toString())
        assertThat(settingList.first { it.isVillageSettingItemCode最大人数 }.villageSettingText).isEqualTo(capacityMax.toString())
        assertThat(settingList.first { it.isVillageSettingItemCode突然死ありか }.villageSettingText).isEqualTo("1")
        assertThat(settingList.first { it.isVillageSettingItemCode記名投票か }.villageSettingText).isEqualTo("0")
        assertThat(settingList.first { it.isVillageSettingItemCode開始予定日時 }.villageSettingText).isNotNull()
        assertThat(settingList.first { it.isVillageSettingItemCode期間形式 }.villageSettingText).isEqualTo(CDef.Term.長期.code())
        // message_restriction
        val restrictList = messageRestrictionBhv.selectList { it.query().setVillageId_Equal(villageId) }
        assertThat(restrictList.size).isEqualTo(2)
        assertThat(restrictList.first { it.isMessageTypeCode人狼の囁き }).satisfies { restrict ->
            assertThat(restrict.messageMaxLength).isEqualTo(200)
            assertThat(restrict.messageMaxNum).isEqualTo(40)
        }
        assertThat(restrictList.first { it.isMessageTypeCode通常発言 }).satisfies { restrict ->
            assertThat(restrict.messageMaxLength).isEqualTo(200)
            assertThat(restrict.messageMaxNum).isEqualTo(20)
        }
    }

    @Test
    fun test_findVillages() {
        // ## Arrange ##
        val village1 = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village1.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village1.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village1.id, createDummyVillageParticipantParam())
        val village2 = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village2.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village2.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village2.id, createDummyVillageParticipantParam())
        val village3 = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village3.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village3.id, createDummyVillageParticipantParam())
        insertVillagePlayer(village3.id, createDummyVillageParticipantParam())

        // ## Act ##
        val villages = villageDataSource.findVillages()

        // ## Assert ##
        assertThat(villages.villageList.size).isEqualTo(3)
        assertThat(villages.villageList.first().participant.count).isEqualTo(3)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
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

    private fun createDummyVillageParticipantParam(): VillageParticipant {
        return VillageParticipant(
            id = 1, // dummy
            charaId = 1,
            playerId = 1,
            dead = null,
            isSpectator = false,
            isGone = false,
            skill = null,
            skillRequest = SkillRequest(Skill(CDef.Skill.おまかせ), Skill(CDef.Skill.おまかせ)),
            isWin = null
        )
    }

    private fun insertVillagePlayer(
        villageId: Int,
        participant: VillageParticipant
    ): Int {
        val vp = VillagePlayer()
        vp.villageId = villageId
        vp.playerId = participant.playerId
        vp.charaId = participant.charaId
        vp.isDead = false
        vp.isSpectator = participant.isSpectator
        vp.isGone = false
        vp.requestSkillCodeAsSkill = participant.skillRequest.first.toCdef()
        vp.secondRequestSkillCodeAsSkill = participant.skillRequest.second.toCdef()
        villagePlayerBhv.insert(vp)
        return vp.villagePlayerId
    }
}