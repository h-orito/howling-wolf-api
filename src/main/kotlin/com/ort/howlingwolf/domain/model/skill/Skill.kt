package com.ort.howlingwolf.domain.model.skill

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.ability.Abilities
import com.ort.howlingwolf.domain.model.ability.Ability
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.message.MessageType

data class Skill(
    val code: String,
    val name: String,
    val shortName: String,
    val winJudgeCamp: Camp,
    val abilityList: List<Ability>,
    val manualAbilityList: List<Ability>,
    val isDivineResultWolf: Boolean,
    val isPsychicResultWolf: Boolean,
    val sayableSkillMessageTypeList: List<MessageType>,
    val viewableSkillMessageTypeList: List<MessageType>,
    val countCamp: Camp?,
    val description: String
) {

    constructor(
        cdefSkill: CDef.Skill
    ) : this(
        code = cdefSkill.code(),
        name = cdefSkill.alias(),
        shortName = cdefSkill.shortName(),
        winJudgeCamp = Camp(CDef.Camp.codeOf(cdefSkill.campCode())),
        abilityList = Companion.getAbilities(cdefSkill).list,
        manualAbilityList = getManualAbilities(cdefSkill).list,
        isDivineResultWolf = cdefSkill.isDivineResultWolf,
        isPsychicResultWolf = cdefSkill.isPsychicResultWolf,
        sayableSkillMessageTypeList = getSayableMessageTypeList(cdefSkill),
        viewableSkillMessageTypeList = getViewableMessageTypeList(cdefSkill),
        countCamp = getCountCamp(cdefSkill),
        description = cdefSkill.description()
    )

    companion object {

        val skillRequestSomeoneList = listOf(CDef.Skill.おまかせ)
        private val skillAbilityTypeListMap = mapOf(
            CDef.Skill.人狼 to listOf(CDef.AbilityType.襲撃),
            CDef.Skill.占い師 to listOf(CDef.AbilityType.占い),
            CDef.Skill.狩人 to listOf(CDef.AbilityType.護衛)
        )

        // 説明書専用
        private val skillAbilityListMapForManual = mapOf(
            CDef.Skill.人狼 to listOf(Ability(CDef.AbilityType.襲撃)),
            CDef.Skill.占い師 to listOf(Ability(CDef.AbilityType.占い)),
            CDef.Skill.狩人 to listOf(Ability(CDef.AbilityType.護衛)),
            CDef.Skill.霊能者 to listOf(Ability("PSYCHIC", "霊視"))
        )

        fun skillByShortName(shortName: String): Skill? {
            val cdefSkill: CDef.Skill = CDef.Skill.listAll().firstOrNull {
                it.shortName() == shortName
            } ?: return null
            return Skill(cdefSkill)
        }

        fun getAbilities(cdefSkill: CDef.Skill): Abilities {
            val cdefAbilityList = skillAbilityTypeListMap[cdefSkill] ?: return Abilities(listOf())
            return Abilities(cdefAbilityList.map { Ability(it) })
        }

        fun getManualAbilities(cdefSkill: CDef.Skill): Abilities {
            return Abilities(skillAbilityListMapForManual[cdefSkill] ?: listOf())
        }

        fun getSayableMessageTypeList(cdefSkill: CDef.Skill): List<MessageType> {
            val list = mutableListOf<MessageType>()
            // 囁き
            if (cdefSkill.isAvailableWerewolfSay) list.add(MessageType(CDef.MessageType.人狼の囁き))

            return list
        }

        fun getViewableMessageTypeList(cdefSkill: CDef.Skill): List<MessageType> {
            val list = mutableListOf<MessageType>()
            // 囁き
            if (cdefSkill.isViewableWerewolfSay) list.add(MessageType(CDef.MessageType.人狼の囁き))

            return list
        }

        private fun getCountCamp(cdefSkill: CDef.Skill): Camp? {
            // TODO 妖狐実装時に「なし」になりえる
            return if (cdefSkill.isCountWolf) return Camp(CDef.Camp.人狼陣営)
            else Camp(CDef.Camp.村人陣営)
        }
    }

    fun getAbilities(): Abilities {
        val cdefSkill = CDef.Skill.codeOf(code) ?: return Abilities(listOf())
        return Companion.getAbilities(cdefSkill)
    }

    fun toCdef(): CDef.Skill = CDef.Skill.codeOf(code)
}