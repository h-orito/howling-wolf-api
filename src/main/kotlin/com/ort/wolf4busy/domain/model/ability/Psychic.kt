package com.ort.wolf4busy.domain.model.ability

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.daychange.DayChange
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

object Psychic {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        // 霊能がいない、または処刑・突然死がいない場合は何もしない
        val existsAlivePsychic = dayChange.village.participant.filterAlive().memberList.any { it.skill!!.toCdef().isHasPsychicAbility }
        if (!existsAlivePsychic) return dayChange
        val todayDeadParticipants = dayChange.village.todayDeadParticipants().memberList.filter { it.dead!!.toCdef().isPsychicableDeath }
        if (todayDeadParticipants.isEmpty()) return dayChange

        var messages = dayChange.messages.copy()
        todayDeadParticipants.forEach { deadParticipant ->
            messages = messages.add(createPsychicPrivateMessage(dayChange.village, charas, deadParticipant))
        }
        return dayChange.copy(messages = messages).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createPsychicPrivateMessage(
        village: Village,
        charas: Charas,
        deadParticipant: VillageParticipant
    ): Message {
        val chara = charas.chara(deadParticipant.charaId)
        val isWolf = village.participant.member(deadParticipant.id).skill!!.toCdef().isPsychicResultWolf
        val text = createPsychicPrivateMessageString(chara, isWolf)
        return Message.createPsychicPrivateMessage(text, village.day.latestDay().id)
    }

    private fun createPsychicPrivateMessageString(chara: Chara, isWolf: Boolean): String =
        "${chara.charaName.name}は人狼${if (isWolf) "の" else "ではない"}ようだ。"
}
