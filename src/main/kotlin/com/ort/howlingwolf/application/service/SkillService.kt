package com.ort.howlingwolf.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.Skills
import org.springframework.stereotype.Service

@Service
class SkillService {

    fun findSkills(): Skills {
        return Skills(
            CDef.Skill.listAll().filterNot {
                it.isSomeoneSkill
            }.sortedBy {
                it.order()
            }.map { Skill(it) }
        )
    }
}
