package com.ort.howlingwolf.domain.model.skill

import com.ort.dbflute.allcommon.CDef

data class Skills(
    val list: List<Skill>
) {
    companion object {

        val all: Skills = Skills(
            list = CDef.Skill.listAll().map { it.toModel() }
        ).filterNotSomeone().sorted()

        val wolfs: Skills = Skills(
            list = CDef.Skill.listOfAvailableWerewolfSay().map { it.toModel() }
        ).sorted()

        val masons: Skills = Skills(
            list = CDef.Skill.listOfRecognizableEachMason().map { it.toModel() }
        ).sorted()

        val foxs: Skills = Skills(list = listOf(CDef.Skill.妖狐.toModel()))
    }

    fun filterNotSomeone(): Skills = copy(list.filterNot { it.toCdef().isSomeoneSkill })

    fun sorted(): Skills = copy(list.sortedBy { it.toCdef().order().toInt() })
}