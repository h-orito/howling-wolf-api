package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.Prologue
import com.ort.wolf4busy.domain.model.daychange.SkillAssign
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
    //                                                                          Definition
    //                                                                          ==========
    private val everyoneAllowedMessageTypeList = listOf(CDef.MessageType.公開システムメッセージ, CDef.MessageType.通常発言, CDef.MessageType.村建て発言)

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
    /**
     * 閲覧できる発言種別リスト
     *
     * @param participant 参加情報
     * @param day 何日目か
     * @param authority ユーザの権限
     * @return 閲覧できる発言種別
     */
    fun viewableMessageTypeList(
        participant: VillageParticipant?,
        day: Int,
        authority: CDef.Authority?
    ): List<CDef.MessageType> {
        // 管理者は全て見られる
        if (authority == CDef.Authority.管理者) return CDef.MessageType.listAll()
        // 村が終了していたら全て見られる
        if (status.isCompleted()) return CDef.MessageType.listAll()

        val allowedTypeList: MutableList<CDef.MessageType> = mutableListOf()
        allowedTypeList.addAll(everyoneAllowedMessageTypeList)
        // 権限に応じて追加していく（独り言と秘話はここでは追加しない）
        if (isViewableMessage(participant, CDef.MessageType.死者の呻き.code())) allowedTypeList.add(CDef.MessageType.死者の呻き)
        if (isViewableMessage(participant, CDef.MessageType.見学発言.code(), day)) allowedTypeList.add(CDef.MessageType.見学発言)
        if (isViewableMessage(participant, CDef.MessageType.人狼の囁き.code())) allowedTypeList.add(CDef.MessageType.人狼の囁き)
        if (isViewableMessage(participant, CDef.MessageType.白黒霊視結果.code())) allowedTypeList.add(CDef.MessageType.白黒霊視結果)
        return allowedTypeList
    }

    /**
     * 閲覧できるか
     *
     * @param participant 参加情報
     * @param messageType 発言種別
     * @param day 何日目か
     * @return 閲覧できるか
     */
    fun isViewableMessage(participant: VillageParticipant?, messageType: String, day: Int = 1): Boolean {
        return when (CDef.MessageType.codeOf(messageType) ?: return false) {
            CDef.MessageType.通常発言 -> NormalSay.isViewable(this, participant)
            CDef.MessageType.人狼の囁き -> WerewolfSay.isViewable(this, participant)
            CDef.MessageType.死者の呻き -> GraveSay.isViewable(this, participant)
            CDef.MessageType.見学発言 -> SpectateSay.isViewable(this, participant, day)
            CDef.MessageType.独り言 -> MonologueSay.isViewable(this)
            CDef.MessageType.秘話 -> SecretSay.isViewable(this)
            CDef.MessageType.白黒霊視結果 -> PsychicMessage.isViewable(this, participant)
            else -> return false
        }
    }

    // ===================================================================================
    //                                                                                 say
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
    fun isAvailableSay(
        user: Wolf4busyUser, participant: VillageParticipant, message: String, messageType: String, faceType: String?,
        latestDayMessageList: List<Message>, charas: Charas
    ): Boolean {
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
    //                                                                          day change
    //                                                                        ============
    /**
     * 必要あれば日付更新
     *
     * @param todayMessages 最新日の通常発言
     * @param charas キャラ
     * @return 更新後の村と更新に際してのメッセージ
     */
    fun dayChangeIfNeeded(todayMessages: Messages, charas: Charas): Pair<Village, Messages> {
        return if (status.isPrologue()) { // プロローグ
            Prologue.dayChange(this, todayMessages, charas)
        } else if (status.isProgress() && day.latestDay().day == 1) { // 進行中で1日目
            this to Messages(listOf())
        } else if (status.isProgress()) { // 進行中で2日目以降
            this to Messages(listOf())
        } else if (status.code == CDef.VillageStatus.エピローグ.code()) {
            this to Messages(listOf())
        } else {
            this to Messages(listOf())
        }
    }

    // 最新の村日付を追加
    fun addNewDay(): Village {
        val dayList = mutableListOf<VillageDay>()
        dayList.addAll(day.dayList)
        val newDay = VillageDay(
            id = 0, // dummy
            day = day.latestDay().day + 1, // 一旦長期だけを考えるので常に昼
            noonnight = CDef.Noonnight.昼.code(),
            dayChangeDatetime = day.latestDay().dayChangeDatetime.plusSeconds(setting.time.dayChangeIntervalSeconds.toLong()),
            isUpdating = true,
            isPrologue = false, // dummy
            isEpilogue = false // dummy
        )
        dayList.add(newDay)
        return this.copy(day = this.day.copy(dayList = dayList))
    }

    // 役職割り当て
    fun assignSkill(): Village {
        val assignedParticipants = SkillAssign.assign(participant, setting.organizations.mapToSkillCount(participant.count), dummyChara())

        return this
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAlreadyParticipateCharacter(charaId: Int): Boolean {
        return participant.memberList.any { it.charaId == charaId }
            || spectator.memberList.any { it.charaId == charaId }
    }

    private fun isRestricted(
        village: Village,
        participant: VillageParticipant,
        latestDayMessageList: List<Message>,
        charas: Charas,
        messageType: String
    ): Boolean {
        val saySituation = VillageSaySituation(village, participant, charas, latestDayMessageList)
        val restrict = saySituation.selectableMessageTypeList.find { it.messageType.code == messageType }
        restrict ?: return false
        return restrict.restrict.isRestricted && restrict.restrict.remainingCount != null && restrict.restrict.remainingCount <= 0
    }
}
