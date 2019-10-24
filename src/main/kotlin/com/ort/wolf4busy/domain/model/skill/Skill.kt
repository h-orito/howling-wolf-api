package com.ort.wolf4busy.domain.model.skill

import com.ort.dbflute.allcommon.CDef

data class Skill(
    val code: String,
    val name: String
) {
    companion object {

        val skillRequestSomeoneList =
            listOf(CDef.Skill.おまかせ, CDef.Skill.おまかせ村人陣営, CDef.Skill.おまかせ人狼陣営, CDef.Skill.おまかせ人外, CDef.Skill.おまかせ役職窓あり)

        fun skillByShortName(shortName: String): Skill? {
            val cdefSkill: CDef.Skill? = CDef.Skill.listAll().first {
                it.shortName() == shortName
            }
            cdefSkill ?: return null
            return Skill(
                code = cdefSkill.code(),
                name = cdefSkill.name
            )
        }
    }
}