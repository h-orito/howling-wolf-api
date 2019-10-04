package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.body.PlayerUpdateNicknameBody
import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class PlayerController(
        private val playerService: PlayerService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @PostMapping("/player/nickname")
    fun updateNickname(@AuthenticationPrincipal user: Wolf4busyUser,
                       @RequestBody @Validated body: PlayerUpdateNicknameBody) {
        playerService.updateNickname(user, body.nickname!!)
    }

}