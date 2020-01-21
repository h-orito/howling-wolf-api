package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.ability.Attack
import com.ort.wolf4busy.domain.model.ability.Divine
import com.ort.wolf4busy.domain.model.ability.Guard
import com.ort.wolf4busy.domain.model.ability.Psychic
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Progress {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    fun addDayIfNeeded(dayChange: DayChange, commits: Commits): DayChange {
        // 日付更新の必要がなかったら終了
        if (!shouldForward(dayChange.village, commits)) return dayChange
        // 日付追加
        return addNewDay(dayChange).setIsChange(dayChange)
    }

    fun dayChange(
        beforeDayChange: DayChange,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        // 突然死
        var dayChange = SuddenlyDeath.process(beforeDayChange, todayMessages, charas)

        // 処刑
        dayChange = Execute.process(dayChange, charas)

        // 霊能
        dayChange = Psychic.process(dayChange, charas)

        // 占い
        dayChange = Divine.process(dayChange, charas)

        // 護衛
        dayChange = Guard.process(dayChange, charas)

        // 襲撃
        dayChange = Attack.process(dayChange, charas)

        // 無惨メッセージ
        dayChange = MiserableDeath.process(dayChange, charas)

        // 2日目限定メッセージ
        dayChange = addDay2MessageIfNeeded(dayChange)

        // 勝敗
        dayChange = Epilogue.transitionToEpilogueIfNeeded(dayChange)

        // 勝敗が決していたらここで終了
        if (dayChange.village.status.isSolved()) return dayChange.setIsChange(beforeDayChange)

        // 投票や能力行使のデフォルト設定
        dayChange = addDefaultVoteAndAbilities(dayChange)

        // 生存者メッセージ登録
        dayChange = addAliveMemberMessage(dayChange, charas)

        return dayChange.setIsChange(beforeDayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 日付を進める必要があるか
    private fun shouldForward(village: Village, commits: Commits): Boolean {
        // 全員コミットしている
        if (allCommitted(village, commits)) return true
        // 更新日時を過ぎている
        return !Wolf4busyDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)
    }

    private fun allCommitted(village: Village, commits: Commits): Boolean {
        if (!village.setting.rules.availableCommit) return false
        // ダミーを除く最新日の生存者数
        val livingPersonCount = village.notDummyParticipant().filterAlive().count
        // コミット数
        val commitCount = commits.list.filter { it.villageDayId == village.day.latestDay().id && it.isCommitting }.size

        return livingPersonCount == commitCount
    }

    // 日付追加
    private fun addNewDay(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.addNewDay()
        ).setIsChange(dayChange)
    }

    private fun addDay2MessageIfNeeded(dayChange: DayChange): DayChange {
        val village = dayChange.village
        if (village.day.latestDay().day != 2) return dayChange
        return dayChange.copy(
            messages = dayChange.messages.add(village.createVillageDay2Message())
        ).setIsChange(dayChange)
    }

    // 生存者メッセージ
    private fun addAliveMemberMessage(dayChange: DayChange, charas: Charas): DayChange {
        return dayChange.copy(
            messages = dayChange.messages.add(createAliveMemberMessage(dayChange.village, charas))
        ).setIsChange(dayChange)
    }

    private fun createAliveMemberMessage(village: Village, charas: Charas): Message {
        val text = village.participant.filterAlive().memberList.joinToString(
            separator = "\n",
            prefix = "現在の生存者は以下の${village.participant.filterAlive().count}名。\n"
        ) { member ->
            charas.chara(member.charaId).charaName.name
        }
        return Message.createPublicSystemMessage(text, village.day.latestDay().id)
    }

    // デフォルト投票能力行使
    private fun addDefaultVoteAndAbilities(dayChange: DayChange): DayChange {
        val abilities = dayChange.abilities.addDefaultAbilities(village = dayChange.village)
        val votes = dayChange.votes.addDefaultVote(village = dayChange.village)
        return dayChange.copy(
            abilities = abilities,
            votes = votes
        ).setIsChange(dayChange)
    }
}
