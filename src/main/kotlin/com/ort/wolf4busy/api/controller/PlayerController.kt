package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.body.PlayerUpdateNicknameBody
import com.ort.wolf4busy.api.view.player.MyselfPlayerView
import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@CrossOrigin
@RestController
class PlayerController(
    private val playerService: PlayerService,
    private val villageService: VillageService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/my-player")
    fun myPlayer(
        @AuthenticationPrincipal user: Wolf4busyUser
    ): MyselfPlayerView {
        val player: Player = playerService.findPlayer(user)
        val participantVillages = villageService.findVillages(
            player.participateProgressVillageIdList + player.participateFinishedVillageIdList
        )
        val createVillages = villageService.findVillages(
            player.createProgressVillageIdList + player.createFinishedVillageIdList
        )
        return MyselfPlayerView(
            player,
            participantVillages,
            createVillages
        )
    }

    @PostMapping("/player/nickname")
    fun updateNickname(
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: PlayerUpdateNicknameBody
    ) {
        playerService.updateNickname(user, body.nickname!!, body.twitterUserName!!)
    }
}