package com.ort.howlingwolf.domain.service.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class PrologueDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var prologueDomainService: PrologueDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_leaveParticipantIfNeeded_退村なし() {
        // ## Arrange ##
        val participant1 = DummyDomainModelCreator.createDummyVillageParticipant()
        val participant2 = DummyDomainModelCreator.createDummyVillageParticipant()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 2,
                    memberList = listOf(
                        participant1, participant2
                    )
                )
            )
        )
        val todayMessages = Messages(
            listOf(
                DummyDomainModelCreator.createDummyMessage().copy(
                    fromVillageParticipantId = participant1.id,
                    content = DummyDomainModelCreator.createDummyMessageContent().copy(
                        type = MessageType(CDef.MessageType.通常発言)
                    ),
                    time = DummyDomainModelCreator.createDummyMessageTime().copy(
                        datetime = LocalDateTime.now().minusHours(1L)
                    )
                ),
                DummyDomainModelCreator.createDummyMessage().copy(
                    fromVillageParticipantId = participant2.id,
                    content = DummyDomainModelCreator.createDummyMessageContent().copy(
                        type = MessageType(CDef.MessageType.通常発言)
                    ),
                    time = DummyDomainModelCreator.createDummyMessageTime().copy(
                        datetime = LocalDateTime.now().minusHours(1L)
                    )
                )
            )
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = participant1.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = participant2.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.leaveParticipantIfNeeded(dayChange, todayMessages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_leaveParticipantIfNeeded_退村あり() {
        // ## Arrange ##
        val participant1 = DummyDomainModelCreator.createDummyVillageParticipant()
        val participant2 = DummyDomainModelCreator.createDummyVillageParticipant()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 2,
                    memberList = listOf(
                        participant1, participant2
                    )
                ),
                day = VillageDays(listOf(latestDay))
            )
        )
        val todayMessages = Messages(
            listOf(
                DummyDomainModelCreator.createDummyMessage().copy(
                    fromVillageParticipantId = participant1.id,
                    content = DummyDomainModelCreator.createDummyMessageContent().copy(
                        type = MessageType(CDef.MessageType.通常発言)
                    ),
                    time = DummyDomainModelCreator.createDummyMessageTime().copy(
                        villageDayId = latestDay.id,
                        datetime = LocalDateTime.now().minusHours(1L)
                    )
                ),
                DummyDomainModelCreator.createDummyMessage().copy(
                    fromVillageParticipantId = participant2.id,
                    content = DummyDomainModelCreator.createDummyMessageContent().copy(
                        type = MessageType(CDef.MessageType.通常発言)
                    ),
                    time = DummyDomainModelCreator.createDummyMessageTime().copy(
                        villageDayId = latestDay.id,
                        datetime = LocalDateTime.now().minusHours(25L)
                    )
                )
            )
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = participant1.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = participant2.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.leaveParticipantIfNeeded(dayChange, todayMessages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.member(participant1.id).isGone).isFalse()
        assertThat(afterDayChange.village.participant.member(participant2.id).isGone).isTrue()
    }

    @Test
    fun test_addDayIfNeeded_開始時刻になっていない() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay().copy(
                            dayChangeDatetime = LocalDateTime.now().plusSeconds(1L)
                        )
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.addDayIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_addDayIfNeeded_人数不足() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay().copy(
                            dayChangeDatetime = LocalDateTime.now().minusSeconds(1L)
                        )
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.addDayIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.廃村)
    }

    @Test
    fun test_addDayIfNeeded_人数が足りている() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay().copy(
                            dayChangeDatetime = LocalDateTime.now().minusSeconds(1L)
                        )
                    )
                ),
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    capacity = PersonCapacity(2, 10)
                ),
                participant = VillageParticipants(
                    count = 2,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyVillageParticipant(),
                        DummyDomainModelCreator.createDummyVillageParticipant()
                    )
                )
            )
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.addDayIfNeeded(dayChange)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.day.dayList.size).isEqualTo(2)
    }

    @Test
    fun test_dayChange() {
        // ## Arrange ##
        val dummyParticipant = DummyDomainModelCreator.createDummyVillageParticipant()
        val villagerList = (1..10).toList().map { DummyDomainModelCreator.createDummyVillageParticipant() }
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(
                    listOf(
                        DummyDomainModelCreator.createDummyVillageDay(),
                        DummyDomainModelCreator.createDummyVillageDay()
                    )
                ),
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    capacity = PersonCapacity(10, 16),
                    charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                        dummyCharaId = dummyParticipant.charaId
                    )
                ),
                participant = VillageParticipants(
                    count = villagerList.size + 2,
                    memberList = villagerList + dummyParticipant
                )
            )
        )
        val charas = Charas(
            villagerList.map { DummyDomainModelCreator.createDummyChara().copy(id = it.charaId) }
                + DummyDomainModelCreator.createDummyChara().copy(id = dummyParticipant.charaId)
        )

        // ## Act ##
        val afterDayChange = prologueDomainService.dayChange(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list.size).isEqualTo(4)
        afterDayChange.messages.list.forEach { println(it.content.text) }
        assertThat(afterDayChange.village.participant.memberList.all { it.skill != null }).`as`("役職が割り振られている").isTrue()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.進行中)
    }
}