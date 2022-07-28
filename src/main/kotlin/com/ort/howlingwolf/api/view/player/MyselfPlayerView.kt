package com.ort.howlingwolf.api.view.player

import com.ort.howlingwolf.api.view.village.VillagesView
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.fw.security.HowlingWolfUser

data class MyselfPlayerView(
    val id: Int,
    val nickname: String,
    val twitterUserName: String,
    val availableCreateVillage: Boolean,
    val participateProgressVillages: VillagesView,
    val participateFinishedVillages: VillagesView,
    val createProgressVillages: VillagesView,
    val createFinishedVillages: VillagesView,
    val blacklistPlayers: List<PlayerView>,
    val introducePlayers: List<PlayerView>,
    val introducedPlayers: List<PlayerView>
) {
    constructor(
        player: Player,
        participantVillages: Villages,
        createVillages: Villages,
        blacklistPlayers: Players,
        user: HowlingWolfUser,
        introducePlayers: Players,
        introducedPlayers: Players
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName,
        availableCreateVillage = player.isAvailableCreateVillage(user),
        participateProgressVillages = VillagesView(Villages(participantVillages.list.filter {
            !it.status.isSolved()
        })),
        participateFinishedVillages = VillagesView(Villages(participantVillages.list.filter {
            it.status.isSolved()
        })),
        createProgressVillages = VillagesView(Villages(createVillages.list.filter {
            !it.status.isSolved()
        })),
        createFinishedVillages = VillagesView(Villages(createVillages.list.filter {
            it.status.isSolved()
        })),
        blacklistPlayers = blacklistPlayers.list.map { PlayerView(it) },
        introducePlayers = introducePlayers.list.map { PlayerView(it) },
        introducedPlayers = introducedPlayers.list.map { PlayerView(it) }
    )
}