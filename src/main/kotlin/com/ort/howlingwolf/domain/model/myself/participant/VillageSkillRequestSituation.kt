package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageSkillRequestSituation(
    val isAvailableSkillRequest: Boolean,
    val selectableSkillList: List<Skill> = listOf(),
    val skillRequest: SkillRequest?
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        skillRequest: SkillRequest?
    ) : this(
        isAvailableSkillRequest = SkillRequest.isAvailableSkillRequest(village, participant),
        selectableSkillList = village.setting.organizations.allRequestableSkillList(),
        skillRequest = skillRequest
    )
}
