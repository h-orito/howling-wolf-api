package com.ort.howlingwolf.domain.model.daychange

import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.vote.VillageVotes

data class DayChange(
    // 何かしらの変更があったか
    val isChange: Boolean,
    // 更新後のdomain model
    val village: Village,
    val messages: Messages,
    val votes: VillageVotes,
    val abilities: VillageAbilities,
    val players: Players
) {

    constructor(
        village: Village,
        votes: VillageVotes,
        abilities: VillageAbilities,
        players: Players
    ) : this(
        isChange = false,
        village = village,
        messages = Messages(listOf()),
        votes = votes,
        abilities = abilities,
        players = players
    )

    fun setIsChange(beforeDayChange: DayChange): DayChange {
        return if (isChange) this
        else this.copy(isChange = existsDifference(beforeDayChange))
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun existsDifference(beforeDayChange: DayChange): Boolean {
        // village
        if (village.existsDifference(beforeDayChange.village)) return true
        // message
        if (messages.existsDifference(beforeDayChange.messages)) return true
        // votes
        if (votes.existsDifference(beforeDayChange.votes)) return true
        // abilities
        return abilities.existsDifference(beforeDayChange.abilities)
    }
}