package com.ort.wolf4busy.api.view.myself.participant

import com.ort.wolf4busy.domain.model.charachip.CharaFace
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.myself.participant.VillageSaySituation
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village

data class VillageSaySituationView(
    val isAvailableSay: Boolean,
    val selectableMessageTypeList: List<VillageSayMessageTypeSituationView>,
    val selectableFaceTypeList: List<CharaFace>,
    val defaultMessageType: MessageType?
) {

    constructor(
        situation: VillageSaySituation,
        village: Village,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        isAvailableSay = situation.isAvailableSay,
        selectableMessageTypeList = situation.selectableMessageTypeList.map {
            VillageSayMessageTypeSituationView(
                situation = it,
                village = village,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        },
        selectableFaceTypeList = situation.selectableFaceTypeList,
        defaultMessageType = situation.defaultMessageType
    )
}
