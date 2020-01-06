package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.player.PlayerView
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageParticipantView(
    val id: Int,
    val chara: Chara, // domainと違う箇所
    val player: PlayerView?, // domainと違う箇所
    val dead: Dead?,
    val isSpectator: Boolean,
    val skill: Skill?
) {
    constructor(
        villageParticipant: VillageParticipant,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        id = villageParticipant.id,
        chara = charas.chara(villageParticipant.charaId),
        player = if (shouldHidePlayer || villageParticipant.playerId == null) null
        else PlayerView(players.list.find { it.id == villageParticipant.playerId }!!),
        dead = villageParticipant.dead,
        isSpectator = villageParticipant.isSpectator,
        skill = villageParticipant.skill
    )
}