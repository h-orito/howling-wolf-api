package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.*
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.myself.participant.*
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
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
        messageService.registerInitialMessage(village.id, village.day.latestDay().id)
        // ダミーキャラを参加させる
        participateDummyChara(village.id, village)
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
            village.assertSpectate(player, charas.list.size)
        } else {
            village.assertParticipate(
                player,
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
        val villagePlayerId: Int = villageService.registerVillagePlayer(
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
        // 何人参加しているか
        val participateCount: Int = if (isSpectate) village.spectator.count + 1 else village.participant.count + 1
        // {N}人目、{キャラ名} と
        // ユーザー入力の発言
        messageService.registerParticipateMessage(
            villageId = villageId,
            villageDayId = village.day.prologueDay().id,
            villagePlayerId = villagePlayerId,
            charaName = chara.charaName.name,
            firstRequestSkillName = firstRequestSkill.alias(),
            secondRequestSkillName = secondRequestSkill.alias(),
            message = message,
            participateNumber = participateCount, // 何人目か
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
        village.assertLeave(participant)
        // 退村
        villageService.leaveVillage(participant!!)
        // 退村メッセージ
        val chara = charachipService.findChara(participant.charaId)
        messageService.registerLeaveMessage(village.id, chara, village.day.prologue().id)
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
        // 発言できない状況ならエラー
        val situation = findSaySituation(villageId, user)
        val messageContent = MessageContent.invoke(messageType, messageText, faceType)
        situation.assertSay(messageContent)
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
        // 発言できない状況ならエラー
        val situation = findSaySituation(villageId, user)
        val messageContent = MessageContent.invoke(messageType, messageText, faceType)
        situation.assertSay(messageContent)
        // 発言
        val village = villageService.findVillage(villageId)
        val participant = villageService.findParticipantByUid(villageId, user.uid)!!
        messageService.registerSayMessage(villageId, village.day.latestDay().id, participant, messageContent)
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
        val situation = findAbilitySituation(village, user, participant)
        situation.assertAbility(targetId, abilityType)
        // 能力セット
        abilityService.updateAbility(village.day.latestDay().id, participant!!, targetId, abilityType)
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        messageService.registerAbilitySetMessage(villageId, participant, targetId, abilityType, village.day.latestDay().id, charas)
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
        val situation = findVoteSituation(village, participant)
        situation.assertVote(targetId)
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
        village.assertCommit(participant)
        // コミット
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        commitService.updateCommit(village.day.latestDay().id, participant!!, doCommit)
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
    private fun participateDummyChara(villageId: Int, village: Village) {
        val dummyPlayerId = 1 // 固定
        val message = "人狼なんているわけないじゃん。みんな大げさだなあ\n>>1>>*1>>+1>>=1>>#1aaa>>-1>>@1" // TODO
        this.participate(
            villageId = villageId,
            playerId = dummyPlayerId,
            charaId = village.setting.charachip.dummyCharaId,
            message = message,
            isSpectate = false,
            password = ""
        )
    }

    private fun findSaySituation(villageId: Int, user: Wolf4busyUser?): VillageSaySituation {
        val village: Village = villageService.findVillage(villageId)
        val participant: VillageParticipant? = if (user == null) null else villageService.findParticipantByUid(villageId, user.uid)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)

        return VillageSaySituation(
            village,
            participant,
            charas,
            latestDayMessageList
        )
    }

    fun findAbilitySituation(
        village: Village,
        user: Wolf4busyUser?,
        participant: VillageParticipant?
    ): VillageAbilitySituations {
        val abilities: VillageAbilities = abilityService.findVillageAbilities(village.id)
        return VillageAbilitySituations(
            village,
            participant,
            abilities
        )
    }

    private fun findVoteSituation(
        village: Village,
        participant: VillageParticipant?
    ): VillageVoteSituation {
        val votes: VillageVotes = voteService.findVillageVotes(village.id)
        return VillageVoteSituation(
            village,
            participant,
            votes
        )
    }

    private fun findCommitSituation(village: Village, participant: VillageParticipant?): VillageCommitSituation {
        val commit: Commit? = commitService.findCommit(village, participant)
        return VillageCommitSituation(
            village,
            participant,
            commit
        )
    }
}
