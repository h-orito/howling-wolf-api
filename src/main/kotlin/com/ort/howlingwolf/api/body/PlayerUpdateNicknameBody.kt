package com.ort.howlingwolf.api.body

import javax.validation.constraints.NotNull

data class PlayerUpdateNicknameBody(
        @field:NotNull(message = "nicknameは必須")
        val nickname: String?,

        @field:NotNull(message = "twitterUserNameは必須")
        val twitterUserName: String?
        ) {
    constructor() : this(
            null, null
    ) {
    }
}