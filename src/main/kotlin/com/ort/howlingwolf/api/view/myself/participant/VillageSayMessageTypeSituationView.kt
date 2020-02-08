package com.ort.howlingwolf.api.view.myself.participant

import com.ort.howlingwolf.api.view.village.VillageParticipantView
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.myself.participant.VillageSayMessageTypeSituation
import com.ort.howlingwolf.domain.model.myself.participant.VillageSayRestrictSituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village

data class VillageSayMessageTypeSituationView(
    val messageType: MessageType,
    val restrict: VillageSayRestrictSituation,
    // 秘話用
    val targetList: List<VillageParticipantView>
) {
    constructor(
        situation: VillageSayMessageTypeSituation,
        village: Village,
        players: Players,
        charas: Charas,
        shouldHidePlayer: Boolean
    ) : this(
        messageType = situation.messageType,
        restrict = situation.restrict,
        targetList = situation.targetList.map {
            VillageParticipantView(
                village = village,
                villageParticipantId = it.id,
                players = players,
                charas = charas,
                shouldHidePlayer = shouldHidePlayer
            )
        }
    )

}
