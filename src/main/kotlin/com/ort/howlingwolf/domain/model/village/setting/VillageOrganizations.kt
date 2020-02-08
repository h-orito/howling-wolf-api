package com.ort.howlingwolf.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.skill.Skill

data class VillageOrganizations(
    val organization: Map<Int, String> = defaultOrganization()
) {
    companion object {
        operator fun invoke(
            organization: Map<Int, String>?
        ): VillageOrganizations {
            requireNotNull(organization)
            return VillageOrganizations(organization = organization)
        }

        private fun defaultOrganization(): Map<Int, String> {
            return mapOf(
                5 to "狼占村村村",
                6 to "狼占村村村村",
                7 to "狼狼占村村村村",
                8 to "狼狼占霊村村村村",
                9 to "狼狼占霊村村村村村",
                10 to "狼狼占霊村村村村村村",
                11 to "狼狼狂占霊狩村村村村村",
                12 to "狼狼狂占霊狩村村村村村村",
                13 to "狼狼狼狂占霊狩村村村村村村",
                14 to "狼狼狼狂占霊狩村村村村村村村",
                15 to "狼狼狼狂占霊狩村村村村村村村村",
                16 to "狼狼狼狂占霊狩村村村村村村村村村"
            )
        }
    }

    fun mapToSkillCount(personNum: Int): Map<Skill, Int> {
        val org = checkNotNull(organization[personNum])
        val map = mutableMapOf<Skill, Int>()
        CDef.Skill.listAll().forEach { cdefSkill ->
            val skillShortName = cdefSkill.shortName()
            val count = org.chunked(1).count { char -> char == skillShortName }
            map[Skill(cdefSkill)] = count
        }
        return map
    }

    fun allRequestableSkillList(): List<Skill> {
        val skillList: MutableList<Skill> = organization
            .map { org -> org.value } // 人数ごとの編成を
            .flatMap { org -> org.split("") } // 全部まとめて1文字ずつに
            .mapNotNull { orgChar -> Skill.skillByShortName(orgChar) } // 略称から役職を取得して
            .distinct().toMutableList() // 重複削除
        skillList.addAll(Skill.skillRequestSomeoneList.map { Skill(it) })
        return skillList.sortedBy { it.toCdef().order() }
    }

    fun existsDifference(organizations: VillageOrganizations): Boolean {
        if (organization.size != organizations.organization.size) return true
        organization.forEach { (count, org) ->
            if (!organizations.organization.containsKey(count)) return true
            if (org != organizations.organization[count]) return true
        }
        return false
    }

    override fun toString(): String {
        val sortedMap = this.organization.toSortedMap()
        return sortedMap.map { it.value }.joinToString(separator = "\n")
    }
}