package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.vote.Vote

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
            .filter {
                it.villageDayId == village.day.yesterday().id &&
                    village.participant.member(it.myselfId).isAlive()
            }
            .groupBy { it.targetId }

        if (votedMap.isEmpty()) return dayChange // 全員突然死

        // 個別投票メッセージ
        messages = messages.add(Vote.createEachVoteMessage(village, charas, votedMap))

        // 得票数トップの参加者リスト
        val maxVotedParticipantIdList = filterMaxVotedParticipantList(votedMap)
        // うち一人を処刑する
        maxVotedParticipantIdList.shuffled().first().let { executedParticipantId ->
            // 処刑（突然死していた場合は死因を上書きしない）
            if (village.participant.member(executedParticipantId).isAlive()) {
                village = village.executeParticipant(executedParticipantId, village.day.latestDay())
            }
            // 処刑メッセージ
            messages = messages.add(createExecuteMessage(village, executedParticipantId, votedMap, charas))
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

    /**
     * 処刑メッセージ
     * @param village village
     * @param participantId 処刑される村参加者ID
     * @param votedMap key: 非投票参加者ID, value: 投票
     * @param charas charas
     * @return 処刑メッセージ
     */
    private fun createExecuteMessage(
        village: Village,
        participantId: Int,
        votedMap: Map<Int, List<VillageVote>>,
        charas: Charas
    ): Message {
        val executedCharaName = charas.chara(village.participant, participantId).charaName.name
        val message = votedMap.entries.sortedBy { it.value.size }.reversed().joinToString(
            separator = "\n",
            postfix = "\n\n${executedCharaName}は村人達の手により処刑された。"
        ) { entry ->
            val votedCharaName = charas.chara(village.participant, entry.key).charaName.name
            "${votedCharaName}、${entry.value.size}票"
        }
        return Message.createPublicSystemMessage(
            message,
            village.day.latestDay().id
        )
    }
}
