package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.skill.Skill

data class VillageParticipants(
    val count: Int,
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
}