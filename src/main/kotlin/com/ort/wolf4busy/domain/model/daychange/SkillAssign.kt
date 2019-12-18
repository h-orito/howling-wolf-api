package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants

object SkillAssign {
    fun assign(participants: VillageParticipants, skillPersonCountMap: Map<Skill, Int>, dummyChara: VillageParticipant): VillageParticipants {
        // TODO 存在しない役職を自動変更

        // ダミー配役
        var changedParticipants = participants.assignSkill(dummyChara.id, Skill(CDef.Skill.村人))

        // 第1希望で役職希望した人を割り当て
        changedParticipants = assignFirstSpecifyRequest(changedParticipants, skillPersonCountMap)

        // 第2希望で役職希望した人を割り当て
        changedParticipants = assignSecondSpecifyRequest(changedParticipants, skillPersonCountMap)

        return changedParticipants
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun assignFirstSpecifyRequest(participants: VillageParticipants, skillPersonCountMap: Map<Skill, Int>): VillageParticipants {
        var changedParticipants = participants.copy()
        for ((skill, capacity) in skillPersonCountMap.entries) {
            // この役職を希望していてまだ割り当たってない人
            var requestPlayerList = changedParticipants.memberList.filter {
                it.skillRequest.first.code == skill.code && it.skill == null
            }
            // 希望している人がいない
            if (requestPlayerList.isEmpty()) continue

            // 空いている枠数
            val left = capacity - changedParticipants.memberList.count { it.skill?.code == skill.code }
            // もう空きがない
            if (left <= 0) continue

            // 空いている人数まで割り当てる
            var count = 0
            for (requestPlayer in requestPlayerList.shuffled()) {
                if (count >= left) break
                changedParticipants.assignSkill(requestPlayer.id, skill)
                count++
            }
        }
        return changedParticipants
    }

    private fun assignSecondSpecifyRequest(participants: VillageParticipants, skillPersonCountMap: Map<Skill, Int>): VillageParticipants {
        var changedParticipants = participants.copy()
        for ((skill, capacity) in skillPersonCountMap.entries) {
            // この役職を希望していてまだ割り当たってない人
            var requestPlayerList = changedParticipants.memberList.filter {
                it.skillRequest.second.code == skill.code && it.skill == null
            }
            // 希望している人がいない
            if (requestPlayerList.isEmpty()) continue

            // 空いている枠数
            val left = capacity - changedParticipants.memberList.count { it.skill?.code == skill.code }
            // もう空きがない
            if (left <= 0) continue

            // 空いている人数まで割り当てる
            var count = 0
            for (requestPlayer in requestPlayerList.shuffled()) {
                if (count >= left) break
                changedParticipants.assignSkill(requestPlayer.id, skill)
                count++
            }
        }
        return changedParticipants
    }

}
