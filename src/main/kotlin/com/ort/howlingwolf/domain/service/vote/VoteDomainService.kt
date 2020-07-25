package com.ort.howlingwolf.domain.service.vote

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.myself.participant.VillageVoteSituation
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.vote.VillageVote
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service

@Service
class VoteDomainService {

    fun convertToSituation(
        village: Village,
        participant: VillageParticipant?,
        votes: VillageVotes
    ): VillageVoteSituation {
        return VillageVoteSituation(
            isAvailableVote = isAvailableVote(village, participant),
            targetList = getSelectableTargetList(village, participant),
            target = getSelectingTarget(village, participant, votes)
        )
    }

    fun assertVote(village: Village, participant: VillageParticipant?, targetId: Int) {
        if (!isAvailableVote(village, participant)) throw HowlingWolfBusinessException("投票できません")
        if (getSelectableTargetList(village, participant).none { it.id == targetId }) throw HowlingWolfBusinessException("投票できません")
    }

    /**
     * 投票結果メッセージ
     * @param village village
     * @param charas charas
     * @param votedMap key: 非投票参加者ID, value: 投票
     * @return 投票結果メッセージ
     */
    fun createEachVoteMessage(
        village: Village,
        charas: Charas,
        votedMap: Map<Int, List<VillageVote>>
    ): Message {
        val maxFromCharaNameLength = votedMap.values.flatten().map { vote ->
            charas.chara(village.participant, vote.myselfId).charaName.fullName().length
        }.max()!!
        val maxToCharaNameLength = votedMap.values.flatten().map { vote ->
            charas.chara(village.participant, vote.targetId).charaName.fullName().length
        }.max()!!

        val text = votedMap.entries.sortedBy { it.value.size }.reversed().map { entry ->
            // 得票数が多い順
            entry.value.map { vote ->
                val fromChara = charas.chara(village.participant, vote.myselfId)
                val toChara = charas.chara(village.participant, vote.targetId)
                createEachVoteResultString(
                    fromChara,
                    toChara,
                    maxFromCharaNameLength,
                    maxToCharaNameLength,
                    entry.value.size
                )
            }
        }.flatten().joinToString(
            prefix = "投票結果は以下の通り。\n",
            separator = "\n"
        )

        return if (village.setting.rules.openVote) {
            Message.createPublicSystemMessage(text, village.day.latestDay().id)
        } else {
            Message.createPrivateSystemMessage(text, village.day.latestDay().id)
        }
    }

    fun addDefaultVote(dayChange: DayChange): DayChange {
        val village = dayChange.village
        var votes = dayChange.votes

        // 最新日
        val latestVillageDayId = village.day.latestDay().id
        // 生存している人だけ自分に投票
        val newVoteList = village.participant.filterAlive().memberList.map { member ->
            VillageVote(
                villageDayId = latestVillageDayId,
                myselfId = member.id,
                targetId = member.id
            )
        }
        return dayChange.copy(
            votes = votes.addAll(newVoteList)
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * @param fromChara 投票したキャラ
     * @param toChara 投票されたキャラ
     * @param maxFromCharaNameLength 投票したキャラの最大文字数
     * @param maxToCharaNameLength 投票されたキャラの最大文字数
     * @param count 得票数
     * @return {キャラ名} -> {キャラ名}（{N}票）
     */
    private fun createEachVoteResultString(
        fromChara: Chara,
        toChara: Chara,
        maxFromCharaNameLength: Int,
        maxToCharaNameLength: Int,
        count: Int
    ): String {
        return fromChara.charaName.fullName().padEnd(
            length = maxFromCharaNameLength,
            padChar = '　'
        ) +
            " → " +
            toChara.charaName.fullName().padEnd(
                length = maxToCharaNameLength,
                padChar = '　'
            ) +
            "(${count}票)"
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAvailableVote(village: Village, participant: VillageParticipant?): Boolean {
        // 参加者として可能か
        participant ?: return false
        if (!participant.isAvailableVote()) return false
        // 村として可能か
        return village.isAvailableVote()
    }

    fun getSelectableTargetList(village: Village, participant: VillageParticipant?): List<VillageParticipant> {
        if (!isAvailableVote(village, participant)) return listOf()
        return village.participant.memberList.filter { it.isAlive() }
    }

    fun getSelectingTarget(village: Village, participant: VillageParticipant?, votes: VillageVotes): VillageParticipant? {
        if (!isAvailableVote(village, participant)) return null
        val voteTargetParticipantId = votes.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.myselfId == participant!!.id
        }?.targetId ?: return null
        return village.participant.member(voteTargetParticipantId)
    }
}