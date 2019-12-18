package com.ort.wolf4busy.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.Village

data class VillageParticipant(
    val id: Int,
    val charaId: Int,
    val playerId: Int?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val isGone: Boolean,
    val skill: Skill?
) {

    fun alive(): Boolean {
        return dead == null
    }

    // ===================================================================================
    //                                                                                 say
    //                                                                        ============
    /**
     * @param village village
     * @return 通常発言可能か
     */
    fun isAvailableNormalSay(village: Village): Boolean {
        // エピローグ以外で死亡していたら不可
        if (dead != null && village.status.code != CDef.VillageStatus.エピローグ.code()) return false
        // 見学は不可
        return !isSpectator
    }

    /**
     * @param village village
     * @return 人狼発言可能か
     */
    fun isAvailableWerewolfSay(village: Village): Boolean {
        // 囁ける役職以外は不可
        if (skill == null || !CDef.Skill.codeOf(skill.code).isAvailableWerewolfSay) return false
        // 死亡していたら不可
        if (dead != null) return false
        // 進行中以外は不可
        return village.status.code == CDef.VillageStatus.進行中.code()
    }

    /**
     * @param village village
     * @return 墓下発言可能か
     */
    fun isAvailableGraveSay(village: Village): Boolean {
        // 死亡していなかったら不可
        if (dead == null) return false
        // 進行中以外は不可
        return village.status.code == CDef.VillageStatus.進行中.code()
    }

    /**
     * @param village village
     * @return 見学発言可能か
     */
    fun isAvailableSpectateSay(village: Village): Boolean {
        return isSpectator
    }

    /**
     * @param village village
     * @return 独り言可能か
     */
    fun isAvailableMonologueSay(village: Village): Boolean {
        // いつでも可能
        return true
    }
}