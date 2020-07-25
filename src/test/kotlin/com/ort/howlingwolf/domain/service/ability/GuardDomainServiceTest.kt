package com.ort.howlingwolf.domain.service.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class GuardDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var guardDomainService: GuardDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_getSelectableTargetList_未参加者() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null

        // ## Act ##
        val selectableTargetList = guardDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("参加していないのでなし").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_1日目() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyFirstVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val selectableTargetList = guardDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("1日目なのでなし").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_生存者なし() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveHunter()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    participant
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )

        // ## Act ##
        val selectableTargetList = guardDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("生存者が自分だけ").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_生存者あり() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveHunter()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 4,
                memberList = listOf(
                    DummyDomainModelCreator.createDummyAliveVillager(),
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    DummyDomainModelCreator.createDummyAliveWolf(),
                    participant
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )

        // ## Act ##
        val selectableTargetList = guardDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList.size).isEqualTo(2)
    }

    @Test
    fun test_getSelectingTarget_未参加者() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = guardDomainService.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("参加していないのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_セットなし() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(listOf(DummyDomainModelCreator.createDummyVillageDay()))
        ).addNewDay()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = guardDomainService.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("セットしていないのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_セットあり() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                listOf(latestDay)
            ),
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(
                    aliveWolf, participant
                )
            )
        )
        val villageAbilities = VillageAbilities(
            list = listOf(
                VillageAbility(
                    villageDayId = latestDay.id,
                    myselfId = participant.id,
                    targetId = aliveWolf.id,
                    abilityType = AbilityType(CDef.AbilityType.護衛)
                )
            )
        )

        // ## Act ##
        val target = guardDomainService.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target?.id).isEqualTo(aliveWolf.id)
    }

    @Test
    fun test_getSetMessage_対象あり() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = DummyDomainModelCreator.createDummyChara()

        // ## Act ##
        val message = guardDomainService.createSetMessage(chara, targetChara)

        // ## Assert ##
        assertThat(message).`as`("対象あり").doesNotContain("なし")
    }

    @Test
    fun test_getSetMessage_対象なし() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = null

        // ## Act ##
        val message = guardDomainService.createSetMessage(chara, targetChara)

        // ## Assert ##
        assertThat(message).`as`("対象なし").contains("なし")
    }

    @Test
    fun test_getDefaultAbilityList_進行中でない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.終了)
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = guardDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList).`as`("進行中でないのでなし").isEmpty()
    }

    @Test
    fun test_getDefaultAbilityList_1日目() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyFirstVillageDay()
                )
            )
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = guardDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList).`as`("進行中でないのでなし").isEmpty()
    }

    @Test
    fun test_getDefaultAbilityList_対象なし() {
        // ## Arrange ##
        val aliveHunter = DummyDomainModelCreator.createDummyAliveHunter()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveHunter, deadVillager, deadWolf
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = guardDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList).`as`("生存者がいないのでなし").isEmpty()
    }

    @Test
    fun test_getDefaultAbilityList_対象あり() {
        // ## Arrange ##
        val aliveHunter = DummyDomainModelCreator.createDummyAliveHunter()
        val aliveHunter2 = DummyDomainModelCreator.createDummyAliveHunter()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(
                    aliveHunter, aliveHunter2
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = guardDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList.size).isEqualTo(2)
        assertThat(villageAbilityList.find { it.myselfId == aliveHunter.id }).satisfies {
            assertThat(it?.targetId).isEqualTo(aliveHunter2.id)
            assertThat(it?.abilityType?.code).isEqualTo(CDef.AbilityType.護衛.code())
        }
        assertThat(villageAbilityList.find { it.myselfId == aliveHunter2.id }).satisfies {
            assertThat(it?.targetId).isEqualTo(aliveHunter.id)
        }
    }

    @Test
    fun test_process_生存している狩人がいない() {
        // ## Arrange ##
        val deadHunter = DummyDomainModelCreator.createDummyDeadHunter()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = deadHunter.id,
                    targetId = aliveVillager.id,
                    abilityType = AbilityType(CDef.AbilityType.護衛)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(deadHunter, aliveVillager)
            ),
            day = VillageDays(listOf(yesterday, latestDay))
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = guardDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("狩人が死んでいる").isFalse()
    }

    @Test
    fun test_process_能力セットしていない() {
        // ## Arrange ##
        val aliveHunter = DummyDomainModelCreator.createDummyAliveHunter()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(listOf())
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveHunter, aliveVillager)
            ),
            day = VillageDays(listOf(yesterday, latestDay))
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = guardDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("能力セットなし").isFalse()
    }

    @Test
    fun test_process_護衛した() {
        // ## Arrange ##
        val aliveHunter = DummyDomainModelCreator.createDummyAliveHunter()
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveHunter.id,
                    targetId = aliveWolf.id,
                    abilityType = AbilityType(CDef.AbilityType.護衛)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveHunter, aliveWolf)
            ),
            day = VillageDays(listOf(yesterday, latestDay))
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = aliveHunter.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = guardDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list).isNotEmpty()
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            assertThat(message.content.text).contains("を護衛している")
            assertThat(message.content.type.code).isEqualTo(CDef.MessageType.非公開システムメッセージ.code())
        }
    }
}