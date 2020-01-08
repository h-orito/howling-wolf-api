package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.PersonCapacity
import com.ort.wolf4busy.domain.model.village.setting.VillageRules
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VillageParticipateSituationTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_constructor_ログインしていない() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = null
        val user = null
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_既に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_プロローグでない() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_既に最大人数まで参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            participant = VillageParticipants(
                count = 16,
                memberList = (1..16).map { DummyDomainModelCreator.createDummyVillageParticipant() }
            )
        )
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
    }

    @Test
    fun test_constructor_既に最大人数まで見学している() {
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
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_決着のついていない村に参加している() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = true
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_入村制限がかかっている() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = true
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isFalse()
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_参加できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableParticipate).isTrue()
    }

    @Test
    fun test_constructor_見学できない設定である() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(availableSpectate = false)
            )
        )
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableSpectate).isFalse()
    }

    @Test
    fun test_constructor_見学できる() {
        // ## Arrange ##
        val village = createAvailableSpectateVillage()
        val participant = null
        val user = DummyDomainModelCreator.createDummyUser()
        val isParticipatingProgressVillage = false
        val isRestrictedParticipatePlayer = false
        val charachipCharaNum = 30

        // ## Act ##
        val villageParticipateSituation = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        )

        // ## Assert ##
        assertThat(villageParticipateSituation.isAvailableSpectate).isTrue()
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