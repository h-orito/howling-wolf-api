package com.ort.howlingwolf.domain.service.say

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class WerewolfSayDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var werewolfSayDomainService: WerewolfSayDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isViewable_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = null

        // ## Act ##
        val isViewable = werewolfSayDomainService.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isTrue()
    }

    @Test
    fun test_isViewable_進行中_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = null

        // ## Act ##
        val isViewable = werewolfSayDomainService.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isFalse()
    }

    @Test
    fun test_isViewable_進行中_村人() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isViewable = werewolfSayDomainService.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isFalse()
    }

    @Test
    fun test_isViewable_進行中_人狼() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyAliveWolf()

        // ## Act ##
        val isViewable = werewolfSayDomainService.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isTrue()
    }

    @Test
    fun test_isSayable_役職なし() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val isSayable = werewolfSayDomainService.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_村人() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isSayable = werewolfSayDomainService.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_人狼_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyDeadWolf()

        // ## Act ##
        val isSayable = werewolfSayDomainService.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_人狼_生存_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyAliveWolf()

        // ## Act ##
        val isSayable = werewolfSayDomainService.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_人狼_生存_進行中() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyAliveWolf()

        // ## Act ##
        val isSayable = werewolfSayDomainService.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isTrue()
    }
}