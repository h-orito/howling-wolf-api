package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
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
        messages = messages.add(createEachVoteMessage(votedMap, village, charas))

        // 得票数トップの参加者リスト
        val maxVotedParticipantIdList = excludeMaxVotedParticipantList(votedMap)
        // うち一人を処刑する
        maxVotedParticipantIdList.shuffled().first().let { executedParticipantId ->
            // 処刑（突然死していた場合は死因を上書きしない）
            if (village.participant.member(executedParticipantId).isAlive()) village = village.executeParticipant(executedParticipantId, village.day.latestDay())
            // 処刑メッセージ
            messages = messages.add(createExecuteMessage(executedParticipantId, votedMap, village, charas))
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
    private fun excludeMaxVotedParticipantList(votedMap: Map<Int, List<VillageVote>>): List<Int> {
        // 最大得票数
        val maxVotedCount = votedMap.maxBy { it.value.size }!!.value.size
        // 最大得票数の参加者idリスト
        return votedMap.filter { it.value.size == maxVotedCount }.keys.toList()
    }

    private fun createEachVoteMessage(votedMap: Map<Int, List<VillageVote>>, village: Village, charas: Charas): Message {
        val maxFromCharaNameLength = votedMap.values.flatten().map { vote ->
            charas.list.first { chara ->
                chara.id == village.participant.memberList.first { member ->
                    member.id == vote.myselfId
                }.charaId
            }.charaName.name.length
        }.max()!!
        val maxToCharaNameLength = votedMap.values.flatten().map { vote ->
            charas.list.first { chara ->
                chara.id == village.participant.memberList.first { member ->
                    member.id == vote.targetId
                }.charaId
            }.charaName.name.length
        }.max()!!

        val text = votedMap.entries.sortedBy { it.value.size }.reversed().map { entry ->
            // 得票数が多い順
            entry.value.map { vote ->
                val fromCharaName = extractCharaName(vote.myselfId, village, charas)
                val toCharaName = extractCharaName(vote.targetId, village, charas)
                val voteCountStr = "${entry.value.size}票"
                "${fromCharaName.padEnd(length = maxFromCharaNameLength, padChar = '　')} → ${toCharaName.padEnd(
                    maxToCharaNameLength,
                    '　'
                )}(${voteCountStr})"
            }
        }.flatten().joinToString(
            prefix = "投票結果は以下の通り。\n",
            separator = "\n"
        )

        return if (village.setting.rules.openVote) {
            DayChange.createPublicSystemMessage(text, village.day.latestDay())
        } else {
            DayChange.createPrivateSystemMessage(text, village.day.latestDay())
        }
    }

    private fun createExecuteMessage(participantId: Int, votedMap: Map<Int, List<VillageVote>>, village: Village, charas: Charas): Message {
        val executedCharaName = extractCharaName(participantId, village, charas)
        val message = votedMap.entries.sortedBy { it.value.size }.reversed().map { entry ->
            val votedCharaName = extractCharaName(entry.key, village, charas)
            "${votedCharaName}、${entry.value.size}票"
        }.joinToString(
            separator = "\n",
            postfix = "\n\n${executedCharaName}は村人達の手により処刑された。"
        )
        return DayChange.createPublicSystemMessage(
            text = message,
            day = village.day.latestDay()
        )
    }

    private fun extractCharaName(participantId: Int, village: Village, charas: Charas): String {
        return charas.list.first { chara ->
            chara.id == village.participant.memberList.first { member -> member.id == participantId }.charaId
        }.charaName.name
    }
}
