package com.ort.wolf4busy.api.controller

import com.ort.wolf4busy.api.view.charachip.CharaView
import com.ort.wolf4busy.api.view.charachip.CharachipListView
import com.ort.wolf4busy.api.view.charachip.CharachipView
import com.ort.wolf4busy.application.service.CharachipService
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charachip
import com.ort.wolf4busy.domain.model.charachip.Charachips
import com.ort.wolf4busy.domain.model.charachip.Charas
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
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/charachip/list")
    fun charachipList(): CharachipListView {
        val charachips: Charachips = charachipService.findCharaChipList()
        val charas: Charas = charachipService.findCharaList(charachips)
        return CharachipListView(
            charachips = charachips,
            charas = charas
        )
    }

    @GetMapping("/charachip/{charaChipId}")
    fun charachip(@PathVariable("charaChipId") charaChipId: Int): CharachipView {
        val charachip: Charachip = charachipService.findCharaChip(charaChipId)
        val charas: Charas = charachipService.findCharaList(charachip.id)
        return CharachipView(
            charachip = charachip,
            charas = charas
        )
    }

    @GetMapping("/chara/{charaId}")
    fun chara(@PathVariable("charaId") charaId: Int): CharaView {
        val chara: Chara = charachipService.findChara(charaId)
        return CharaView(
            chara = chara
        )
    }

    @GetMapping("/charachip/{charaChipId}/dummychara")
    fun dummyChara(@PathVariable("charaChipId") charaChipId: Int): CharaView {
        val chara: Chara = charachipService.findDummyChara(charaChipId)
        return CharaView(
            chara = chara
        )
    }
}
