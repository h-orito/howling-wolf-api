package com.ort.wolf4busy.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.skill.Skill
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VillageOrganizationsTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_mapToSkillCount_標準編成() {
        // ## Arrange ##
        val villageOrganizations = VillageOrganizations()

        // ## Act ##
        val map = villageOrganizations.mapToSkillCount(16)

        // ## Assert ##
        assertThat(map[Skill(CDef.Skill.村人)]).isEqualTo(9)
        assertThat(map[Skill(CDef.Skill.人狼)]).isEqualTo(3)
        assertThat(map[Skill(CDef.Skill.霊能者)]).isEqualTo(1)
        assertThat(map[Skill(CDef.Skill.狩人)]).isEqualTo(1)
        assertThat(map[Skill(CDef.Skill.狂人)]).isEqualTo(1)
        assertThat(map[Skill(CDef.Skill.占い師)]).isEqualTo(1)
    }

    @Test
    fun test_allRequestableSkillList_標準編成() {
        // ## Arrange ##
        val villageOrganizations = VillageOrganizations()

        // ## Act ##
        val allRequestableSkillList = villageOrganizations.allRequestableSkillList()

        // ## Assert ##
        assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.村人 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.人狼 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.占い師 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.狂人 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.狩人 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.霊能者 }).isTrue()
        Assertions.assertThat(allRequestableSkillList.any { it.toCdef() == CDef.Skill.おまかせ }).isTrue()
    }

}