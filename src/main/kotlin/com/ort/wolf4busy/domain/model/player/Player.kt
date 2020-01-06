package com.ort.wolf4busy.domain.model.player

data class Player(
    val id: Int,
    val nickname: String,
    val twitterUserName: String,
    val isRestrictedParticipation: Boolean
) {
    fun restrictParticipation(): Player {
        return this.copy(isRestrictedParticipation = true)
    }
}