package com.ort.wolf4busy.dummy

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.*
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.myself.participant.VillageAbilitySituation
import com.ort.wolf4busy.domain.model.myself.participant.VillageAbilitySituations
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import java.time.LocalDateTime

object DummyDomainModelCreator {

    fun createDummyVillage(): Village {
        return Village(
            id = randomNumber(),
            name = "dummy",
            creatorPlayerId = randomNumber(),
            status = createDummyVillageStatus(),
            winCamp = null,
            setting = createDummyVillageSettings(),
            participant = createDummyVillageParticipants(),
            spectator = createDummyVillageParticipants(),
            day = createDummyVillageDays()
        )
    }

    fun createDummyVillageDays(): VillageDays = VillageDays(listOf())

    fun createDummyVillageDay(): VillageDay = VillageDay(
        id = randomNumber(),
        day = randomNumber(),
        noonnight = CDef.Noonnight.昼.code(),
        dayChangeDatetime = LocalDateTime.now(),
        isUpdating = false
    )

    fun createDummyVillageParticipants(): VillageParticipants = VillageParticipants(0, listOf())

    fun createDummyVillageSettings(): VillageSettings {
        return VillageSettings(
            capacity = createDummyPersonCapacity(),
            time = createDummyVillageTime(),
            charachip = createDummyVillageCharachip(),
            organizations = createDummyVillageOrganizations(),
            rules = createDummyVillageRules(),
            password = createDummyVillagePassword()
        )
    }

    fun createDummyVillagePassword(): VillagePassword = VillagePassword(false, null)

    fun createDummyVillageRules(): VillageRules = VillageRules()

    fun createDummyVillageOrganizations(): VillageOrganizations = VillageOrganizations()

    fun createDummyVillageCharachip(): VillageCharachip = VillageCharachip(1, 1)

    fun createDummyVillageTime(): VillageTime = VillageTime("dummy", LocalDateTime.now(), 0)

    fun createDummyPersonCapacity(): PersonCapacity = PersonCapacity(1, 1)

    fun createDummyVillageStatus(): VillageStatus = VillageStatus("dummy", "dummy")

    fun createDummyVillageParticipant(): VillageParticipant = VillageParticipant(
        id = randomNumber(),
        charaId = randomNumber(),
        playerId = randomNumber(),
        dead = null,
        isSpectator = false,
        isGone = false,
        skill = null,
        skillRequest = createDummySkillRequest(),
        isWin = null
    )

    fun createDummySkillRequest(): SkillRequest = SkillRequest(
        first = Skill(CDef.Skill.人狼),
        second = Skill(CDef.Skill.人狼)
    )

    fun createDummyVillageAbilities(): VillageAbilities = VillageAbilities(listOf())

    fun createDummyChara(): Chara = Chara(
        id = randomNumber(),
        charaName = createDummyCharaName(),
        charachipId = randomNumber(),
        defaultMessage = createDummyCharaDefaultMessage(),
        display = createDummyCharaSize(),
        faceList = listOf()
    )

    fun createDummyCharaSize(): CharaSize = CharaSize(50, 60)

    fun createDummyCharaDefaultMessage(): CharaDefaultMessage = CharaDefaultMessage("dummy", "dummy")

    fun createDummyCharaName(): CharaName = CharaName("dummy", "dummy")

    fun createDummyDead(): Dead = Dead(CDef.DeadReason.処刑, createDummyVillageDay())

    fun createDummyVillageAbility(): VillageAbility = VillageAbility(
        villageDayId = randomNumber(),
        myselfId = randomNumber(),
        targetId = randomNumber(),
        ability = Ability(CDef.AbilityType.襲撃)
    )

    fun createDummyVillageVotes(): VillageVotes = VillageVotes(listOf())

    fun createDummyPlayers(): Players = Players(listOf())

    fun createDummyCharas(): Charas = Charas(listOf())

    fun createDummyDayChange(): DayChange = DayChange(
        village = createDummyVillage(),
        votes = createDummyVillageVotes(),
        abilities = createDummyVillageAbilities(),
        players = createDummyPlayers()
    )

    fun createDummyCommits(): Commits = Commits(listOf())

    fun createDummyMessage(): Message = Message(
        from = createDummyVillageParticipant(),
        to = null,
        time = createDummyMessageTime(),
        content = createDummyMessageContent()
    )

    fun createDummyMessageTime(): MessageTime = MessageTime(
        villageDayId = randomNumber(),
        day = randomNumber(),
        datetime = LocalDateTime.now(),
        unixTimeMilli = 1L
    )

    fun createDummyMessageContent(): MessageContent = MessageContent(
        type = MessageType(CDef.MessageType.公開システムメッセージ),
        num = null,
        text = "dummy message",
        faceCode = null
    )

    fun createDummyVillageAbilitySituations(): VillageAbilitySituations =
        VillageAbilitySituations(listOf())

    fun createDummyVillageAbilitySituation(): VillageAbilitySituation =
        VillageAbilitySituation(
            type = Ability(CDef.AbilityType.襲撃),
            targetList = listOf(),
            target = null,
            exercisable = false
        )

    fun createDummyUser(): Wolf4busyUser = Wolf4busyUser(
        uid = "dummy_user_id",
        authority = CDef.Authority.プレイヤー
    )

    // ===================================================================================
    //                                                                                頻出
    //                                                                        ============
    fun createDummyFirstVillageDay(): VillageDay = createDummyVillageDay().copy(day = 1)

    fun createDummyAliveWolf(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.人狼))

    fun createDummyAliveVillager(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.村人))

    fun createDummyAliveSeer(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.占い師))

    fun createDummyAlivePsychic(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.霊能者))

    fun createDummyAliveHunter(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.狩人))

    fun createDummyAliveMadman(): VillageParticipant = createDummyVillageParticipant().copy(skill = Skill(CDef.Skill.狂人))

    fun createDummyDeadWolf(): VillageParticipant = createDummyAliveWolf().copy(dead = createDummyDead())

    fun createDummyDeadVillager(): VillageParticipant = createDummyAliveVillager().copy(dead = createDummyDead())

    fun createDummyDeadSeer(): VillageParticipant = createDummyAliveSeer().copy(dead = createDummyDead())

    fun createDummyDeadPsychic(): VillageParticipant = createDummyAlivePsychic().copy(dead = createDummyDead())

    fun createDummyDeadHunter(): VillageParticipant = createDummyAliveHunter().copy(dead = createDummyDead())

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun randomNumber(): Int = (Math.random() * 10000).toInt()
}