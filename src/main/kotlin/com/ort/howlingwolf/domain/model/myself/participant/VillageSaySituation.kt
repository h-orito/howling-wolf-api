package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.CharaFace
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.*
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageSaySituation(
    val isAvailableSay: Boolean,
    val selectableMessageTypeList: List<VillageSayMessageTypeSituation> = listOf(),
    val selectableFaceTypeList: List<CharaFace>,
    val defaultMessageType: MessageType?
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        charas: Charas,
        latestDayMessageList: List<Message>
    ) : this(
        isAvailableSay = Say.isAvailableSay(village, participant),
        selectableMessageTypeList = getSelectableMessageTypeList(village, participant, latestDayMessageList),
        selectableFaceTypeList = getSelectableFaceTypeList(participant, charas),
        defaultMessageType = detectDefaultMessageType(Say.isAvailableSay(village, participant), getSelectableMessageTypeList(village, participant, latestDayMessageList))
    )

    companion object {

        private val defaultMessageTypeOrder = listOf(
            CDef.MessageType.人狼の囁き,
            CDef.MessageType.共鳴発言,
            CDef.MessageType.通常発言,
            CDef.MessageType.死者の呻き,
            CDef.MessageType.見学発言,
            CDef.MessageType.独り言
        )

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        private fun getSelectableMessageTypeList(
            village: Village,
            participant: VillageParticipant?,
            latestDayMessageList: List<Message>
        ): List<VillageSayMessageTypeSituation> {
            if (!Say.isAvailableSay(village, participant)) return listOf()

            val list: MutableList<VillageSayMessageTypeSituation> = mutableListOf()

            if (NormalSay.isSayable(village, participant!!)) list.add(VillageSayMessageTypeSituation(village, latestDayMessageList, CDef.MessageType.通常発言))
            if (WerewolfSay.isSayable(village, participant)) list.add(VillageSayMessageTypeSituation(village, latestDayMessageList, CDef.MessageType.人狼の囁き))
            if (GraveSay.isSayable(village, participant)) list.add(VillageSayMessageTypeSituation(village, latestDayMessageList, CDef.MessageType.死者の呻き))
            if (MonologueSay.isSayable(village, participant)) list.add(VillageSayMessageTypeSituation(village, latestDayMessageList, CDef.MessageType.独り言))
            if (SpectateSay.isSayable(village, participant)) list.add(VillageSayMessageTypeSituation(village, latestDayMessageList, CDef.MessageType.見学発言))

            return list
        }

        private fun getSelectableFaceTypeList(participant: VillageParticipant?, charas: Charas): List<CharaFace> {
            if (participant == null) return listOf()
            return charas.chara(participant.charaId).faceList
        }

        private fun detectDefaultMessageType(
            availableSay: Boolean,
            selectableMessageTypeList: List<VillageSayMessageTypeSituation>
        ): MessageType? {
            if (!availableSay || selectableMessageTypeList.isEmpty()) return null
            val selectableMessageTypeCdefList = selectableMessageTypeList.map { it.messageType.toCdef() }

            defaultMessageTypeOrder.forEach { cdefMessageType ->
                if (selectableMessageTypeCdefList.contains(cdefMessageType)) return MessageType(cdefMessageType)
            }
            return null
        }
    }
}
