package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.dead.Dead

data class VillageParticipant(
        val id: Int,
        val charaId: Int,
        val dead: Dead?
) {
}