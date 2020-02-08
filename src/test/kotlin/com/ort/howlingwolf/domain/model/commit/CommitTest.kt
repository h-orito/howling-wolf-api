package com.ort.howlingwolf.domain.model.commit

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CommitTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isAvailableCommit_コミット不可設定() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableCommit = false
                )
            )
        )
        val participant = null

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_参加していない() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = null

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_見学() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_死亡している() {
        // ## Arrange ##
        val village = createCommitAvailableVillage()
        val participant = DummyDomainModelCreator.createDummyDeadVillager()

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_エピローグ() {
        // ## Arrange ##
        val village = createCommitAvailableVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_ダミーキャラ() {
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

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isFalse()
    }

    @Test
    fun test_isAvailableCommit_生存している() {
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

        // ## Act ##
        val isAvailableCommit = Commit.isAvailableCommit(village, participant)

        // ## Assert ##
        assertThat(isAvailableCommit).isTrue()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createCommitAvailableVillage(): Village {
        val dummy = DummyDomainModelCreator.createDummyDeadVillager()
        return DummyDomainModelCreator.createDummyVillage().copy(
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = VillageRules().copy(
                    availableCommit = true
                ),
                charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                    dummyCharaId = dummy.charaId
                )
            ),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(dummy)
            )
        )
    }
}