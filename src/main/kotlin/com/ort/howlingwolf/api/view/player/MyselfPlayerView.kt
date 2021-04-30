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
    val isAvailableCreateVillage: Boolean,
    val participateProgressVillages: VillagesView,
    val participateFinishedVillages: VillagesView,
    val createProgressVillages: VillagesView,
    val createFinishedVillages: VillagesView,
    val blacklistPlayers: List<PlayerView>
) {
    constructor(
        player: Player,
        participantVillages: Villages,
        createVillages: Villages,
        blacklistPlayers: Players,
        user: HowlingWolfUser
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName,
        isAvailableCreateVillage = player.isAvailableCreateVillage(user),
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
        blacklistPlayers = blacklistPlayers.list.map { PlayerView(it) }
    )
}