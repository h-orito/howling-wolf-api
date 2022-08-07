package com.ort.howlingwolf.domain.service.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.commit.Commits
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DayChangeDomainServiceTest : HowlingWolfTest() {

    @Autowired
    lateinit var dayChangeDomainService: DayChangeDomainService

    @Test
    fun test_leaveParticipantIfNeeded_プロローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = DummyDomainModelCreator.createDummyVillageAbilities(),
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val todayMessages = Messages(listOf())
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = dayChangeDomainService.leaveParticipantIfNeeded(dayChange, todayMessages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("プロローグでないので何もしない").isFalse()
    }

    @Test
    fun test_process_終了後() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.終了)
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = DummyDomainModelCreator.createDummyVillageAbilities(),
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val todayMessages = Messages(listOf())
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = dayChangeDomainService.process(dayChange, todayMessages, charas, Commits(listOf()))

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("終了後は何もしない").isFalse()
    }
}