package com.ort.howlingwolf.domain.service.daychange

import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

@Service
class SuicideDomainService {

    fun suicide(daychange: DayChange, charas: Charas): DayChange {
        var village = daychange.village.copy()
        var messages = daychange.messages.copy()

        while (existsSuicideTarget(village)) {
            val target = findSuicideTarget(village)!!
            messages = messages.add(createImmoralSuicideMessage(village, target, charas))
            village = village.suicideParticipant(target.id)
        }

        return daychange.copy(village = village, messages = messages)
    }

    private fun findSuicideTarget(village: Village): VillageParticipant? {
        // 背徳者
        return findImmoralSuicideTarget(village)
    }

    private fun existsSuicideTarget(village: Village): Boolean = findSuicideTarget(village) != null

    private fun findImmoralSuicideTarget(village: Village): VillageParticipant? {
        // 妖狐系が生存していたら後追いしない
        if (village.participant.filterAlive().memberList.any { it.skill!!.isFoxCount() }) {
            return null
        }
        // 生存している背徳者が後追い対象
        return village.participant
            .filterAlive().memberList
            .firstOrNull { it.skill!!.camp().isFoxs() }
    }

    private fun createImmoralSuicideMessage(village: Village, target: VillageParticipant, charas: Charas): Message {
        val name = charas.chara(target.charaId).charaName.fullName()
        return Message.createPublicSystemMessage(
            text = "${name}は、妖狐の後を追い、いなくなってしまった。",
            villageDayId = village.day.latestDay().id
        )
    }
}
