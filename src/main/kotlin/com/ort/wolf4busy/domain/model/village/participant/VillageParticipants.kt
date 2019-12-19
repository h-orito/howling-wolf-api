package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.skill.Skill

data class VillageParticipants(
    val count: Int, // 退村した人は含まない
    val memberList: List<VillageParticipant> = listOf()
) {
    fun assignSkill(villageParticipantId: Int, skill: Skill): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == villageParticipantId) it.assignSkill(skill)
                else it.copy()
            }
        )
    }

    fun leave(participantId: Int): VillageParticipants {
        return this.copy(
            count = this.count - 1,
            memberList = this.memberList.map {
                if (it.id == participantId) it.copy(isGone = true) else it.copy()
            }
        )
    }

    fun aliveMemberList(): VillageParticipants {
        val aliveMembers = memberList.filter { it.isAlive() }
        return VillageParticipants(
            count = aliveMembers.size,
            memberList = aliveMembers
        )
    }

    fun findRandom(predicate: (VillageParticipant) -> Boolean): VillageParticipant? {
        return memberList.filter { predicate(it) }.shuffled().firstOrNull()
    }
}