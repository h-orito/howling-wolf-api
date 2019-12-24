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

    fun winLose(cdefWinCamp: CDef.Camp): VillageParticipant = this.copy(isWin = skill!!.toCdef().campCode() == cdefWinCamp.code())

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
}