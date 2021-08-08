package com.ort.howlingwolf.api.controller

import com.ort.howlingwolf.api.form.ReservedVillageListForm
import com.ort.howlingwolf.api.view.reserved.ReservedVillagesView
import com.ort.howlingwolf.application.service.AutogenerateVillageService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ReservedVillageController(
    val autogenerateVillageService: AutogenerateVillageService
) {

    /**
     * 予約村一覧取得
     */
    @GetMapping("/reserved-village/list")
    fun list(
        @Validated form: ReservedVillageListForm
    ): ReservedVillagesView {
        val reservedVillages = autogenerateVillageService.findReservedVillages(limit = form.limit ?: 3)
        return ReservedVillagesView(reservedVillages)
    }
}