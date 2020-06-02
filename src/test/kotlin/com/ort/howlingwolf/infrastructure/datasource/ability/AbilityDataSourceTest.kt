package com.ort.howlingwolf.infrastructure.datasource.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.AbilityBhv
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exentity.Ability
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
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
class AbilityDataSourceTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageBhv: VillageBhv
    @Autowired
    lateinit var villagePlayerBhv: VillagePlayerBhv
    @Autowired
    lateinit var villageDayBhv: VillageDayBhv
    @Autowired
    lateinit var abilityBhv: AbilityBhv
    @Autowired
    lateinit var abilityDataSource: AbilityDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findAbilities() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertAbility(villageDayId, villagePlayerId)

        // ## Act ##
        val abilities = abilityDataSource.findAbilities(villageId)

        // ## Assert ##
        assertThat(abilities.list.size).isEqualTo(1)
    }

    @Test
    fun test_updateAbility() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villagePlayerId2 = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertAbility(villageDayId, villagePlayerId)

        // ## Act ##
        val villageAbility = VillageAbility(
            villageDayId = villageDayId,
            myselfId = villagePlayerId2,
            targetId = villagePlayerId,
            ability = com.ort.howlingwolf.domain.model.ability.Ability(CDef.AbilityType.襲撃)
        )
        abilityDataSource.updateAbility(villageAbility)

        // ## Assert ##
        val abilities = abilityDataSource.findAbilities(villageId)
        assertThat(abilities.list.size).isEqualTo(1)
        assertThat(abilities.list[0].myselfId).isEqualTo(villagePlayerId2)
        assertThat(abilities.list[0].targetId).isEqualTo(villagePlayerId)
    }

    @Test
    fun test_updateDifference() {
        // ## Arrange ##
        val villageId = insertVillage()
        val villagePlayerId = insertVillagePlayer(villageId)
        val villagePlayerId2 = insertVillagePlayer(villageId)
        val villageDayId = insertVillageDay(villageId)
        insertAbility(villageDayId, villagePlayerId)
        val before = abilityDataSource.findAbilities(villageId)
        val after = before.copy(
            list = before.list + VillageAbility(
                villageDayId = villageDayId,
                myselfId = villagePlayerId2,
                targetId = villagePlayerId,
                ability = com.ort.howlingwolf.domain.model.ability.Ability(CDef.AbilityType.占い)
            )
        )

        // ## Act ##
        abilityDataSource.updateDifference(before, after)

        // ## Assert ##
        val abilities = abilityDataSource.findAbilities(villageId)
        assertThat(abilities.list.size).isEqualTo(2)
        assertThat(abilities.list[0].myselfId).isEqualTo(villagePlayerId)
        assertThat(abilities.list[0].targetId).isNull()
        assertThat(abilities.list[1].myselfId).isEqualTo(villagePlayerId2)
        assertThat(abilities.list[1].targetId).isEqualTo(villagePlayerId)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun insertVillage(): Int {
        val village = Village()
        village.villageDisplayName = "name"
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.プロローグ
        village.createPlayerId = 1
        villageBhv.insert(village)
        return village.villageId
    }

    private fun insertVillagePlayer(villageId: Int): Int {
        val villagePlayer = VillagePlayer()
        villagePlayer.villageId = villageId
        villagePlayer.playerId = 1
        villagePlayer.charaId = 1
        villagePlayer.requestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.secondRequestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.isSpectator = false
        villagePlayer.isGone = false
        villagePlayer.isDead = false
        villagePlayerBhv.insert(villagePlayer)
        return villagePlayer.villagePlayerId
    }

    private fun insertVillageDay(villageId: Int): Int {
        val villageDay = VillageDay()
        villageDay.villageId = villageId
        villageDay.day = 1
        villageDay.noonnightCodeAsNoonnight = CDef.Noonnight.昼
        villageDay.daychangeDatetime = LocalDateTime.now()
        villageDayBhv.insert(villageDay)
        return villageDay.villageDayId
    }

    private fun insertAbility(villageDayId: Int, myselfId: Int) {
        val ability = Ability()
        ability.villageDayId = villageDayId
        ability.abilityTypeCodeAsAbilityType = CDef.AbilityType.襲撃
        ability.villagePlayerId = myselfId
        abilityBhv.insert(ability)
    }
}