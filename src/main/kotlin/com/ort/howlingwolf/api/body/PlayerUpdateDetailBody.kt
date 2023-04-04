package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class PlayerUpdateDetailBody(
    @field:NotNull(message = "nicknameは必須")
    val nickname: String,
    val otherSiteName: String?,
    val introduction: String?
) {
    constructor() : this("", null, null)
}
