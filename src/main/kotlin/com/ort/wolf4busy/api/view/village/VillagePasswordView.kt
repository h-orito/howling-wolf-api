package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.domain.model.village.setting.VillagePassword

data class VillagePasswordView(
    val joinPasswordRequired: Boolean
) {
    constructor(
        villagePassword: VillagePassword
    ) : this(
        joinPasswordRequired = villagePassword.joinPasswordRequired
    )
}