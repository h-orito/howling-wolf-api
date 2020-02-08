package com.ort.howlingwolf.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.api.body.*
import com.ort.howlingwolf.api.form.VillageListForm
import com.ort.howlingwolf.api.form.VillageMessageForm
import com.ort.howlingwolf.api.view.myself.participant.SituationAsParticipantView
import com.ort.howlingwolf.api.view.village.*
import com.ort.howlingwolf.application.coordinator.MessageCoordinator
import com.ort.howlingwolf.application.coordinator.VillageCoordinator
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.*
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class VillageController(
    val villageCoordinator: VillageCoordinator,
    val messageCoordinator: MessageCoordinator,

    val villageService: VillageService,
    val playerService: PlayerService,
    val charachipService: CharachipService
) {
    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    /**
     * 村一覧取得
     * @param user user
     * @param form 検索パラメータ
     */
    @GetMapping("/village/list")
    fun villageList(
        @AuthenticationPrincipal user: HowlingWolfUser?,
        @Validated form: VillageListForm
    ): VillagesView {
        val villageStatusList = form.village_status?.map { VillageStatus(CDef.VillageStatus.codeOf(it)) } ?: listOf()
        val villages: Villages = villageService.findVillages(
            villageStatusList = villageStatusList
        )
        return VillagesView(
            list = villages.list
        )
    }

    /**
     * 村情報取得
     * @param villageId villageId
     */
    @GetMapping("/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): VillageView {
        val village: Village = villageService.findVillage(villageId)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(villageId)
        val createPlayer: Player = playerService.findPlayer(village.creatorPlayerId)
        return VillageView(
            village = village,
            charas = charas,
            players = players,
            createPlayer = createPlayer
        )
    }

    /**
     * アンカー発言取得
     * @param villageId villageId
     * @param messageType 発言種別
     * @param messageNumber 発言番号
     * @param user user
     */
    @GetMapping("/village/{villageId}/message/type/{messageType}/number/{messageNumber}")
    fun anchorMessage(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("messageType") messageType: String,
        @PathVariable("messageNumber") messageNumber: Int,
        @AuthenticationPrincipal user: HowlingWolfUser?
    ): VillageAnchorMessageView {
        val village: Village = villageService.findVillage(villageId, false)
        val message: Message? = messageCoordinator.findMessage(village, messageType, messageNumber, user)
        val players: Players = playerService.findPlayers(villageId)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        return VillageAnchorMessageView(
            message = message,
            village = village,
            players = players,
            charas = charas
        )
    }

    /**
     * 発言取得
     * @param villageId villageId
     * @param day 日付
     * @param noonnight 昼夜
     * @param user user
     */
    @GetMapping("/village/{villageId}/day/{day}/time/{noonnight}/message-list")
    fun message(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("day") day: Int,
        @PathVariable("noonnight") noonnight: String,
        @AuthenticationPrincipal user: HowlingWolfUser?,
        @RequestBody @Validated form: VillageMessageForm?
    ): VillageMessageView {
        val village: Village = villageService.findVillage(villageId, false)
        val messages: Messages = messageCoordinator.findMessageList(village, day, noonnight, user, form?.from)
        val players: Players = playerService.findPlayers(villageId)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        return VillageMessageView(
            messageList = messages.messageList,
            village = village,
            players = players,
            charas = charas
        )
    }

    /**
     * 村作成
     * @param user user
     * @param body 村設定
     */
    @PostMapping("/village")
    fun registerVillage(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageRegisterBody
    ): VillageRegisterView {
        val password: String? = null // TODO
        val player: Player = playerService.findPlayer(user)
        val village: Village = convertRegisterBodyToVillage(body, player)
        val villageId: Int = villageCoordinator.registerVillage(village, user)
        return VillageRegisterView(villageId = villageId)
    }


    /**
     * 村参加状況取得
     * @param villageId villageId
     * @param user user
     * @return 参加状況
     */
    @GetMapping("/village/{villageId}/situation")
    fun getParticipateSituation(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser?
    ): SituationAsParticipantView {
        val village: Village = villageService.findVillage(villageId)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(villageId)
        return SituationAsParticipantView(
            situation = villageCoordinator.findActionSituation(village, user, players, charas),
            village = village,
            charas = charas,
            players = players
        )
    }

    /**
     * 村に参加
     * @param villageId villageId
     * @param user user
     * @param body 村設定
     */
    @PostMapping("/village/{villageId}/participate")
    fun participateVillage(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageParticipateBody
    ) {
        villageCoordinator.assertParticipate(
            villageId = villageId,
            user = user,
            charaId = body.charaId!!,
            isSpectate = body.spectator ?: false,
            firstRequestSkill = CDef.Skill.codeOf(body.firstRequestSkill),
            secondRequestSkill = CDef.Skill.codeOf(body.secondRequestSkill),
            password = body.joinPassword
        )
        val player = playerService.findPlayer(user)
        villageCoordinator.participate(
            villageId = villageId,
            playerId = player.id,
            charaId = body.charaId,
            message = body.joinMessage!!,
            isSpectate = body.spectator ?: false,
            firstRequestSkill = CDef.Skill.codeOf(body.firstRequestSkill),
            secondRequestSkill = CDef.Skill.codeOf(body.secondRequestSkill)
        )
    }

    /**
     * 希望役職変更
     * @param villageId villageId
     * @param user user
     * @param body 役職
     */
    @PostMapping("/village/{villageId}/change-skill")
    fun changeSkill(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageChangeSkillBody
    ) {
        villageCoordinator.changeSkillRequest(villageId, user, body.firstRequestSkill!!, body.secondRequestSkill!!)
    }

    /**
     * 退村
     * @param villageId villageId
     * @param user user
     */
    @PostMapping("/village/{villageId}/leave")
    fun leave(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser
    ) {
        villageCoordinator.leave(villageId, user)
    }

    /**
     * 発言確認
     * @param villageId villageId
     * @param user user
     * @param body 発言内容
     */
    @PostMapping("/village/{villageId}/say-confirm")
    fun sayConfirm(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageSayBody
    ) {
        // TODO パラメータ多数の場合にどう受け渡すか考える
        villageCoordinator.confirmToSay(villageId, user, body.message!!, body.messageType!!, body.faceType!!)
    }

    /**
     * 発言
     * @param villageId villageId
     * @param user user
     * @param body 発言内容
     */
    @PostMapping("/village/{villageId}/say")
    fun say(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageSayBody
    ) {
        villageCoordinator.say(villageId, user, body.message!!, body.messageType!!, body.faceType!!)
    }

    /**
     * 能力セット
     *
     * @param villageId villageId
     * @param user user
     * @param body 能力セット内容
     */
    @PostMapping("/village/{villageId}/ability")
    fun ability(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageAbilityBody
    ) {
        villageCoordinator.setAbility(villageId, user, body.targetId, body.abilityType!!)
    }

    /**
     * 投票セット
     * @param villageId villageId
     * @param user user
     * @param body 投票内容
     */
    @PostMapping("/village/{villageId}/vote")
    fun vote(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageVoteBody
    ) {
        villageCoordinator.setVote(villageId, user, body.targetId!!)
    }

    /**
     * コミットセット
     * @param villageId villageId
     * @param user user
     * @param body コミット/取り消し
     */
    @PostMapping("/village/{villageId}/commit")
    fun commit(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageCommitBody
    ) {
        villageCoordinator.setCommit(villageId, user, body.commit!!)
    }

    /**
     * 村設定変更
     * @param villageId villageId
     * @param user user
     * @param body 村設定内容
     */
    @PostMapping("/village/{villageId}/setting")
    fun setting(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageSettingBody
    ) {
        // TODO 実装
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertRegisterBodyToVillage(body: VillageRegisterBody, player: Player): Village {
        return Village(
            id = 1, // dummy
            name = "dummy village name", // TODO
            creatorPlayerId = player.id,
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = convertRegisterBodyToVillageSettings(body),
            participant = VillageParticipants(
                count = 1, // dummy
                memberList = listOf()
            ),
            spectator = VillageParticipants(
                count = 0, // dummy
                memberList = listOf() // dummy
            ),
            day = VillageDays(
                dayList = listOf() // dummy
            ),
            winCamp = null
        )
    }

    private fun convertRegisterBodyToVillageSettings(body: VillageRegisterBody): VillageSettings {
        return VillageSettings(
            capacity = PersonCapacity(
                min = 10, // TODO
                max = 16 // TODO
            ),
            time = VillageTime(
                termType = CDef.Term.長期.code(), // TODO
                startDatetime = LocalDateTime.now().plusDays(3L), // TODO
                dayChangeIntervalSeconds = 86400 // TODO
            ),
            charachip = VillageCharachip(
                dummyCharaId = 1, // TODO
                charachipId = 1 // TODO
            ),
            organizations = VillageOrganizations(), // TODO
            rules = VillageRules( // TODO
                openVote = false,
                availableSkillRequest = true,
                availableSpectate = false,
                openSkillInGrave = false,
                visibleGraveMessage = false,
                availableSuddenlyDeath = true,
                availableCommit = false,
                messageRestrict = VillageMessageRestricts(
                    existRestricts = true,
                    restrictList = listOf(
                        VillageMessageRestrict(
                            type = MessageType(
                                code = CDef.MessageType.通常発言.code(),
                                name = CDef.MessageType.通常発言.alias()
                            ),
                            count = 20,
                            length = 200
                        ),
                        VillageMessageRestrict(
                            type = MessageType(
                                code = CDef.MessageType.人狼の囁き.code(),
                                name = CDef.MessageType.人狼の囁き.alias()
                            ),
                            count = 40,
                            length = 200
                        )
                    )
                )
            ),
            password = VillagePassword(
                joinPasswordRequired = false, // TODO
                joinPassword = null
            )
        )
    }
}