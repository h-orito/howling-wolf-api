package com.ort.wolf4busy.domain.model.daychange

import com.ort.wolf4busy.domain.model.charachip.Charas

// 無惨な死
object MiserableDeath {

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()

        val miserableDeathCharaNameList = dayChange.village.participant.memberList.filter {
            !it.isAlive() && it.dead?.villageDay?.id == latestDay.id && it.dead.toCdef().isMiserableDeath
        }.map { member ->
            charas.list.first { it.id == member.charaId }.charaName.name
        }

        val text = if (miserableDeathCharaNameList.isEmpty()) {
            "今日は犠牲者がいないようだ。人狼は襲撃に失敗したのだろうか。"
        } else {
            miserableDeathCharaNameList.shuffled().joinToString(
                prefix = "次の日の朝、以下の村人が無惨な姿で発見された。\n",
                separator = "、\n"
            )
        }

        return dayChange.copy(
            messages = dayChange.messages.add(DayChange.createPublicSystemMessage(text, latestDay))
        ).setIsChange(dayChange)
    }
}
