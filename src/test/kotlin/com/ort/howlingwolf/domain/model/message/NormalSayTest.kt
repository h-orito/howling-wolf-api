package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class NormalSayTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isSayable_見学() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            isSpectator = true
        )

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_生存() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().minusMinutes(30L)
                    ),
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isTrue()
    }

    @Test
    fun test_isSayable_進行中_生存_沈黙時間() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                time = DummyDomainModelCreator.createDummyVillageTime().copy(
                    silentHours = 1
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().minusMinutes(30L)
                    ),
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).`as`("沈黙時間中").isFalse()
    }

    @Test
    fun test_isSayable_終了した村() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.終了)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_進行中_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyDeadVillager()

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isFalse()
    }

    @Test
    fun test_isSayable_エピローグ_死亡() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyDeadVillager()

        // ## Act ##
        val isSayable = NormalSay.isSayable(village, participant)

        // ## Assert ##
        assertThat(isSayable).isTrue()
    }
}