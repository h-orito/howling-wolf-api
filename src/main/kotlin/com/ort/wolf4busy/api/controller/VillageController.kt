package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.view.village.VillageListView
import com.ort.wolf4busy.api.view.village.VillageView
import com.ort.wolf4busy.application.service.VillageService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class VillageController(
        val villageService: VillageService
) {

    @GetMapping("/village/list")
    fun villageList(): VillageListView {
        val villages = villageService.findVillageList()
        return VillageListView(
                villageList = villages.villageList
        )
    }

    @GetMapping("/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): VillageView {
        val village = villageService.findVillage(villageId)
        return VillageView(
                village = village
        )
    }
}