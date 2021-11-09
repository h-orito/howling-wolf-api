package com.ort.howlingwolf.api.view.myself.participant

import com.ort.howlingwolf.api.view.village.VillageParticipantView
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.myself.participant.VillageParticipateSituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

data class VillageParticipateSituationView(
    val participating: Boolean,
    val availableParticipate: Boolean,
    val availableSpectate: Boolean,
    val selectableCharaList: List<Chara>,
    val availableLeave: Boolean,
    val myself: VillageParticipantView?
) {
    constructor(
        situation: VillageParticipateSituation,
        village: Village,
        players: Players,
        charas: Charas
    ) : this(
        participating = situation.isParticipating,
        availableParticipate = situation.isAvailableParticipate,
        availableSpectate = situation.isAvailableSpectate,
        selectableCharaList = situation.selectableCharaList,
        availableLeave = situation.isAvailableLeave,
        myself = situation.myself?.let {
            VillageParticipantView(
                village = village,
                villageParticipantId = it.id,
                players = players,
                charas = charas,
                shouldHidePlayer = false // 自分自身なので見えても問題なし
            )
        }
    )
}
