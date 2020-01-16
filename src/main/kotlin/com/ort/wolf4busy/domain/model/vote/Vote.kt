package com.ort.wolf4busy.domain.model.vote

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

object Vote {

    fun isAvailableVote(village: Village, participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        if (!participant.isAvailableVote()) return false
        // 村として可能か
        return village.isAvailableVote()
    }

    fun getSelectableTargetList(village: Village, participant: VillageParticipant?): List<VillageParticipant> {
        if (!isAvailableVote(village, participant)) return listOf()
        return village.participant.memberList.filter { it.isAlive() }
    }

    fun getSelectingTarget(village: Village, participant: VillageParticipant?, votes: VillageVotes): VillageParticipant? {
        if (!isAvailableVote(village, participant)) return null
        val voteTargetParticipantId = votes.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.myselfId == participant!!.id
        }?.targetId ?: return null
        return village.participant.member(voteTargetParticipantId)
    }

    fun assertVote(village: Village, participant: VillageParticipant?, targetId: Int) {
        if (!isAvailableVote(village, participant)) throw Wolf4busyBusinessException("投票できません")
        if (getSelectableTargetList(village, participant).none { it.id == targetId }) throw Wolf4busyBusinessException("投票できません")
    }
}