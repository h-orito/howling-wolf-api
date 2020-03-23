package com.ort.howlingwolf.api.controller

import com.ort.howlingwolf.api.body.PlayerUpdateNicknameBody
import com.ort.howlingwolf.api.view.player.MyselfPlayerView
import com.ort.howlingwolf.api.view.player.PlayerRecordsView
import com.ort.howlingwolf.application.coordinator.PlayerCoordinator
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class PlayerController(
    private val playerCoordinator: PlayerCoordinator,
    private val charachipService: CharachipService,
    private val playerService: PlayerService,
    private val villageService: VillageService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/my-player")
    fun myPlayer(
        @AuthenticationPrincipal user: HowlingWolfUser
    ): MyselfPlayerView {
        val player: Player = playerService.findPlayer(user)
        val participantVillages: Villages = villageService.findVillages(
            player.participateProgressVillageIdList + player.participateFinishedVillageIdList
        )
        val createVillages: Villages = villageService.findVillages(
            player.createProgressVillageIdList + player.createFinishedVillageIdList
        )
        return MyselfPlayerView(
            player,
            participantVillages,
            createVillages,
            user
        )
    }

    @PostMapping("/player/nickname")
    fun updateNickname(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: PlayerUpdateNicknameBody
    ) {
        playerService.updateNickname(user, body.nickname!!, body.twitterUserName!!)
    }

    @GetMapping("/player/{playerId}/record")
    fun stats(
        @PathVariable("playerId") playerId: Int
    ): PlayerRecordsView {
        val player: Player = playerService.findPlayer(playerId)
        val playerRecords = playerCoordinator.findPlayerRecords(player)
        val charachipIdList = playerRecords.participateVillageList.map { it.village.setting.charachip.charachipId }.distinct()
        val charas: Charas = charachipService.findCharas(charachipIdList)
        val playerIdList =
            playerRecords.participateVillageList.flatMap { it.village.participant.memberList.map { it.playerId!! } }.distinct()
        val players: Players = playerService.findPlayers(playerIdList)
        val createPlayerIdList = playerRecords.participateVillageList.map { it.village.creatorPlayerId }
        val createPlayers: Players = playerService.findPlayers(createPlayerIdList)
        return PlayerRecordsView(playerRecords, charas, players, createPlayers)
    }
}