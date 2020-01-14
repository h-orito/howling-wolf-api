package com.ort.wolf4busy.domain.model.myself.participant

import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant

data class VillageCommitSituation(
    val isAvailableCommit: Boolean,
    val isCommitting: Boolean
) {
    constructor(
        village: Village,
        participant: VillageParticipant?,
        commit: Commit?
    ) : this(
        isAvailableCommit = village.isAvailableCommit(participant),
        isCommitting = commit != null
    )
}
