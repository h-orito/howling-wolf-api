package com.ort.howlingwolf.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SkillAssignTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_assign_役職希望無効() {
        // ## Arrange ##
        val dummyChara = DummyDomainModelCreator.createDummyVillageParticipant()
        val participants = VillageParticipants(
            count = 3,
            memberList = listOf(
                dummyChara,
                createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.おまかせ),
                createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.おまかせ)
            )
        )
        val skillPersonCountMap = mapOf(
            CDef.Skill.村人 to 1,
            CDef.Skill.人狼 to 2
        )

        // ## Act ##
        val assign = SkillAssign.assign(participants, skillPersonCountMap, dummyChara, false)

        // ## Assert ##
        assertThat(assign.memberList.count { it.skill?.toCdef() == CDef.Skill.村人 }).isEqualTo(1)
        assertThat(assign.memberList.count { it.skill?.toCdef() == CDef.Skill.人狼 }).isEqualTo(2)
    }

    @Test
    fun test_assign_第1希望で被りなし() {
        // ## Arrange ##
        val dummyChara = DummyDomainModelCreator.createDummyVillageParticipant()
        val wolfRequestParticipants = (1..3).toList().map { createDummySkillRequestParticipant(CDef.Skill.人狼, CDef.Skill.おまかせ) }
        val villagerRequestParticipants = (1..8).toList().map { createDummySkillRequestParticipant(CDef.Skill.村人, CDef.Skill.おまかせ) }
        val seerRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.占い師, CDef.Skill.おまかせ)
        val psychicRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.霊能者, CDef.Skill.おまかせ)
        val madmanRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.狂人, CDef.Skill.おまかせ)
        val hunterRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.狩人, CDef.Skill.おまかせ)
        val participants = VillageParticipants(
            count = 16,
            memberList = wolfRequestParticipants //
                + dummyChara //
                + seerRequestParticipant //
                + psychicRequestParticipant //
                + villagerRequestParticipants //
                + madmanRequestParticipant //
                + hunterRequestParticipant //
        )
        val skillPersonCountMap = mapOf(
            CDef.Skill.村人 to 9,
            CDef.Skill.人狼 to 3,
            CDef.Skill.占い師 to 1,
            CDef.Skill.狂人 to 1,
            CDef.Skill.霊能者 to 1,
            CDef.Skill.狩人 to 1
        )

        // ## Act ##
        val assign = SkillAssign.assign(participants, skillPersonCountMap, dummyChara, false)

        // ## Assert ##
        // assign.memberList.forEach { println("${it.skillRequest.first.code}_${it.skillRequest.second.code}_${it.skill?.code}") }
        assertThat(
            assign.memberList.filter { member ->
                wolfRequestParticipants.any { it.id == member.id }
            }.all { it.skill?.toCdef() == CDef.Skill.人狼 }
        ).isTrue()
        assertThat(
            assign.memberList.filter { member ->
                villagerRequestParticipants.any { it.id == member.id }
            }.all { it.skill?.toCdef() == CDef.Skill.村人 }
        ).isTrue()
        assertThat(assign.memberList.first { it.id == dummyChara.id }.skill?.toCdef()).isEqualTo(CDef.Skill.村人)
        assertThat(assign.memberList.first { it.id == seerRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.占い師)
        assertThat(assign.memberList.first { it.id == psychicRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.霊能者)
        assertThat(assign.memberList.first { it.id == hunterRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.狩人)
        assertThat(assign.memberList.first { it.id == madmanRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.狂人)
    }

    @Test
    fun test_assign_第2希望で被りなし() {
        // ## Arrange ##
        val dummyChara = DummyDomainModelCreator.createDummyVillageParticipant()
        val wolfRequestParticipants = (1..3).toList().map { createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.人狼) }
        val villagerRequestParticipants = (1..8).toList().map { createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.村人) }
        val seerRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.占い師)
        val psychicRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.霊能者)
        val madmanRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.狂人)
        val hunterRequestParticipant = createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.狩人)
        val participants = VillageParticipants(
            count = 16,
            memberList = wolfRequestParticipants //
                + dummyChara //
                + seerRequestParticipant //
                + psychicRequestParticipant //
                + villagerRequestParticipants //
                + madmanRequestParticipant //
                + hunterRequestParticipant //
        )
        val skillPersonCountMap = mapOf(
            CDef.Skill.村人 to 9,
            CDef.Skill.人狼 to 3,
            CDef.Skill.占い師 to 1,
            CDef.Skill.狂人 to 1,
            CDef.Skill.霊能者 to 1,
            CDef.Skill.狩人 to 1
        )

        // ## Act ##
        val assign = SkillAssign.assign(participants, skillPersonCountMap, dummyChara, false)

        // ## Assert ##
        assertThat(
            assign.memberList.filter { member ->
                wolfRequestParticipants.any { it.id == member.id }
            }.all { it.skill?.toCdef() == CDef.Skill.人狼 }
        ).isTrue()
        assertThat(
            assign.memberList.filter { member ->
                villagerRequestParticipants.any { it.id == member.id }
            }.all { it.skill?.toCdef() == CDef.Skill.村人 }
        ).isTrue()
        assertThat(assign.memberList.first { it.id == dummyChara.id }.skill?.toCdef()).isEqualTo(CDef.Skill.村人)
        assertThat(assign.memberList.first { it.id == seerRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.占い師)
        assertThat(assign.memberList.first { it.id == psychicRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.霊能者)
        assertThat(assign.memberList.first { it.id == hunterRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.狩人)
        assertThat(assign.memberList.first { it.id == madmanRequestParticipant.id }.skill?.toCdef()).isEqualTo(CDef.Skill.狂人)
    }

    @Test
    fun test_assign_被っても第2希望が反映される() {
        // ## Arrange ##
        val dummyChara = DummyDomainModelCreator.createDummyVillageParticipant()
        val participant1 = createDummySkillRequestParticipant(CDef.Skill.占い師, CDef.Skill.人狼)
        val participant2 = createDummySkillRequestParticipant(CDef.Skill.占い師, CDef.Skill.霊能者)
        val participant3 = createDummySkillRequestParticipant(CDef.Skill.占い師, CDef.Skill.狩人)
        val leftoverParticipants = (1..12).toList().map { createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.おまかせ) }
        val participants = VillageParticipants(
            count = 16,
            memberList = leftoverParticipants //
                + dummyChara //
                + participant1 //
                + participant2 //
                + participant3 //
        )
        val skillPersonCountMap = mapOf(
            CDef.Skill.村人 to 9,
            CDef.Skill.人狼 to 3,
            CDef.Skill.占い師 to 1,
            CDef.Skill.狂人 to 1,
            CDef.Skill.霊能者 to 1,
            CDef.Skill.狩人 to 1
        )

        // ## Act ##
        val assign = SkillAssign.assign(participants, skillPersonCountMap, dummyChara, false)

        // ## Assert ##
        // assign.memberList.forEach { println("${it.skillRequest.first.code}_${it.skillRequest.second.code}_${it.skill?.code}") }
        val participant1Skill = assign.memberList.first { it.id == participant1.id }.skill?.toCdef()
        assertThat(participant1Skill == CDef.Skill.占い師 || participant1Skill == CDef.Skill.人狼)
        val participant2Skill = assign.memberList.first { it.id == participant2.id }.skill?.toCdef()
        assertThat(participant2Skill == CDef.Skill.占い師 || participant2Skill == CDef.Skill.霊能者)
        val participant3Skill = assign.memberList.first { it.id == participant3.id }.skill?.toCdef()
        assertThat(participant3Skill == CDef.Skill.占い師 || participant3Skill == CDef.Skill.狩人)
    }

    @Test
    fun test_assign_役欠けあり() {
        // ## Arrange ##
        val dummyChara = DummyDomainModelCreator.createDummyVillageParticipant()
        val someoneRequestParticipants = (1..15).toList().map { createDummySkillRequestParticipant(CDef.Skill.おまかせ, CDef.Skill.人狼) }
        val participants = VillageParticipants(
            count = 16,
            memberList = someoneRequestParticipants //
                + dummyChara //
        )
        val skillPersonCountMap = mapOf(
            CDef.Skill.人狼 to 3,
            CDef.Skill.占い師 to 1,
            CDef.Skill.妖狐 to 12
        )

        // ## Act ##
        val assign = SkillAssign.assign(participants, skillPersonCountMap, dummyChara, true)

        // ## Assert ##
        assertThat(assign.memberList.first { it.id == dummyChara.id }.skill?.toCdef()).isEqualTo(CDef.Skill.占い師)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createDummySkillRequestParticipant(first: CDef.Skill, second: CDef.Skill): VillageParticipant =
        DummyDomainModelCreator.createDummyVillageParticipant().copy(
            skillRequest = SkillRequest(Skill(first), Skill(second))
        )
}