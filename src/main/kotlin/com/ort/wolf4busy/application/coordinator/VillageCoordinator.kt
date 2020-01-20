package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.*
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.Say
import com.ort.wolf4busy.domain.model.myself.participant.SituationAsParticipant
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.ability.VillageAbility
import com.ort.wolf4busy.domain.model.village.participant.Leave
import com.ort.wolf4busy.domain.model.village.participant.Participate
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.domain.model.vote.Vote
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class VillageCoordinator(
    val dayChangeCoordinator: DayChangeCoordinator,

    val villageService: VillageService,
    val playerService: PlayerService,
    val messageService: MessageService,
    val charachipService: CharachipService,
    val abilityService: AbilityService,
    val voteService: VoteService,
    val commitService: CommitService
) {

    /**
     * 村登録
     * @param paramVillage village
     * @param user user
     * @param villagePassword password
     * @return 村ID
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun registerVillage(paramVillage: Village, user: Wolf4busyUser, villagePassword: String?): Int {
        // 作成できない状況ならエラー
        val player = playerService.findPlayer(user)
        player.assertCreateVillage(user)
        // 村を登録
        val village: Village = villageService.registerVillage(paramVillage, villagePassword)
        // 村作成時のシステムメッセージを登録
        messageService.registerInitialMessage(village)
        // ダミーキャラを参加させる
        val chara = charachipService.findChara(village.dummyChara().charaId)
        participateDummyChara(village.id, village, chara)
        // 日付更新完了
        villageService.updateVillageDayUpdateComplete(village.day.latestDay().id)

        return village.id
    }

    /**
     * 村に参加できるかチェック
     * @param villageId villageId
     * @param user user
     * @param charaId charaId
     * @param isSpectate 見学か
     * @param firstRequestSkill 役職第1希望
     * @param secondRequestSkill 役職第2希望
     * @param password 入村パスワード
     */
    fun assertParticipate(
        villageId: Int,
        user: Wolf4busyUser,
        charaId: Int,
        isSpectate: Boolean,
        firstRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        password: String?
    ) {
        // 参加できない状況ならエラー
        val village: Village = villageService.findVillage(villageId)
        val player = playerService.findPlayer(user)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)

        if (isSpectate) {
            Participate.assertSpectate(player, village, charas.list.size)
        } else {
            Participate.assertParticipate(
                player,
                village,
                charaId,
                firstRequestSkill,
                secondRequestSkill,
                isSpectate,
                password
            )
        }
    }

    /**
     * 村に参加
     * @param villageId villageId
     * @param playerId playerId
     * @param charaId charaId
     * @param message 入村時発言
     * @param isSpectate 見学か
     * @param firstRequestSkill 役職第1希望
     * @param secondRequestSkill 役職第2希望
     * @param password 入村パスワード
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun participate(
        villageId: Int,
        playerId: Int,
        charaId: Int,
        message: String,
        isSpectate: Boolean,
        firstRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        password: String?
    ) {
        // 村参加者登録
        val participantId: Int = villageService.registerVillageParticipant(
            villageId = villageId,
            playerId = playerId,
            charaId = charaId,
            message = message,
            firstRequestSkill = firstRequestSkill,
            secondRequestSkill = secondRequestSkill,
            isSpectate = isSpectate
        )
        val village: Village = villageService.findVillage(villageId)
        val chara: Chara = charachipService.findChara(charaId)
        // {N}人目、{キャラ名} とユーザー入力の発言
        messageService.registerParticipateMessage(
            village = village,
            participant = village.participant.member(participantId),
            chara = chara,
            message = message,
            isSpectate = isSpectate
        )
    }

    /**
     * 退村
     * @param villageId villageId
     * @param user user
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun leaveVillage(villageId: Int, user: Wolf4busyUser) {
        // 退村できない状況ならエラー
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)
        Leave.assertLeave(village, participant)
        // 退村
        villageService.leaveVillage(participant!!)
        // 退村メッセージ
        val chara = charachipService.findChara(participant.charaId)
        messageService.registerLeaveMessage(village, chara)
    }

    /**
     * 発言できるか確認
     *
     * @param villageId villageId
     * @param user user
     * @param messageText 発言内容
     * @param messageType 発言種別
     * @param faceType 表情種別
     */
    fun confirmToSay(villageId: Int, user: Wolf4busyUser, messageText: String, messageType: String, faceType: String) {
        val messageContent = MessageContent.invoke(messageType, messageText, faceType)
        // 発言できない状況ならエラー
        assertSay(villageId, user, messageContent)
    }

    /**
     * 発言
     *
     * @param villageId villageId
     * @param user user
     * @param messageText 発言内容
     * @param messageType 発言種別
     * @param faceType 表情種別
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun say(villageId: Int, user: Wolf4busyUser, messageText: String, messageType: String, faceType: String) {
        val messageContent = MessageContent.invoke(messageType, messageText, faceType)
        // 発言できない状況ならエラー
        assertSay(villageId, user, messageContent)
        // 発言
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)!!
        val message = Message.createSayMessage(participant, village.day.latestDay().id, messageContent)
        messageService.registerSayMessage(villageId, message)
    }

    /**
     * 能力セット
     *
     * @param villageId villageId
     * @param user user
     * @param targetId 対象村参加者ID
     * @param abilityType 能力種別
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun setAbility(villageId: Int, user: Wolf4busyUser, targetId: Int?, abilityType: String) {
        // 能力セットできない状況ならエラー
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)
        val ability = Ability(abilityType)
        ability.assertAbility(village, participant, targetId)
        // 能力セット
        val villageAbility = VillageAbility(village.day.latestDay().id, participant!!.id, targetId, ability)
        abilityService.updateAbility(villageAbility)
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        messageService.registerAbilitySetMessage(village, participant, targetId, ability, charas)
    }

    /**
     * 投票セット
     *
     * @param villageId villageId
     * @param user user
     * @param targetId 対象村参加者ID
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun setVote(villageId: Int, user: Wolf4busyUser, targetId: Int) {
        // 投票セットできない状況ならエラー
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)
        Vote.assertVote(village, participant, targetId)
        // 投票
        voteService.updateVote(village.day.latestDay().id, participant!!, targetId)
    }

    /**
     * コミットセット
     *
     * @param villageId villageId
     * @param user user
     * @param doCommit コミットするか
     */
    @Transactional(rollbackFor = [Exception::class, Wolf4busyBusinessException::class])
    fun setCommit(villageId: Int, user: Wolf4busyUser, doCommit: Boolean) {
        // コミットできない状況ならエラー
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)
        Commit.assertCommit(village, participant)
        // コミット
        val commit = Commit(village.day.latestDay().id, participant!!.id, doCommit)
        commitService.updateCommit(commit)
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        messageService.registerCommitMessage(villageId, village.day.latestDay().id, participant, charas, doCommit)
        // 日付更新
        if (doCommit) dayChangeCoordinator.dayChangeIfNeeded(village)
    }

    /**
     * 参加状況や可能なアクションを取得
     * @param villageId villageId
     * @param user user
     */
    fun findActionSituation(villageId: Int, user: Wolf4busyUser?): SituationAsParticipant {
        val village: Village = villageService.findVillage(villageId)
        val player = if (user == null) null else playerService.findPlayer(user)
        val participant: VillageParticipant? = if (user == null) null else villageService.findParticipantByUid(villageId, user.uid)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val skillRequest: SkillRequest? = villageService.findSkillRequest(participant)
        val abilities: VillageAbilities = abilityService.findVillageAbilities(villageId)
        val votes: VillageVotes = voteService.findVillageVotes(villageId)
        val commit: Commit? = commitService.findCommit(village, participant)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)

        return SituationAsParticipant(
            village,
            player,
            participant,
            charas,
            skillRequest,
            abilities,
            votes,
            commit,
            latestDayMessageList
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun participateDummyChara(villageId: Int, village: Village, dummyChara: Chara) {
        val dummyPlayerId = 1 // 固定
//        val message = "人狼なんているわけないじゃん。みんな大げさだなあ\n>>1>>*1>>+1>>=1>>#1aaa>>-1>>@1" // TODO
        val message = dummyChara.defaultMessage.joinMessage ?: "人狼なんているわけないじゃん。みんな大げさだなあ"
        this.participate(
            villageId = villageId,
            playerId = dummyPlayerId,
            charaId = village.setting.charachip.dummyCharaId,
            message = message,
            isSpectate = false,
            password = ""
        )
    }

    private fun assertSay(villageId: Int, user: Wolf4busyUser?, messageContent: MessageContent) {
        val village: Village = villageService.findVillage(villageId)
        val participant: VillageParticipant? = if (user == null) null else villageService.findParticipantByUid(villageId, user.uid)
        val chara = if (participant == null) null else charachipService.findChara(participant.charaId)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)
        Say.assertSay(village, participant, chara, latestDayMessageList, messageContent)
    }
}
