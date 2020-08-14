package com.ort.howlingwolf.domain.service.coming_out

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.myself.participant.VillageComingOutSituation
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.Skills
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service


@Service
class ComingOutDomainService {

    fun convertToSituation(village: Village, participant: VillageParticipant?): VillageComingOutSituation {
        return VillageComingOutSituation(
            isAvailableComingOut = isAvailableComingOut(village, participant),
            currentComingOuts = participant?.comingOuts ?: ComingOuts(),
            selectableSkillList = selectableSkillList(village, participant)
        )
    }

    fun assertComingOut(
        village: Village,
        participant: VillageParticipant?
    ) {
        if (!isAvailableComingOut(village, participant)) throw HowlingWolfBusinessException("カミングアウトできません")
    }

    fun createComingOutMessage(chara: Chara, skills: Skills, villageDayId: Int): Message {
        return Message.createPublicSystemMessage(getComingOutSetMessage(chara, skills), villageDayId)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun selectableSkillList(village: Village, participant: VillageParticipant?): List<Skill> {
        if (!isAvailableComingOut(village, participant)) return listOf()
        return village.setting.organizations.mapToSkillCount(village.participant.count)
            .filter { it.value > 0 }.keys.sortedBy { it.order().toInt() }.map { Skill(it) }
    }

    private fun isAvailableComingOut(village: Village, participant: VillageParticipant?): Boolean {
        // 村として可能か
        if (!village.isAvailableComingOut()) return false
        // 参加者として可能か
        participant ?: return false
        return participant.isAvailableComingOut()
    }

    private fun getComingOutSetMessage(chara: Chara, skills: Skills): String {
        val name = chara.charaName.fullName()
        return if (skills.list.isEmpty()) {
            "${name}がカミングアウトを取り消しました。"
        } else {
            val skill = skills.list.map { it.name }.joinToString("と")
            "${name}が${skill}をカミングアウトしました。"
        }
    }
}