package com.ort.wolf4busy.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.api.body.*
import com.ort.wolf4busy.api.form.VillageMessageForm
import com.ort.wolf4busy.api.view.village.*
import com.ort.wolf4busy.application.coordinator.MessageCoordinator
import com.ort.wolf4busy.application.coordinator.VillageCoordinator
import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.slf4j.LoggerFactory
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@CrossOrigin
@RestController
class VillageController(
    val villageService: VillageService,
    val villageCoordinator: VillageCoordinator,
    val messageCoordinator: MessageCoordinator,
    val playerService: PlayerService
) {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private val logger = LoggerFactory.getLogger(VillageController::class.java)

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    /**
     * 村一覧取得
     * @param user user
     */
    @GetMapping("/village/list")
    fun villageList(@AuthenticationPrincipal user: Wolf4busyUser?): VillageListView {
        val villages = villageService.findVillageList()
        logger.info(user.toString())
        return VillageListView(
            villageList = villages.villageList
        )
    }

    /**
     * 村情報取得
     * @param villageId villageId
     */
    @GetMapping("/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): VillageView {
        val village = villageService.findVillage(villageId)
        return VillageView(
            village = village
        )
    }

    /**
     * アンカー発言取得
     * @param villageId villageId
     * @param day 日付
     * @param time 昼夜
     * @param user user
     */
    @GetMapping("/village/{villageId}/message/type/{messageType}/number/{messageNumber}")
    fun anchorMessage(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("messageType") messageType: String,
        @PathVariable("messageNumber") messageNumber: Int,
        @AuthenticationPrincipal user: Wolf4busyUser?
    ): VillageAnchorMessageView {
        val message: Message? = messageCoordinator.findMessage(villageId, messageType, messageNumber, user)
        return VillageAnchorMessageView(
            message = message
        )
    }

    /**
     * 発言取得
     * @param villageId villageId
     * @param day 日付
     * @param time 昼夜
     * @param user user
     */
    @GetMapping("/village/{villageId}/day/{day}/time/{noonnight}/message-list")
    fun message(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("day") day: Int,
        @PathVariable("noonnight") noonnight: String,
        @AuthenticationPrincipal user: Wolf4busyUser?,
        @RequestBody @Validated form: VillageMessageForm?
    ): VillageMessageView {
        val messages: Messages = messageCoordinator.findMessageList(villageId, day, noonnight, user, form?.from)
        return VillageMessageView(
            messageList = messages.messageList
        )
    }

    /**
     * 村作成
     * @param user user
     * @param body 村設定
     */
    @PostMapping("/village")
    fun registerVillage(
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageRegisterBody
    ): VillageRegisterView {
        val password: String? = null // TODO
        val village: Village = convertRegisterBodyToVillage(body, user)
        val villageId: Int = villageCoordinator.registerVillage(village, password)
        return VillageRegisterView(villageId = villageId)
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageParticipateBody
    ) {
        val player = playerService.findPlayer(user)
        if (playerService.isRestrictedParticipatePlayer(user)) throw Wolf4busyBusinessException("参加を制限されています")

        villageCoordinator.participate(
            villageId = villageId,
            playerId = player.id,
            charaId = body.charaId!!,
            message = body.joinMessage!!,
            isSpectate = body.spectator ?: false,
            firstRequestSkill = CDef.Skill.codeOf(body.firstRequestSkill),
            secondRequestSkill = CDef.Skill.codeOf(body.secondRequestSkill),
            password = body.joinPassword
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageChangeSkillBody
    ) {
        // TODO 実装
    }

    /**
     * 退村
     * @param villageId villageId
     * @param user user
     */
    @PostMapping("/village/{villageId}/leave")
    fun leave(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: Wolf4busyUser
    ) {
        // TODO 実装
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageSayBody
    ) {
        // TODO 実装
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageAbilityBody
    ) {
        // TODO 実装
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageVoteBody
    ) {
        // TODO 実装
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageCommitBody
    ) {
        // TODO 実装
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
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageSettingBody
    ) {
        // TODO 実装
    }


    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertRegisterBodyToVillage(body: VillageRegisterBody, user: Wolf4busyUser): Village {
        // TODO
        return Village(
            id = 1, // dummy
            name = "dummy village name", // TODO
            creatorPlayerName = "master", // TODO
            status = VillageStatus(
                code = CDef.VillageStatus.募集中.code(),
                name = CDef.VillageStatus.募集中.name
            ),
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
            )
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
                startDatetime = LocalDateTime.now(), // TODO
                dayChangeIntervalSeconds = 86400 // TODO
            ),
            charachip = VillageCharachip(
                dummyCharaId = 22, // TODO
                charachipId = 2 // TODO
            ),
            organizations = VillageOrganizations(), // TODO
            rules = VillageRules(), // TODO
            password = VillagePassword(
                joinPasswordRequired = false // TODO
            )
        )
    }
}