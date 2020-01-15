package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.CharaFace
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.*
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

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
        selectableMessageTypeList = getSelectableMessageTypeList(
            village,
            participant,
            latestDayMessageList
        ),
        selectableFaceTypeList = getSelectableFaceTypeList(
            participant,
            charas
        ),
        defaultMessageType = detectDefaultMessageType(
            Say.isAvailableSay(village, participant),
            getSelectableMessageTypeList(
                village,
                participant,
                latestDayMessageList
            )
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
        private fun getSelectableMessageTypeList(
            village: Village,
            participant: VillageParticipant?,
            latestDayMessageList: List<Message>
        ): List<VillageSayMessageTypeSituation> {
            if (!Say.isAvailableSay(village, participant)) return listOf()

            val selectableMessageTypeList: MutableList<VillageSayMessageTypeSituation> = mutableListOf()
            if (NormalSay.isSayable(village, participant!!)) {
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

    fun assertSay(
        messageContent: MessageContent
    ) {
        if (!isAvailableSay) throw Wolf4busyBusinessException("発言できません")
        val available = selectableMessageTypeList.find {
            it.messageType.code == messageContent.type.code
        } ?: throw Wolf4busyBusinessException("発言できません")
        if (available.restrict.isRestricted) {
            // 回数
            if (available.restrict.remainingCount!! <= 0) throw Wolf4busyBusinessException("発言できません")
            // 文字数
            messageContent.assertMessageLength(available.restrict.maxLength!!)
        }
        if (selectableFaceTypeList.none { it.type == messageContent.faceCode }) throw Wolf4busyBusinessException("発言できません")
    }
}
