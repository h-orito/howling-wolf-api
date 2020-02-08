package com.ort.howlingwolf.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.village.VillageDays
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
class ExecuteTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_process_2日目() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(
                    DummyDomainModelCreator.createDummyFirstVillageDay(),
                    DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
                ))
            )
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = Execute.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_process_処刑あり() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 3)
        val aliveVillager1 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager2 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager3 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager4 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveWolf1 = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveWolf2 = DummyDomainModelCreator.createDummyAliveWolf()
        val suddenlyDeathVillager1 = DummyDomainModelCreator.createDummyDeadVillager().suddenlyDeath(latestDay)

        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(
                    yesterday,
                    latestDay
                )),
                participant = VillageParticipants(
                    count = 12,
                    memberList = listOf(
                        aliveVillager1,
                        aliveVillager2,
                        aliveVillager3,
                        aliveVillager4,
                        aliveWolf1,
                        aliveWolf2,
                        suddenlyDeathVillager1,
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager()
                    )
                )
            ),
            votes = VillageVotes(listOf(
                VillageVote(yesterday.id, aliveVillager1.id, aliveVillager2.id),
                VillageVote(yesterday.id, aliveVillager2.id, aliveVillager1.id),
                VillageVote(yesterday.id, aliveVillager3.id, aliveVillager1.id),
                VillageVote(yesterday.id, aliveVillager4.id, aliveVillager1.id),
                VillageVote(yesterday.id, aliveWolf1.id, aliveVillager1.id),
                VillageVote(yesterday.id, aliveWolf2.id, aliveVillager1.id),
                VillageVote(yesterday.id, suddenlyDeathVillager1.id, aliveVillager1.id)
            ))
        )
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager2.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager3.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager4.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf2.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = suddenlyDeathVillager1.charaId)
        ))

        // ## Act ##
        val afterDayChange = Execute.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.member(aliveVillager1.id)).satisfies { villager ->
            assertThat(villager.isAlive()).isFalse()
            assertThat(villager.dead?.toCdef()).isEqualTo(CDef.DeadReason.処刑)
        }
        assertThat(afterDayChange.messages.messageList.size).isEqualTo(2)
        assertThat(afterDayChange.messages.messageList.first()).satisfies { eachVoteMessage ->
            println(eachVoteMessage.content.text)
            assertThat(eachVoteMessage.content.type.toCdef()).isEqualTo(CDef.MessageType.非公開システムメッセージ)
            assertThat(eachVoteMessage.content.text).`as`("突然死者の票は入らない").contains("5票")
            assertThat(eachVoteMessage.content.text).contains("1票")
        }
        assertThat(afterDayChange.messages.messageList.last()).satisfies { executeMessage ->
            println(executeMessage.content.text)
            assertThat(executeMessage.content.type.toCdef()).isEqualTo(CDef.MessageType.公開システムメッセージ)
            assertThat(executeMessage.content.text).contains(charas.list.first().charaName.name)
        }
    }

    @Test
    fun test_process_処刑あり_突然死者を処刑() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 3)
        val aliveVillager1 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager2 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager3 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveVillager4 = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveWolf1 = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveWolf2 = DummyDomainModelCreator.createDummyAliveWolf()
        val suddenlyDeathVillager1 = DummyDomainModelCreator.createDummyDeadVillager().suddenlyDeath(latestDay)

        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(
                    yesterday,
                    latestDay
                )),
                participant = VillageParticipants(
                    count = 12,
                    memberList = listOf(
                        aliveVillager1,
                        aliveVillager2,
                        aliveVillager3,
                        aliveVillager4,
                        aliveWolf1,
                        aliveWolf2,
                        suddenlyDeathVillager1,
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager()
                    )
                )
            ),
            votes = VillageVotes(listOf(
                VillageVote(yesterday.id, aliveVillager1.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, aliveVillager2.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, aliveVillager3.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, aliveVillager4.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, aliveWolf1.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, aliveWolf2.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, suddenlyDeathVillager1.id, aliveVillager1.id)
            ))
        )
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager2.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager3.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager4.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf2.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = suddenlyDeathVillager1.charaId)
        ))

        // ## Act ##
        val afterDayChange = Execute.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.member(suddenlyDeathVillager1.id)).satisfies { villager ->
            assertThat(villager.isAlive()).isFalse()
            assertThat(villager.dead?.toCdef()).isEqualTo(CDef.DeadReason.突然)
        }
        assertThat(afterDayChange.messages.messageList.size).isEqualTo(2)
        assertThat(afterDayChange.messages.messageList.first()).satisfies { eachVoteMessage ->
            println(eachVoteMessage.content.text)
        }
        assertThat(afterDayChange.messages.messageList.last()).satisfies { executeMessage ->
            println(executeMessage.content.text)
        }
    }

    @Test
    fun test_process_全員突然死() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 3)
        val suddenlyDeathVillager1 = DummyDomainModelCreator.createDummyDeadVillager().suddenlyDeath(latestDay)
        val suddenlyDeathVillager2 = DummyDomainModelCreator.createDummyDeadVillager().suddenlyDeath(latestDay)
        val suddenlyDeathVillager3 = DummyDomainModelCreator.createDummyDeadVillager().suddenlyDeath(latestDay)

        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                day = VillageDays(listOf(
                    yesterday,
                    latestDay
                )),
                participant = VillageParticipants(
                    count = 8,
                    memberList = listOf(
                        suddenlyDeathVillager1,
                        suddenlyDeathVillager2,
                        suddenlyDeathVillager3,
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager(),
                        DummyDomainModelCreator.createDummyDeadVillager()
                    )
                )
            ),
            votes = VillageVotes(listOf(
                VillageVote(yesterday.id, suddenlyDeathVillager1.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, suddenlyDeathVillager2.id, suddenlyDeathVillager1.id),
                VillageVote(yesterday.id, suddenlyDeathVillager3.id, suddenlyDeathVillager1.id)
            ))
        )
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = suddenlyDeathVillager1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = suddenlyDeathVillager2.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = suddenlyDeathVillager3.charaId)
        ))

        // ## Act ##
        val afterDayChange = Execute.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }
}