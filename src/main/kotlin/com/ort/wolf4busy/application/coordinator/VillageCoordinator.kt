package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.CharachipService
import com.ort.wolf4busy.application.service.MessageService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service


@Service
class VillageCoordinator(
    val villageService: VillageService,
    val messageService: MessageService,
    val charachipService: CharachipService
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
        assertParticipate(village, charaId, firstRequestSkill, secondRequestSkill, isSpectate)
        // パスワードが正しくないとエラー
        assertPassword(village, password, playerId)
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
        val participant = villageService.findParticipantByUid(villageId, user.uid)
        participant ?: throw IllegalStateException("セッション切れ？")
        val village = villageService.findVillage(villageId)
        if (!village.status.isPrologue()) return // 開始直前に変更しようとして間に合わなかった
        // 退村
        villageService.leaveVillage(participant)
        // 退村メッセージ
        val chara = charachipService.findChara(participant.charaId)
        messageService.registerLeaveMessage(village.id, chara, village.day.prologue().id)
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

    private fun assertParticipate(
        village: Village,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        isSpectate: Boolean
    ) {
        // 既に参加しているキャラはNG
        if (isAlreadyParticipateCharacter(village, charaId)) throw Wolf4busyBusinessException("既に参加されているキャラクターです")

        if (isSpectate) {
            // [キャラチップの人数 - 定員] 人を超えて見学はできない
            val charachipCharaNum = charachipService.findCharaChip(village.setting.charachip.charachipId).charaIdList.size
            if (charachipCharaNum - village.setting.capacity.max <= village.spectator.count) throw Wolf4busyBusinessException("既に上限人数まで見学者がいるため見学者として参加できません。")
        } else {
            if (village.setting.capacity.max <= village.participant.count) throw Wolf4busyBusinessException("既に上限人数までプレイヤーが参加しているため参加できません。")
            if (!village.setting.rules.availableSkillRequest &&
                (firstRequestSkill != CDef.Skill.おまかせ || secondRequestSkill != CDef.Skill.おまかせ)
            ) {
                throw Wolf4busyBusinessException("希望役職が不正です")
            }
        }
    }

    private fun isAlreadyParticipateCharacter(village: Village, charaId: Int): Boolean {
        return village.participant.memberList.any { it.charaId == charaId }
            || village.spectator.memberList.any { it.charaId == charaId }
    }

    private fun assertPassword(village: Village, password: String?, playerId: Int) {
        // ダミーはパスワードなしでOK
        if (playerId == 1 || !village.setting.password.joinPasswordRequired) return

        password ?: throw Wolf4busyBusinessException("入村パスワードが誤っています")
        if (!villageService.isCollectPassword(village.id, password)) {
            throw Wolf4busyBusinessException("入村パスワードが誤っています")
        }
    }
}
