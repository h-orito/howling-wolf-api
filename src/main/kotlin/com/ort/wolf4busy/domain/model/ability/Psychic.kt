package com.ort.wolf4busy.domain.model.ability

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange

object Psychic {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        // 霊能がいない、または処刑・突然死がいない場合は何もしない
        val existsAlivePsychic = dayChange.village.participant.filterAlive().memberList.any { it.skill!!.toCdef().isHasPsychicAbility }
        if (!existsAlivePsychic) return dayChange
        val todayDeadParticipants = dayChange.village.todayDeadParticipants().memberList.filter { it.dead!!.toCdef().isPsychicableDeath }
        if (todayDeadParticipants.isEmpty()) return dayChange

        var messages = dayChange.messages.copy()
        todayDeadParticipants.forEach { deadParticipant ->
            val toCharaName = charas.list.first { it.id == deadParticipant.charaId }.charaName.name
            val isWolf = dayChange.village.participant.member(deadParticipant.id).skill!!.toCdef().isPsychicResultWolf
            val text = "${toCharaName}は人狼${if (isWolf) "の" else "ではない"}ようだ。"
            messages = messages.add(DayChange.createPsychicPrivateMessage(text, dayChange.village.day.latestDay()))
        }
        return dayChange.copy(messages = messages).setIsChange(dayChange)
    }
}
