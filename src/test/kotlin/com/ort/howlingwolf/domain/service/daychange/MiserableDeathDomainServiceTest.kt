package com.ort.howlingwolf.domain.service.daychange

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
class MiserableDeathDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var miserableDeathDomainService: MiserableDeathDomainService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_process_犠牲者なし() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 3,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager().copy(
                            dead = Dead(CDef.DeadReason.処刑, yesterday)
                        ),
                        DummyDomainModelCreator.createDummyDeadVillager().copy(
                            dead = Dead(CDef.DeadReason.処刑, latestDay)
                        )
                    )
                )
            )
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = miserableDeathDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list.size).isEqualTo(1)
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            assertThat(message.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
            assertThat(message.content.text).contains("犠牲者がいない")
        }
    }

    @Test
    fun test_process_犠牲者が1名() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val attackedVillager = DummyDomainModelCreator.createDummyDeadVillager().copy(
            dead = Dead(CDef.DeadReason.襲撃, latestDay)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 3,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager().copy(
                            dead = Dead(CDef.DeadReason.処刑, yesterday)
                        ),
                        attackedVillager
                    )
                )
            )
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = attackedVillager.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = miserableDeathDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list.size).isEqualTo(1)
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            println(message.content.text)
            assertThat(message.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
            assertThat(message.content.text).contains(charas.list.first().charaName.name)
        }
    }

    @Test
    fun test_process_犠牲者が複数() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val attackedVillager1 = DummyDomainModelCreator.createDummyDeadVillager().copy(
            dead = Dead(CDef.DeadReason.襲撃, latestDay)
        )
        val attackedVillager2 = DummyDomainModelCreator.createDummyDeadVillager().copy(
            dead = Dead(CDef.DeadReason.襲撃, latestDay)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 4,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager().copy(
                            dead = Dead(CDef.DeadReason.処刑, yesterday)
                        ),
                        attackedVillager1,
                        attackedVillager2
                    )
                )
            )
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = attackedVillager1.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = attackedVillager2.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = miserableDeathDomainService.processDayChangeAction(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.messages.list.size).isEqualTo(1)
        assertThat(afterDayChange.messages.list.first()).satisfies { message ->
            println(message.content.text)
            assertThat(message.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
            assertThat(message.content.text).contains(charas.list.first().charaName.name)
            assertThat(message.content.text).contains(charas.list.last().charaName.name)
        }
    }
}