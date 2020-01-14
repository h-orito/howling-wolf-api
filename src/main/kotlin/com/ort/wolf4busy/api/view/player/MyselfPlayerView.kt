package com.ort.wolf4busy.api.view.player

import com.ort.wolf4busy.api.view.village.VillageListView
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.Villages

data class MyselfPlayerView(
    val id: Int,
    val nickname: String,
    val twitterUserName: String,
    val participateProgressVillages: VillageListView,
    val participateFinishedVillages: VillageListView,
    val createProgressVillages: VillageListView,
    val createFinishedVillages: VillageListView
) {
    constructor(
        player: Player,
        participantVillages: Villages,
        createVillages: Villages
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName,
        participateProgressVillages = VillageListView(participantVillages.villageList.filter {
            !it.status.isSolved()
        }),
        participateFinishedVillages = VillageListView(participantVillages.villageList.filter {
            it.status.isSolved()
        }),
        createProgressVillages = VillageListView(createVillages.villageList.filter {
            !it.status.isSolved()
        }),
        createFinishedVillages = VillageListView(createVillages.villageList.filter {
            it.status.isSolved()
        })
    )
}