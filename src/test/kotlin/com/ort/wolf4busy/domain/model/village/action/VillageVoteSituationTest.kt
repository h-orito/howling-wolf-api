package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VillageVoteSituationTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_constructor_isAvailableVote_投票できる() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isTrue()
    }

    @Test
    fun test_constructor_isAvailableVote_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = null
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isFalse()
    }

    @Test
    fun test_constructor_isAvailableVote_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyDeadVillager()
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isFalse()
    }

    @Test
    fun test_constructor_isAvailableVote_見学() {
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
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isFalse()
    }

    @Test
    fun test_constructor_isAvailableVote_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isFalse()
    }

    @Test
    fun test_constructor_isAvailableVote_1日目() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(listOf(
                DummyDomainModelCreator.createDummyFirstVillageDay()
            ))
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.isAvailableVote).isFalse()
    }

    @Test
    fun test_constructor_getSelectableTargetList() {
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
        val votes = DummyDomainModelCreator.createDummyVillageVotes()

        // ## Act ##
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.targetList.size).isEqualTo(2)
        assertThat(villageVoteSituation.targetList.any { it.id == participant.id }).isTrue()
        assertThat(villageVoteSituation.targetList.any { it.id == aliveVillager.id }).isTrue()
    }

    @Test
    fun test_constructor_getTarget() {
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
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)

        // ## Assert ##
        assertThat(villageVoteSituation.target?.id).isEqualTo(aliveVillager.id)
    }
}