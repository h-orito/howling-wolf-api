package com.ort.wolf4busy.domain.model.player

data class Players(
    val list: List<Player>
) {

    fun restrictParticipation(playerId: Int?): Players {
        return Players(
            list = this.list.map { player ->
                if (player.id == playerId) player.restrictParticipation()
                else player.copy()
            }
        )
    }
}