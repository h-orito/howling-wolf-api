package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.security.Wolf4busyUser

data class VillageActionSituation(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val isAvailableLeave: Boolean,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: List<VillageAbilitySituation>,
    val vote: VillageVoteSituation
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        user: Wolf4busyUser?,
        isParticipatingProgressVillage: Boolean,
        isRestrictedParticipatePlayer: Boolean,
        charachipCharaNum: Int,
        skillRequest: SkillRequest?,
        commit: Commit?
    ) : this(
        participate = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        ),
        skillRequest = VillageSkillRequestSituation(
            village,
            participant,
            skillRequest
        ),
        isAvailableLeave = isAvailableLeave(village, participant),
        commit = VillageCommitSituation(
            village,
            participant,
            commit
        ),
        say = VillageSaySituation(
            village,
            participant
        ),
        ability = listOf(
            VillageAbilitySituation( // todo
                type = Ability(
                    code = "code", // todo
                    name = "name" // todo
                ),
                targetList = listOf(), // todo
                target = null // todo
            )
        ),
        vote = VillageVoteSituation(
            isAvailableVote = false, // todo
            targetList = listOf(), // todo
            target = null
        )
    )

    companion object {

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        private fun isAvailableLeave(village: Village, participant: VillageParticipant?): Boolean {
            // 参加していない
            participant ?: return false
            // プロローグなら退村できる
            return village.isPrologue()
        }
    }
}