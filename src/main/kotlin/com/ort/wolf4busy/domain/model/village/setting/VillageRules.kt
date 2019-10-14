package com.ort.wolf4busy.domain.model.village.setting

data class VillageRules(
    val openVote: Boolean,
    val availableSkillRequest: Boolean,
    val availableSpectate: Boolean,
    val openSkillInGrave: Boolean,
    val visibleGraveMessage: Boolean,
    val availableSuddenlyDeath: Boolean,
    val availableCommit: Boolean
) {
    companion object {
        operator fun invoke(
            openVote: Boolean?,
            availableSkillRequest: Boolean?,
            availableSpectate: Boolean?,
            openSkillInGrave: Boolean?,
            visibleGraveMessage: Boolean?,
            availableSuddenlyDeath: Boolean?,
            availableCommit: Boolean?
        ): VillageRules {
            return VillageRules(
                openVote = openVote ?: false,
                availableSkillRequest = availableSkillRequest ?: true,
                availableSpectate = availableSpectate ?: false,
                openSkillInGrave = openSkillInGrave ?: false,
                visibleGraveMessage = visibleGraveMessage ?: false,
                availableSuddenlyDeath = availableSuddenlyDeath ?: true,
                availableCommit = availableCommit ?: false
            )
        }
    }
}