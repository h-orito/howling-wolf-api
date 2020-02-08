package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.commit.Commit
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes

data class SituationAsParticipant(
    val participate: VillageParticipateSituation,
    val skillRequest: VillageSkillRequestSituation,
    val commit: VillageCommitSituation,
    val say: VillageSaySituation,
    val ability: VillageAbilitySituations,
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
            charas
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