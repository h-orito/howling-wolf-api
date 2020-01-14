package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.myself.participant.VillageCommitSituation
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.VillageRules
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VillageCommitSituationTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_constructor_コミット不可設定() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableCommit = false
                )
            )
        )
        val participant = null
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_参加していない() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = null
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_見学() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_死亡している() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = DummyDomainModelCreator.createDummyDeadVillager()
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_エピローグ() {
        // ## Arrange ##
        val village = createCommitAvailableVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_ダミーキャラ() {
        // ## Arrange ##
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val village = createCommitAvailableVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(availableCommit = true),
                charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                    dummyCharaId = participant.charaId
                )
            ),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(participant)
            )
        )
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isFalse()
    }

    @Test
    fun test_constructor_生存している() {
        // ## Arrange ##
        val dummyParticipant = DummyDomainModelCreator.createDummyAliveVillager()
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val village = createCommitAvailableVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(availableCommit = true),
                charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                    dummyCharaId = dummyParticipant.charaId
                )
            ),
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(participant, dummyParticipant)
            )
        )
        val commit = null

        // ## Act ##
        val villageCommitSituation = VillageCommitSituation(village, participant, commit)

        // ## Assert ##
        assertThat(villageCommitSituation.isAvailableCommit).isTrue()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createCommitAvailableVillage(): Village = DummyDomainModelCreator.createDummyVillage().copy(
        setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
            rules = VillageRules().copy(
                availableCommit = true
            )
        )
    )
}
