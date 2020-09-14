package com.ort.howlingwolf.dummy

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.CharaDefaultMessage
import com.ort.howlingwolf.domain.model.charachip.CharaName
import com.ort.howlingwolf.domain.model.charachip.CharaSize
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.commit.Commits
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageTime
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageDay
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts
import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.domain.model.village.setting.VillageCharachip
import com.ort.howlingwolf.domain.model.village.setting.VillageOrganizations
import com.ort.howlingwolf.domain.model.village.setting.VillagePassword
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.domain.model.village.setting.VillageSettings
import com.ort.howlingwolf.domain.model.village.setting.VillageTime
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
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

    fun createDummyVillageRegisterParam(): Village = Village.createAutoGeneratedForRegister(
        playerId = 1,
        organization = "狼狼狼狂占霊狩村村村村村村村村村",
        startDatetime = LocalDateTime.now().plusDays(1L),
        silentHours = null,
        availableDummySkill = false,
        forBeginner = false
    )

    fun createDummyVillageDays(): VillageDays = VillageDays(listOf())

    fun createDummyVillageDay(): VillageDay = VillageDay(
        id = randomNumber(),
        day = randomNumber(),
        noonnight = CDef.Noonnight.昼.code(),
        dayChangeDatetime = LocalDateTime.now()
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

    fun createDummyVillageTime(): VillageTime = VillageTime("dummy", LocalDateTime.now(), null, null, LocalDateTime.now(), 0, null)

    fun createDummyPersonCapacity(): PersonCapacity = PersonCapacity(1, 1)

    fun createDummyVillageStatus(): VillageStatus = VillageStatus(CDef.VillageStatus.廃村)

    fun createDummyVillageParticipant(): VillageParticipant = VillageParticipant(
        id = randomNumber(),
        charaId = randomNumber(),
        playerId = randomNumber(),
        dead = null,
        isSpectator = false,
        isGone = false,
        skill = null,
        skillRequest = createDummySkillRequest(),
        isWin = null,
        comingOuts = ComingOuts()
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

    fun createDummyVillageVotes(): VillageVotes = VillageVotes(listOf())

    fun createDummyPlayers(): Players = Players(listOf())

    fun createDummyPlayer(): Player = Player(
        id = randomNumber(),
        nickname = "dummy",
        twitterUserName = "dummy",
        otherSiteName = null,
        introduction = null,
        isRestrictedParticipation = false
    )

    fun createDummyCharas(): Charas = Charas(listOf())

    fun createDummyDayChange(): DayChange = DayChange(
        village = createDummyVillage(),
        votes = createDummyVillageVotes(),
        abilities = createDummyVillageAbilities(),
        players = createDummyPlayers()
    )

    fun createDummyCommits(): Commits = Commits(listOf())

    fun createDummyMessage(): Message = Message(
        fromVillageParticipantId = createDummyVillageParticipant().id,
        toVillageParticipantId = null,
        time = createDummyMessageTime(),
        content = createDummyMessageContent()
    )

    fun createDummyMessageTime(): MessageTime = MessageTime(
        villageDayId = randomNumber(),
        datetime = LocalDateTime.now(),
        unixTimeMilli = 1L
    )

    fun createDummyMessageContent(): MessageContent = MessageContent(
        type = MessageType(CDef.MessageType.公開システムメッセージ),
        num = null,
        count = null,
        text = "dummy message",
        faceCode = null
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