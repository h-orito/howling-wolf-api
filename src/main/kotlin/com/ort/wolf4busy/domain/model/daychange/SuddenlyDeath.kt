package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object SuddenlyDeath {

    fun process(dayChange: DayChange, todayMessages: Messages, charas: Charas): DayChange {
        var village = dayChange.village.copy()
        var players = dayChange.players.copy()
        var messages = dayChange.messages.copy()

        // 突然死あり設定でなければ何もしない
        if (!village.setting.rules.availableSuddenlyDeath) return dayChange

        // 前日に発言していない人が対象
        dayChange.village.notDummyParticipant().filterAlive().memberList.filter { member ->
            todayMessages.messageList.none { message ->
                message.from!!.id == member.id
            }
        }.forEach { member ->
            // 突然死
            village = village.suddenlyDeathParticipant(member.id, village.day.latestDay())
            // 入村制限
            players = players.restrictParticipation(member.playerId)
            // 突然死メッセージ
            messages = messages.add(createSuddenlyDeathMessage(member, charas, village.day.latestDay()))
        }

        return dayChange.copy(
            village = village,
            messages = messages,
            players = players
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 突然死メッセージ
    private fun createSuddenlyDeathMessage(
        participant: VillageParticipant,
        charas: Charas,
        latestDay: VillageDay
    ): Message {
        val charaName = charas.list.first { it.id == participant.charaId }.charaName
        val message = "${charaName}は突然死した。"
        return DayChange.createPublicSystemMessage(message, latestDay)
    }
}