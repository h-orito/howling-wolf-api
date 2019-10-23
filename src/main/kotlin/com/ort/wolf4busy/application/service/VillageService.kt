package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class VillageService(
    val villageDataSource: VillageDataSource
) {

    /**
     * 村一覧取得
     * @return Villages
     */
    fun findVillageList(): Villages {
        return villageDataSource.selectVillages()
    }

    /**
     * 村取得
     * @param villageId villageId
     * @return Village
     */
    fun findVillage(villageId: Int): Village {
        return villageDataSource.selectVillage(villageId)
    }

    /**
     * 村登録
     * @param village village
     * @return villageId
     */
    fun registerVillage(village: Village): Int {
        return villageDataSource.insertVillage(village)
    }

    /**
     * 村設定登録
     * @param villageId villageId
     * @param villageSettings 村設定
     * @param password 村パスワード
     */
    fun registerVillageSettings(villageId: Int, villageSettings: VillageSettings, password: String?) {
        villageDataSource.insertVillageSettings(villageId, villageSettings, password)
    }

    /**
     * 村日付取得
     * @param villageId villageId
     * @param day 日付
     * @param noonnightCode 昼夜
     */
    fun findVillageDay(villageId: Int, day: Int, noonnightCode: String): com.ort.wolf4busy.domain.model.village.VillageDay {
        return villageDataSource.selectVillageDay(villageId, day, noonnightCode)
    }

    /**
     * 村日付登録
     * @param villageId villageId
     * @param day 日付
     * @param noonnight 昼夜
     * @param dayChangeDatetime 日付変更日時
     * @return 村日付ID
     */
    fun registerVillageDay(villageId: Int, day: Int, noonnight: CDef.Noonnight, dayChangeDatetime: LocalDateTime): Int {
        return villageDataSource.insertVillageDay(
            villageId, com.ort.wolf4busy.domain.model.village.VillageDay(
                id = 1, // dummy
                day = day,
                noonnight = noonnight.code(),
                startDatetime = dayChangeDatetime,
                isUpdating = true // dummy
            )
        )
    }

    /**
     * 村日付を更新完了にする
     * @param villageDayId 村日付ID
     */
    fun updateVillageDayUpdateComplete(villageDayId: Int) {
        villageDataSource.updateVillageDayUpdateComplete(villageDayId)
    }

    fun findParticipantByUid(villageId: Int, uid: String?): VillageParticipant? {
        uid ?: return null
        return villageDataSource.selectVillagePlayer(villageId, uid)
    }

    /**
     * 村参加者人数取得
     * @param villageId 村ID
     * @param isSpectate 見学か
     */
    fun findParticipateCount(villageId: Int, isSpectate: Boolean): Int {
        return villageDataSource.selectVillagePlayerCount(villageId, isSpectate)
    }

    /**
     * 村参加者登録
     * @param villageId villageId
     * @param playerId playerId
     * @param charaId charaId
     * @param message 参加時発言
     * @param firstRequestSkill 役職第1希望
     * @param secondRequestSkill 役職第2希望
     * @param isSpectate 見学か
     * @return 村参加者ID
     */
    fun registerVillagePlayer(
        villageId: Int,
        playerId: Int,
        charaId: Int,
        message: String,
        firstRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        isSpectate: Boolean = false
    ): Int {
        return villageDataSource.insertVillagePlayer(
            villageId,
            playerId,
            charaId,
            firstRequestSkill,
            secondRequestSkill,
            message,
            isSpectate
        )
    }

    /**
     * パスワードが正しいか
     *
     * @param villageId villageId
     * @param password 入村パスワード
     */
    fun isCollectPassword(villageId: Int, password: String): Boolean {
        val villagePassword: String = villageDataSource.selectVillagePassword(villageId)
        return villagePassword == password
    }
}
