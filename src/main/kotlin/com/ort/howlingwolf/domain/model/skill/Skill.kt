package com.ort.howlingwolf.domain.model.skill

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.ability.Abilities
import com.ort.howlingwolf.domain.model.ability.Ability

data class Skill(
    val code: String,
    val name: String,
    val description: String
) {

    constructor(
        cdefSkill: CDef.Skill
    ) : this(
        code = cdefSkill.code(),
        name = cdefSkill.alias(),
        description = cdefSkill.description()
    )

    companion object {

        val skillRequestSomeoneList = listOf(CDef.Skill.おまかせ)
        private val skillAbilityTypeListMap = mapOf(
            CDef.Skill.人狼 to listOf(CDef.AbilityType.襲撃),
            CDef.Skill.占い師 to listOf(CDef.AbilityType.占い),
            CDef.Skill.狩人 to listOf(CDef.AbilityType.護衛)
        )

        fun skillByShortName(shortName: String): Skill? {
            val cdefSkill: CDef.Skill = CDef.Skill.listAll().firstOrNull {
                it.shortName() == shortName
            } ?: return null
            return Skill(cdefSkill)
        }
    }

    fun getAbilities(): Abilities {
        val cdefSkill = CDef.Skill.codeOf(code) ?: return Abilities(listOf())
        val cdefAbilityList = skillAbilityTypeListMap[cdefSkill] ?: return Abilities(listOf())
        return Abilities(cdefAbilityList.map { Ability(it) })
    }

    fun toCdef(): CDef.Skill = CDef.Skill.codeOf(code)
}