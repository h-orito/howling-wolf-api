package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.SkillAssign
import com.ort.wolf4busy.domain.model.message.*
import com.ort.wolf4busy.domain.model.myself.participant.VillageSaySituation
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

data class Village(
    val id: Int,
    val name: String,
    val creatorPlayerId: Int,
    val status: VillageStatus,
    val winCamp: VillageWinCamp?,
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
        return participant.memberList.first { it.charaId == setting.charachip.dummyCharaId }
    }

    fun notDummyParticipant(): VillageParticipants {
        val notDummyMembers = participant.memberList.filter { it.charaId != setting.charachip.dummyCharaId }
        return VillageParticipants(
            count = notDummyMembers.size,
            memberList = notDummyMembers
        )
    }

    fun todayDeadParticipants(): VillageParticipants {
        val deadTodayMemberList = participant.memberList.filter {
            !it.isAlive() && it.dead?.villageDay?.id == day.latestDay().id
        }
        return VillageParticipants(
            count = deadTodayMemberList.size,
            memberList = deadTodayMemberList
        )
    }

    // ===================================================================================
    //                                                                           situation
    //                                                                           =========
    /**
     * @param player player
     * @return 参加可能な状況か
     */
    fun isAvailableParticipate(
        player: Player?
    ): Boolean {
        // プレイヤーとして参加可能か
        player ?: return false
        if (!player.isAvailableParticipate()) return false

        // 村として参加可能か
        // プロローグでない
        if (!status.isPrologue()) return false
        // 既に最大人数まで参加している
        if (participant.count >= setting.capacity.max) return false

        return true
    }

    fun assertParticipate(
        player: Player?,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        isSpectate: Boolean,
        password: String?
    ) {
        if (!isAvailableParticipate(player)) throw Wolf4busyBusinessException("参加できません")
        // 既に参加しているキャラはNG
        if (isAlreadyParticipateCharacter(charaId)) throw Wolf4busyBusinessException("既に参加されているキャラクターです")
        // 役職希望無効の場合はおまかせのみ
        if (!isSpectate && !setting.rules.isValidSkillRequest(
                firstRequestSkill,
                secondRequestSkill
            )
        ) throw Wolf4busyBusinessException("希望役職が不正です")
        // パスワードが合っているかチェック
        assertPassword(password)
    }

    /**
     * @param player player
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     * @return 見学可能な状況か
     */
    fun isAvailableSpectate(
        player: Player?,
        charachipCharaNum: Int
    ): Boolean {
        // プレイヤーとして参加可能か
        player ?: return false
        if (!player.isAvailableParticipate()) return false

        // 村として見学可能か
        // プロローグでない
        if (!status.isPrologue()) return false
        // 既に最大人数まで参加している
        if (charachipCharaNum - setting.capacity.max <= spectator.count) return false
        // 見学できない設定の村である
        if (!setting.rules.availableSpectate) return false

        return true
    }

    /**
     * 見学チェック
     * @param player player
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     */
    fun assertSpectate(
        player: Player?,
        charachipCharaNum: Int
    ) {
        if (!isAvailableSpectate(player, charachipCharaNum)) throw Wolf4busyBusinessException("見学できません")
    }

    /**
     * @param participant 参加者
     * @return 退村可能か
     */
    fun isAvailableLeave(participant: VillageParticipant?): Boolean {
        // 参加していない
        participant ?: return false
        // プロローグなら退村できる
        return status.isPrologue()
    }

    /**
     * 退村チェック
     * @param participant 参加者
     */
    fun assertLeave(participant: VillageParticipant?) {
        if (!isAvailableLeave(participant)) throw Wolf4busyBusinessException("退村できません")
    }

    /**
     * @param participant 参加者
     * @return 役職希望可能か
     */
    fun isAvailableSkillRequest(participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        participant.isAvailableSkillRequest()
        // 村として可能か
        // プロローグでない
        if (!status.isPrologue()) return false
        // 役職希望設定
        return setting.rules.availableSkillRequest
    }

    /**
     * 役職希望変更チェック
     * @param participant 参加者
     * @param firstRequestSkill 第1役職希望
     * @param secondRequestSkill 第2役職希望
     */
    fun assertSkillRequest(participant: VillageParticipant?, firstRequestSkill: String, secondRequestSkill: String) {
        if (!isAvailableSkillRequest(participant)) throw Wolf4busyBusinessException("役職希望変更できません")
        val first = CDef.Skill.codeOf(firstRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
        val second = CDef.Skill.codeOf(secondRequestSkill) ?: throw Wolf4busyBusinessException("第1希望が不正")
        if (setting.organizations.allRequestableSkillList().none { it.code == first.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
        if (setting.organizations.allRequestableSkillList().none { it.code == second.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
    }

    /**
     * @param participant 参加者
     * @return コミットできるか
     */
    fun isAvailableCommit(participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        participant.isAvailableCommit(dummyChara().id)
        // 村として可能か
        // コミットできない設定ならNG
        if (!setting.rules.availableCommit) return false
        // 進行中以外はNG
        if (!status.isProgress()) return false

        return true
    }

    /**
     * コミットチェック
     * @param participant 参加者
     */
    fun assertCommit(participant: VillageParticipant?) {
        if (!isAvailableCommit(participant)) throw Wolf4busyBusinessException("コミットできません")
    }

    /**
     * @param participant 参加者
     * @return 発言できるか
     */
    fun isAvailableSay(participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        participant.isAvailableSay(status.toCdef() == CDef.VillageStatus.エピローグ)
        // 村として可能か
        // 終了していたら不可
        if (status.toCdef().isFinishedVillage) return false

        return true
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
        if (status.isSolved()) return CDef.MessageType.listAll()

        val allowedTypeList: MutableList<CDef.MessageType> = mutableListOf()
        allowedTypeList.addAll(everyoneAllowedMessageTypeList)
        // 権限に応じて追加していく（独り言と秘話はここでは追加しない）
        if (isViewableMessage(participant, CDef.MessageType.死者の呻き.code())) allowedTypeList.add(CDef.MessageType.死者の呻き)
        if (isViewableMessage(participant, CDef.MessageType.見学発言.code(), day)) allowedTypeList.add(CDef.MessageType.見学発言)
        if (isViewableMessage(participant, CDef.MessageType.人狼の囁き.code())) allowedTypeList.add(CDef.MessageType.人狼の囁き)
        if (isViewableMessage(participant, CDef.MessageType.白黒霊視結果.code())) allowedTypeList.add(CDef.MessageType.白黒霊視結果)
        if (isViewableMessage(participant, CDef.MessageType.襲撃結果.code())) allowedTypeList.add(CDef.MessageType.襲撃結果)
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
            CDef.MessageType.襲撃結果 -> AttackMessage.isViewable(this, participant)
            else -> return false
        }
    }

    // ===================================================================================
    //                                                                          day change
    //                                                                        ============
    // 最新の村日付を追加
    fun addNewDay(): Village {
        val dayList = mutableListOf<VillageDay>()
        dayList.addAll(day.dayList)
        val newDay = VillageDay(
            id = 0, // dummy
            day = day.latestDay().day + 1, // 一旦長期だけを考えるので常に昼
            noonnight = CDef.Noonnight.昼.code(),
            dayChangeDatetime = day.latestDay().dayChangeDatetime.plusSeconds(setting.time.dayChangeIntervalSeconds.toLong()),
            isUpdating = true
        )
        dayList.add(newDay)
        return this.copy(day = this.day.copy(dayList = dayList))
    }

    // 退村
    fun leaveParticipant(participantId: Int): Village {
        return this.copy(
            participant = this.participant.leave(participantId)
        )
    }

    // 突然死
    fun suddenlyDeathParticipant(participantId: Int, latestDay: VillageDay): Village {
        return this.copy(
            participant = this.participant.suddenlyDeath(participantId, latestDay)
        )
    }

    // 処刑
    fun executeParticipant(participantId: Int, latestDay: VillageDay): Village {
        return this.copy(participant = this.participant.execute(participantId, latestDay))
    }

    // 襲撃
    fun attackParticipant(participantId: Int, latestDay: VillageDay): Village {
        return this.copy(participant = this.participant.attack(participantId, latestDay))
    }

    // 役職割り当て
    fun assignSkill(): Village {
        val assignedParticipants = SkillAssign.assign(
            participant,
            setting.organizations.mapToSkillCount(participant.count),
            dummyChara()
        )
        return this.copy(participant = assignedParticipants)
    }

    // ステータス変更
    fun changeStatus(cdefVillageStatus: CDef.VillageStatus): Village = this.copy(status = VillageStatus(cdefVillageStatus))

    // 勝利陣営設定
    fun win(winCamp: CDef.Camp): Village {
        return this.copy(
            winCamp = VillageWinCamp(winCamp), // 村自体の勝利陣営
            participant = this.participant.winLose(winCamp) // 個人ごとの勝敗
        )
    }

    // 最新の日を24時間にする
    fun extendLatestDay(): Village = this.copy(day = this.day.extendLatestDay())

    // 差分があるか
    fun existsDifference(village: Village): Boolean {
        return status.code != village.status.code
            || winCamp?.code != village.winCamp?.code
            || participant.existsDifference(village.participant)
            || day.existsDifference(village.day)
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
        val saySituation =
            VillageSaySituation(village, participant, charas, latestDayMessageList)
        val restrict = saySituation.selectableMessageTypeList.find { it.messageType.code == messageType }
        restrict ?: return false
        return restrict.restrict.isRestricted && restrict.restrict.remainingCount != null && restrict.restrict.remainingCount <= 0
    }

    private fun assertPassword(password: String?) {
        if (!setting.password.joinPasswordRequired) return
        if (setting.password.joinPassword != password) throw Wolf4busyBusinessException("入村パスワードが誤っています")
    }
}
