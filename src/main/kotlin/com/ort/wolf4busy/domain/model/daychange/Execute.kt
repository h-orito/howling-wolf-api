package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.vote.VillageVote

object Execute {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        // 1→2日目は処刑なし
        if (dayChange.village.day.latestDay().day <= 2) {
            return dayChange
        }

        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()

        // 得票 key: target participant id, value: vote list
        val votedMap = dayChange.votes.list
            .filter { village.participant.member(it.myselfId).isAlive() }
            .groupBy { it.targetId }

        if (votedMap.isEmpty()) return dayChange // 全員突然死

        // 個別投票メッセージ
        messages = messages.add(Message.createEachVoteMessage(village, charas, votedMap))

        // 得票数トップの参加者リスト
        val maxVotedParticipantIdList = filterMaxVotedParticipantList(votedMap)
        // うち一人を処刑する
        maxVotedParticipantIdList.shuffled().first().let { executedParticipantId ->
            // 処刑（突然死していた場合は死因を上書きしない）
            if (village.participant.member(executedParticipantId).isAlive()) village = village.executeParticipant(executedParticipantId, village.day.latestDay())
            // 処刑メッセージ
            messages = messages.add(Message.createExecuteMessage(village, executedParticipantId, votedMap, charas))
        }
        return dayChange.copy(
            village = village,
            messages = messages
        ).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 得票数トップの参加者idリスト
    private fun filterMaxVotedParticipantList(votedMap: Map<Int, List<VillageVote>>): List<Int> {
        // 最大得票数
        val maxVotedCount = votedMap.maxBy { it.value.size }!!.value.size
        // 最大得票数の参加者idリスト
        return votedMap.filter { it.value.size == maxVotedCount }.keys.toList()
    }
}
