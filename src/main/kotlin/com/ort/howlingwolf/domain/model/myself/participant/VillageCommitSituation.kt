package com.ort.howlingwolf.domain.model.myself.participant

import com.ort.howlingwolf.domain.model.commit.Commit
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

data class VillageCommitSituation(
    val isAvailableCommit: Boolean,
    val isCommitting: Boolean
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        commit: Commit?
    ) : this(
        isAvailableCommit = Commit.isAvailableCommit(village, participant),
        isCommitting = commit != null
    )
}
