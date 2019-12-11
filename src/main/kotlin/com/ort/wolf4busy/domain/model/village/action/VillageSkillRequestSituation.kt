package com.ort.wolf4busy.domain.model.village.action

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

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
            skillList.addAll(Skill.skillRequestSomeoneList.map { Skill(it.code(), it.name) })
            return skillList.sortedBy { CDef.Skill.codeOf(it.code).order() }
        }
    }
}
