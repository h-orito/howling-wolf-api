package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VillageAbilitySituationsTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isSettableAbility_その能力を持っていない() {
        // ## Arrange ##
        val villageAbilitySituations = DummyDomainModelCreator.createDummyVillageAbilitySituations()
        val targetId = null
        val abilityType = CDef.AbilityType.襲撃.code()

        // ## Act ##
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)

        // ## Assert ##
        assertThat(isSettable).isFalse()
    }

    @Test
    fun test_isSettableAbility_対象なしにできない能力なのに対象なし() {
        // ## Arrange ##
        val villageAbilitySituations = DummyDomainModelCreator.createDummyVillageAbilitySituations().copy(listOf(
            DummyDomainModelCreator.createDummyVillageAbilitySituation().copy(
                type = Ability(CDef.AbilityType.占い)
            )
        ))
        val targetId = null
        val abilityType = CDef.AbilityType.占い.code()

        // ## Act ##
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)

        // ## Assert ##
        assertThat(isSettable).isFalse()
    }

    @Test
    fun test_isSettableAbility_対象なしにできる能力で対象なし() {
        // ## Arrange ##
        val villageAbilitySituations = DummyDomainModelCreator.createDummyVillageAbilitySituations().copy(listOf(
            DummyDomainModelCreator.createDummyVillageAbilitySituation().copy(
                type = Ability(CDef.AbilityType.襲撃)
            )
        ))
        val targetId = null
        val abilityType = CDef.AbilityType.襲撃.code()

        // ## Act ##
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)

        // ## Assert ##
        assertThat(isSettable).isTrue()
    }

    @Test
    fun test_isSettableAbility_対象あり_対象に選べない人を選ぼうとしている() {
        // ## Arrange ##
        val availableTarget = DummyDomainModelCreator.createDummyAliveHunter()
        val villageAbilitySituations = DummyDomainModelCreator.createDummyVillageAbilitySituations().copy(listOf(
            DummyDomainModelCreator.createDummyVillageAbilitySituation().copy(
                type = Ability(CDef.AbilityType.襲撃),
                targetList = listOf(availableTarget),
                target = null,
                exercisable = true
            )
        ))
        val targetId = 10001
        val abilityType = CDef.AbilityType.襲撃.code()

        // ## Act ##
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)

        // ## Assert ##
        assertThat(isSettable).isFalse()
    }

    @Test
    fun test_isSettableAbility_対象あり_正しい対象() {
        // ## Arrange ##
        val availableTarget = DummyDomainModelCreator.createDummyAliveHunter()
        val villageAbilitySituations = DummyDomainModelCreator.createDummyVillageAbilitySituations().copy(listOf(
            DummyDomainModelCreator.createDummyVillageAbilitySituation().copy(
                type = Ability(CDef.AbilityType.襲撃),
                targetList = listOf(availableTarget),
                target = null,
                exercisable = true
            )
        ))
        val targetId = availableTarget.id
        val abilityType = CDef.AbilityType.襲撃.code()

        // ## Act ##
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)

        // ## Assert ##
        assertThat(isSettable).isTrue()
    }
}