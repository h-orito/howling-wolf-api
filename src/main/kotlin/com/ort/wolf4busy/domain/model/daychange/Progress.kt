package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.ability.Divine
import com.ort.wolf4busy.domain.model.ability.Guard
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Progress {

    fun dayChange(
        village: Village,
        votes: VillageVotes,
        abilities: VillageAbilities,
        commits: Commits,
        todayMessages: Messages,
        charas: Charas,
        players: Players
    ): DayChange {
        var dayChange = DayChange(
            isChange = false, // あとで更新
            village = village.copy(),
            messages = Messages(listOf()),
            votes = votes.copy(),
            abilities = abilities.copy(),
            players = players.copy()
        )

        // 日付更新の必要がなかったら終了
        if (!shouldForward(dayChange.village, commits)) return dayChange

        // 日付追加
        dayChange = addNewDay(dayChange)

        // 突然死
        dayChange = SuddenlyDeath.process(dayChange, todayMessages, charas)

        // 処刑
        dayChange = Execute.process(dayChange, charas)

        // 霊能
        dayChange = Psychic.process(dayChange, charas)

        // 占い
        dayChange = Divine.process(dayChange, charas)

        // 護衛
        dayChange = Guard.process(dayChange, charas)

        // 襲撃

        // 無惨メッセージ


        return dayChange
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 日付を進める必要があるか
    private fun shouldForward(village: Village, commits: Commits): Boolean {
        // 全員コミットしている
        if (allCommited(village, commits)) return true
        // 更新日時を過ぎている
        return !Wolf4busyDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)
    }

    private fun allCommited(village: Village, commits: Commits): Boolean {
        if (!village.setting.rules.availableCommit) return false
        // ダミーを除く最新日の生存者数
        val livingPersonCount = village.notDummyParticipant().filterAlive().count
        // コミット数
        val commitCount = commits.list.filter { it.villageDayId == village.day.latestDay().id && it.isCommiting }.size

        return livingPersonCount == commitCount
    }

    // 日付追加
    private fun addNewDay(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.addNewDay()
        )
    }
}
