package com.ort.wolf4busy.domain.model.village.setting

data class VillageOrganizations(
        val organization: Map<Int, String> = defaultOrganization()
) {
    companion object {
        operator fun invoke(
                organization: Map<Int, String>?
        ): VillageOrganizations {
            organization ?: throw IllegalArgumentException("organization is required.")
            return VillageOrganizations(organization = organization)
        }

        private fun defaultOrganization(): Map<Int, String> {
            return mapOf(
                    5 to "狼占村村村",
                    6 to "狼占村村村村",
                    7 to "狼狼占村村村村",
                    8 to "狼狼占霊村村村村",
                    9 to "狼狼占霊村村村村村",
                    10 to "狼狼占霊村村村村村村",
                    11 to "狼狼狂占霊狩村村村村村",
                    12 to "狼狼狂占霊狩村村村村村村",
                    13 to "狼狼狼狂占霊狩村村村村村村",
                    14 to "狼狼狼狂占霊狩村村村村村村村",
                    15 to "狼狼狼狂占霊狩村村村村村村村村",
                    16 to "狼狼狼狂占霊狩村村村村村村村村村"
            )
        }
    }

    override fun toString(): String {
        val sortedMap = this.organization.toSortedMap()
        return sortedMap.map { it.value }.joinToString(separator = "\n")
    }

}