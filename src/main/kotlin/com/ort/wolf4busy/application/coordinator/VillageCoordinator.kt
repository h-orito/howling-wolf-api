package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.*
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.action.VillageAbilitySituations
import com.ort.wolf4busy.domain.model.village.action.VillageVoteSituation
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service


@Service
class VillageCoordinator(
    val villageService: VillageService,
    val messageService: MessageService,
    val charachipService: CharachipService,
    val abilityService: AbilityService,
    val voteService: VoteService
) {

    /**
     * 村登録
     * @param village village
     * @param villagePassword villagePassword
     */
    fun registerVillage(village: Village, villagePassword: String?): Int {
        // 作成権限がなければNG
        if (!canRegisterVillage()) throw Wolf4busyBusinessException("村を作成できません。")
        // 村を登録
        val villageId: Int = villageService.registerVillage(village)
        // 村設定を登録
        villageService.registerVillageSettings(villageId, village.setting, villagePassword)
        // 発言制限を登録
        villageService.registerMessageRestriction(villageId, village.setting)
        // 村日付を登録
        val villageDayId = villageService.registerVillageDay(villageId, 0, CDef.Noonnight.昼, village.setting.time.startDatetime)
        // 村作成時のシステムメッセージを登録
        messageService.registerInitialMessage(villageId, villageDayId)
        // ダミーキャラを参加させる
        participateDummyChara(villageId, village)
        // tweet TODO

        // 日付更新完了
        villageService.updateVillageDayUpdateComplete(villageDayId)

        return villageId
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
     */
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
        val village: Village = villageService.findVillage(villageId)
        // 参加できない状況ならエラー
        val charachipCharaNum =
            if (!isSpectate) 0 else charachipService.findCharaChip(village.setting.charachip.charachipId).charaIdList.size
        val isCollectPassword =
            if (!village.setting.password.joinPasswordRequired) true else villageService.isCollectPassword(village.id, password)
        village.assertParticipate(
            playerId,
            charaId,
            firstRequestSkill,
            secondRequestSkill,
            isSpectate,
            charachipCharaNum,
            isCollectPassword
        )

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
        // 0日目昼
        val villageDay: VillageDay = villageService.findVillageDay(villageId, 0, CDef.Noonnight.昼.code())
        // キャラ
        val chara: Chara = charachipService.findChara(charaId)
        // 何人参加しているか
        val participateCount: Int = villageService.findParticipateCount(villageId, isSpectate)
        // {N}人目、{キャラ名} と
        // ユーザー入力の発言
        messageService.registerParticipateMessage(
            villageId = villageId,
            villageDayId = villageDay.id,
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
    fun leaveVillage(villageId: Int, user: Wolf4busyUser) {
        val participant = villageService.findParticipantByUid(villageId, user.uid) ?: throw IllegalStateException("セッション切れ？")
        val village = villageService.findVillage(villageId)
        if (!village.status.isPrologue()) return // 開始直前に変更しようとして間に合わなかった
        // 退村
        villageService.leaveVillage(participant)
        // 退村メッセージ
        val chara = charachipService.findChara(participant.charaId)
        messageService.registerLeaveMessage(village.id, chara, village.day.prologue().id)
    }

    /**
     * 発言できるか確認
     *
     * @param villageId villageId
     * @param user user
     * @param message 発言内容
     * @param messageType 発言種別
     * @param faceType 表情種別
     */
    fun confirmToSay(villageId: Int, user: Wolf4busyUser, message: String, messageType: String, faceType: String) {
        val participant = villageService.findParticipantByUid(villageId, user.uid) ?: throw IllegalStateException("セッション切れ？")
        CDef.FaceType.codeOf(faceType) ?: throw IllegalStateException("改竄")
        val village = villageService.findVillage(villageId)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        // 発言できるか
        val isAvailableSay = village.isAvailableSay(user, participant, message, messageType, faceType, latestDayMessageList, charas)
        if (!isAvailableSay) throw Wolf4busyBusinessException("発言できません")
    }

    /**
     * 発言
     *
     * @param villageId villageId
     * @param user user
     * @param message 発言内容
     * @param messageType 発言種別
     * @param faceType 表情種別
     */
    fun say(villageId: Int, user: Wolf4busyUser, message: String, messageType: String, faceType: String) {
        val participant = villageService.findParticipantByUid(villageId, user.uid) ?: throw IllegalStateException("セッション切れ？")
        CDef.FaceType.codeOf(faceType) ?: throw IllegalStateException("改竄")
        val village = villageService.findVillage(villageId)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        // 発言できるか
        val isAvailableSay = village.isAvailableSay(user, participant, message, messageType, faceType, latestDayMessageList, charas)
        if (!isAvailableSay) throw Wolf4busyBusinessException("発言できません")

        // 発言
        messageService.registerSayMessage(villageId, village.day.latestDay().id, participant, message, messageType, faceType)
    }

    /**
     * 能力セット
     *
     * @param villageId villageId
     * @param user user
     * @param targetId 対象村参加者ID
     */
    fun setAbility(villageId: Int, user: Wolf4busyUser, targetId: Int?, abilityType: String) {
        val participant = villageService.findParticipantByUid(villageId, user.uid) ?: throw IllegalStateException("セッション切れ？")
        val village = villageService.findVillage(villageId)
        val abilities: VillageAbilities = abilityService.findVillageAbilities(villageId)
        val villageAbilitySituations = VillageAbilitySituations(village, participant, abilities)
        val isSettable = villageAbilitySituations.isSettableAbility(targetId, abilityType)
        if (!isSettable) throw Wolf4busyBusinessException("能力セットできません")
        abilityService.updateAbility(village.day.latestDay().id, participant, targetId, abilityType)
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
    fun setVote(villageId: Int, user: Wolf4busyUser, targetId: Int) {
        val participant = villageService.findParticipantByUid(villageId, user.uid) ?: throw IllegalStateException("セッション切れ？")
        val village = villageService.findVillage(villageId)
        val votes: VillageVotes = voteService.findVillageVotes(villageId)
        val villageVoteSituation = VillageVoteSituation(village, participant, votes)
        val isSettable = villageVoteSituation.isSettableVote(targetId)
        if (!isSettable) throw Wolf4busyBusinessException("投票セットできません")
        voteService.updateVote(village.day.latestDay().id, participant, targetId)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun canRegisterVillage(): Boolean {
        // TODO 管理者はOK
        // TODO 参加権限がなければNG
        // TODO 終了していない村に参加している場合NG
        // TODO 自分が作成した村が終了していなければNG
        return true
    }

    private fun participateDummyChara(villageId: Int, village: Village) {
        val dummyPlayerId = 1 // 固定
        val message: String = "人狼なんているわけないじゃん。みんな大げさだなあ\n>>1>>*1>>+1>>=1>>#1aaa>>-1>>@1" // TODO
        this.participate(
            villageId = villageId,
            playerId = dummyPlayerId,
            charaId = village.setting.charachip.dummyCharaId,
            message = message,
            isSpectate = false,
            password = ""
        )
    }
}
