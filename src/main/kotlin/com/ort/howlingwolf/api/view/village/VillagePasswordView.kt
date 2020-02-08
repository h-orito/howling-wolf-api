package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.domain.model.village.setting.VillagePassword

data class VillagePasswordView(
    val joinPasswordRequired: Boolean
) {
    constructor(
        villagePassword: VillagePassword
    ) : this(
        joinPasswordRequired = villagePassword.joinPasswordRequired
    )
}