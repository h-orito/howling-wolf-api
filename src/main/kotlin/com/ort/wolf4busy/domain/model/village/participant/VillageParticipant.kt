package com.ort.wolf4busy.domain.model.village.participant

import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest

data class VillageParticipant(
    val id: Int,
    val charaId: Int,
    val playerId: Int?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val isGone: Boolean,
    val skill: Skill?,
    val skillRequest: SkillRequest
) {

    fun isAlive(): Boolean {
        return dead == null
    }

    fun gone(): VillageParticipant {
        return this.copy(isGone = true)
    }

    fun assignSkill(skill: Skill): VillageParticipant {
        return this.copy(skill = skill)
    }
}