package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message

// 無惨な死
object MiserableDeath {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()

        val miserableDeathCharaList = dayChange.village.participant.memberList.filter {
            !it.isAlive() && it.dead?.villageDay?.id == latestDay.id && it.dead.toCdef().isMiserableDeath
        }.map { member ->
            charas.chara(member.charaId)
        }

        return dayChange.copy(
            messages = dayChange.messages.add(Message.createMiserableDeathMessage(dayChange.village, Charas(miserableDeathCharaList)))
        ).setIsChange(dayChange)
    }
}
