package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.setting.VillageRules
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class GraveSayTest : Wolf4busyTest() {

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
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isTrue()
    }

    @Test
    fun test_isViewable_進行中_閲覧可能な設定() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(visibleGraveMessage = true)
            )
        )
        val participant = null

        // ## Act ##
        val isViewable = GraveSay.isViewable(village, participant)

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
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isFalse()
    }

    @Test
    fun test_isViewable_進行中_見学() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )

        // ## Act ##
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isTrue()
    }

    @Test
    fun test_isViewable_進行中_死亡_突然死() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = Dead(CDef.DeadReason.突然, DummyDomainModelCreator.createDummyFirstVillageDay())
        )

        // ## Act ##
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isFalse()
    }

    @Test
    fun test_isViewable_進行中_死亡_処刑() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = Dead(CDef.DeadReason.処刑, DummyDomainModelCreator.createDummyFirstVillageDay())
        )

        // ## Act ##
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isTrue()
    }

    @Test
    fun test_isViewable_進行中_生存() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = null
        )

        // ## Act ##
        val isViewable = GraveSay.isViewable(village, participant)

        // ## Assert ##
        assertThat(isViewable).isFalse()
    }

    @Test
    fun test_isSayable_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val isSayable = GraveSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_生存() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isSayable = GraveSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_見学() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )

        // ## Act ##
        val isSayable = GraveSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_死亡_突然死() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = Dead(CDef.DeadReason.突然, DummyDomainModelCreator.createDummyFirstVillageDay())
        )

        // ## Act ##
        val isSayable = GraveSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_死亡_処刑() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = Dead(CDef.DeadReason.処刑, DummyDomainModelCreator.createDummyFirstVillageDay())
        )

        // ## Act ##
        val isSayable = GraveSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isTrue()
    }
}