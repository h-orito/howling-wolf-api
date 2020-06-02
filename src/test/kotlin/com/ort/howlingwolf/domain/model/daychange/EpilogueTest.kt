package com.ort.howlingwolf.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class EpilogueTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_transitionToEpilogueIfNeeded_狼勝利() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 5,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyAliveWolf(),
                        DummyDomainModelCreator.createDummyAliveWolf()
                    )
                ),
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        latestDay
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = Epilogue.transitionToEpilogueIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village).satisfies { village ->
            assertThat(village.status.toCdef()).isEqualTo(CDef.VillageStatus.エピローグ)
            assertThat(village.winCamp?.toCdef()).isEqualTo(CDef.Camp.人狼陣営)
            assertThat(village.day.latestDay().dayChangeDatetime).isAfter(latestDay.dayChangeDatetime)
        }
        assertThat(afterDayChange.messages.list).satisfies { messageList ->
            assertThat(messageList.size).isEqualTo(2)
            assertThat(messageList.first()).satisfies { winCampMessage ->
                assertThat(winCampMessage.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
                assertThat(winCampMessage.content.text).contains("もう人狼に")
            }
            assertThat(messageList.last().content.type.toCdef()).isEqualTo(CDef.MessageType.参加者一覧)
        }
    }

    @Test
    fun test_transitionToEpilogueIfNeeded_村勝利() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 5,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveMadman(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadWolf(),
                        DummyDomainModelCreator.createDummyDeadWolf()
                    )
                ),
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        latestDay
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = Epilogue.transitionToEpilogueIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village).satisfies { village ->
            assertThat(village.status.toCdef()).isEqualTo(CDef.VillageStatus.エピローグ)
            assertThat(village.winCamp?.toCdef()).isEqualTo(CDef.Camp.村人陣営)
            assertThat(village.day.latestDay().dayChangeDatetime).isAfter(latestDay.dayChangeDatetime)
        }
        assertThat(afterDayChange.messages.list).satisfies { messageList ->
            assertThat(messageList.size).isEqualTo(2)
            assertThat(messageList.first()).satisfies { winCampMessage ->
                assertThat(winCampMessage.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
                assertThat(winCampMessage.content.text).contains("全ての人狼を")
            }
            assertThat(messageList.last().content.type.toCdef()).isEqualTo(CDef.MessageType.参加者一覧)
        }
    }

    @Test
    fun test_transitionToEpilogueIfNeeded_未決着() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 5,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveMadman(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyAliveWolf(),
                        DummyDomainModelCreator.createDummyDeadWolf()
                    )
                ),
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        latestDay
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = Epilogue.transitionToEpilogueIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_addDayIfNeeded_必要なし() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        DummyDomainModelCreator.createDummyVillageDay().copy(
                            dayChangeDatetime = LocalDateTime.now().plusHours(1L)
                        )
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = Epilogue.addDayIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_addDayIfNeeded_追加() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        DummyDomainModelCreator.createDummyVillageDay().copy(
                            dayChangeDatetime = LocalDateTime.now().minusHours(1L)
                        )
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = Epilogue.addDayIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.day.dayList.size).isEqualTo(3)
    }

    @Test
    fun test_dayChange() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange()

        // ## Act ##
        val afterDayChange = Epilogue.dayChange(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.終了)
    }
}