package com.ort.howlingwolf.domain.service.vote

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VoteDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var voteDomainService: VoteDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_assertVote_投票できる() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(participant)
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val targetId = participant.id

        // ## Act ##
        // ## Assert ##
        voteDomainService.assertVote(village, participant, targetId)
    }

    @Test
    fun test_assertVote_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val participant = null
        val targetId = 1

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            voteDomainService.assertVote(village, participant, targetId)
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertVote_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyDeadVillager()
        val targetId = 1

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            voteDomainService.assertVote(village, participant, targetId)
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertVote_見学() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )
        val targetId = 1

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            voteDomainService.assertVote(village, participant, targetId)
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertVote_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val targetId = 1

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            voteDomainService.assertVote(village, participant, targetId)
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_assertVote_1日目() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyFirstVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val targetId = 1

        // ## Act ##
        // ## Assert ##
        assertThatThrownBy {
            voteDomainService.assertVote(village, participant, targetId)
        }.isInstanceOf(HowlingWolfBusinessException::class.java)
    }

    @Test
    fun test_getSelectableTargetList() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(participant, aliveVillager, deadVillager)
            )
        )

        // ## Act ##
        val selectableTargetList = voteDomainService.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(selectableTargetList.size).isEqualTo(2)
        assertThat(selectableTargetList.any { it.id == participant.id }).isTrue()
        assertThat(selectableTargetList.any { it.id == aliveVillager.id }).isTrue()
    }

    @Test
    fun test_getSelectingTarget() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    latestDay
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(participant, aliveVillager, deadVillager)
            )
        )
        val votes = VillageVotes(
            listOf(
                VillageVote(latestDay.id, participant.id, aliveVillager.id),
                VillageVote(latestDay.id, aliveVillager.id, participant.id)
            )
        )

        // ## Act ##
        val target = voteDomainService.getSelectingTarget(village, participant, votes)

        // ## Assert ##
        assertThat(target?.id).isEqualTo(aliveVillager.id)
    }

    // TODO assertVote
}