package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes

data class SituationAsParticipant(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: VillageAbilitySituations, // TODO 役職仲間
    val vote: VillageVoteSituation
) {
    constructor(
        village: Village,
        player: Player?,
        participant: VillageParticipant?,
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
            player,
            charas.list.size
        ),
        skillRequest = VillageSkillRequestSituation(
            village,
            participant,
            skillRequest
        ),
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
}