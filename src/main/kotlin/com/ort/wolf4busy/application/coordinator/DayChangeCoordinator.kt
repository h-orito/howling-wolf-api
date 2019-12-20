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
        val todayMessages =
            messageService.findMessageList(village.id, village.day.latestDay().id, listOf(CDef.MessageType.通常発言), null, null)
        val charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val players = playerService.findPlayers(village.id)

        // 必要があれば日付更新
        val dayChange = DayChange.invoke(
            village = village,
            votes = votes,
            abilities = abilities,
            commits = commits,
            todayMessages = todayMessages,
            charas = charas,
            players = players
        )

        // 更新があれば更新
        if (dayChange.isChange) {
            // TODO
        }
    }
}