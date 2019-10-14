package com.ort.wolf4busy.domain.model.village.setting

data class VillageOrganizations(
        val organization: Map<Int, String>
) {
    companion object {
        operator fun invoke(
                organization: Map<Int, String>?
        ): VillageOrganizations {
            organization ?: throw IllegalArgumentException("organization is required.")
            return VillageOrganizations(organization = organization)
        }
    }

    override fun toString(): String {
        val sortedMap = this.organization.toSortedMap()
        return sortedMap.map { it.value }.joinToString(separator = "\n")
    }
}