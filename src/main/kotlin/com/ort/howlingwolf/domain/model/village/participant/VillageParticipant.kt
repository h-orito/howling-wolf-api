package com.ort.howlingwolf.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.VillageDay
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts

data class VillageParticipant(
    val id: Int,
    val charaId: Int,
    val playerId: Int?,
    val dead: Dead?,
    val isSpectator: Boolean,
    val isGone: Boolean,
    val skill: Skill?,
    val skillRequest: SkillRequest,
    val isWin: Boolean?,
    val comingOuts: ComingOuts,
    val accessInfos: List<AccessInfo>
) {
    // ===================================================================================
    //                                                                                read
    //                                                                           =========
    fun isAdmin(): Boolean = playerId == 1
    fun isAlive(): Boolean = dead == null
    fun isDead(): Boolean = !isAlive()
    fun isAvailableSkillRequest(): Boolean = true // 制限なし
    fun isAvailableCommit(dummyParticipantId: Int): Boolean = !isSpectator && isAlive() && id != dummyParticipantId
    fun isAvailableComingOut(): Boolean = !isSpectator && isAlive()
    fun isAvailableSay(isEpilogue: Boolean): Boolean = !isDead() || !dead!!.isSuddenly() || isEpilogue
    fun isSayableNormalSay(isEpilogue: Boolean): Boolean = isAdmin() || (!isSpectator && (isAlive() || isEpilogue))
    fun isViewableWerewolfSay(): Boolean = isAdmin() || skill?.isViewableWerewolfSay() ?: false
    fun isSayableWerewolfSay(): Boolean = isAdmin() || (isAlive() && skill?.isAvailableWerewolfSay() ?: false)
    fun isViewableGraveSay(): Boolean = isAdmin() || isSpectator || (isDead() && !dead!!.isSuddenly())
    fun isSayableGraveSay(): Boolean = isAdmin() || (!isSpectator && isDead() && !dead!!.isSuddenly())
    fun isViewableMonologueSay(): Boolean = isAdmin()
    fun isSayableMonologueSay(): Boolean = true
    fun isViewableSpectateSay(): Boolean = isAdmin() || isSpectator || (isDead() && !dead!!.isSuddenly())
    fun isSayableSpectateSay(): Boolean = isAdmin() || isSpectator
    fun isViewableAttackMessage(): Boolean = skill?.isAvailableWerewolfSay() ?: false
    fun isViewableFanaticMessage(): Boolean = skill?.canRecognizeWolf() ?: false
    fun isViewableMasonMessage(): Boolean = skill?.canRecognizeEachMason() ?: false
    fun isViewableFoxMessage(): Boolean = skill?.canRecognizeFoxs() ?: false
    fun isViewablePsychicMessage(): Boolean = skill?.hasPsychicAbility() ?: false
    fun isViewableSecretSay(): Boolean = isAdmin()
    fun isSayableSecretSay(): Boolean = isAdmin()
    fun isViewablePrivateSystemMessage(): Boolean = isAdmin()

    // 能力行使可能か
    fun canUseAbility(): Boolean = !isSpectator

    // 投票可能か
    fun isAvailableVote(): Boolean = isAlive() && !isSpectator

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
        if (accessInfos.size != participant.accessInfos.size) return true
        return false
    }

    // ===================================================================================
    //                                                                              update
    //                                                                           =========
    // 退村
    fun gone(): VillageParticipant = this.copy(isGone = true)

    // 突然死
    fun suddenlyDeath(villageDay: VillageDay): VillageParticipant =
        this.copy(dead = Dead(CDef.DeadReason.突然, villageDay))

    // 処刑
    fun execute(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.処刑, villageDay))

    // 襲撃
    fun attack(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.襲撃, villageDay))

    // 呪殺
    fun divineKill(villageDay: VillageDay): VillageParticipant =
        this.copy(dead = Dead(CDef.DeadReason.呪殺, villageDay))

    // 後追い
    fun suicide(villageDay: VillageDay): VillageParticipant = this.copy(dead = Dead(CDef.DeadReason.後追, villageDay))

    // 役職割り当て
    fun assignSkill(skill: Skill): VillageParticipant = this.copy(skill = skill)

    // 希望役職
    fun changeSkillRequest(first: CDef.Skill, second: CDef.Skill): VillageParticipant =
        this.copy(skillRequest = SkillRequest(Skill(first), Skill(second)))

    // 勝敗
    fun winLose(winCamp: Camp): VillageParticipant {
        val isSuddenlyDeath = dead?.toCdef() == CDef.DeadReason.突然
        return this.copy(
            isWin = !isSuddenlyDeath && skill?.toCdef()?.campCode() == winCamp.code
        )
    }

    // IPアドレス追加
    fun addAccessInfo(accessInfo: AccessInfo): VillageParticipant {
        return if (accessInfos.any { a -> a.ipAddress == accessInfo.ipAddress && a.clientToken == accessInfo.clientToken }) this
        else this.copy(accessInfos = accessInfos + accessInfo)
    }
}