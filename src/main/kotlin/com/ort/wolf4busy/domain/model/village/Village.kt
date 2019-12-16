package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.*
import com.ort.wolf4busy.domain.model.village.action.VillageSaySituation
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser

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

    fun assertParticipate(
        playerId: Int,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        isSpectate: Boolean,
        charachipCharaNum: Int,
        isCollectPassword: Boolean
    ) {
        // 既に参加しているキャラはNG
        if (isAlreadyParticipateCharacter(charaId)) throw Wolf4busyBusinessException("既に参加されているキャラクターです")

        if (isSpectate) {
            // [キャラチップの人数 - 定員] 人を超えて見学はできない
            if (charachipCharaNum - setting.capacity.max <= spectator.count) throw Wolf4busyBusinessException("既に上限人数まで見学者がいるため見学者として参加できません。")
        } else {
            if (setting.capacity.max <= participant.count) throw Wolf4busyBusinessException("既に上限人数までプレイヤーが参加しているため参加できません。")
            if (!setting.rules.isValidSkillRequest(firstRequestSkill, secondRequestSkill)) throw Wolf4busyBusinessException("希望役職が不正です")
        }

        assertPassword(playerId, isCollectPassword)
    }

    private fun assertPassword(playerId: Int, isCollectPassword: Boolean) {
        if (playerId == 1) return // ダミーはパスワードなしでOK
        if (!isCollectPassword) throw Wolf4busyBusinessException("入村パスワードが誤っています")
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
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * 発言できるか
     *
     * @param user user
     * @param participant 村参加者
     * @param message 発言内容
     * @param messageType 発言種別
     * @param faceType 表情種別
     */
    fun isAvailableSay(user: Wolf4busyUser, participant: VillageParticipant, message: String, messageType: String, faceType: String?,
                       latestDayMessageList: List<Message>, charas: Charas): Boolean {
        val cdefMessageType = CDef.MessageType.codeOf(messageType)
        cdefMessageType ?: throw IllegalStateException("発言種別改竄")

        // 管理者は発言可能
        if (user.authority == CDef.Authority.管理者) return true

        val sayable = when (cdefMessageType) {
            CDef.MessageType.通常発言 -> NormalSay.isSayable(this, participant)
            CDef.MessageType.人狼の囁き -> WerewolfSay.isSayable(this, participant)
            CDef.MessageType.共鳴発言 -> MasonSay.isSayable(this, participant)
            CDef.MessageType.死者の呻き -> GraveSay.isSayable(this, participant)
            CDef.MessageType.見学発言 -> SpectateSay.isSayable(this, participant)
            CDef.MessageType.独り言 -> MonologueSay.isSayable(this, participant)
            CDef.MessageType.秘話 -> SecretSay.isSayable(this, participant)
            else -> false
        }
        if (!sayable) return false

        // 発言制限
        return !isRestricted(this, participant, latestDayMessageList, charas, messageType)

    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isParticipateSkillAs(participant: VillageParticipant?, skill: CDef.Skill): Boolean {
        return skill.code() == participant?.skill?.code
    }

    private fun isAlreadyParticipateCharacter(charaId: Int): Boolean {
        return participant.memberList.any { it.charaId == charaId }
            || spectator.memberList.any { it.charaId == charaId }
    }

    private fun isRestricted(village: Village, participant: VillageParticipant, latestDayMessageList: List<Message>, charas: Charas, messageType: String): Boolean {
        val saySituation = VillageSaySituation(village, participant, charas, latestDayMessageList)
        val restrict = saySituation.selectableMessageTypeList.find { it.messageType.code == messageType }
        restrict ?: return false
        return restrict.restrict.isRestricted && restrict.restrict.remainingCount != null && restrict.restrict.remainingCount <= 0

    }
}
