package com.ort.wolf4busy.domain.model.village.setting

data class VillageSettings(
        val capacity: PersonCapacity,
        val time: VillageTime,
        val charachip: VillageCharachip,
        val organizations: VillageOrganizations,
        val rules: VillageRules,
        val password: VillagePassword
) {
}