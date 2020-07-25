package com.ort.howlingwolf.domain.service.participate

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ParticipateDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var participateDomainService: ParticipateDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_assertParticipate_ログインしていない() {
        // ## Arrange ##
        val player = null
        val village = createAvailableSpectateVillage()
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_既に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            participateProgressVillageIdList = listOf(village.id)
        )
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_プロローグでない() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_既に最大人数まで参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            participant = VillageParticipants(
                count = 16,
                memberList = (1..16).map { DummyDomainModelCreator.createDummyVillageParticipant() }
            )
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_既に最大人数まで見学している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            spectator = VillageParticipants(
                count = 14,
                memberList = (1..14).map {
                    DummyDomainModelCreator.createDummyVillageParticipant().copy(
                        isSpectator = true
                    )
                }
            )
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_決着のついていない村に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            participateProgressVillageIdList = listOf(village.id + 1)
        )
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_入村制限がかかっている() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            isRestrictedParticipation = true
        )
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertParticipate(
                player,
                village,
                charaId,
                firstRequest,
                secondRequest,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_参加できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val firstRequest = CDef.Skill.村人
        val secondRequest = CDef.Skill.村人

        // ## Act ##
        // ## Assert ##
        participateDomainService.assertParticipate(
            player,
            village,
            charaId,
            firstRequest,
            secondRequest,
            null
        )
    }

    @Test
    fun test_assertParticipate_見学できない設定である() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(availableSpectate = false)
            )
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            participateDomainService.assertSpectate(
                player,
                village,
                charaId,
                charachipCharaNum,
                null
            )
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertParticipate_見学できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charaId = 1
        val charachipCharaNum = 30

        // ## Act ##
        // ## Assert ##
        participateDomainService.assertSpectate(
            player,
            village,
            charaId,
            charachipCharaNum,
            null
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createAvailableSpectateVillage(): Village = DummyDomainModelCreator.createDummyVillage().copy(
        status = VillageStatus(CDef.VillageStatus.プロローグ),
        setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
            rules = VillageRules().copy(availableSpectate = true),
            capacity = PersonCapacity(10, 16)
        ),
        participant = VillageParticipants(
            count = 15,
            memberList = (1..15).map { DummyDomainModelCreator.createDummyVillageParticipant() }
        ),
        spectator = VillageParticipants(
            count = 13,
            memberList = (1..13).map {
                DummyDomainModelCreator.createDummyVillageParticipant().copy(
                    isSpectator = true
                )
            }
        )
    )
}