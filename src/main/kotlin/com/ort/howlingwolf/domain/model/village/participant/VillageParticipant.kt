package com.ort.howlingwolf.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.VillageDay

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
    // ===================================================================================
    //                                                                                read
    //                                                                           =========
    // 生存しているか
    fun isAlive(): Boolean = dead == null

    // 差分有無
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
    //                                                                              update
    //                                                                           =========
    // 退村
    fun gone(): VillageParticipant = this.copy(isGone = true)

    // 突然死
    fun suddenlyDeath(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.突然, villageDay))

    // 処刑
    fun execute(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.処刑, villageDay))

    // 襲撃
    fun attack(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.襲撃, villageDay))

    // 呪殺
    fun divineKill(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.呪殺, villageDay))

    // 役職割り当て
    fun assignSkill(skill: Skill): VillageParticipant = this.copy(skill = skill)

    // 希望役職
    fun changeSkillRequest(first: CDef.Skill, second: CDef.Skill): VillageParticipant =
        this.copy(skillRequest = SkillRequest(Skill(first), Skill(second)))

    // 勝敗
    fun winLose(cdefWinCamp: CDef.Camp): VillageParticipant = this.copy(isWin = skill?.toCdef()?.campCode() == cdefWinCamp.code())

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
        // ダミーはOK
        if (playerId == 1) return true
        // 見学は不可
        if (isSpectator) return false
        // エピローグ以外で死亡している場合は不可
        if (!isAlive() && !isEpilogue) return false

        return true
    }

    fun isViewableWerewolfSay(): Boolean {
        return skill?.toCdef()?.isViewableWerewolfSay ?: false
    }

    fun isSayableWerewolfSay(): Boolean {
        // ダミーはOK
        if (playerId == 1) return true
        // 死亡していたら不可
        if (!isAlive()) return false
        // 囁ける役職でなければ不可
        return skill?.toCdef()?.isAvailableWerewolfSay ?: false
    }

    fun isViewableGraveSay(): Boolean {
        if (isSpectator) return true
        // 突然死以外で死亡している
        return !isAlive() && CDef.DeadReason.突然.code() != dead?.code
    }

    fun isSayableGraveSay(): Boolean {
        // ダミーはOK
        if (playerId == 1) return true
        // 死亡していなかったら不可
        if (isAlive()) return false
        // 見学は不可
        if (isSpectator) return false
        // 突然死は不可
        if (dead?.toCdef() == CDef.DeadReason.突然) return false
        return true
    }

    fun isViewableMonologueSay(): Boolean = true // 制約なし

    fun isSayableMonologueSay(): Boolean = true // 制約なし

    fun isViewableSpectateSay(): Boolean {
        // 見学は開放
        if (isSpectator) return true
        // 突然死以外で死亡している
        return !isAlive() && CDef.DeadReason.突然.code() != dead?.code
    }

    fun isSayableSpectateSay(): Boolean {
        // ダミーはOK
        if (playerId == 1) return true
        return isSpectator // 見学していなかったら不可
    }

    fun isViewableAttackMessage(): Boolean {
        // 生存していて囁き可能なら開放
        if (!isAlive()) return false
        return skill?.toCdef()?.isAvailableWerewolfSay ?: false
    }

    fun isViewableMasonMessage(): Boolean {
        // 生存していて共有職なら開放
        if (!isAlive()) return false
        return skill?.toCdef()?.isRecognizableEachMason ?: false
    }

    fun isViewablePsychicMessage(): Boolean {
        // 生存していて霊能者なら開放
        if (!isAlive()) return false
        return skill?.toCdef() == CDef.Skill.霊能者
    }

    fun isViewableSecretSay(): Boolean = true // 制約なし

    // 能力行使可能か
    fun canUseAbility(): Boolean = !isSpectator

    // 投票可能か
    fun isAvailableVote(): Boolean {
        if (!isAlive()) return false
        if (isSpectator) return false
        return true
    }
}