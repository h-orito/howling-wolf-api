package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas

object Psychic {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        // 霊能がいない、または処刑・突然死がいない場合は何もしない
        val existsAlivePsychic = dayChange.village.participant.filterAlive().memberList.any { it.skill!!.toCdef().isHasPsychicAbility }
        val todayDeadParticipants = dayChange.village.todayDeadParticipants()
        if (!existsAlivePsychic || todayDeadParticipants.count <= 0) return dayChange

        var messages = dayChange.messages.copy()
        todayDeadParticipants.memberList.forEach { deadParticipant ->
            val toCharaName = charas.list.first { it.id == deadParticipant.charaId }.charaName.name
            val isWolf = dayChange.village.participant.member(deadParticipant.id).skill!!.toCdef().isPsychicResultWolf
            val text = "${toCharaName}は人狼${if (isWolf) "の" else "ではない"}ようだ。"
            messages = messages.add(DayChange.createPsychicPrivateMessage(text, dayChange.village.day.latestDay()))
        }
        return dayChange.copy(messages = messages)
    }
}
