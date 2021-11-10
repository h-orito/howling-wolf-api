package com.ort.howlingwolf.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.application.service.AbilityService
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.CommitService
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.application.service.VoteService
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import com.ort.howlingwolf.dummy.DummyVillageService
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class VillageCoordinatorTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var playerBhv: PlayerBhv
    @Autowired
    lateinit var villageCoordinator: VillageCoordinator
    @Autowired
    lateinit var villageService: VillageService
    @Autowired
    lateinit var messageService: MessageService
    @Autowired
    lateinit var charachipService: CharachipService
    @Autowired
    lateinit var playerService: PlayerService
    @Autowired
    lateinit var abilityService: AbilityService
    @Autowired
    lateinit var voteService: VoteService
    @Autowired
    lateinit var commitService: CommitService

    @Autowired
    lateinit var dummyVillageService: DummyVillageService

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_registerVillage() {
        // ## Arrange ##
        val paramVillage = DummyDomainModelCreator.createDummyVillageRegisterParam()
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)

        // ## Act ##
        val villageId = villageCoordinator.registerVillage(paramVillage, user)

        // ## Assert ##
        val village = villageService.findVillage(villageId)
        assertThat(village.creatorPlayerId).isEqualTo(1)
        assertThat(village.participant.count).isEqualTo(1)
        val messages = messageService.findMessages(
            villageId,
            village.day.latestDay().id,
            MessageQuery(listOf(CDef.MessageType.通常発言))
        )
        assertThat(messages.list).isNotEmpty
    }

    @Test(expected = HowlingWolfBusinessException::class)
    fun test_assertParticipate() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        val village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)

        // ## Act ##
        // ## Assert ##
        villageCoordinator.assertParticipate(
            villageId = village.id,
            user = user,
            message = "aa",
            charaId = charas.list[1].id,
            isSpectate = false,
            password = ""
        )
        // 見学不可設定なので見学はできない
        villageCoordinator.assertParticipate(
            villageId = village.id,
            user = user,
            message = "aa",
            charaId = charas.list[1].id,
            isSpectate = true,
            password = ""
        )
    }

    @Test
    fun test_participate() {
        // ## Arrange ##
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)

        // ## Act ##
        villageCoordinator.participate(
            villageId = village.id,
            playerId = 2,
            charaId = charas.list[1].id,
            message = "入村しましたよ",
            isSpectate = false
        )

        // ## Assert ##
        village = villageService.findVillage(village.id)
        assertThat(village.participant.memberList.any { it.charaId == charas.list[1].id })
    }

    @Test
    fun test_changeSkillRequest() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        villageCoordinator.participate(
            villageId = village.id,
            playerId = 2,
            charaId = charas.list[1].id,
            message = "入村しましたよ",
            isSpectate = false
        )
        val first = CDef.Skill.人狼
        val second = CDef.Skill.村人

        // ## Act ##
        villageCoordinator.changeSkillRequest(
            village.id,
            user,
            first.code(),
            second.code()
        )

        // ## Assert ##
        village = villageService.findVillage(village.id)
        val participant = villageCoordinator.findParticipant(village, user)
        assertThat(participant?.skillRequest?.first?.toCdef()).isEqualTo(first)
        assertThat(participant?.skillRequest?.second?.toCdef()).isEqualTo(second)
    }

    @Test
    fun test_leave() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        villageCoordinator.participate(
            villageId = village.id,
            playerId = 2,
            charaId = charas.list[1].id,
            message = "入村しましたよ",
            isSpectate = false
        )

        // ## Act ##
        villageCoordinator.leave(village.id, user)

        // ## Assert ##
        village = villageService.findVillage(village.id)
        val participant = villageCoordinator.findParticipant(village, user)
        assertThat(participant).isNull()
    }

    @Test
    fun test_confirmToSay() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        villageCoordinator.participate(
            villageId = village.id,
            playerId = 2,
            charaId = charas.list[1].id,
            message = "入村しましたよ",
            isSpectate = false
        )
        val messageText = "message text"

        // ## Act ##
        // ## Assert ##
        villageCoordinator.confirmToSay(
            village.id,
            user,
            messageText,
            CDef.MessageType.通常発言.code(),
            CDef.FaceType.通常.code()
        )
    }

    @Test
    fun test_say() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        villageCoordinator.participate(
            villageId = village.id,
            playerId = 2,
            charaId = charas.list[1].id,
            message = "入村しましたよ",
            isSpectate = false
        )
        val messageText = "message text"

        // ## Act ##
        villageCoordinator.say(
            village.id,
            user,
            messageText,
            CDef.MessageType.通常発言.code(),
            CDef.FaceType.通常.code()
        )

        // ## Assert ##
        village = villageService.findVillage(village.id)
        val participant = villageCoordinator.findParticipant(village, user)
        val messages = messageService.findMessages(
            village.id,
            village.day.latestDay().id,
            MessageQuery(listOf(CDef.MessageType.通常発言))
        )
        assertThat(messages.list.any {
            it.fromVillageParticipantId == participant?.id
                && it.content.text == messageText
        }).isTrue()
    }

    @Test
    fun test_setAbility() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        (2..11).forEach {
            villageCoordinator.participate(
                villageId = village.id,
                playerId = it,
                charaId = charas.list[it].id,
                message = "入村しましたよ",
                firstRequestSkill = if (it == 2) CDef.Skill.占い師 else CDef.Skill.おまかせ,
                isSpectate = false
            )
        }
        village = villageService.findVillage(village.id)
        village = villageService.updateVillageDifference(
            village,
            village.addNewDay().changeStatus(CDef.VillageStatus.進行中).assignSkill(
                participants = VillageParticipants(
                    count = village.participant.count,
                    memberList = village.participant.memberList.map { it.assignSkill(it.skillRequest.first) }
                )
            )
        )
        val dummy = village.dummyChara()
        val participant = villageCoordinator.findParticipant(village, user)

        // ## Act ##
        villageCoordinator.setAbility(
            village.id,
            user,
            null,
            dummy.id,
            CDef.AbilityType.占い.code()
        )

        // ## Assert ##
        val abilities = abilityService.findVillageAbilities(village.id)
        assertThat(abilities.list.any {
            it.abilityType.toCdef() == CDef.AbilityType.占い
                && it.myselfId == participant?.id
                && it.targetId == village.dummyChara().id
        }).isTrue()
    }

    @Test
    fun test_setVote() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        (2..11).forEach {
            villageCoordinator.participate(
                villageId = village.id,
                playerId = it,
                charaId = charas.list[it].id,
                message = "入村しましたよ",
                firstRequestSkill = if (it == 2) CDef.Skill.占い師 else CDef.Skill.おまかせ,
                isSpectate = false
            )
        }
        village = villageService.findVillage(village.id)
        village = villageService.updateVillageDifference(
            village,
            village.addNewDay().addNewDay().changeStatus(CDef.VillageStatus.進行中).assignSkill(
                participants = VillageParticipants(
                    count = village.participant.count,
                    memberList = village.participant.memberList.map { it.assignSkill(it.skillRequest.first) }
                )
            )
        )
        val dummy = village.dummyChara()
        val participant = villageCoordinator.findParticipant(village, user)

        // ## Act ##
        villageCoordinator.setVote(
            village.id, user, dummy.id
        )

        // ## Assert ##
        val votes = voteService.findVillageVotes(village.id)
        assertThat(votes.list.any {
            it.myselfId == participant?.id
                && it.targetId == village.dummyChara().id
        }).isTrue()
    }

    @Test
    fun test_setCommit() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)
        (2..11).forEach {
            villageCoordinator.participate(
                villageId = village.id,
                playerId = it,
                charaId = charas.list[it].id,
                message = "入村しましたよ",
                firstRequestSkill = if (it == 2) CDef.Skill.占い師 else CDef.Skill.おまかせ,
                isSpectate = false
            )
        }
        village = villageService.findVillage(village.id)
        village = villageService.updateVillageDifference(
            village,
            village.addNewDay().changeStatus(CDef.VillageStatus.進行中).copy(
                setting = village.setting.copy(
                    rules = village.setting.rules.copy(availableCommit = true)
                )
            )
        )
        val participant = villageCoordinator.findParticipant(village, user)

        // ## Act ##
        villageCoordinator.setCommit(
            village.id, user, true
        )

        // ## Assert ##
        val commits = commitService.findCommits(village.id)
        assertThat(commits.list.any {
            it.myselfId == participant?.id && it.isCommitting
        }).isTrue()
    }

    @Test
    fun test_findActionSituation_エラーが起きないこと() {
        // ## Arrange ##
        val player = playerBhv.selectByPK(2).get()
        val user = HowlingWolfUser(player.uid, player.authorityCodeAsAuthority)
        var village = dummyVillageService.createG16PrologueVillage()
        val players: Players = playerService.findPlayers(village.id)
        val charas = charachipService.findCharas(village.setting.charachip.charachipId)

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        (2..16).forEach {
            villageCoordinator.participate(
                villageId = village.id,
                playerId = it,
                charaId = charas.list[it].id,
                message = "入村しましたよ",
                firstRequestSkill = if (it == 2) CDef.Skill.占い師 else CDef.Skill.おまかせ,
                isSpectate = false
            )
        }

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        village = villageService.findVillage(village.id)
        village = villageService.updateVillageDifference(
            village,
            village.addNewDay().addNewDay().changeStatus(CDef.VillageStatus.進行中).assignSkill(
                participants = VillageParticipants(
                    count = village.participant.count,
                    memberList = village.participant.memberList.map { it.assignSkill(it.skillRequest.first) }
                )
            ).copy(
                setting = village.setting.copy(
                    rules = village.setting.rules.copy(availableCommit = true)
                )
            )
        )

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        villageCoordinator.say(
            village.id,
            user,
            "hoge",
            CDef.MessageType.通常発言.code(),
            CDef.FaceType.通常.code()
        )

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        villageCoordinator.setAbility(
            village.id,
            user,
            null,
            village.dummyChara().id,
            CDef.AbilityType.占い.code()
        )

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        villageCoordinator.setVote(village.id, user, village.dummyChara().id)

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)

        // ## Arrange ##
        villageCoordinator.setCommit(village.id, user, true)

        // ## Act ##
        // ## Assert ##
        villageCoordinator.findActionSituation(village, user, players, charas)
    }
}