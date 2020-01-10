package com.ort.wolf4busy.domain.model.player

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser

data class PlayerSituation(
    val progressVillages: Villages,
    val completedVillages: Villages,
    val isAvailableCreateVillage: Boolean
) {

    constructor(
        user: Wolf4busyUser?,
        villages: Villages,
        isParticipatingProgressVillage: Boolean,
        isRestrictedParticipatePlayer: Boolean,
        isProgressMyselfVillage: Boolean
    ) : this(
        progressVillages = Villages(villages.villageList.filter {
            it.status.toCdef() != CDef.VillageStatus.終了 && it.status.toCdef() != CDef.VillageStatus.廃村
        }),
        completedVillages = Villages(villages.villageList.filter {
            it.status.toCdef() == CDef.VillageStatus.終了 || it.status.toCdef() == CDef.VillageStatus.廃村
        }),
        isAvailableCreateVillage = isAvailableCreateVillage(
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            isProgressMyselfVillage
        )
    )

    companion object {
        private fun isAvailableCreateVillage(
            user: Wolf4busyUser?,
            participatingProgressVillage: Boolean,
            restrictedParticipatePlayer: Boolean,
            progressMyselfVillage: Boolean
        ): Boolean {
            user ?: return false
            if (user.authority == CDef.Authority.管理者) return true
            if (participatingProgressVillage) return false
            if (restrictedParticipatePlayer) return false
            if (progressMyselfVillage) return false
            return true
        }
    }

    fun assertCreateVillage() {
        if (!isAvailableCreateVillage) throw Wolf4busyBusinessException("村を作成できません")
    }

}