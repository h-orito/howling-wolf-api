package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.skill.Skill

data class VillageParticipant(
    val id: Int,
    val chara: Chara,
    val player: Player?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val skill: Skill?
) {
}