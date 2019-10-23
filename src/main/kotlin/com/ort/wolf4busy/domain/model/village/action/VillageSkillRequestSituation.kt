package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.skill.Skill

data class VillageSkillRequestSituation(
    val isAvailableSkillRequest: Boolean,
    val selectableSkillList: List<Skill> = listOf(),
    val firstRequestSkill: Skill?,
    val secondRequestSkill: Skill?
) {
}
