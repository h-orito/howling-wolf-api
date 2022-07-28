package com.ort.howlingwolf.api.controller

import com.ort.howlingwolf.api.body.PlayerUpdateDetailBody
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
import org.slf4j.LoggerFactory
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


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

        val blacklistPlayers: Players = playerService.findPlayers(player.blacklistPlayers.list)
        val introducePlayers: Players = playerService.findPlayers(player.introducePlayerIds)
        val introducedPlayers: Players = playerService.findPlayers(player.introducedPlayerIds)
        return MyselfPlayerView(
            player,
            participantVillages,
            createVillages,
            blacklistPlayers,
            user,
            introducePlayers,
            introducedPlayers
        )
    }

    @PostMapping("/player/nickname")
    fun updateNickname(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: PlayerUpdateNicknameBody
    ) {
        playerService.updateNickname(user, body.nickname!!, body.twitterUserName!!)
    }

    @PostMapping("/player/detail")
    fun updateDetail(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: PlayerUpdateDetailBody
    ) {
        playerService.updateDetail(user.uid, body.otherSiteName, body.introduction)
    }

    @PostMapping("/player/blacklist-player/register/{playerId}")
    fun registerBlacklistPlayer(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @PathVariable("playerId") targetPlayerId: Int
    ) {
        val target: Player = playerService.findPlayer(targetPlayerId)
        playerService.registerBlacklist(user.uid, target.id)
    }

    @PostMapping("/player/blacklist-player/remove/{playerId}")
    fun removeBlacklistPlayer(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @PathVariable("playerId") targetPlayerId: Int
    ) {
        val target: Player = playerService.findPlayer(targetPlayerId)
        playerService.deleteBlacklist(user.uid, target.id)
    }

    @PostMapping("/player/introduce/{playerId}")
    fun registerIntroduce(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @PathVariable("playerId") targetPlayerId: Int
    ) {
        val target: Player = playerService.findPlayer(targetPlayerId)
        playerService.registerIntroduce(user.uid, target.id)
    }

    @PostMapping("/player/remove-introduce/{playerId}")
    fun removeIntroduce(
        @AuthenticationPrincipal user: HowlingWolfUser,
        @PathVariable("playerId") targetPlayerId: Int
    ) {
        val target: Player = playerService.findPlayer(targetPlayerId)
        playerService.deleteIntroduce(user.uid, target.id)
    }

    @GetMapping("/player/{playerId}/record")
    fun stats(
        @PathVariable("playerId") playerId: Int
    ): PlayerRecordsView {
        val player: Player = playerService.findPlayer(playerId)
        val playerRecords = playerCoordinator.findPlayerRecords(player)
        val charachipIdList =
            playerRecords.participateVillageList.map { it.village.setting.charachip.charachipId }.distinct()
        val charas: Charas = charachipService.findCharas(charachipIdList)
        val playerIdList =
            playerRecords.participateVillageList.flatMap { it.village.participant.memberList.map { it.playerId!! } }
                .distinct()
        val players: Players = playerService.findPlayers(playerIdList)
        val createPlayerIdList = playerRecords.participateVillageList.map { it.village.creatorPlayerId }
        val createPlayers: Players = playerService.findPlayers(createPlayerIdList)
        return PlayerRecordsView(playerRecords, charas, players, createPlayers)
    }
}