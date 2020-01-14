package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
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
class VillageSkillRequestSituationTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_constructor_isAvailableSkillRequest_参加していない() {
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
        val skillRequest = SkillRequest(Skill(CDef.Skill.村人), Skill(CDef.Skill.村人))

        // ## Act ##
        val villageSkillRequestSituation =
            VillageSkillRequestSituation(village, participant, skillRequest)

        // ## Assert ##
        assertThat(villageSkillRequestSituation.isAvailableSkillRequest).isFalse()
    }

    @Test
    fun test_constructor_isAvailableSkillRequest_プロローグでない() {
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
        val skillRequest = SkillRequest(Skill(CDef.Skill.村人), Skill(CDef.Skill.村人))

        // ## Act ##
        val villageSkillRequestSituation =
            VillageSkillRequestSituation(village, participant, skillRequest)

        // ## Assert ##
        assertThat(villageSkillRequestSituation.isAvailableSkillRequest).isFalse()
    }

    @Test
    fun test_constructor_isAvailableSkillRequest_希望できない設定() {
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
        val skillRequest = SkillRequest(Skill(CDef.Skill.村人), Skill(CDef.Skill.村人))

        // ## Act ##
        val villageSkillRequestSituation =
            VillageSkillRequestSituation(village, participant, skillRequest)

        // ## Assert ##
        assertThat(villageSkillRequestSituation.isAvailableSkillRequest).isFalse()
    }


    @Test
    fun test_constructor_isAvailableSkillRequest_役職希望できる() {
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
        val skillRequest = SkillRequest(Skill(CDef.Skill.村人), Skill(CDef.Skill.村人))

        // ## Act ##
        val villageSkillRequestSituation =
            VillageSkillRequestSituation(village, participant, skillRequest)

        // ## Assert ##
        assertThat(villageSkillRequestSituation.isAvailableSkillRequest).isTrue()
    }

    @Test
    fun test_constructor_selectableSkillList_標準編成() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val skillRequest = SkillRequest(Skill(CDef.Skill.村人), Skill(CDef.Skill.村人))

        // ## Act ##
        val villageSkillRequestSituation =
            VillageSkillRequestSituation(village, participant, skillRequest)

        // ## Assert ##
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.村人 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.人狼 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.占い師 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.狂人 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.狩人 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.霊能者 }).isTrue()
        assertThat(villageSkillRequestSituation.selectableSkillList.any { it.toCdef() == CDef.Skill.おまかせ }).isTrue()
    }
}