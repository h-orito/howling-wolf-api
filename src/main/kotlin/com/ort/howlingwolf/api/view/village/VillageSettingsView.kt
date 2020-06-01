package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.domain.model.village.setting.VillageCharachip
import com.ort.howlingwolf.domain.model.village.setting.VillageOrganizations
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.domain.model.village.setting.VillageSettings

data class VillageSettingsView(
    val capacity: PersonCapacity,
    val time: VillageTimeView,
    val charachip: VillageCharachip,
    val organizations: VillageOrganizations,
    val rules: VillageRules,
    val password: VillagePasswordView
) {
    constructor(
        villageSettings: VillageSettings
    ) : this(
        capacity = villageSettings.capacity,
        time = VillageTimeView(villageSettings.time),
        charachip = villageSettings.charachip,
        organizations = villageSettings.organizations,
        rules = villageSettings.rules,
        password = VillagePasswordView(villageSettings.password)
    )
}
