package com.ort.wolf4busy.domain.model.village.action

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.security.Wolf4busyUser

data class VillageParticipateSituation(
    val isParticipating: Boolean,
    val isAvailableParticipate: Boolean,
    val isAvailableSpectate: Boolean,
    val myself: VillageParticipant?
) {

    constructor(
        village: Village,
        participant: VillageParticipant?,
        user: Wolf4busyUser?,
        isParticipatingProgressVillage: Boolean,
        isRestrictedParticipatePlayer: Boolean,
        charachipCharaNum: Int
    ) : this(
        isParticipating = participant != null,
        isAvailableParticipate = isAvailableParticipate(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer
        ),
        isAvailableSpectate = isAvailableSpectate(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum
        ),
        myself = participant
    )

    companion object {

        // ===================================================================================
        //                                                            Constructor Assist Logic
        //                                                                        ============
        private fun isAvailableParticipate(
            village: Village,
            participant: VillageParticipant?,
            user: Wolf4busyUser?,
            isParticipatingProgressVillage: Boolean,
            isRestrictedParticipatePlayer: Boolean
        ): Boolean {
            // ログインしていない
            user ?: return false
            // 既に参加している
            if (participant != null) return false
            // プロローグでない
            if (!village.status.isPrologue()) return false
            // 既に最大人数まで参加している
            if (village.participant.count >= village.setting.capacity.max) return false
            // 決着のついていない村に参加している
            if (isParticipatingProgressVillage) return false
            // 入村制限がかかっている
            if (isRestrictedParticipatePlayer) return false

            return true
        }

        private fun isAvailableSpectate(
            village: Village,
            participant: VillageParticipant?,
            user: Wolf4busyUser?,
            isParticipatingProgressVillage: Boolean,
            isRestrictedParticipatePlayer: Boolean,
            charachipCharaNum: Int
        ): Boolean {
            // ログインしていない
            user ?: return false
            // 既に参加している
            if (participant != null) return false
            // プロローグでない
            if (!village.status.isPrologue()) return false
            // 既に最大人数まで参加している
            if (charachipCharaNum - village.setting.capacity.max <= village.spectator.count) return false
            // 決着のついていない村に参加している
            if (isParticipatingProgressVillage) return false
            // 入村制限がかかっている
            if (isRestrictedParticipatePlayer) return false
            // 見学できない設定の村
            if (!village.setting.rules.availableSpectate) return false

            return true
        }
    }
}
