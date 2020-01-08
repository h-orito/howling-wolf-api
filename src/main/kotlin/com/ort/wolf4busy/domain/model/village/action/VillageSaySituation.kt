package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.CharaFace
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.*
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

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
        latestDayMessageList: List<Message> // TODO これ通常発言だけになってない？
    ) : this(
        isAvailableSay = isAvailableSay(village, participant),
        selectableMessageTypeList = getSelectableMessageTypeList(village, participant, latestDayMessageList),
        selectableFaceTypeList = getSelectableFaceTypeList(village, participant, charas),
        defaultMessageType = detectDefaultMessageType(
            isAvailableSay(village, participant),
            getSelectableMessageTypeList(village, participant, latestDayMessageList)
        )
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
        private fun isAvailableSay(village: Village, participant: VillageParticipant?): Boolean {
            // 参加していない場合はNG
            participant ?: return false
            // 突然死した場合はエピローグ以外NG
            if (participant.dead?.toCdef() == CDef.DeadReason.突然 //
                && village.status.toCdef() != CDef.VillageStatus.エピローグ
            ) {
                return false
            }

            return true
        }

        private fun getSelectableMessageTypeList(
            village: Village,
            participant: VillageParticipant?,
            latestDayMessageList: List<Message>
        ): List<VillageSayMessageTypeSituation> {
            if (participant == null || isAvailableSay(village, participant)) return listOf()

            val selectableMessageTypeList: MutableList<VillageSayMessageTypeSituation> = mutableListOf()
            if (NormalSay.isSayable(village, participant)) {
                selectableMessageTypeList.add(
                    VillageSayMessageTypeSituation(
                        village,
                        participant,
                        latestDayMessageList,
                        CDef.MessageType.通常発言
                    )
                )
            }
            if (WerewolfSay.isSayable(village, participant)) {
                selectableMessageTypeList.add(
                    VillageSayMessageTypeSituation(
                        village,
                        participant,
                        latestDayMessageList,
                        CDef.MessageType.人狼の囁き
                    )
                )
            }
            if (GraveSay.isSayable(village, participant)) {
                selectableMessageTypeList.add(
                    VillageSayMessageTypeSituation(
                        village,
                        participant,
                        latestDayMessageList,
                        CDef.MessageType.死者の呻き
                    )
                )
            }
            if (MonologueSay.isSayable(village, participant)) {
                selectableMessageTypeList.add(
                    VillageSayMessageTypeSituation(
                        village,
                        participant,
                        latestDayMessageList,
                        CDef.MessageType.独り言
                    )
                )
            }
            if (SpectateSay.isSayable(village, participant)) {
                selectableMessageTypeList.add(
                    VillageSayMessageTypeSituation(
                        village,
                        participant,
                        latestDayMessageList,
                        CDef.MessageType.見学発言
                    )
                )
            }

            return selectableMessageTypeList
        }

        private fun getSelectableFaceTypeList(village: Village, participant: VillageParticipant?, charas: Charas): List<CharaFace> {
            if (participant == null) return listOf()

            val charaId: Int = if (participant.isSpectator) {
                village.spectator.memberList.first { it.id == participant.id }.charaId
            } else {
                village.participant.memberList.first { it.id == participant.id }.charaId
            }
            return charas.list.first { it.id == charaId }.faceList
        }

        private fun detectDefaultMessageType(
            availableSay: Boolean,
            selectableMessageTypeList: List<VillageSayMessageTypeSituation>
        ): MessageType? {
            if (!availableSay || selectableMessageTypeList.isEmpty()) return null
            val selectableMessageTypeList = selectableMessageTypeList.map { it.messageType.toCdef() }

            defaultMessageTypeOrder.forEach { cdefMessageType ->
                if (selectableMessageTypeList.contains(cdefMessageType)) return MessageType(cdefMessageType)
            }
            return null
        }
    }
}
