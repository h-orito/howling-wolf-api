package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class ProgressTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_addDayIfNeeded_必要なし_コミットなし設定() {
        // ## Arrange ##
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableCommit = false
                    )
                ),
                day = VillageDays(listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().plusHours(1L)
                    )
                ))
            )
        )
        val commits = DummyDomainModelCreator.createDummyCommits()

        // ## Act ##
        val afterDayChange = Progress.addDayIfNeeded(dayChange, commits)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_addDayIfNeeded_必要なし_コミットされていない_時間を過ぎていない() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(
            dayChangeDatetime = LocalDateTime.now().plusHours(1L)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableCommit = true
                    )
                ),
                day = VillageDays(listOf(latestDay)),
                participant = VillageParticipants(
                    count = 3,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager()
                    )
                )
            )
        )
        val commits = Commits(
            listOf(
                Commit(latestDay.id, true),
                Commit(latestDay.id, true)
            )
        )

        // ## Act ##
        val afterDayChange = Progress.addDayIfNeeded(dayChange, commits)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isFalse()
    }

    @Test
    fun test_addDayIfNeeded_必要あり_コミット() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(
            dayChangeDatetime = LocalDateTime.now().plusHours(1L)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableCommit = true
                    )
                ),
                day = VillageDays(listOf(latestDay)),
                participant = VillageParticipants(
                    count = 3,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager()
                    )
                )
            )
        )
        val commits = Commits(
            listOf(
                Commit(latestDay.id, true),
                Commit(latestDay.id, true),
                Commit(latestDay.id, true)
            )
        )

        // ## Act ##
        val afterDayChange = Progress.addDayIfNeeded(dayChange, commits)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.day.dayList.size).isEqualTo(2)
    }

    @Test
    fun test_addDayIfNeeded_時間を過ぎている() {
        // ## Arrange ##
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(
            dayChangeDatetime = LocalDateTime.now().minusHours(1L)
        )
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableCommit = true
                    )
                ),
                day = VillageDays(listOf(latestDay)),
                participant = VillageParticipants(
                    count = 3,
                    memberList = listOf(
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager(),
                        DummyDomainModelCreator.createDummyAliveVillager()
                    )
                )
            )
        )
        val commits = DummyDomainModelCreator.createDummyCommits()

        // ## Act ##
        val afterDayChange = Progress.addDayIfNeeded(dayChange, commits)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.day.dayList.size).isEqualTo(2)
    }

    @Test
    fun test_dayChange_2日目() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 2)
        val dummyParticipant = DummyDomainModelCreator.createDummyAliveVillager()
        val villager = DummyDomainModelCreator.createDummyAliveVillager()
        val seer = DummyDomainModelCreator.createDummyAliveSeer()
        val hunter = DummyDomainModelCreator.createDummyAliveHunter()
        val psychic = DummyDomainModelCreator.createDummyAlivePsychic()
        val wolf = DummyDomainModelCreator.createDummyAliveWolf()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                status = VillageStatus(CDef.VillageStatus.進行中),
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 6,
                    memberList = listOf(
                        dummyParticipant,
                        villager,
                        seer,
                        hunter,
                        psychic,
                        wolf
                    )
                ),
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableSuddenlyDeath = false
                    ),
                    charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                        dummyCharaId = dummyParticipant.charaId
                    )
                )
            ),
            abilities = VillageAbilities(listOf(
                VillageAbility(yesterday.id, wolf.id, dummyParticipant.id, Ability(CDef.AbilityType.襲撃))
            ))
        )
        val messages = Messages(listOf())
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = dummyParticipant.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = villager.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = seer.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = hunter.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = psychic.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = wolf.charaId)
        ))

        // ## Act ##
        val afterDayChange = Progress.dayChange(dayChange, messages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.dummyChara().isAlive()).isFalse()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.進行中)
        assertThat(afterDayChange.messages.messageList.any { message ->
            message.content.type.toCdef() == CDef.MessageType.公開システムメッセージ
                && message.content.text.contains("ついに犠牲者が")
        }).isTrue()
        assertThat(afterDayChange.messages.messageList.any { message ->
            message.content.type.toCdef() == CDef.MessageType.公開システムメッセージ
                && message.content.text.contains("現在の生存者は")
                && message.content.text.contains(charas.list.last().charaName.name)
        }).isTrue()
        assertThat(afterDayChange.abilities.list.filter { it.villageDayId == latestDay.id }).isNotEmpty
        assertThat(afterDayChange.votes.list.filter { it.villageDayId == latestDay.id }).isNotEmpty
        afterDayChange.messages.messageList.forEach { println(it.content.text) }
    }

    @Test
    fun test_dayChange_3日目_人狼を処刑_村人を襲撃() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 3)
        val dummyParticipant = DummyDomainModelCreator.createDummyDeadVillager()
        val villager = DummyDomainModelCreator.createDummyAliveVillager()
        val seer = DummyDomainModelCreator.createDummyAliveSeer()
        val hunter = DummyDomainModelCreator.createDummyAliveHunter()
        val psychic = DummyDomainModelCreator.createDummyAlivePsychic()
        val wolf1 = DummyDomainModelCreator.createDummyAliveWolf()
        val wolf2 = DummyDomainModelCreator.createDummyAliveWolf()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                status = VillageStatus(CDef.VillageStatus.進行中),
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 7,
                    memberList = listOf(
                        dummyParticipant,
                        villager,
                        seer,
                        hunter,
                        psychic,
                        wolf1,
                        wolf2
                    )
                ),
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableSuddenlyDeath = false
                    ),
                    charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                        dummyCharaId = dummyParticipant.charaId
                    )
                )
            ),
            abilities = VillageAbilities(listOf(
                VillageAbility(yesterday.id, wolf1.id, villager.id, Ability(CDef.AbilityType.襲撃)),
                VillageAbility(yesterday.id, hunter.id, wolf2.id, Ability(CDef.AbilityType.護衛)),
                VillageAbility(yesterday.id, seer.id, wolf2.id, Ability(CDef.AbilityType.占い))
            )),
            votes = VillageVotes(listOf(
                VillageVote(yesterday.id, villager.id, wolf1.id),
                VillageVote(yesterday.id, seer.id, wolf1.id),
                VillageVote(yesterday.id, hunter.id, wolf1.id),
                VillageVote(yesterday.id, psychic.id, wolf1.id),
                VillageVote(yesterday.id, wolf1.id, wolf1.id),
                VillageVote(yesterday.id, wolf2.id, wolf1.id)
            ))
        )
        val messages = Messages(listOf())
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = dummyParticipant.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = villager.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = seer.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = hunter.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = psychic.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = wolf1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = wolf2.charaId)
        ))

        // ## Act ##
        val afterDayChange = Progress.dayChange(dayChange, messages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.member(villager.id).isAlive()).isFalse()
        assertThat(afterDayChange.village.participant.member(wolf1.id).isAlive()).isFalse()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.進行中)
        assertThat(afterDayChange.messages.messageList.any { message ->
            message.content.type.toCdef() == CDef.MessageType.公開システムメッセージ
                && message.content.text.contains("現在の生存者は")
                && message.content.text.contains(charas.list.last().charaName.name)
        }).isTrue()
        assertThat(afterDayChange.abilities.list.filter { it.villageDayId == latestDay.id }).satisfies { latestDayAbilityList ->
            assertThat(latestDayAbilityList.any { it.ability.code == CDef.AbilityType.襲撃.code() }).isTrue()
            assertThat(latestDayAbilityList.any { it.ability.code == CDef.AbilityType.占い.code() }).isTrue()
            assertThat(latestDayAbilityList.any { it.ability.code == CDef.AbilityType.護衛.code() }).isTrue()
        }
        assertThat(afterDayChange.votes.list.count { it.villageDayId == latestDay.id }).isEqualTo(4)
        afterDayChange.messages.messageList.forEach { println(it.content.text) }
    }

    @Test
    fun test_dayChange_4日目_人狼を処刑() {
        // ## Arrange ##
        val yesterday = DummyDomainModelCreator.createDummyFirstVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay().copy(day = 4)
        val dummyParticipant = DummyDomainModelCreator.createDummyDeadVillager()
        val villager = DummyDomainModelCreator.createDummyDeadVillager()
        val seer = DummyDomainModelCreator.createDummyAliveSeer()
        val hunter = DummyDomainModelCreator.createDummyAliveHunter()
        val psychic = DummyDomainModelCreator.createDummyAlivePsychic()
        val wolf1 = DummyDomainModelCreator.createDummyDeadWolf()
        val wolf2 = DummyDomainModelCreator.createDummyAliveWolf()
        val dayChange = DummyDomainModelCreator.createDummyDayChange().copy(
            village = DummyDomainModelCreator.createDummyVillage().copy(
                status = VillageStatus(CDef.VillageStatus.進行中),
                day = VillageDays(listOf(yesterday, latestDay)),
                participant = VillageParticipants(
                    count = 7,
                    memberList = listOf(
                        dummyParticipant,
                        villager,
                        seer,
                        hunter,
                        psychic,
                        wolf1,
                        wolf2
                    )
                ),
                setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                    rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                        availableSuddenlyDeath = false
                    ),
                    charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                        dummyCharaId = dummyParticipant.charaId
                    )
                )
            ),
            abilities = VillageAbilities(listOf(
                VillageAbility(yesterday.id, wolf2.id, seer.id, Ability(CDef.AbilityType.襲撃)),
                VillageAbility(yesterday.id, hunter.id, seer.id, Ability(CDef.AbilityType.護衛)),
                VillageAbility(yesterday.id, seer.id, wolf2.id, Ability(CDef.AbilityType.占い))
            )),
            votes = VillageVotes(listOf(
                VillageVote(yesterday.id, seer.id, wolf2.id),
                VillageVote(yesterday.id, hunter.id, wolf2.id),
                VillageVote(yesterday.id, psychic.id, wolf2.id),
                VillageVote(yesterday.id, wolf2.id, wolf2.id)
            ))
        )
        val messages = Messages(listOf())
        val charas = Charas(listOf(
            DummyDomainModelCreator.createDummyChara().copy(id = dummyParticipant.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = villager.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = seer.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = hunter.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = psychic.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = wolf1.charaId),
            DummyDomainModelCreator.createDummyChara().copy(id = wolf2.charaId)
        ))

        // ## Act ##
        val afterDayChange = Progress.dayChange(dayChange, messages, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.member(wolf2.id).isAlive()).isFalse()
        assertThat(afterDayChange.village.participant.member(seer.id).isAlive()).isTrue()
        assertThat(afterDayChange.village.status.toCdef()).isEqualTo(CDef.VillageStatus.エピローグ)
        assertThat(afterDayChange.messages.messageList.none { message ->
            message.content.type.toCdef() == CDef.MessageType.公開システムメッセージ
                && message.content.text.contains("現在の生存者は")
        }).isTrue()
        assertThat(afterDayChange.abilities.list.filter { it.villageDayId == latestDay.id }).satisfies { latestDayAbilityList ->
            assertThat(latestDayAbilityList.none { it.ability.code == CDef.AbilityType.襲撃.code() }).isTrue()
            assertThat(latestDayAbilityList.none { it.ability.code == CDef.AbilityType.占い.code() }).isTrue()
            assertThat(latestDayAbilityList.none { it.ability.code == CDef.AbilityType.護衛.code() }).isTrue()
        }
        assertThat(afterDayChange.votes.list.count { it.villageDayId == latestDay.id }).isEqualTo(0)
        afterDayChange.messages.messageList.forEach { println(it.content.text) }
    }
}