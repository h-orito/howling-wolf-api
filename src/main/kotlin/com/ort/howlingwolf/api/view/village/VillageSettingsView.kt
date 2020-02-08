package com.ort.howlingwolf.api.view.village

import com.ort.howlingwolf.domain.model.village.setting.*

data class VillageSettingsView(
    val capacity: PersonCapacity,
    val time: VillageTime,
    val charachip: VillageCharachip,
    val organizations: VillageOrganizations,
    val rules: VillageRules,
    val password: VillagePasswordView
) {
    constructor(
        villageSettings: VillageSettings
    ) : this(
        capacity = villageSettings.capacity,
        time = villageSettings.time,
        charachip = villageSettings.charachip,
        organizations = villageSettings.organizations,
        rules = villageSettings.rules,
        password = VillagePasswordView(villageSettings.password)
    )
}
