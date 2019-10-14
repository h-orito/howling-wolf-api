package com.ort.wolf4busy.domain.model.village

import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.participant.VillageVisitors
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings

data class Village(
        val id: Int,
        val name: String,
        val creatorPlayerName: String,
        val status: VillageStatus,
        val setting: VillageSettings,
        val participant: VillageParticipants,
        val visitor: VillageVisitors
) {
}