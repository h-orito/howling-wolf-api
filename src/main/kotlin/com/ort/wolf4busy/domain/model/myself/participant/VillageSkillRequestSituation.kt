package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

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
