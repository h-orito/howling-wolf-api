package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class VillageSkillRequestSituation(
    val isAvailableSkillRequest: Boolean,
    val selectableSkillList: List<Skill> = listOf(),
    val skillRequest: SkillRequest?
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        skillRequest: SkillRequest?
    ) : this(
        isAvailableSkillRequest = isAvailableSkillRequest(village, participant),
        selectableSkillList = findSelectableSkillList(village),
        skillRequest = skillRequest
    )

    companion object {

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        private fun isAvailableSkillRequest(village: Village, participant: VillageParticipant?): Boolean {
            // 参加していない
            participant ?: return false
            // プロローグでない
            if (!village.status.isPrologue()) return false
            // 役職希望設定
            return village.setting.rules.availableSkillRequest
        }

        private fun findSelectableSkillList(village: Village): List<Skill> {
            val skillList: MutableList<Skill> = village.setting.organizations.organization
                .map { org -> org.value } // 人数ごとの編成を
                .flatMap { org -> org.split("") } // 全部まとめて1文字ずつに
                .mapNotNull { orgChar -> Skill.skillByShortName(orgChar) } // 略称から役職を取得して
                .distinct().toMutableList() // 重複削除
            skillList.addAll(Skill.skillRequestSomeoneList.map { Skill(it) })
            return skillList.sortedBy { it.toCdef().order() }
        }
    }

    fun assertSkillRequest(firstRequestSkill: String, secondRequestSkill: String) {
        if (!isAvailableSkillRequest) throw Wolf4busyBusinessException("役職希望変更できません")
        val first = CDef.Skill.codeOf(firstRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
        val second = CDef.Skill.codeOf(secondRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
        if (selectableSkillList.none { it.code == first.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
        if (selectableSkillList.none { it.code == second.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
    }
}
