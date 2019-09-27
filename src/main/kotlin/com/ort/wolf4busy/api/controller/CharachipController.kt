package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.view.charachip.CharaView
import com.ort.wolf4busy.api.view.charachip.CharachipListView
import com.ort.wolf4busy.api.view.charachip.CharachipView
import com.ort.wolf4busy.application.service.CharachipService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class CharachipController(
        val charachipService: CharachipService
) {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/charachip/list")
    fun charachipList(): CharachipListView {
        val charaChips = charachipService.findCharaChipList()
        return CharachipListView(
                charachipList = charaChips.charachipList
        )
    }

    @GetMapping("/charachip/{charaChipId}")
    fun charachip(@PathVariable("charaChipId") charaChipId: Int): CharachipView {
        val charaChip = charachipService.findCharaChip(charaChipId)
        return CharachipView(
                charachip = charaChip
        )
    }

    @GetMapping("/charachip/{charaChipId}/chara/{charaId}")
    fun chara(@PathVariable("charaChipId") charaChipId: Int,
              @PathVariable("charaId") charaId: Int): CharaView {
        val chara = charachipService.findChara(charaChipId, charaId)
        return CharaView(
                chara = chara
        )
    }

    @GetMapping("/charachip/{charaChipId}/dummychara")
    fun chara(@PathVariable("charaChipId") charaChipId: Int): CharaView {
        val chara = charachipService.findDummyChara(charaChipId)
        return CharaView(
                chara = chara
        )
    }
}
