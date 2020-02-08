package com.ort.howlingwolf.api.view.myself.participant

import com.ort.howlingwolf.api.view.village.VillageParticipantView
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.myself.participant.VillageParticipateSituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

data class VillageParticipateSituationView(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val selectableCharaList: List<Chara>,
    val isAvailableLeave: Boolean,
    val myself: VillageParticipantView?
) {
    constructor(
        situation: VillageParticipateSituation,
        village: Village,
        players: Players,
        charas: Charas
    ) : this(
        isParticipating = situation.isParticipating,
        isAvailableParticipate = situation.isAvailableParticipate,
        isAvailableSpectate = situation.isAvailableSpectate,
        selectableCharaList = situation.selectableCharaList,
        isAvailableLeave = situation.isAvailableLeave,
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
