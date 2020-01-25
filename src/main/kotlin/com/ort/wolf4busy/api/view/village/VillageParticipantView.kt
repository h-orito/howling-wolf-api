package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.api.view.player.PlayerView
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.Village

data class VillageParticipantView(
    val id: Int,
    val chara: Chara,
    val player: PlayerView?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val skill: Skill?
) {
    constructor(
        village: Village,
        villageParticipantId: Int,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        id = village.participant.member(villageParticipantId).id,
        chara = charas.chara(village.participant.member(villageParticipantId).charaId),
        player = if (shouldHidePlayer || village.participant.member(villageParticipantId).playerId == null) null
        else PlayerView(players.list.find { it.id == village.participant.member(villageParticipantId).playerId }!!),
        dead = village.participant.member(villageParticipantId).dead,
        isSpectator = village.participant.member(villageParticipantId).isSpectator,
        skill = if (shouldHidePlayer) null else village.participant.member(villageParticipantId).skill
    )
}