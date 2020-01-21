package com.ort.wolf4busy.domain.model.vote

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

object Vote {

    fun isAvailableVote(village: Village, participant: VillageParticipant?): Boolean {
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

    fun assertVote(village: Village, participant: VillageParticipant?, targetId: Int) {
        if (!isAvailableVote(village, participant)) throw Wolf4busyBusinessException("投票できません")
        if (getSelectableTargetList(village, participant).none { it.id == targetId }) throw Wolf4busyBusinessException("投票できません")
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
            charas.chara(village.participant, vote.myselfId).charaName.name.length
        }.max()!!
        val maxToCharaNameLength = votedMap.values.flatten().map { vote ->
            charas.chara(village.participant, vote.targetId).charaName.name.length
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
        return fromChara.charaName.name.padEnd(
            length = maxFromCharaNameLength,
            padChar = '　'
        ) +
            " → " +
            toChara.charaName.name.padEnd(
                length = maxToCharaNameLength,
                padChar = '　'
            ) +
            "(${count}票)"
    }
}