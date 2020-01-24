package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.SkillAssign
import com.ort.wolf4busy.domain.model.message.*
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
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

    private val initialMessage: String =
        "昼間は人間のふりをして、夜に正体を現すという人狼。\nその人狼が、この館に紛れ込んでいるという噂が広がった。\n\n村人達は半信半疑ながらも、村はずれの宿に集められることになった。"

    private val day1Message: String =
        "さあ、自らの姿を鏡に映してみよう。\nそこに映るのはただの村人か、それとも血に飢えた人狼か。\n\n例え人狼でも、多人数で立ち向かえば怖くはない。\n問題は、だれが人狼なのかという事だ。\n占い師の能力を持つ人間ならば、それを見破れるだろう。"

    private val day2Message: String =
        "ついに犠牲者が出た。\n\n村人達は、この中にいる人狼を排除するため、投票を行う事にした。\n無実の犠牲者が出るのもやむをえない。村が全滅するよりは……。\n\n最後まで残るのは村人か、それとも人狼か。"

    private val cancelMessage: String = "人数が不足しているため廃村しました。"

    // ===================================================================================
    //                                                                             message
    //                                                                           =========
    /** 村作成時のメッセージ */
    fun createVillagePrologueMessage(): Message =
        Message.createPublicSystemMessage(initialMessage, day.latestDay().id)

    /** 1日目のメッセージ */
    fun createVillageDay1Message(): Message =
        Message.createPublicSystemMessage(day1Message, day.latestDay().id)

    /** 2日目のメッセージ */
    fun createVillageDay2Message(): Message =
        Message.createPublicSystemMessage(day2Message, day.latestDay().id)

    /** 廃村メッセージ */
    fun createCancelVillageMessage(): Message =
        Message.createPublicSystemMessage(cancelMessage, day.latestDay().id)

    /** 構成メッセージ */
    fun createOrganizationMessage(): Message {
        val skillCountMap = setting.organizations.mapToSkillCount(participant.count)
        val text = CDef.Skill.listAll().sortedBy { Integer.parseInt(it.order()) }.mapNotNull { cdefSkill ->
            val skill = Skill(cdefSkill)
            val count = skillCountMap[skill]
            if (count == null || count == 0) null else "${skill.name}が${count}人"
        }.joinToString(
            separator = "、\n",
            prefix = "この村には\n",
            postfix = "いるようだ。"
        )
        return Message.createPublicSystemMessage(text, day.latestDay().id)
    }

    /**
     * ダミーキャラの1日目発言
     * @param charas charas
     */
    fun createDummyCharaFirstDayMessage(charas: Charas): Message? {
        val firstDayMessage = charas.chara(dummyChara().charaId).defaultMessage.firstDayMessage ?: return null
        val messageContent = MessageContent.invoke(
            messageType = CDef.MessageType.通常発言.code(),
            text = firstDayMessage,
            faceCode = CDef.FaceType.通常.code()
        )
        return Message.createSayMessage(
            from = dummyChara(),
            villageDayId = day.latestDay().id,
            messageContent = messageContent
        )
    }

    // ===================================================================================
    //                                                                                read
    //                                                                           =========
    fun dummyChara(): VillageParticipant = participant.memberList.first { it.charaId == setting.charachip.dummyCharaId }

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

    // 差分があるか
    fun existsDifference(village: Village): Boolean {
        return status.code != village.status.code
            || winCamp?.code != village.winCamp?.code
            || participant.existsDifference(village.participant)
            || day.existsDifference(village.day)
            || setting.existsDifference(village.setting)
    }

    // ===================================================================================
    //                                                                                 権限
    //                                                                           =========
    /** 村として参加可能か */
    fun isAvailableParticipate(): Boolean {
        // プロローグでない
        if (!status.isPrologue()) return false
        // 既に最大人数まで参加している
        if (participant.count >= setting.capacity.max) return false

        return true
    }

    /**
     * 村としての参加チェック
     * @param charaId charaId
     * @param password 入村パスワード
     */
    fun assertParticipate(
        charaId: Int,
        password: String?
    ) {
        // 既に参加しているキャラはNG
        if (isAlreadyParticipateCharacter(charaId)) throw Wolf4busyBusinessException("既に参加されているキャラクターです")
        // パスワードが合っているかチェック
        assertPassword(password)
    }

    /**
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     * @return 村として見学可能な状況か
     */
    fun isAvailableSpectate(
        charachipCharaNum: Int
    ): Boolean {
        // プロローグでない
        if (!status.isPrologue()) return false
        // 既に最大人数まで参加している
        if (charachipCharaNum - setting.capacity.max <= spectator.count) return false
        // 見学できない設定の村である
        if (!setting.rules.availableSpectate) return false

        return true
    }

    /** 村として退村可能か */
    fun isAvailableLeave(): Boolean = status.isPrologue() // プロローグなら退村できる

    /** 村として役職希望可能か */
    fun isAvailableSkillRequest(): Boolean {
        // プロローグでない
        if (!status.isPrologue()) return false
        // 役職希望設定
        return setting.rules.availableSkillRequest
    }

    /**
     * 役職希望変更チェック
     * @param first 第1役職希望
     * @param second 第2役職希望
     */
    fun assertSkillRequest(first: CDef.Skill, second: CDef.Skill) {
        if (setting.organizations.allRequestableSkillList().none { it.code == first.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
        if (setting.organizations.allRequestableSkillList().none { it.code == second.code() }) throw Wolf4busyBusinessException("役職希望変更できません")
    }

    /** 村としてコミットできるか */
    fun isAvailableCommit(): Boolean {
        // コミットできない設定ならNG
        if (!setting.rules.availableCommit) return false
        // 進行中以外はNG
        if (!status.isProgress()) return false

        return true
    }

    /** 村の状況として発言できるか */
    fun isAvailableSay(): Boolean = !status.toCdef().isFinishedVillage // 終了していたら不可

    /** 村として通常発言できるか */
    fun isSayableNormalSay(): Boolean = !status.toCdef().isFinishedVillage // 終了していたら不可

    /** 村として囁き発言を見られるか */
    fun isViewableWerewolfSay(): Boolean = status.isSolved()

    /** 村として囁き発言できるか */
    fun isSayableWerewolfSay(): Boolean = status.isProgress() // 進行中以外は不可

    /** 村として墓下発言を見られるか */
    fun isViewableGraveSay(): Boolean {
        if (status.isSolved()) return true
        return setting.rules.visibleGraveMessage
    }

    /** 村として墓下発言できるか */
    fun isSayableGraveSay(): Boolean = status.isProgress() // 進行中以外は不可

    /** 村として独り言を見られるか */
    fun isViewableMonologueSay(): Boolean = status.isSolved() // 終了していたら全て見られる

    /** 村として独り言発言できるか */
    fun isSayableMonologueSay(): Boolean = true // 制約なし

    /** 村として見学発言を見られるか */
    fun isViewableSpectateSay(): Boolean {
        // 進行中以外は開放
        if (!status.isProgress()) return true
        // 見られる設定なら開放
        return setting.rules.visibleGraveMessage
    }

    /** 村として見学発言できるか */
    fun isSayableSpectateSay(): Boolean = true // 制約なし

    /** 村として襲撃メッセージを見られるか */
    fun isViewableAttackMessage(): Boolean = status.isSolved() // 終了していたら全て見られる

    /** 村として白黒霊能結果を見られるか */
    fun isViewablePsychicMessage(): Boolean = status.isSolved()// 終了していたら全て見られる

    /** 村として秘話を見られるか */
    fun isViewableSecretSay(): Boolean = status.isSolved()

    /**
     * 発言制限チェック
     * @param messageContent 発言内容
     * @param latestDayMessageList 本日の発言
     */
    fun assertMessageRestrict(messageContent: MessageContent, latestDayMessageList: List<Message>) {
        val restrict = setting.rules.messageRestrict.restrict(messageContent.type.toCdef()) ?: return // 制限なし
        restrict.assertSay(messageContent, latestDayMessageList)
    }

    /** 村として能力を行使できるか */
    fun canUseAbility(): Boolean = status.isProgress()

    /** 村として投票できるか */
    fun isAvailableVote(): Boolean {
        if (!status.isProgress()) return false
        return day.latestDay().day > 1
    }

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
            CDef.MessageType.独り言 -> MonologueSay.isViewable(this, participant)
            CDef.MessageType.秘話 -> SecretSay.isViewable(this, participant)
            CDef.MessageType.白黒霊視結果 -> PsychicMessage.isViewable(this, participant)
            CDef.MessageType.襲撃結果 -> AttackMessage.isViewable(this, participant)
            else -> return false
        }
    }

    // ===================================================================================
    //                                                                              update
    //                                                                        ============
    // 最新の村日付を追加
    fun addNewDay(): Village {
        val dayList = mutableListOf<VillageDay>()
        dayList.addAll(day.dayList)
        val newDay = VillageDay(
            id = 0, // dummy
            day = day.latestDay().day + 1, // 一旦長期だけを考えるので常に昼
            noonnight = CDef.Noonnight.昼.code(),
            dayChangeDatetime = day.latestDay().dayChangeDatetime.plusSeconds(setting.time.dayChangeIntervalSeconds.toLong())
        )
        dayList.add(newDay)
        return this.copy(day = this.day.copy(dayList = dayList))
    }

    // 入村
    fun participate(
        playerId: Int,
        charaId: Int,
        firstRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        isSpectate: Boolean
    ): Village {
        return if (isSpectate) {
            this.copy(
                spectator = spectator.addParticipant(
                    charaId = charaId,
                    playerId = playerId,
                    skillRequest = SkillRequest(Skill(firstRequestSkill), Skill(secondRequestSkill)),
                    isSpectator = true
                )
            )
        } else {
            this.copy(
                participant = participant.addParticipant(
                    charaId = charaId,
                    playerId = playerId,
                    skillRequest = SkillRequest(Skill(firstRequestSkill), Skill(secondRequestSkill)),
                    isSpectator = false
                )
            )
        }
    }

    // 希望役職変更
    fun changeSkillRequest(participantId: Int, first: CDef.Skill, second: CDef.Skill): Village =
        this.copy(participant = participant.changeSkillRequest(participantId, first, second))

    // 退村
    fun leaveParticipant(participantId: Int): Village = this.copy(participant = this.participant.leave(participantId))

    // 突然死
    fun suddenlyDeathParticipant(participantId: Int, latestDay: VillageDay): Village =
        this.copy(participant = this.participant.suddenlyDeath(participantId, latestDay))

    // 処刑
    fun executeParticipant(participantId: Int, latestDay: VillageDay): Village =
        this.copy(participant = this.participant.execute(participantId, latestDay))

    // 襲撃
    fun attackParticipant(participantId: Int, latestDay: VillageDay): Village =
        this.copy(participant = this.participant.attack(participantId, latestDay))

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

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAlreadyParticipateCharacter(charaId: Int): Boolean {
        return participant.memberList.any { it.charaId == charaId }
            || spectator.memberList.any { it.charaId == charaId }
    }

    private fun assertPassword(password: String?) {
        if (!setting.password.joinPasswordRequired) return
        if (setting.password.joinPassword != password) throw Wolf4busyBusinessException("入村パスワードが誤っています")
    }
}
