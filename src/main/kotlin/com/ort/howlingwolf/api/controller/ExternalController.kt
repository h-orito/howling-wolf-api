package com.ort.howlingwolf.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.api.view.external.RecruitingVillagesView
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.ReservedVillageService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.village.VillageStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExternalController(
    val villageService: VillageService,
    val reservedVillageService: ReservedVillageService,
    val charachipService: CharachipService
) {

    @GetMapping("/recruiting-village-list")
    fun recruitingVillageList(): RecruitingVillagesView {
        val villageList = villageService.findVillages(
            villageStatusList = listOf(
                VillageStatus(CDef.VillageStatus.プロローグ),
                VillageStatus(CDef.VillageStatus.進行中),
                VillageStatus(CDef.VillageStatus.エピローグ)
            )
        ).list.sortedBy { it.id }
        val reservedVillageList = reservedVillageService.findReservedVillages().list

        val charachips = charachipService.findCharaChips()

        return RecruitingVillagesView(
            villageList = villageList,
            reservedVillageList = reservedVillageList,
            charachips = charachips
        )
    }
}