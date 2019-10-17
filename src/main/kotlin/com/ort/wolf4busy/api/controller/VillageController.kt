package com.ort.wolf4busy.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.api.body.VillageRegisterBody
import com.ort.wolf4busy.api.view.village.VillageListView
import com.ort.wolf4busy.api.view.village.VillageMessageView
import com.ort.wolf4busy.api.view.village.VillageRegisterView
import com.ort.wolf4busy.api.view.village.VillageView
import com.ort.wolf4busy.application.coordinator.MessageCoordinator
import com.ort.wolf4busy.application.coordinator.VillageCoordinator
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
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
    val messageCoordinator: MessageCoordinator
) {

    private val logger = LoggerFactory.getLogger(VillageController::class.java)

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
     * 発言取得
     * @param villageId villageId
     * @param day 日付
     * @param time 昼夜
     * @param user user
     */
    @GetMapping("/village/{villageId}/day/{day}/time/{time}/message-list")
    fun message(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("day") day: Int,
        @PathVariable("time") time: String,
        @AuthenticationPrincipal user: Wolf4busyUser?
    ): VillageMessageView {
        val messages: Messages = messageCoordinator.findMessageList(villageId, day, time, user)
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
                memberList = listOf(
                    VillageParticipant(
                        id = 1, // dummy
                        charaId = 1, // TODO
                        dead = null // dummy
                    )
                )
            ),
            spectator = VillageParticipants(
                count = 0, // dummy
                memberList = listOf() // dummy
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
                dummyCharaId = 1, // TODO
                charachipId = 1 // TODO
            ),
            organizations = VillageOrganizations(), // TODO
            rules = VillageRules(), // TODO
            password = VillagePassword(
                joinPasswordRequired = false // TODO
            )
        )
    }
}