package com.ort.howlingwolf.api.view.myself.participant

import com.ort.howlingwolf.domain.model.charachip.CharaFace
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.myself.participant.VillageSaySituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

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
