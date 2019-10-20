package com.ort.wolf4busy.application.util

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object MessageAuthorizationUtil {

    // ===================================================================================
    //                                                                                View
    //                                                                           =========
    fun isViewableGraveMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 見られる設定なら開放
        if (village.setting.rules.visibleGraveMessage) return true
        // 参加していなければNG
        if (participant == null) return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return participant?.dead != null && CDef.DeadReason.突然.code() != participant.dead.code
    }

    fun isViewableSpectateMessage(village: Village, participant: VillageParticipant?, day: Int): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 進行中以外は開放
        if (CDef.VillageStatus.進行中.code() != village.status.code) return true
        // 見られる設定なら開放
        if (village.setting.rules.visibleGraveMessage) return true
        // 進行中でも0日目なら開放
        if (CDef.VillageStatus.進行中.code() == village.status.code && day == 0) return true
        // 参加していなければNG
        if (participant == null) return false
        // 見学は開放
        if (participant.isSpectator) return true
        // 突然死以外で死亡している
        return participant?.dead != null && CDef.DeadReason.突然.code() != participant.dead.code
    }

    fun isViewableMasonMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて共鳴者なら開放
        return isParticipateSkilAs(participant, CDef.Skill.共鳴者)
    }

    fun isViewableWolfMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて人狼なら開放
        return isParticipateSkilAs(participant, CDef.Skill.人狼)
    }

    fun isViewableSeerMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて占い師なら開放
        return isParticipateSkilAs(participant, CDef.Skill.占い師)
    }

    fun isViewableWiseMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて賢者なら開放
        return isParticipateSkilAs(participant, CDef.Skill.賢者)
    }

    fun isViewablePsychicMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて霊能者なら開放
        return isParticipateSkilAs(participant, CDef.Skill.霊能者)
    }

    fun isViewableGuruMessage(village: Village, participant: VillageParticipant?): Boolean {
        // 終了していたら全て見られる
        if (village.isCompleted()) return true
        // 参加していて導師なら開放
        return isParticipateSkilAs(participant, CDef.Skill.導師)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isParticipateSkilAs(participant: VillageParticipant?, skill: CDef.Skill): Boolean {
        return skill.code() == participant?.skill?.code
    }
}