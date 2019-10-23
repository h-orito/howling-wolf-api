package com.ort.wolf4busy.api.body

import javax.validation.constraints.NotNull

data class VillageChangeSkillBody(
    @field:NotNull(message = "firstRequestSkillは必須")
    val firstRequestSkill: String?,

    @field:NotNull(message = "secondRequestSkillは必須")
    val secondRequestSkill: String?
) {
    constructor() : this(null, null) {}
}
