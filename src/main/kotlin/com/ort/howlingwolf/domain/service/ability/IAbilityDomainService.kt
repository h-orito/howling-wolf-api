package com.ort.howlingwolf.domain.service.ability

import com.ort.howlingwolf.domain.model.ability.AbilityType
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

interface IAbilityDomainService {

    fun getAbilityType(): AbilityType

    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant>

    fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageParticipant?

    fun createSetMessage(
        myChara: Chara,
        targetChara: Chara?
    ): String

    fun getDefaultAbilityList(
        village: Village,
        villageAbilities: VillageAbilities
    ): List<VillageAbility>

    fun processDayChangeAction(
        dayChange: DayChange,
        charas: Charas
    ): DayChange

    fun isAvailableNoTarget(village: Village): Boolean

    fun isUsable(
        village: Village,
        participant: VillageParticipant
    ): Boolean
}