package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.camp.Camp
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Epilogue {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun transitionToEpilogueIfNeeded(dayChange: DayChange): DayChange {
        val villagerCount = dayChange.village.participant.memberList.count { it.isAlive() && !it.skill!!.toCdef().isCountWolf }
        val wolfCount = dayChange.village.participant.memberList.count { it.isAlive() && it.skill!!.toCdef().isCountWolf }

        // 狼勝利
        if (villagerCount <= wolfCount) return epilogueVillage(dayChange, CDef.Camp.人狼陣営).setIsChange(dayChange)
        // 村勝利
        else if (wolfCount <= 0) return epilogueVillage(dayChange, CDef.Camp.村人陣営).setIsChange(dayChange)
        // まだ決着がついていない
        return dayChange
    }

    fun addDayIfNeeded(dayChange: DayChange): DayChange {
        // 日付更新の必要がなかったら終了
        if (!shouldForward(dayChange.village)) return dayChange
        // 日付追加
        return addNewDay(dayChange).setIsChange(dayChange)
    }

    fun dayChange(dayChange: DayChange): DayChange {
        // ステータス変更
        var village = dayChange.village.changeStatus(CDef.VillageStatus.終了)
        return dayChange.copy(village = village).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun epilogueVillage(dayChange: DayChange, winCamp: CDef.Camp): DayChange {
        // ステータス変更
        var village = dayChange.village.changeStatus(CDef.VillageStatus.エピローグ)
        // 勝利陣営設定、勝敗設定
        village = village.win(winCamp)
        // エピローグ遷移メッセージ登録
        var messages = dayChange.messages.add(Camp.createWinCampMessage(winCamp, village.day.latestDay().id))
        // 参加者一覧メッセージ登録
        messages = messages.add(Message.createParticipantsMessage(village.day.latestDay().id))
        // エピローグは固定で24時間にするので、最新日を差し替える
        village = village.extendLatestDay()

        return dayChange.copy(
            village = village,
            messages = messages
        )
    }

    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean {
        // 更新日時を過ぎている
        return !Wolf4busyDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)
    }

    // 日付追加
    private fun addNewDay(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.addNewDay()
        )
    }
}
