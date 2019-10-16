package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.body.PlayerUpdateNicknameBody
import com.ort.wolf4busy.api.body.VillageRegisterBody
import com.ort.wolf4busy.api.view.village.VillageListView
import com.ort.wolf4busy.api.view.village.VillageMessageView
import com.ort.wolf4busy.api.view.village.VillageView
import com.ort.wolf4busy.application.coordinator.MessageCoordinator
import com.ort.wolf4busy.application.coordinator.VillageCoordinator
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.village.message.VillageMessages
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.slf4j.LoggerFactory
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
class VillageController(
    val villageService: VillageService,
    val villageCoordinator: VillageCoordinator,
    val messageCoordinator: MessageCoordinator
) {

    private val logger = LoggerFactory.getLogger(VillageController::class.java)

    @GetMapping("/village/list")
    fun villageList(@AuthenticationPrincipal user: Wolf4busyUser?): VillageListView {
        val villages = villageService.findVillageList()
        logger.info(user.toString())
        return VillageListView(
            villageList = villages.villageList
        )
    }

    @GetMapping("/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): VillageView {
        val village = villageService.findVillage(villageId)
        return VillageView(
            village = village
        )
    }

    @GetMapping("/village/{villageId}/day/{day}/time/{time}/message-list")
    fun message(
        @PathVariable("villageId") villageId: Int,
        @PathVariable("day") day: Int,
        @PathVariable("time") time: String,
        @AuthenticationPrincipal user: Wolf4busyUser?
    ): VillageMessageView {
        val messages: VillageMessages = messageCoordinator.findMessageList(villageId, day, time, user)
        return VillageMessageView(
            messageList = messages.messageList
        )
    }

    @PostMapping("/village")
    fun registerVillage(
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: VillageRegisterBody
    ) {
        villageCoordinator.registerVillage()
    }
}