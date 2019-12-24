package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.VillageDay

object Epilogue {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun transitionToEpilogueIfNeeded(dayChange: DayChange, charas: Charas): DayChange {
        val villagerCount = dayChange.village.participant.memberList.count { it.isAlive() && !it.skill!!.toCdef().isCountWolf }
        val wolfCount = dayChange.village.participant.memberList.count { it.isAlive() && it.skill!!.toCdef().isCountWolf }

        // 狼勝利
        if (villagerCount <= wolfCount) return epilogueVillage(dayChange, CDef.Camp.人狼陣営, charas)
        // 村勝利
        else if (wolfCount <= 0) return epilogueVillage(dayChange, CDef.Camp.村人陣営, charas)
        // まだ決着がついていない
        return dayChange
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun epilogueVillage(dayChange: DayChange, winCamp: CDef.Camp, charas: Charas): DayChange {
        // ステータス変更
        var village = dayChange.village.changeStatus(CDef.VillageStatus.エピローグ)
        // 勝利陣営設定、勝敗設定
        village = village.win(winCamp)
        // エピローグ遷移メッセージ登録
        var messages = dayChange.messages.add(createEpilogueMessage(winCamp, village.day.latestDay()))
        // 参加者一覧メッセージ登録
        messages = messages.add(createParticipantsMessage(village.day.latestDay()))
        // エピローグは固定で24時間にするので、最新日を差し替える
        village = village.extendLatestDay()

        return dayChange.copy(
            village = village,
            messages = messages
        )
    }

    private fun createEpilogueMessage(winCamp: CDef.Camp, latestDay: VillageDay): Message {
        val message = when (winCamp) {
            CDef.Camp.村人陣営 -> "全ての人狼を退治した。人狼に怯える日々は去ったのだ！"
            CDef.Camp.人狼陣営 -> "もう人狼に抵抗できるほど村人は残っていない。\n人狼は残った村人を全て食らい、別の獲物を求めて村を去っていった。"
            CDef.Camp.狐陣営 -> "全ては終わったかのように見えた。\nだが、奴が生き残っていた。"
        }
        return DayChange.createPublicSystemMessage(message, latestDay.day)
    }

    private fun createParticipantsMessage(latestDay: VillageDay): Message {
        // 別途情報取得して表示させるので、参加者一覧であることだけわかればok
        return DayChange.createParticipantsMessage(latestDay.day)
    }
}
