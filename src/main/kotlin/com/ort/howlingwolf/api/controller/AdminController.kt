package com.ort.howlingwolf.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.api.body.AdminKickBody
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.MessageService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AdminController(
    private val villageService: VillageService,
    private val charachipService: CharachipService,
    private val messageService: MessageService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @PostMapping("/admin/village/{villageId}/kick")
    fun kick(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: AdminKickBody
    ) {
        if (user.authority != CDef.Authority.管理者) throw HowlingWolfBusinessException("管理者しか使えません")

        // キック
        val village = villageService.findVillage(villageId)
        val changedVillage = village.leaveParticipant(body.targetId!!)
        val participant = village.participant.member(body.targetId!!)
        if (participant.playerId == 1) return // ダミーはキックできない
        // シスメ
        val chara: Chara = charachipService.findChara(participant.charaId)
        val updatedVillage = villageService.updateVillageDifference(village, changedVillage)
        messageService.registerLeaveMessage(updatedVillage, chara)
    }
}