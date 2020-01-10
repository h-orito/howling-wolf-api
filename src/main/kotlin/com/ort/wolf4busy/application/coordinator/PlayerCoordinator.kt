package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.player.PlayerSituation
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service

@Service
class PlayerCoordinator(
    private val playerService: PlayerService,
    private val villageService: VillageService
) {

    fun findPlayerSituation(user: Wolf4busyUser?): PlayerSituation {
        val villages = if (user == null) Villages(listOf()) else villageService.findVillageList(user)
        val isParticipatingProgressVillage: Boolean = user != null && playerService.isParticipatingAnyProgressVillage(user.uid)
        val isRestrictedParticipatePlayer: Boolean = user != null && playerService.isRestrictedParticipatePlayer(user)
        val isProgressMyselfVillage: Boolean = user != null && playerService.hasProgressMyselfVillage(user.uid)
        return PlayerSituation(
            user,
            villages,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            isProgressMyselfVillage
        )
    }
}