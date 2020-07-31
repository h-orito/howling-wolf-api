package com.ort.howlingwolf.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.application.service.AbilityService
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.CommitService
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.application.service.VoteService
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.commit.Commits
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.MessageQuery
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.domain.service.daychange.DayChangeDomainService
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DayChangeCoordinator(
    val villageService: VillageService,
    val voteService: VoteService,
    val abilityService: AbilityService,
    val commitService: CommitService,
    val messageService: MessageService,
    val charachipService: CharachipService,
    val playerService: PlayerService,
    // domain service
    val dayChangeDomainService: DayChangeDomainService
) {

    /**
     * 必要あれば日付更新
     *
     * @param village village
     */
    @Transactional(rollbackFor = [Exception::class, HowlingWolfBusinessException::class])
    fun dayChangeIfNeeded(village: Village) {
        val votes: VillageVotes = voteService.findVillageVotes(village.id)
        val abilities: VillageAbilities = abilityService.findVillageAbilities(village.id)
        val commits: Commits = commitService.findCommits(village.id)
        // 最新日の通常発言
        val todayMessages = messageService.findMessages(village.id, village.day.latestDay().id, MessageQuery(listOf(CDef.MessageType.通常発言)))
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(village.id)

        val beforeDayChange = DayChange(village.copy(
            participant = village.participant.copy(
                count = village.participant.memberList.count { !it.isGone },
                memberList = village.participant.memberList.filter { !it.isGone }
            )
        ), votes, abilities, players)

        // プロローグで長時間発言していない人を退村させる
        var dayChange = dayChangeDomainService.leaveParticipantIfNeeded(
            dayChange = beforeDayChange,
            todayMessages = todayMessages,
            charas = charas
        ).let { updateIfNeeded(beforeDayChange, it) }

        // 廃村やプロローグ延長処理
        val isExistOtherPrologueVillage = villageService.findVillages(
            villageStatusList = listOf(VillageStatus(CDef.VillageStatus.プロローグ))
        ).list.any { it.id != village.id }
        dayChange = updateIfNeeded(
            dayChange,
            dayChangeDomainService.cancelOrExtendVillageIfNeeded(dayChange, isExistOtherPrologueVillage)
        )

        // 廃村になっていたらここで終了
        if (dayChange.village.status.toCdef() == CDef.VillageStatus.廃村) return

        // 必要あれば日付追加
        dayChange = dayChangeDomainService.addDayIfNeeded(dayChange, commits).let {
            if (!it.isChange) return
            updateIfNeeded(dayChange, it)
        }

        // 登録後の村日付idが必要になるので取得し直す
        dayChange = dayChange.copy(village = villageService.findVillage(village.id))

        // 日付更新
        dayChangeDomainService.process(dayChange, todayMessages, charas).also {
            updateIfNeeded(dayChange, it)
        }
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun updateIfNeeded(before: DayChange, after: DayChange): DayChange {
        if (!after.isChange) return after
        update(before, after)
        return after.copy(isChange = false)
    }

    private fun update(before: DayChange, after: DayChange) {
        // player
        if (before.players.existsDifference(after.players)) {
            playerService.updateDifference(before.players, after.players)
        }
        // village
        if (before.village.existsDifference(after.village)) {
            villageService.updateVillageDifference(before.village, after.village)
        }
        // message
        if (before.messages.existsDifference(after.messages)) {
            messageService.updateDifference(before.village.id, before.messages, after.messages)
        }
        // votes
        if (before.votes.existsDifference(after.votes)) {
            voteService.updateDifference(before.votes, after.votes)
        }
        // abilities
        if (before.abilities.existsDifference(after.abilities)) {
            abilityService.updateDifference(before.abilities, after.abilities)
        }
    }
}