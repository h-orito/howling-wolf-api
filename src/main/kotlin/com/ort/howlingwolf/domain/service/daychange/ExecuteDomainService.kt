package com.ort.howlingwolf.domain.service.daychange

import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageDay
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.domain.service.vote.VoteDomainService
import org.springframework.stereotype.Service

@Service
class ExecuteDomainService(
    private val voteDomainService: VoteDomainService
) {

    fun processDayChangeAction(dayChange: DayChange, charas: Charas): DayChange {
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
        messages = messages.add(voteDomainService.createEachVoteMessage(village, charas, votedMap))

        // 得票数トップの参加者リスト
        val maxVotedParticipantIdList = filterMaxVotedParticipantList(votedMap)
        // うち一人を処刑する
        val executedParticipantId = getExecutedParticipantId(maxVotedParticipantIdList)
        // 処刑（突然死していた場合は死因を上書きしない）
        val executedParticipant = village.participant.member(executedParticipantId)
        if (executedParticipant.isAlive()) {
            village = village.executeParticipant(executedParticipantId, village.day.latestDay())
        }
        // 処刑メッセージ
        messages = messages.add(createExecuteMessage(village, executedParticipantId, votedMap, charas))

        // 猫又による道連れ
        if (executedParticipant.isAlive()) {
            forceSuicidedParticipant(village, dayChange.votes, executedParticipant)?.let {
                village = village.divineKillParticipant(it.id, village.day.latestDay())
                messages = messages.add(createForceSuicideMessage(executedParticipant, it, village.day.latestDay(), charas))
            }
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
        val executedCharaName = charas.chara(village.participant, participantId).charaName.fullName()
        val message = votedMap.entries.sortedBy { it.value.size }.reversed().joinToString(
            separator = "\n",
            postfix = "\n\n${executedCharaName}は村人達の手により処刑された。"
        ) { entry ->
            val votedCharaName = charas.chara(village.participant, entry.key).charaName.fullName()
            "${votedCharaName}、${entry.value.size}票"
        }
        return Message.createPublicSystemMessage(
            message,
            village.day.latestDay().id
        )
    }

    private fun forceSuicidedParticipant(
        village: Village,
        votes: VillageVotes,
        executedParticipant: VillageParticipant
    ): VillageParticipant? {
        // 処刑されたのが道連れ役職でなければ何もしない
        if (!executedParticipant.skill!!.toCdef().isForceDoubleSuicide) return null
        // 生存している投票者からランダムで1名を道連れにする
        return votes.filterYesterday(village).list.shuffled().firstOrNull {
            it.targetId == executedParticipant.id && village.participant.member(it.myselfId).isAlive()
        }?.let { village.participant.member(it.myselfId) }
    }

    private fun createForceSuicideMessage(
        executedParticipant: VillageParticipant,
        forceSuicidedParticipant: VillageParticipant,
        latestDay: VillageDay,
        charas: Charas
    ): Message {
        val executedCharaName = charas.chara(executedParticipant.charaId).charaName.fullName()
        val forceSuicidedCharaName = charas.chara(forceSuicidedParticipant.charaId).charaName.fullName()
        val message = "${executedCharaName}は、${forceSuicidedCharaName}を道連れにした。"
        return Message.createPrivateSystemMessage(
            message,
            latestDay.id
        )
    }

    private fun getExecutedParticipantId(maxVotedParticipantIdList: List<Int>): Int {
        return maxVotedParticipantIdList.shuffled().first()
    }
}