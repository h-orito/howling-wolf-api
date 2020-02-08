package com.ort.howlingwolf.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AbilityTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_getSelectableTargetList_未参加者() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null

        // ## Act ##
        val selectableTargetList = ability.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("参加していないので選択不可能").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_終了した村() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage().changeStatus(CDef.VillageStatus.終了)
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val selectableTargetList = ability.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("村が終了しているので選択不可能").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_対象あり() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            id = 1
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                3,
                listOf(
                    participant.copy(id = 1),
                    participant.copy(id = 2),
                    participant.copy(id = 3)
                )
            )
        )

        // ## Act ##
        val selectableTargetList = ability.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList.size).isEqualTo(2)
    }

    @Test
    fun test_getSelectingTarget_未参加者() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = ability.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("参加していないのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_終了した村() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage().changeStatus(CDef.VillageStatus.終了)
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = ability.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("村が終了しているのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_対象あり() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(id = 100)
        val targetParticipant = DummyDomainModelCreator.createDummyVillageParticipant().copy(id = 101)
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(
                    participant,
                    targetParticipant
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(id = 2)
                )
            )
        )
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = 2,
                    myselfId = participant.id,
                    targetId = targetParticipant.id,
                    ability = Ability(CDef.AbilityType.占い)
                )
            )
        )

        // ## Act ##
        val target = ability.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target?.id).`as`("").isEqualTo(targetParticipant.id)
    }

    @Test
    fun test_createAbilitySetMessage() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = DummyDomainModelCreator.createDummyChara()

        // ## Act ##
        val message = ability.createAbilitySetMessage(village, chara, targetChara)

        // ## Assert ##
        assertThat(message.content.text).isNotEmpty()
    }

    @Test(expected = HowlingWolfBusinessException::class)
    fun test_assertAbility_その能力を持っていない() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.襲撃)
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyAliveSeer()
        val targetId = null

        // ## Act ##
        // ## Assert ##
        ability.assertAbility(village, participant, targetId)
    }

    @Test(expected = HowlingWolfBusinessException::class)
    fun test_assertAbility_対象なしにできない能力なのに対象なし() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.占い)
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyAliveSeer()
        val targetId = null

        // ## Act ##
        // ## Assert ##
        ability.assertAbility(village, participant, targetId)
    }

    fun test_assertAbility_対象なしにできる能力で対象なし() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.襲撃)
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyAliveWolf()
        val targetId = null

        // ## Act ##
        // ## Assert ##
        ability.assertAbility(village, participant, targetId)
    }

    @Test(expected = HowlingWolfBusinessException::class)
    fun test_assertAbility_対象あり_対象に選べない人を選ぼうとしている() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.襲撃)
        val availableTarget = DummyDomainModelCreator.createDummyAliveHunter()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(availableTarget)
            ),
            day = VillageDays(listOf(DummyDomainModelCreator.createDummyVillageDay()))
        )
        val participant = DummyDomainModelCreator.createDummyAliveWolf()
        val targetId = 10001

        // ## Act ##
        // ## Assert ##
        ability.assertAbility(village, participant, targetId)
    }

    @Test
    fun test_assertAbility_対象あり_正しい対象() {
        // ## Arrange ##
        val ability = Ability(CDef.AbilityType.襲撃)
        val availableTarget = DummyDomainModelCreator.createDummyAliveHunter()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(availableTarget)
            ),
            day = VillageDays(listOf(DummyDomainModelCreator.createDummyVillageDay()))
        )
        val participant = DummyDomainModelCreator.createDummyAliveWolf()
        val targetId = availableTarget.id

        // ## Act ##
        // ## Assert ##
        ability.assertAbility(village, participant, targetId)
    }
}