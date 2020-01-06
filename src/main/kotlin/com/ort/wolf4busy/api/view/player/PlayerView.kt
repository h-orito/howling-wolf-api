package com.ort.wolf4busy.api.view.player

import com.ort.wolf4busy.domain.model.player.Player

data class PlayerView(
    val id: Int,
    val nickname: String,
    val twitterUserName: String
) {
    constructor(
        player: Player
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName
    )
}