package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts

data class VillageComingOutSituation(
    val isAvailableComingOut: Boolean,
    val currentComingOuts: ComingOuts,
    val selectableSkillList: List<Skill>
)
