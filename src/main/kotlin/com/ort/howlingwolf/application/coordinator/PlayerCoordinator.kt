package com.ort.howlingwolf.application.coordinator

import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.player.PlayerRecords
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service


@Service
class PlayerCoordinator(
    private val villageService: VillageService
) {
    fun findPlayerRecords(player: Player): PlayerRecords {
        if (player.participateFinishedVillageIdList.isEmpty()) throw HowlingWolfBusinessException("戦績がありません")
        val villages = villageService.findVillagesAsDetail(player.participateFinishedVillageIdList)
        return PlayerRecords(player, villages)
    }
}
