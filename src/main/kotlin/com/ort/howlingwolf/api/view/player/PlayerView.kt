package com.ort.howlingwolf.api.view.player

import com.ort.howlingwolf.domain.model.player.Player

data class PlayerView(
    val id: Int,
    val nickname: String,
    val twitterUserName: String,
    val otherSiteName: String?,
    val introduction: String?,
    val introduced: Boolean
) {
    constructor(
        player: Player
    ) : this(
        id = player.id,
        nickname = player.nickname,
        twitterUserName = player.twitterUserName,
        otherSiteName = player.otherSiteName,
        introduction = player.introduction,
        introduced = player.introducedPlayerIds.isNotEmpty()
    )
}