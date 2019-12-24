package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.*
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import org.springframework.stereotype.Service

@Service
class DayChangeCoordinator(
    val villageService: VillageService,
    val voteService: VoteService,
    val abilityService: AbilityService,
    val commitService: CommitService,
    val messageService: MessageService,
    val charachipService: CharachipService,
    val playerService: PlayerService
) {

    /**
     * 必要あれば日付更新
     *
     * @param village village
     */
    fun dayChangeIfNeeded(village: Village) {
        // 最新日の通常発言
        val votes: VillageVotes = voteService.findVillageVotes(village.id)
        val abilities: VillageAbilities = abilityService.findVillageAbilities(village.id)
        val commits: Commits = commitService.findCommits(village.id)
        val todayMessages = messageService.findMessageList(village.id, village.day.latestDay().id, listOf(CDef.MessageType.通常発言))
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val players = playerService.findPlayers(village.id)

        var dayChange = DayChange(village, votes, abilities, players)

        // プロローグで長時間発言していない人を退村させる
        dayChange = dayChange.leaveParticipantIfNeeded(todayMessages, charas).also { if (it.isChange) update() }

        // 必要あれば日付追加
        dayChange = dayChange.addDayIfNeeded(commits)

        if (!dayChange.isChange) return

        // 日付追加
        update()

        // 登録後の村日付idが必要になるので取得し直す
        // TODO 更新時にセットし直すほうが早いか？
        dayChange = dayChange.copy(village = villageService.findVillage(village.id))

        // 日付更新
        dayChange.process(todayMessages, charas).let { if (it.isChange) update() }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    fun update() {
        // TODO
    }
}