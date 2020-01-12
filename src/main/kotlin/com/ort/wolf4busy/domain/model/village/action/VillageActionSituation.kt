package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser

data class VillageActionSituation(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val isAvailableLeave: Boolean,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: VillageAbilitySituations, // TODO 役職仲間
    val vote: VillageVoteSituation
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        user: Wolf4busyUser?,
        isParticipatingProgressVillage: Boolean,
        isRestrictedParticipatePlayer: Boolean,
        charas: Charas,
        skillRequest: SkillRequest?,
        abilities: VillageAbilities,
        votes: VillageVotes,
        commit: Commit?,
        latestDayMessageList: List<Message>
    ) : this(
        participate = VillageParticipateSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charas.list.size
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
            participant,
            charas,
            latestDayMessageList
        ),
        ability = VillageAbilitySituations(
            village,
            participant,
            abilities
        ),
        vote = VillageVoteSituation(
            village,
            participant,
            votes
        )
    )

    companion object {

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        fun isAvailableLeave(village: Village, participant: VillageParticipant?): Boolean {
            // 参加していない
            participant ?: return false
            // プロローグなら退村できる
            return village.status.isPrologue()
        }

        fun assertLeave(village: Village, participant: VillageParticipant?) {
            if (!isAvailableLeave(village, participant)) throw Wolf4busyBusinessException("退村できません")
        }
    }
}