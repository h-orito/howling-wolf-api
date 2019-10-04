package com.ort.wolf4busy.api.body

import javax.validation.constraints.NotNull

data class PlayerUpdateNicknameBody(
        @field:NotNull(message = "nicknameは必須")
        val nickname: String?
) {
    constructor() : this(
            null
    ) {
    }
}