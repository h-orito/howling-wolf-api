package com.ort.howlingwolf.domain.model.vote

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VoteTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isAvailableVote_投票できる() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isTrue()
    }

    @Test
    fun test_isAvailableVote_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = null

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isFalse()
    }

    @Test
    fun test_isAvailableVote_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyDeadVillager()

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isFalse()
    }

    @Test
    fun test_isAvailableVote_見学() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isFalse()
    }

    @Test
    fun test_isAvailableVote_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isFalse()
    }

    @Test
    fun test_isAvailableVote_1日目() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyFirstVillageDay()
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isAvailableVote = Vote.isAvailableVote(village, participant)

        // ## Assert ##
        assertThat(isAvailableVote).isFalse()
    }

    @Test
    fun test_getSelectableTargetList() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            )),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(participant, aliveVillager, deadVillager)
            )
        )

        // ## Act ##
        val selectableTargetList = Vote.getSelectableTargetList(village, participant)

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
            day = VillageDays(listOf(
                latestDay
            )),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(participant, aliveVillager, deadVillager)
            )
        )
        val votes = VillageVotes(listOf(
            VillageVote(latestDay.id, participant.id, aliveVillager.id),
            VillageVote(latestDay.id, aliveVillager.id, participant.id)
        ))

        // ## Act ##
        val target = Vote.getSelectingTarget(village, participant, votes)

        // ## Assert ##
        assertThat(target?.id).isEqualTo(aliveVillager.id)
    }

    // TODO assertVote
}