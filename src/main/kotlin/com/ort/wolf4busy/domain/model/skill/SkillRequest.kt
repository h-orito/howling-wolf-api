package com.ort.wolf4busy.domain.model.skill

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class SkillRequest(
    val first: Skill,
    val second: Skill
) {

    companion object {

        /**
         * @param village village
         * @param participant 参加者
         * @return 役職希望可能か
         */
        fun isAvailableSkillRequest(
            village: Village,
            participant: VillageParticipant?
        ): Boolean {
            // 村として可能か
            if (!village.isAvailableSkillRequest()) return false
            // 参加者として可能か
            participant ?: return false
            return participant.isAvailableSkillRequest()
        }

        /**
         * 役職希望変更チェック
         * @param village village
         * @param participant 参加者
         * @param firstRequestSkill 第1役職希望
         * @param secondRequestSkill 第2役職希望
         */
        fun assertSkillRequest(
            village: Village,
            participant: VillageParticipant?,
            firstRequestSkill: String,
            secondRequestSkill: String
        ) {
            if (!isAvailableSkillRequest(village, participant)) throw Wolf4busyBusinessException("役職希望変更できません")
            val first = CDef.Skill.codeOf(firstRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
            val second = CDef.Skill.codeOf(secondRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
            village.assertSkillRequest(first, second)
        }
    }
}