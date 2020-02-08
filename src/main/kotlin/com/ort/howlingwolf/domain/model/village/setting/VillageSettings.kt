package com.ort.howlingwolf.domain.model.village.setting

data class VillageSettings(
    val capacity: PersonCapacity,
    val time: VillageTime,
    val charachip: VillageCharachip,
    val organizations: VillageOrganizations,
    val rules: VillageRules,
    val password: VillagePassword
) {
    fun existsDifference(setting: VillageSettings): Boolean {
        return capacity.existsDifference(setting.capacity)
            || time.existsDifference(setting.time)
            || organizations.existsDifference(setting.organizations)
            || rules.existsDifference(setting.rules)
            || password.existsDifference(setting.password)
    }
}