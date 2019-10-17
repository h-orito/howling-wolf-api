package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.CharachipService
import com.ort.wolf4busy.application.service.MessageService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
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
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ
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
            participateNumber = participateCount + 1, // 何人目か
            isSpectate = isSpectate
        )

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
        val message: String = "人狼なんているわけないじゃん。みんな大げさだなあ" // TODO
        this.participate(
            villageId = villageId,
            playerId = dummyPlayerId,
            charaId = village.setting.charachip.dummyCharaId,
            message = message,
            isSpectate = false
        )
    }
}