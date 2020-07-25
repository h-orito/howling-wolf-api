package com.ort.howlingwolf.domain.service.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.village.VillageDays
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
class PsychicDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var psychicDomainService: PsychicDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_process_霊能がいない() {
        // ## Arrange ##
        val deadPsychic = DummyDomainModelCreator.createDummyDeadPsychic()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 1,
                    memberList = listOf(deadPsychic)
                )
            )
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = psychicDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_process_霊能がいるが霊視できる死者がいない() {
        // ## Arrange ##
        val alivePsychic = DummyDomainModelCreator.createDummyAlivePsychic()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 2,
                    memberList = listOf(
                        alivePsychic,
                        DummyDomainModelCreator.createDummyDeadVillager().copy(
                            dead = Dead(CDef.DeadReason.襲撃, latestDay)
                        )
                    )
                ),
                day = VillageDays(listOf(latestDay))
            )
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = psychicDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_process_霊視あり() {
        // ## Arrange ##
        val alivePsychic = DummyDomainModelCreator.createDummyAlivePsychic()
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf().copy(
            dead = Dead(CDef.DeadReason.処刑, latestDay)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                participant = VillageParticipants(
                    count = 2,
                    memberList = listOf(
                        alivePsychic,
                        deadWolf
                    )
                ),
                day = VillageDays(listOf(yesterday, latestDay))
            )
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = alivePsychic.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = deadWolf.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = psychicDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list).isNotEmpty
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            assertThat(message.content.type.toCdef()).isEqualTo(CDef.MessageType.白黒霊視結果)
            assertThat(message.content.text).contains("人狼のようだ")
        }
    }
}