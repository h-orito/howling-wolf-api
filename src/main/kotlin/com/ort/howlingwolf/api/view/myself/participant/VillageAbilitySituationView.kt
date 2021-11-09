package com.ort.howlingwolf.api.view.myself.participant

import com.ort.howlingwolf.api.view.village.VillageParticipantView
import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.myself.participant.VillageAbilitySituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

data class VillageAbilitySituationView(
    val type: AbilityType,
    val targetList: List<VillageParticipantView>,
    val target: VillageParticipantView?,
    val usable: Boolean,
    val availableNoTarget: Boolean
) {
    constructor(
        situation: VillageAbilitySituation,
        village: Village,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        type = situation.type,
        targetList = situation.targetList.map {
            VillageParticipantView(
                village = village,
                villageParticipantId = it.id,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        },
        target = situation.target?.let {
            VillageParticipantView(
                village = village,
                villageParticipantId = it.id,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        },
        usable = situation.usable,
        availableNoTarget = situation.isAvailableNoTarget
    )
}
