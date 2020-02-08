package com.ort.howlingwolf.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ParticipateTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isAvailableParticipate_ログインしていない() {
        // ## Arrange ##
        val player = null
        val village = createAvailableSpectateVillage()
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_既に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            participateProgressVillageIdList = listOf(village.id)
        )
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_プロローグでない() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_既に最大人数まで参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            participant = VillageParticipants(
                count = 16,
                memberList = (1..16).map { DummyDomainModelCreator.createDummyVillageParticipant() }
            )
        )
        val player = DummyDomainModelCreator.createDummyPlayer()

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_既に最大人数まで見学している() {
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
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_決着のついていない村に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            participateProgressVillageIdList = listOf(village.id + 1)
        )
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_入村制限がかかっている() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer().copy(
            isRestrictedParticipation = true
        )
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableParticipate).isFalse()
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_参加できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer()

        // ## Act ##
        val isAvailableParticipate = Participate.isAvailableParticipate(player, village)

        // ## Assert ##
        assertThat(isAvailableParticipate).isTrue()
    }

    @Test
    fun test_isAvailableParticipate_見学できない設定である() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(availableSpectate = false)
            )
        )
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableSpectate).isFalse()
    }

    @Test
    fun test_isAvailableParticipate_見学できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val player = DummyDomainModelCreator.createDummyPlayer()
        val charachipCharaNum = 30

        // ## Act ##
        val isAvailableSpectate = Participate.isAvailableSpectate(player, village, charachipCharaNum)

        // ## Assert ##
        assertThat(isAvailableSpectate).isTrue()
    }

    // TODO assertParticipate

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