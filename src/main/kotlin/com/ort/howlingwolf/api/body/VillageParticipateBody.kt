package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class VillageParticipateBody(
    @field:NotNull(message = "charaIdは必須")
    val charaId: Int?,

    @field:NotNull(message = "firstRequestSkillは必須")
    val firstRequestSkill: String?,

    @field:NotNull(message = "secondRequestSkillは必須")
    val secondRequestSkill: String?,

    @field:NotNull(message = "joinMessageは必須")
    val joinMessage: String?,

    val joinPassword: String?,

    val spectator: Boolean?
) {
    constructor() : this(null, null, null, null, null, null) {}
}
