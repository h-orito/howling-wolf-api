package com.ort.howlingwolf.domain.model.village

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.skill.Skills
import com.ort.howlingwolf.domain.model.village.blacklist.BlacklistPlayers
import com.ort.howlingwolf.domain.model.village.participant.AccessInfo
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.VillageSettings
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Village(
    val id: Int,
    val name: String,
    val creatorPlayerId: Int,
    val status: VillageStatus,
    val winCamp: Camp?,
    val setting: VillageSettings,
    val participant: VillageParticipants,
    val spectator: VillageParticipants,
    val day: VillageDays,
    val blacklistPlayers: BlacklistPlayers
) {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private val initialMessage: String =
        "昼間は人間のふりをして、夜に正体を現すという人狼。\nその人狼が、この村に紛れ込んでいるという噂が広がった。\n\n村人達は半信半疑ながらも、村はずれの宿に集められることになった。"

    private val beginnerMessage: String =
        "この村は初心者村です。\n\n・村建てから24時間経過するまでは1戦以上参加したことがある方の参加が制限されます\n" +
                "・初心者の方は初心者COしてもOKです\n・初心者でない方は初心者に優しく教えながら参加してください\n" +
                "・他のサイトや対面などで何戦かやったことがあるけど自信がない、という方も大歓迎です\n" +
                "　（どの程度経験があるか記載しておくとサポートを受けやすくなると思います。）"

    private val day1Message: String =
        "さあ、自らの姿を鏡に映してみよう。\nそこに映るのはただの村人か、それとも血に飢えた人狼か。\n\nたとえ人狼でも、多人数で立ち向かえば怖くはない。\n問題は、だれが人狼なのかという事だ。\n占い師の能力を持つ人間ならば、それを見破れるだろう。"

    private val day2Message: String =
        "ついに犠牲者が出た。\n\n村人達は、この中にいる人狼を排除するため、投票を行う事にした。\n無実の犠牲者が出るのもやむをえない。村が全滅するよりは……。\n\n最後まで残るのは村人か、それとも人狼か。"

    private val cancelMessage: String = "人数が不足しているため廃村しました。"

    private val extendPrologueMessage: String = "まだ村人達は揃っていないようだ。"

    // ===================================================================================
    //                                                                             message
    //                                                                           =========
    /** 村作成時のメッセージ */
    fun createVillagePrologueMessage(): Message =
        Message.createPublicSystemMessage(initialMessage, day.latestDay().id)

    /** 初心者村のメッセージ */
    fun createBeginnerVillageMessage(): Message =
        Message.createPublicSystemMessage(beginnerMessage, day.latestDay().id)

    /** 1日目のメッセージ */
    fun createVillageDay1Message(): Message =
        Message.createPublicSystemMessage(day1Message, day.latestDay().id)

    /** 2日目のメッセージ */
    fun createVillageDay2Message(): Message =
        Message.createPublicSystemMessage(day2Message, day.latestDay().id)

    /** 廃村メッセージ */
    fun createCancelVillageMessage(): Message =
        Message.createPublicSystemMessage(cancelMessage, day.latestDay().id)

    fun createExtendPrologueMessage(): Message =
        Message.createPublicSystemMessage(extendPrologueMessage, day.latestDay().id)

    /** 構成メッセージ */
    fun createOrganizationMessage(): Message {
        val skillCountMap = setting.organizations.mapToSkillCount(participant.count)
        val text = CDef.Skill.listAll().sortedBy { Integer.parseInt(it.order()) }.mapNotNull { cdefSkill ->
            val skill = Skill(cdefSkill)
            val count = skillCountMap[cdefSkill]
            if (count == null || count == 0) null else "${skill.name}が${count}人"
        }.joinToString(
            separator = "、\n",
            prefix = "この村には\n",
            postfix = "\nいるようだ。"
        )
        return Message.createPublicSystemMessage(text, day.latestDay().id)
    }

    /** 人狼系の役職相互確認メッセージ */
    fun createWolfsConfirmMessage(charas: Charas): Message {
        val text = createRecognizeSkillMessageText(Skills.wolfs.list, charas)
        return Message.createAttackPrivateMessage(text, day.latestDay().id)
    }

    /** 狂信者の役職確認メッセージ */
    fun createFanaticConfirmMessage(charas: Charas): Message? {
        // 狂信者がいなければなし
        if (participant.memberList.none { it.skill!!.canRecognizeWolf() }) return null
        // 襲撃役職を一括りにして人狼とする
        val text = participant.memberList.filter { it.skill!!.hasAttackAbility() }.joinToString(
            separator = "、",
            prefix = "この村の人狼は",
            postfix = "のようだ。"
        ) {
            charas.chara(it.charaId).charaName.fullName()
        }
        return Message.createFanaticPrivateMessage(text, day.latestDay().id)
    }

    /** 共有系の役職相互確認メッセージ */
    fun createMasonsConfirmMessage(charas: Charas): Message? {
        // 共有がいなければなし
        if (participant.memberList.none { it.skill!!.canRecognizeEachMason() }) return null
        val text = createRecognizeSkillMessageText(Skills.masons.list, charas)
        return Message.createMasonPrivateMessage(text, day.latestDay().id)
    }

    /** 妖狐系の役職相互確認メッセージ */
    fun createFoxsConfirmMessage(charas: Charas): Message? {
        // 妖狐がいなければなし
        if (participant.memberList.none { it.skill!!.canRecognizeFoxs() }) return null
        val text = createRecognizeSkillMessageText(Skills.foxs.list, charas)
        return Message.createFoxPrivateMessage(text, day.latestDay().id)
    }

    private fun createRecognizeSkillMessageText(skills: List<Skill>, charas: Charas): String {
        return skills.mapNotNull { skill ->
            val list = participant.filterBySkill(skill).memberList
            if (list.isEmpty()) null
            else "${skill.name}は${
                list.joinToString(separator = "、") {
                    charas.chara(it.charaId).charaName.fullName()
                }
            }"
        }.joinToString(
            separator = "、\n",
            prefix = "この村の",
            postfix = "のようだ。"
        )
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

    fun createNewVillageMessage(): String {
        val organization = setting.organizations.organization[setting.capacity.max]!!
        val startDatetime = setting.time.startDatetime.format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm"))
        val silentHoursStr = setting.time.silentHours?.let {
            if (it == 0) "" else "更新後沈黙時間：${it}時間\r\n"
        } ?: ""
        val forBeginner = if (setting.rules.forBeginner) "（初心者村）" else ""

        return "新しい村が作成されました。\r\n" +
                "村名：$name$forBeginner\r\n" +
                "編成：$organization\r\n" +
                "開始予定：$startDatetime\r\n" +
                silentHoursStr +
                "https://howling-wolf.com/village?id=$id"
    }

    fun createStartVillageMessage(): String {
        val organization = setting.organizations.organization[setting.capacity.max]!!
        val startDatetime = setting.time.startDatetime.format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm"))
        val silentHoursStr = setting.time.silentHours?.let {
            if (it == 0) "" else "更新後沈黙時間：${it}時間\r\n"
        } ?: ""
        val forBeginner = if (setting.rules.forBeginner) "（初心者村）" else ""

        return "村が開始されました。\r\n" +
                "村名：$name$forBeginner\r\n" +
                "編成：$organization\r\n" +
                "開始予定：$startDatetime\r\n" +
                silentHoursStr +
                "https://howling-wolf.com/village?id=$id"
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

    // 決着がついたか
    fun isSettled(): Boolean {
        val wolfCount = wolfCount()
        return wolfCount <= 0 || villagerCount() <= wolfCount
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
        if (isAlreadyParticipateCharacter(charaId)) throw HowlingWolfBusinessException("既に参加されているキャラクターです")
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
    fun isAvailableLeave(): Boolean {
        // プロローグでない
        if (!status.isPrologue()) return false
        // 開始まで2時間を切っていたら退村できない
        return setting.time.startDatetime.minusHours(2L).isAfter(HowlingWolfDateUtil.currentLocalDateTime())
    }

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
        if (setting.organizations.allRequestableSkillList()
                .none { it.code == first.code() }
        ) throw HowlingWolfBusinessException("役職希望変更できません")
        if (setting.organizations.allRequestableSkillList()
                .none { it.code == second.code() }
        ) throw HowlingWolfBusinessException("役職希望変更できません")
    }

    fun isSilentTime(): Boolean =
        status.isProgress() && setting.time.isSilentTime(day.yesterday().dayChangeDatetime)

    fun isAvailableCommit(): Boolean = setting.rules.availableCommit && status.isProgress()
    fun isAvailableComingOut(): Boolean = !isSilentTime() && status.isProgress()
    fun isAvailableSay(): Boolean = !status.toCdef().isFinishedVillage
    fun isSayableNormalSay(): Boolean = !status.isFinished() && !isSilentTime()
    fun isViewableWerewolfSay(): Boolean = status.isSolved()
    fun isSayableWerewolfSay(): Boolean = status.isProgress()
    fun isViewableGraveSay(): Boolean = status.isSolved() || setting.rules.visibleGraveMessage
    fun isSayableGraveSay(): Boolean = status.isProgress()
    fun isViewableMonologueSay(): Boolean = status.isSolved()
    fun isSayableMonologueSay(): Boolean = true
    fun isViewableSpectateSay(): Boolean = !status.isProgress() || setting.rules.visibleGraveMessage
    fun isSayableSpectateSay(): Boolean = true
    fun isViewableAttackMessage(): Boolean = status.isSolved()
    fun isViewableMasonMessage(): Boolean = status.isSolved()
    fun isViewableFanaticMessage(): Boolean = status.isSolved()
    fun isViewableFoxMessage(): Boolean = status.isSolved()
    fun isViewablePsychicMessage(): Boolean = status.isSolved()
    fun isViewableSecretSay(): Boolean = status.isSolved()

    /**
     * 発言制限チェック
     * @param messageContent 発言内容
     * @param latestDayMessageList 本日の発言
     */
    fun assertMessageRestrict(messageContent: MessageContent, latestDayMessageList: List<Message>) {
        val restrict = setting.rules.messageRestrict.restrict(messageContent.type.toCdef()) ?: return // 制限なし
        restrict.assertSay(messageContent, status.toCdef(), latestDayMessageList)
    }

    /** 村として能力を行使できるか */
    fun canUseAbility(): Boolean = status.isProgress()

    /** 村として投票できるか */
    fun isAvailableVote(): Boolean {
        if (!status.isProgress()) return false
        return day.latestDay().day > 1
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
        isSpectate: Boolean,
        accessInfo: AccessInfo
    ): Village {
        return if (isSpectate) {
            this.copy(
                spectator = spectator.addParticipant(
                    charaId = charaId,
                    playerId = playerId,
                    skillRequest = SkillRequest(Skill(firstRequestSkill), Skill(secondRequestSkill)),
                    isSpectator = true,
                    accessInfo = accessInfo
                )
            )
        } else {
            this.copy(
                participant = participant.addParticipant(
                    charaId = charaId,
                    playerId = playerId,
                    skillRequest = SkillRequest(Skill(firstRequestSkill), Skill(secondRequestSkill)),
                    isSpectator = false,
                    accessInfo = accessInfo
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

    // 呪殺
    fun divineKillParticipant(participantId: Int, latestDay: VillageDay): Village =
        this.copy(participant = this.participant.divineKill(participantId, latestDay))

    // 後追い
    fun suicideParticipant(participantId: Int): Village =
        this.copy(participant = this.participant.suicide(participantId, day.latestDay()))

    // IPアドレス追加
    fun addParticipantIpAddress(id: Int, accessInfo: AccessInfo): Village =
        this.copy(participant = this.participant.addAccessInfo(id, accessInfo))

    // 役職割り当て
    fun assignSkill(participants: VillageParticipants): Village {
        return this.copy(participant = participants)
    }

    // ステータス変更
    fun changeStatus(cdefVillageStatus: CDef.VillageStatus): Village =
        this.copy(status = VillageStatus(cdefVillageStatus))

    // エピローグ遷移
    fun toEpilogue(): Village {
        return this
            .changeStatus(CDef.VillageStatus.エピローグ) // エピローグへ
            .winLose() // 勝敗陣営設定
            .setEpilogueTime() // エピローグ日時、エピローグ日
            .extendLatestDay() // エピローグは固定で24時間にするので、最新日を差し替える
    }

    // 最新の日を24時間にする
    fun extendLatestDay(): Village = this.copy(day = this.day.extendLatestDay())

    fun extendPrologue(): Village = this.copy(
        setting = setting.extendPrologue(),
        day = day.extendPrologue()
    )

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAlreadyParticipateCharacter(charaId: Int): Boolean {
        return participant.memberList.any { it.charaId == charaId }
                || spectator.memberList.any { it.charaId == charaId }
    }

    private fun assertPassword(password: String?) {
        if (!setting.password.joinPasswordRequired) return
        if (setting.password.joinPassword != password) throw HowlingWolfBusinessException("入村パスワードが誤っています")
    }

    private fun villagerCount(): Int =
        participant.filterAlive().memberList.count { !it.skill!!.toCdef().isCountWolf && !it.skill.toCdef().isNoCount }

    private fun wolfCount(): Int = participant.filterAlive().memberList.count { it.skill!!.toCdef().isCountWolf }

    private fun isFoxAlive(): Boolean = participant.filterAlive().memberList.any { it.skill!!.toCdef().isNoCount }

    // 勝利陣営設定
    private fun winLose(): Village {
        if (!isSettled()) return this
        return this.copy(
            winCamp = judgeWinCamp(), // 村自体の勝利陣営
            participant = this.participant.winLose(judgeWinCamp()!!) // 個人ごとの勝敗
        )
    }

    private fun setEpilogueTime(): Village {
        return this.copy(
            setting = setting.toEpilogue(day)
        )
    }

    private fun judgeWinCamp(): Camp? {
        if (!this.isSettled()) return null
        if (isFoxAlive()) return Camp(CDef.Camp.狐陣営)
        if (wolfCount() > 0) return Camp(CDef.Camp.人狼陣営)
        return Camp(CDef.Camp.村人陣営)
    }

    // ===================================================================================
    //                                                                    companion object
    //                                                                             =======
    companion object {

        fun createAutoGeneratedForRegister(
            playerId: Int,
            organization: String,
            startDatetime: LocalDateTime,
            silentHours: Int?,
            availableDummySkill: Boolean,
            forBeginner: Boolean,
            canSkillRequest: Boolean
        ): Village {
            return Village(
                id = 1, // dummy
                name = "dummy village name",
                creatorPlayerId = playerId,
                status = VillageStatus(CDef.VillageStatus.プロローグ),
                setting = VillageSettings.createAutoGeneratedForRegister(
                    organization,
                    startDatetime,
                    silentHours,
                    availableDummySkill,
                    forBeginner,
                    canSkillRequest
                ),
                participant = VillageParticipants(
                    count = 0,
                    memberList = listOf()
                ),
                spectator = VillageParticipants(
                    count = 0,
                    memberList = listOf()
                ),
                day = VillageDays(
                    dayList = listOf()
                ),
                winCamp = null,
                blacklistPlayers = BlacklistPlayers(listOf())
            )
        }
    }
}
