package com.ort.howlingwolf.api.view.player

import com.ort.howlingwolf.domain.model.player.Player

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