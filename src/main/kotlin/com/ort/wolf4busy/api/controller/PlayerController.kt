package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.body.PlayerUpdateNicknameBody
import com.ort.wolf4busy.api.view.player.PlayerView
import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@CrossOrigin
@RestController
class PlayerController(
        private val playerService: PlayerService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/myplayer")
    fun myplayer(@AuthenticationPrincipal user: Wolf4busyUser
    ): PlayerView {
        val player: Player = playerService.findPlayer(user)
        return PlayerView(player)
    }

    @PostMapping("/player/nickname")
    fun updateNickname(@AuthenticationPrincipal user: Wolf4busyUser,
                       @RequestBody @Validated body: PlayerUpdateNicknameBody
    ) {
        playerService.updateNickname(user, body.nickname!!, body.twitterUserName!!)
    }
}