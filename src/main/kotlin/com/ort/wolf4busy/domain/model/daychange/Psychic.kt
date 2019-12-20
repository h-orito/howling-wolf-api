package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas

object Psychic {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        // 霊能がいない、または処刑・突然死がいない場合は何もしない
        val existsAlivePsychic = dayChange.village.participant.filterAlive().memberList.any { it.skill!!.toCdef().isHasPsychicAbility }
        val todayDeadParticipants = dayChange.village.deadTodayParticipant()
        if (!existsAlivePsychic || todayDeadParticipants.count <= 0) return dayChange

        var messages = dayChange.messages.copy()
        todayDeadParticipants.memberList.forEach { deadParticipant ->
            val toCharaName = charas.list.find { it.id == deadParticipant.id }!!.charaName.name
            val isWolf = dayChange.village.participant.memberList.find { it.id == deadParticipant.id }!!.skill!!.toCdef().isPsychicResultWolf
            val text = "${toCharaName}は${if (isWolf) "人狼" else "人間"}のようだ。"
            messages = messages.add(DayChange.createPsychicPrivateMessage(text, dayChange.village.day.latestDay().day))
        }
        return dayChange.copy(messages = messages)
    }
}
