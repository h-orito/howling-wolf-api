package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class VillageVoteSituation(
    val isAvailableVote: Boolean,
    val targetList: List<VillageParticipant>,
    val target: VillageParticipant?
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        votes: VillageVotes
    ) : this(
        isAvailableVote = isAvailableVote(
            village,
            participant
        ),
        targetList = getSelectableTargetList(
            village,
            participant
        ),
        target = getTarget(village, participant, votes)

    )

    companion object {

        private fun isAvailableVote(village: Village, participant: VillageParticipant?): Boolean {
            participant ?: return false
            if (!participant.isAlive()) return false
            if (participant.isSpectator) return false
            if (!village.status.isProgress()) return false
            return village.day.latestDay().day > 1
        }

        private fun getSelectableTargetList(village: Village, participant: VillageParticipant?): List<VillageParticipant> {
            if (!isAvailableVote(village, participant)) return listOf()
            return village.participant.memberList.filter { it.isAlive() }
        }

        private fun getTarget(village: Village, participant: VillageParticipant?, votes: VillageVotes): VillageParticipant? {
            if (!isAvailableVote(village, participant)) return null
            val voteTargetParticipantId = votes.list.find {
                it.villageDayId == village.day.latestDay().id
                    && it.myselfId == participant!!.id
            }?.targetId ?: return null
            return village.participant.member(voteTargetParticipantId)
        }

    }

    fun assertVote(targetId: Int) {
        if (!isAvailableVote || targetList.none { it.id == targetId }) throw Wolf4busyBusinessException("投票できません")
    }
}
