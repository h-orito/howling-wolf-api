package com.ort.wolf4busy.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.VillageDay

data class VillageParticipant(
    val id: Int,
    val charaId: Int,
    val playerId: Int?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val isGone: Boolean,
    val skill: Skill?,
    val skillRequest: SkillRequest,
    val isWin: Boolean?
) {

    fun isAlive(): Boolean = dead == null

    fun gone(): VillageParticipant = this.copy(isGone = true)

    fun suddenlyDeath(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.突然, villageDay))

    fun execute(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.処刑, villageDay))

    fun attack(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.襲撃, villageDay))

    fun assignSkill(skill: Skill): VillageParticipant = this.copy(skill = skill)

    fun winLose(cdefWinCamp: CDef.Camp): VillageParticipant = this.copy(isWin = skill?.toCdef()?.campCode() == cdefWinCamp.code())

    fun existsDifference(participant: VillageParticipant): Boolean {
        if (id != participant.id) return true
        if (charaId != participant.charaId) return true
        if (playerId != participant.playerId) return true
        if (dead?.code != participant.dead?.code) return true
        if (isSpectator != participant.isSpectator) return true
        if (isGone != participant.isGone) return true
        if (skill?.code != participant.skill?.code) return true
        if (skillRequest.first.code != participant.skillRequest.first.code) return true
        if (skillRequest.second.code != participant.skillRequest.second.code) return true
        return false
    }

    // ===================================================================================
    //                                                                                権限
    //                                                                        ============
    // 役職希望可能か
    fun isAvailableSkillRequest(): Boolean = true // 制限なし

    // コミット可能か
    fun isAvailableCommit(dummyParticipantId: Int): Boolean {
        // 参加していなかったり死亡していたらNG
        if (isSpectator) return false
        if (!isAlive()) return false
        // ダミーはコミットできない
        if (id == dummyParticipantId) return false

        return true
    }

    // 発言可能か
    fun isAvailableSay(isEpilogue: Boolean): Boolean {
        // 突然死した場合はエピローグ以外NG
        if (dead?.toCdef() == CDef.DeadReason.突然 && !isEpilogue) return false
        return true
    }

    fun isSayableNormalSay(isEpilogue: Boolean): Boolean {
        // 見学は不可
        if (isSpectator) return false
        // エピローグ以外で死亡している場合は不可
        if (!isAlive() && !isEpilogue) return false

        return true
    }
}