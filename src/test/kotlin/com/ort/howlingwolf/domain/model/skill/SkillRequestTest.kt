package com.ort.howlingwolf.domain.model.skill

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SkillRequestTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isAvailableSkillRequest_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableSkillRequest = true
                )
            )
        )
        val participant = null

        // ## Act ##
        val isAvailableSkillRequest = SkillRequest.isAvailableSkillRequest(village, participant)

        // ## Assert ##
        assertThat(isAvailableSkillRequest).isTrue()
    }

    @Test
    fun test_isAvailableSkillRequest_プロローグでない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableSkillRequest = true
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val isAvailableSkillRequest = SkillRequest.isAvailableSkillRequest(village, participant)

        // ## Assert ##
        assertThat(isAvailableSkillRequest).isFalse()
    }

    @Test
    fun test_isAvailableSkillRequest_希望できない設定() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableSkillRequest = false
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val isAvailableSkillRequest = SkillRequest.isAvailableSkillRequest(village, participant)

        // ## Assert ##
        assertThat(isAvailableSkillRequest).isFalse()
    }


    @Test
    fun test_isAvailableSkillRequest_役職希望できる() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableSkillRequest = true
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val isAvailableSkillRequest = SkillRequest.isAvailableSkillRequest(village, participant)

        // ## Assert ##
        assertThat(isAvailableSkillRequest).isTrue()
    }

    // TODO assertSkillRequest
}