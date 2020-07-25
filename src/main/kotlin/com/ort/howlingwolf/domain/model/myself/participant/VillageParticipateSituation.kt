package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageParticipateSituation(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val selectableCharaList: List<Chara>,
    val isAvailableLeave: Boolean,
    val myself: VillageParticipant?
)