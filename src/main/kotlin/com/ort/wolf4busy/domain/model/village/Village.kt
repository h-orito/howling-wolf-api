package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings

data class Village(
    val id: Int,
    val name: String,
    val creatorPlayerName: String,
    val status: VillageStatus,
    val setting: VillageSettings,
    val participant: VillageParticipants,
    val spectator: VillageParticipants,
    val day: VillageDays
) {

    // ===================================================================================
    //                                                                         participant
    //                                                                           =========
    fun dummyChara(): VillageParticipant {
        return participant.memberList.find { it.charaId == setting.charachip.dummyCharaId }!!
    }

    // ===================================================================================
    //                                                                                View
    //                                                                           =========
    fun isViewableNormalMessage(): Boolean {
        return true
    }

    fun isViewableGraveMessage(participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (this.status.isCompleted()) return true
        // 見られる設定なら開放
        if (this.setting.rules.visibleGraveMessage) return true
        // 参加していなければNG
        if (participant == null) return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return participant?.dead != null && CDef.DeadReason.突然.code() != participant.dead.code
    }

    fun isViewableSpectateMessage(participant: VillageParticipant?, day: Int): Boolean {
        // 終了していたら全て見られる
        if (this.status.isCompleted()) return true
        // 進行中以外は開放
        if (CDef.VillageStatus.進行中.code() != this.status.code) return true
        // 見られる設定なら開放
        if (this.setting.rules.visibleGraveMessage) return true
        // 進行中でも0日目なら開放
        if (CDef.VillageStatus.進行中.code() == this.status.code && day == 0) return true
        // 参加していなければNG
        if (participant == null) return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return participant?.dead != null && CDef.DeadReason.突然.code() != participant.dead.code
    }

    fun isViewableWerewolfMessage(participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (this.status.isCompleted()) return true
        // 参加していて人狼なら開放
        return isParticipateSkillAs(participant, CDef.Skill.人狼)
    }

    fun isViewableSeerMessage(participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (this.status.isCompleted()) return true
        // 参加していて占い師なら開放
        return isParticipateSkillAs(participant, CDef.Skill.占い師)
    }

    fun isViewablePsychicMessage(participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (this.status.isCompleted()) return true
        // 参加していて霊能者なら開放
        return isParticipateSkillAs(participant, CDef.Skill.霊能者)
    }

    fun isViewableMonologueMessage(): Boolean {
        // 終了していたら全て見られる
        return this.status.isCompleted()
    }

    fun isViewableSecretMessage(): Boolean {
        // 終了していたら全て見られる
        return this.status.isCompleted()
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    fun changeSkill(): Village {
        return this.copy(

        )
    }


    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isParticipateSkillAs(participant: VillageParticipant?, skill: CDef.Skill): Boolean {
        return skill.code() == participant?.skill?.code
    }
}