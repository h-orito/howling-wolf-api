package com.ort.wolf4busy.domain.model.ability

import com.ort.wolf4busy.domain.model.skill.Skill

data class Abilities(
    val list: List<Ability>
) {
    constructor(
        skill: Skill
    ) : this(
        list = skill.getAbilities().list
    )
}
