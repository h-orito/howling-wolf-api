package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageParticipantView(
    val id: Int,
    val chara: Chara, // domainと違う箇所
    val player: Player?, // domainと違う箇所
    val dead: Dead?,
    val isSpectator: Boolean,
    val skill: Skill?
) {
    constructor(
        villageParticipant: VillageParticipant,
        playerList: List<Player>,
        charas: Charas
    ) : this(
        id = villageParticipant.id,
        chara = charas.list.find { it.id == villageParticipant.charaId }!!,
        player = if (villageParticipant.playerId == null) null else playerList.find { it.id == villageParticipant.playerId },
        dead = villageParticipant.dead,
        isSpectator = villageParticipant.isSpectator,
        skill = villageParticipant.skill
    )
}