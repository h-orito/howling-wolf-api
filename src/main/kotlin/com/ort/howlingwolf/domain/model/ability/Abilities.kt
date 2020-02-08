package com.ort.howlingwolf.domain.model.ability

import com.ort.howlingwolf.domain.model.skill.Skill

data class Abilities(
    val list: List<Ability>
) {
    constructor(
        skill: Skill
    ) : this(
        list = skill.getAbilities().list
    )
}
