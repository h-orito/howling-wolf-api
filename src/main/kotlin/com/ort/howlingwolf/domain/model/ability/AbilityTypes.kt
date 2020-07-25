package com.ort.howlingwolf.domain.model.ability

import com.ort.howlingwolf.domain.model.skill.Skill

data class AbilityTypes(
    val list: List<AbilityType>
) {
    constructor(
        skill: Skill
    ) : this(
        list = skill.getAbilities().list
    )
}
