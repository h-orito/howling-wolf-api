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
class DivineDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var divineDomainService: DivineDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_getSelectableTargetList_未参加者() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null

        // ## Act ##
        val selectableTargetList = divineDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("参加していないのでなし").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_生存者なし() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveSeer()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    participant
                )
            )
        )

        // ## Act ##
        val selectableTargetList = divineDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList).`as`("生存者が自分だけ").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_生存者あり() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveSeer()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 4,
                memberList = listOf(
                    DummyDomainModelCreator.createDummyAliveVillager(),
                    DummyDomainModelCreator.createDummyDeadVillager(),
                    DummyDomainModelCreator.createDummyAliveWolf(),
                    participant
                )
            )
        )

        // ## Act ##
        val selectableTargetList = divineDomainService.getSelectableTargetList(village, participant)

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
        val target = divineDomainService.getSelectingTarget(village, participant, villageAbilities)

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
        val target = divineDomainService.getSelectingTarget(village, participant, villageAbilities)

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
                    abilityType = AbilityType(CDef.AbilityType.占い)
                )
            )
        )

        // ## Act ##
        val target = divineDomainService.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target?.id).isEqualTo(aliveWolf.id)
    }

    @Test
    fun test_getSetMessage_対象あり() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = DummyDomainModelCreator.createDummyChara()

        // ## Act ##
        val message = divineDomainService.createSetMessage(chara, targetChara)

        // ## Assert ##
        assertThat(message).`as`("対象あり").doesNotContain("なし")
    }

    @Test
    fun test_getSetMessage_対象なし() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = null

        // ## Act ##
        val message = divineDomainService.createSetMessage(chara, targetChara)

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
        val villageAbilityList = divineDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList).`as`("進行中でないのでなし").isEmpty()
    }

    @Test
    fun test_getDefaultAbilityList_対象なし() {
        // ## Arrange ##
        val aliveSeer = DummyDomainModelCreator.createDummyAliveSeer()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveSeer, deadVillager, deadWolf
                )
            ),
            day = VillageDays(listOf(DummyDomainModelCreator.createDummyVillageDay()))
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = divineDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList).`as`("生存者がいないのでなし").isEmpty()
    }

    @Test
    fun test_getDefaultAbilityList_対象あり() {
        // ## Arrange ##
        val aliveSeer = DummyDomainModelCreator.createDummyAliveSeer()
        val aliveSeer2 = DummyDomainModelCreator.createDummyAliveSeer()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(
                    aliveSeer, aliveSeer2
                )
            ),
            day = VillageDays(listOf(DummyDomainModelCreator.createDummyVillageDay()))
        )
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val villageAbilityList = divineDomainService.getDefaultAbilityList(village, villageAbilities)

        // ## Assert ##
        assertThat(villageAbilityList.size).isEqualTo(2)
        assertThat(villageAbilityList.find { it.myselfId == aliveSeer.id }).satisfies {
            assertThat(it?.targetId).isEqualTo(aliveSeer2.id)
            assertThat(it?.abilityType?.code).isEqualTo(CDef.AbilityType.占い.code())
        }
        assertThat(villageAbilityList.find { it.myselfId == aliveSeer2.id }).satisfies {
            assertThat(it?.targetId).isEqualTo(aliveSeer.id)
        }
    }

    @Test
    fun test_process_生存している占い師がいない() {
        // ## Arrange ##
        val deadSeer = DummyDomainModelCreator.createDummyDeadSeer()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = deadSeer.id,
                    targetId = aliveVillager.id,
                    abilityType = AbilityType(CDef.AbilityType.占い)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(deadSeer, aliveVillager)
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
        val afterDayChange = divineDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("占い師が死んでいる").isFalse()
    }

    @Test
    fun test_process_能力セットしていない() {
        // ## Arrange ##
        val aliveSeer = DummyDomainModelCreator.createDummyAliveSeer()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(listOf())
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveSeer, aliveVillager)
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
        val afterDayChange = divineDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("能力セットなし").isFalse()
    }

    @Test
    fun test_process_人狼を占った() {
        // ## Arrange ##
        val aliveSeer = DummyDomainModelCreator.createDummyAliveSeer()
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveSeer.id,
                    targetId = aliveWolf.id,
                    abilityType = AbilityType(CDef.AbilityType.占い)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveSeer, aliveWolf)
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
                DummyDomainModelCreator.createDummyChara().copy(id = aliveSeer.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = divineDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list).isNotEmpty()
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            assertThat(message.content.text).contains("人狼のようだ")
            assertThat(message.content.type.code).isEqualTo(CDef.MessageType.白黒占い結果.code())
        }
    }
}