package com.ort.howlingwolf.domain.model.skill

import com.ort.dbflute.allcommon.CDef

data class SkillRequest(
    val first: Skill,
    val second: Skill
) {
    constructor(
        first: CDef.Skill,
        second: CDef.Skill
    ) : this(
        first = Skill(first),
        second = Skill(second)
    )
}