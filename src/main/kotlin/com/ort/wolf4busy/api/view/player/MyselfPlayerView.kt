package com.ort.wolf4busy.api.view.player

import com.ort.wolf4busy.api.view.village.VillagesView
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.fw.security.Wolf4busyUser

data class MyselfPlayerView(
    val id: Int,
    val nickname: String,
    val twitterUserName: String,
    val isAvailableCreateVillage: Boolean,
    val participateProgressVillages: VillagesView,
    val participateFinishedVillages: VillagesView,
    val createProgressVillages: VillagesView,
    val createFinishedVillages: VillagesView
) {
    constructor(
        player: Player,
        participantVillages: Villages,
        createVillages: Villages,
        user: Wolf4busyUser
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName,
        isAvailableCreateVillage = player.isAvailableCreateVillage(user),
        participateProgressVillages = VillagesView(participantVillages.list.filter {
            !it.status.isSolved()
        }),
        participateFinishedVillages = VillagesView(participantVillages.list.filter {
            it.status.isSolved()
        }),
        createProgressVillages = VillagesView(createVillages.list.filter {
            !it.status.isSolved()
        }),
        createFinishedVillages = VillagesView(createVillages.list.filter {
            it.status.isSolved()
        })
    )
}