package com.ort.wolf4busy.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.dummy.DummyDomainModelCreator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class AttackTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_getSelectableTargetList_未参加者() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null

        // ## Act ##
        val targetList = Attack.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(targetList).`as`("参加していないので対象なし").isEmpty()
    }

    @Test
    fun test_getSelectableTargetList_1日目() {
        // ## Arrange ##
        val dummyParticipant = DummyDomainModelCreator.createDummyVillageParticipant()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                listOf(DummyDomainModelCreator.createDummyFirstVillageDay())
            ),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf(dummyParticipant)
            ),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                    dummyCharaId = dummyParticipant.charaId
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val targetList = Attack.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(targetList.firstOrNull()?.id).`as`("初日なのでダミーキャラ").isEqualTo(dummyParticipant.id)
    }

    @Test
    fun test_getSelectableTargetList_2日目以降() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        day = 2
                    )
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveWolf,
                    aliveVillager,
                    deadVillager
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()

        // ## Act ##
        val targetList = Attack.getSelectableTargetList(village, participant)

        // ## Assert ##
        assertThat(targetList.size).`as`("死亡していなくて襲撃対象にできる役職のみ").isEqualTo(1)
    }

    @Test
    fun test_getSelectingTarget_未参加者() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = Attack.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("参加していないのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_未セット() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveWolf,
                    aliveVillager,
                    deadVillager
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val villageAbilities = DummyDomainModelCreator.createDummyVillageAbilities()

        // ## Act ##
        val target = Attack.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target).`as`("セットしていないのでなし").isNull()
    }

    @Test
    fun test_getSelectingTarget_セット済み() {
        // ## Arrange ##
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            day = VillageDays(
                dayList = listOf(
                    VillageDay(
                        id = 1,
                        day = 2,
                        noonnight = CDef.Noonnight.昼.code(),
                        dayChangeDatetime = LocalDateTime.now()
                    )
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    deadWolf,
                    aliveVillager,
                    deadVillager
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyVillageParticipant()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = 1,
                    myselfId = deadWolf.id,
                    targetId = deadVillager.id,
                    ability = Ability(CDef.AbilityType.襲撃)
                )
            )
        )

        // ## Act ##
        val target = Attack.getSelectingTarget(village, participant, villageAbilities)

        // ## Assert ##
        assertThat(target?.id).`as`("死亡していても対象になる").isEqualTo(deadVillager.id)
    }

    @Test
    fun test_getSetMessage_対象あり() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = DummyDomainModelCreator.createDummyChara()

        // ## Act ##
        val message = Attack.getSetMessage(chara, targetChara)

        // ## Assert ##
        assertThat(message).`as`("対象あり").doesNotContain("なし")
    }

    @Test
    fun test_getSetMessage_対象なし() {
        // ## Arrange ##
        val chara = DummyDomainModelCreator.createDummyChara()
        val targetChara = null

        // ## Act ##
        val message = Attack.getSetMessage(chara, targetChara)

        // ## Assert ##
        assertThat(message).`as`("対象なし").contains("なし")
    }

    @Test
    fun test_getDefaultAbility_進行中でない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.終了)
        )

        // ## Act ##
        val villageAbility = Attack.getDefaultAbility(village)

        // ## Assert ##
        assertThat(villageAbility).`as`("進行中でないのでなし").isNull()
    }

    @Test
    fun test_getDefaultAbility_狼が全員死亡() {
        // ## Arrange ##
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    deadWolf
                )
            )
        )

        // ## Act ##
        val villageAbility = Attack.getDefaultAbility(village)

        // ## Assert ##
        assertThat(villageAbility).`as`("人狼が全員死亡しているのでなし").isNull()
    }

    @Test
    fun test_getDefaultAbility_1日目() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val dummyParticipant = DummyDomainModelCreator.createDummyAliveVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        day = 1
                    )
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveWolf, dummyParticipant
                )
            ),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                charachip = DummyDomainModelCreator.createDummyVillageCharachip().copy(
                    dummyCharaId = dummyParticipant.charaId
                )
            )
        )

        // ## Act ##
        val villageAbility = Attack.getDefaultAbility(village)

        // ## Assert ##
        assertThat(villageAbility?.myselfId).`as`("生存している狼").isEqualTo(aliveWolf.id)
        assertThat(villageAbility?.targetId).`as`("初日はダミー固定").isEqualTo(dummyParticipant.id)
        assertThat(villageAbility?.ability?.code).isEqualTo(CDef.AbilityType.襲撃.code())
    }

    @Test
    fun test_getDefaultAbility_対象なし() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val deadVillager = DummyDomainModelCreator.createDummyDeadVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        day = 4
                    )
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveWolf, deadVillager
                )
            )
        )

        // ## Act ##
        val villageAbility = Attack.getDefaultAbility(village)

        // ## Assert ##
        assertThat(villageAbility).`as`("対象がいないのでなし").isNull()
    }

    @Test
    fun test_getDefaultAbility_対象あり() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        day = 4
                    )
                )
            ),
            participant = VillageParticipants(
                count = 3,
                memberList = listOf(
                    aliveWolf, aliveVillager
                )
            )
        )

        // ## Act ##
        val villageAbility = Attack.getDefaultAbility(village)

        // ## Assert ##
        assertThat(villageAbility?.myselfId).`as`("生存している狼").isEqualTo(aliveWolf.id)
        assertThat(villageAbility?.targetId).`as`("生存者").isEqualTo(aliveVillager.id)
        assertThat(villageAbility?.ability?.code).isEqualTo(CDef.AbilityType.襲撃.code())
    }

    @Test
    fun test_process_人狼が一人も生きていない() {
        // ## Arrange ##
        val deadWolf = DummyDomainModelCreator.createDummyDeadWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = deadWolf.id,
                    targetId = aliveVillager.id,
                    ability = Ability(CDef.AbilityType.襲撃)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(deadWolf, aliveVillager)
            ),
            day = VillageDays(listOf(yesterday, latestDay))
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = Attack.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("襲撃する人が死んでいる").isFalse()
    }

    @Test
    fun test_process_意図的襲撃なし() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()

        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveWolf.id,
                    targetId = null, // 襲撃なし
                    ability = Ability(CDef.AbilityType.襲撃)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveWolf, aliveVillager)
            ),
            day = VillageDays(listOf(yesterday, latestDay))
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = DummyDomainModelCreator.createDummyCharas()

        // ## Act ##
        val afterDayChange = Attack.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).`as`("意図的襲撃なし").isFalse()
    }

    @Test
    fun test_process_襲撃成功_狩人に護衛されていたが狩人が死亡() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val deadHunter = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = DummyDomainModelCreator.createDummyDead(),
            skill = Skill(CDef.Skill.狩人)
        )
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveWolf.id,
                    targetId = aliveVillager.id,
                    ability = Ability(CDef.AbilityType.襲撃)
                ),
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = deadHunter.id,
                    targetId = aliveVillager.id,
                    ability = Ability(CDef.AbilityType.護衛)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveWolf, aliveVillager, deadHunter)
            ),
            day = VillageDays(
                listOf(
                    yesterday,
                    latestDay
                )
            )
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = Attack.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.memberList.first { it.id == aliveVillager.id }).`as`("襲撃されて死亡")
            .satisfies { attackedVillager ->
                assertThat(attackedVillager.isAlive()).`as`("死亡").isFalse()
                assertThat(attackedVillager.dead?.code).`as`("襲撃死").isEqualTo(CDef.DeadReason.襲撃.code())
                assertThat(attackedVillager.dead?.villageDay?.id).isEqualTo(latestDay.id)
            }
        assertThat(afterDayChange.messages.messageList.first()).satisfies { message ->
            assertThat(message.content.text).contains("襲撃した")
            assertThat(message.content.type.code).isEqualTo(CDef.MessageType.襲撃結果.code())
        }
    }

    @Test
    fun test_process_護衛されて襲撃失敗() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val aliveVillager = DummyDomainModelCreator.createDummyAliveVillager()
        val aliveHunter = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            skill = Skill(CDef.Skill.狩人)
        )

        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveWolf.id,
                    targetId = aliveVillager.id,
                    ability = Ability(CDef.AbilityType.襲撃)
                ),
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveHunter.id,
                    targetId = aliveVillager.id,
                    ability = Ability(CDef.AbilityType.護衛)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveWolf, aliveVillager, aliveHunter)
            ),
            day = VillageDays(
                listOf(
                    yesterday,
                    latestDay
                )
            )
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = aliveVillager.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = aliveHunter.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = Attack.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.memberList.first { it.id == aliveVillager.id }.isAlive())
            .`as`("護衛成功").isTrue()
        assertThat(afterDayChange.messages.messageList.isNotEmpty()).isTrue()
    }

    @Test
    fun test_process_襲撃対象が死亡() {
        // ## Arrange ##
        val aliveWolf = DummyDomainModelCreator.createDummyAliveWolf()
        val deadVillager = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = DummyDomainModelCreator.createDummyDead().copy(code = CDef.DeadReason.処刑.code()),
            skill = Skill(CDef.Skill.村人)
        )
        val deadHunter = DummyDomainModelCreator.createDummyVillageParticipant().copy(
            dead = DummyDomainModelCreator.createDummyDead(),
            skill = Skill(CDef.Skill.狩人)
        )
        val yesterday = DummyDomainModelCreator.createDummyVillageDay()
        val latestDay = DummyDomainModelCreator.createDummyVillageDay()
        val villageAbilities = VillageAbilities(
            listOf(
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = aliveWolf.id,
                    targetId = deadVillager.id,
                    ability = Ability(CDef.AbilityType.襲撃)
                ),
                VillageAbility(
                    villageDayId = yesterday.id,
                    myselfId = deadHunter.id,
                    targetId = deadVillager.id,
                    ability = Ability(CDef.AbilityType.護衛)
                )
            )
        )
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            participant = VillageParticipants(
                count = 2,
                memberList = listOf(aliveWolf, deadVillager, deadHunter)
            ),
            day = VillageDays(
                listOf(
                    yesterday,
                    latestDay
                )
            )
        )
        val dayChange = DayChange(
            village = village,
            votes = DummyDomainModelCreator.createDummyVillageVotes(),
            abilities = villageAbilities,
            players = DummyDomainModelCreator.createDummyPlayers()
        )
        val charas = Charas(
            listOf(
                DummyDomainModelCreator.createDummyChara().copy(id = aliveWolf.charaId),
                DummyDomainModelCreator.createDummyChara().copy(id = deadVillager.charaId)
            )
        )

        // ## Act ##
        val afterDayChange = Attack.process(dayChange, charas)

        // ## Assert ##
        assertThat(afterDayChange.isChange).isTrue()
        assertThat(afterDayChange.village.participant.memberList.first { it.id == deadVillager.id }).`as`("襲撃されて死亡")
            .satisfies { attackedVillager ->
                assertThat(attackedVillager.isAlive()).`as`("死亡").isFalse()
                assertThat(attackedVillager.dead?.code).`as`("襲撃死ではない").isNotEqualTo(CDef.DeadReason.襲撃.code())
            }
        assertThat(afterDayChange.messages.messageList.isNotEmpty()).isTrue()
    }
}