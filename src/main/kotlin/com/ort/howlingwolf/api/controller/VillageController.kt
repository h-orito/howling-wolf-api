package com.ort.howlingwolf.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.api.body.AutoGeneratedVillageRegisterBody
import com.ort.howlingwolf.api.body.VillageAbilityBody
import com.ort.howlingwolf.api.body.VillageChangeSkillBody
import com.ort.howlingwolf.api.body.VillageComingOutBody
import com.ort.howlingwolf.api.body.VillageCommitBody
import com.ort.howlingwolf.api.body.VillageParticipateBody
import com.ort.howlingwolf.api.body.VillageSayBody
import com.ort.howlingwolf.api.body.VillageSettingBody
import com.ort.howlingwolf.api.body.VillageVoteBody
import com.ort.howlingwolf.api.form.VillageListForm
import com.ort.howlingwolf.api.form.VillageMessageForm
import com.ort.howlingwolf.api.view.charachip.CharaView
import com.ort.howlingwolf.api.view.message.MessageTimeView
import com.ort.howlingwolf.api.view.message.MessageView
import com.ort.howlingwolf.api.view.message.MessagesView
import com.ort.howlingwolf.api.view.myself.participant.SituationAsParticipantView
import com.ort.howlingwolf.api.view.village.VillageAnchorMessageView
import com.ort.howlingwolf.api.view.village.VillageLatestView
import com.ort.howlingwolf.api.view.village.VillageParticipantView
import com.ort.howlingwolf.api.view.village.VillageRegisterView
import com.ort.howlingwolf.api.view.village.VillageView
import com.ort.howlingwolf.api.view.village.VillagesView
import com.ort.howlingwolf.application.coordinator.MessageCoordinator
import com.ort.howlingwolf.application.coordinator.VillageCoordinator
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.message.MessageTime
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.Skills
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.domain.model.village.participant.AccessInfo
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.ZoneOffset

@RestController
class VillageController(
    val villageCoordinator: VillageCoordinator,
    val messageCoordinator: MessageCoordinator,

    val villageService: VillageService,
    val playerService: PlayerService,
    val charachipService: CharachipService,
    val messageService: MessageService
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
        villageCoordinator.registerVillageFromReservedIfNeeded()
        val villages: Villages = villageService.findVillages(
            villageStatusList = villageStatusList
        )
        return VillagesView(villages)
    }

    /**
     * 村情報取得
     * @param villageId villageId
     */
    @GetMapping("/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): VillageView {
        val village: Village = villageService.findVillage(villageId)
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
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
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
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
        @Validated form: VillageMessageForm
    ): MessagesView {
        val village: Village = villageService.findVillage(villageId, false)
        val messageTypeList = form.message_type_list?.mapNotNull { CDef.MessageType.codeOf(it) }
        val messages: Messages = messageCoordinator.findMessageList(
            village = village,
            day = day,
            noonnight = noonnight,
            user = user,
            from = form.from,
            pageSize = form.page_size,
            pageNum = form.page_num,
            keyword = form.keyword,
            messageTypeList = messageTypeList,
            isLatest = form.is_disp_latest ?: false,
            participantIdList = form.participant_id_list?.filterNotNull() // [null]で来る問題に対応
        )
        val players: Players = playerService.findPlayers(villageId)
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
        val villageDayId: Int = village.day.dayList.first { it.day == day && it.noonnight == noonnight }.id
        val todayMessages =
            messageService.findMessages(village.id, villageDayId, MessageQuery(listOf(CDef.MessageType.通常発言)))
        return MessagesView(
            messages = messages,
            village = village,
            players = players,
            charas = charas,
            todayMessages = todayMessages
        )
    }

    /**
     * 最新発言時間、村日付取得
     * @param villageId villageId
     * @param user user
     */
    @GetMapping("/village/{villageId}/latest")
    fun findLatest(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser?
    ): VillageLatestView {
        val village: Village = villageService.findVillage(villageId, false)
        val unixTimeMilli = messageCoordinator.findLatestMessagesUnixTimeMilli(village, user)
        return VillageLatestView(
            unixTimeMilli = unixTimeMilli,
            villageDayId = village.day.latestDay().id
        )
    }

    /**
     * 自動生成村作成
     * @param user user
     * @param body 村設定
     */
    @PostMapping("/auto-generated-village")
    fun registerAutoGeneratedVillage(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: AutoGeneratedVillageRegisterBody
    ): VillageRegisterView {
        val player: Player = playerService.findPlayer(user)
        val village: Village = Village.createAutoGeneratedForRegister(
            player.id,
            body.organization!!,
            body.startDatetime!!,
            body.silentHours,
            body.availableDummySkill!!,
            body.forBeginner!!,
            true
        )
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
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(villageId)
        return SituationAsParticipantView(
            situation = villageCoordinator.findActionSituation(village, user, players, charas),
            village = village,
            charas = charas,
            players = players
        )
    }

    /**
     * 村参加確認
     * @param villageId villageId
     * @param user user
     * @param body 村参加に必要な情報
     */
    @PostMapping("/village/{villageId}/participate-confirm")
    fun participateConfirm(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageParticipateBody
    ): MessageView {
        villageCoordinator.assertParticipate(
            villageId = villageId,
            user = user,
            charaId = body.charaId!!,
            message = body.joinMessage!!,
            isSpectate = body.spectator ?: false,
            firstRequestSkill = CDef.Skill.codeOf(body.firstRequestSkill),
            secondRequestSkill = CDef.Skill.codeOf(body.secondRequestSkill),
            password = body.joinPassword
        )
        val messageContent = MessageContent.invoke(
            CDef.MessageType.通常発言.code(),
            body.joinMessage,
            CDef.FaceType.通常.code()
        ).copy(num = 0)
        val chara: Chara = charachipService.findChara(body.charaId)
        return MessageView(
            from = VillageParticipantView(
                id = 1, // dummy
                chara = CharaView(chara),
                player = null,
                dead = null,
                spectator = body.spectator ?: false,
                skill = null,
                skillRequest = null,
                win = null,
                comingOuts = ComingOuts()
            ),
            to = null,
            time = MessageTimeView(
                villageDayId = 1, // dummy
                day = 0,
                datetime = LocalDateTime.now(),
                unixTimeMilli = LocalDateTime.now().toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()
            ),
            content = messageContent
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
            message = body.joinMessage!!,
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
            secondRequestSkill = CDef.Skill.codeOf(body.secondRequestSkill),
            accessInfo = AccessInfo(user.ipAddress!!, user.clientToken)
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
    @ResponseBody
    fun sayConfirm(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageSayBody
    ): MessageView {
        villageCoordinator.confirmToSay(villageId, user, body.message!!, body.messageType!!, body.faceType!!)
        val village = villageService.findVillage(villageId)
        val participant = villageCoordinator.findParticipant(village, user)
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(villageId)
        return MessageView(
            message = Message(
                fromVillageParticipantId = participant!!.id,
                toVillageParticipantId = null,
                time = MessageTime(
                    villageDayId = village.day.latestDay().id,
                    datetime = LocalDateTime.now(),
                    unixTimeMilli = LocalDateTime.now().toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()
                ),
                content = MessageContent.invoke(
                    messageType = body.messageType,
                    text = body.message,
                    faceCode = body.faceType
                ).copy(num = 1)
            ),
            village = village,
            players = players,
            charas = charas,
            shouldHidePlayer = true
        )
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
        villageCoordinator.setAbility(villageId, user, body.myselfId, body.targetId, body.abilityType!!)
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
     * カミングアウトセット
     * @param villageId villageId
     * @param user user
     * @param body co内容
     */
    @PostMapping("/village/{villageId}/comingout")
    fun comingout(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: VillageComingOutBody
    ) {
        val skills = if (body.skillCode.isNullOrEmpty()) Skills(listOf())
        else Skills(body.skillCode.map { Skill(CDef.Skill.codeOf(it)) })
        villageCoordinator.setComingOut(
            villageId,
            user,
            skills
        )
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
}