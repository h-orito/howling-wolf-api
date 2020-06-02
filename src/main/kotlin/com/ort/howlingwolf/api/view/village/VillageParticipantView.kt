package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.api.view.charachip.CharaView
import com.ort.howlingwolf.api.view.dead.DeadView
import com.ort.howlingwolf.api.view.player.PlayerView
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.Village

data class VillageParticipantView(
    val id: Int,
    val chara: CharaView,
    val player: PlayerView?,
    val dead: DeadView?,
    val isSpectator: Boolean,
    val skill: Skill?,
    val skillRequest: SkillRequest?,
    val isWin: Boolean?
) {
    constructor(
        village: Village,
        villageParticipantId: Int,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        id = village.participant.member(villageParticipantId).id,
        chara = CharaView(charas.chara(village.participant.member(villageParticipantId).charaId)),
        player = if (shouldHidePlayer || village.participant.member(villageParticipantId).playerId == null) null
        else PlayerView(players.list.find { it.id == village.participant.member(villageParticipantId).playerId }!!),
        dead = village.participant.member(villageParticipantId).dead?.let { DeadView(it, shouldHidePlayer) },
        isSpectator = village.participant.member(villageParticipantId).isSpectator,
        skill = if (shouldHidePlayer) null else village.participant.member(villageParticipantId).skill,
        skillRequest = if (shouldHidePlayer) null else village.participant.member(villageParticipantId).skillRequest,
        isWin = village.participant.member(villageParticipantId).isWin
    )
}