package com.ort.howlingwolf.domain.model.player.record

import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Villages

data class Record(
    val participateCount: Int,
    val winCount: Int,
    val winRate: Float
) {
    constructor(
        player: Player,
        villages: Villages
    ) : this(
        participateCount = villages.list.size,
        winCount = sumWinCount(villages, player),
        winRate = if (villages.list.isEmpty()) 0F else sumWinCount(villages, player).toFloat() / villages.list.size.toFloat()
    )

    companion object {
        private fun sumWinCount(villages: Villages, player: Player): Int {
            return villages.list.count { village ->
                village.participant.memberList.first { participant ->
                    participant.playerId == player.id && !participant.isGone
                }.isWin!!
            }
        }
    }
}