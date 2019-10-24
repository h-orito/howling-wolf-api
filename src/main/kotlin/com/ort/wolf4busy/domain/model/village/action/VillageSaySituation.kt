package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.CharaFace
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageSaySituation(
    val isAvailableSay: Boolean,
    val selectableMessageTypeList: List<VillageSayMessageTypeSituation> = listOf(),
    val selectableFaceTypeList: List<CharaFace>
) {
    constructor(
        village: Village,
        participant: VillageParticipant?
    ) : this(
        isAvailableSay = isAvailableSay(village, participant),
        selectableMessageTypeList = getSelectableMessageTypeList(village, participant),
        selectableFaceTypeList = getSelectableFaceTypeList(village, participant)
    )

    companion object {

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        private fun isAvailableSay(village: Village, participant: VillageParticipant?): Boolean {
            // 参加していない場合はNG
            participant ?: return false
            // 突然死した場合はエピローグ以外NG
            if (participant.dead != null && CDef.DeadReason.codeOf(participant.dead.code) == CDef.DeadReason.突然
                && CDef.VillageStatus.codeOf(village.status.code) != CDef.VillageStatus.エピローグ
            ) {
                return false
            }

            return true
        }

        private fun getSelectableMessageTypeList(village: Village, participant: VillageParticipant?): List<VillageSayMessageTypeSituation> {
            if (participant == null || isAvailableSay(village, participant)) return listOf()

            val selectableMessageTypeList: MutableList<VillageSayMessageTypeSituation> = mutableListOf()
            if (participant.isAvailableNormalSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.通常発言))
            }
            if (participant.isAvailableWerewolfSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.人狼の囁き))
            }
            if (participant.isAvailableMasonSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.共鳴発言))
            }
            if (participant.isAvailableGraveSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.死者の呻き))
            }
            if (participant.isAvailableMonologueSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.独り言))
            }
            if (participant.isAvailableSpectateSay(village)) {
                selectableMessageTypeList.add(VillageSayMessageTypeSituation(village, participant, CDef.MessageType.見学発言))
            }

            return selectableMessageTypeList
        }

        private fun getSelectableFaceTypeList(village: Village, participant: VillageParticipant?): List<CharaFace> {
            if (participant == null) return listOf()
            return if (participant.isSpectator) {
                village.participant.memberList.find { it.id == participant.id }!!.chara!!.faceList
            } else {
                village.spectator.memberList.find { it.id == participant.id }!!.chara!!.faceList
            }
        }
    }
}
