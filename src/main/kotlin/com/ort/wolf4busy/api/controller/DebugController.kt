package com.ort.wolf4busy.api.controller

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.CharaBhv
import com.ort.wolf4busy.api.body.AdminDummyLoginBody
import com.ort.wolf4busy.api.body.AdminParticipateBody
import com.ort.wolf4busy.application.coordinator.VillageCoordinator
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


/**
 * デバッグ用なのでDDDに拘らない
 */
@RestController
class DebugController(
    val charaBhv: CharaBhv,

    val villageCoordinator: VillageCoordinator,

    val villageService: VillageService
) {
    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    /**
     * 人数指定で参加させる
     * @param villageId villageId
     * @param user user
     * @param body body
     */
    @PostMapping("/admin/village/{villageId}/participate")
    fun participateVillage(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: AdminParticipateBody
    ) {
        if (user.authority != CDef.Authority.管理者) throw Wolf4busyBusinessException("invalid user")

        val village = villageService.findVillage(villageId)

        // 参戦していないキャラを人数分探す
        val charaList = charaBhv.selectList { cb ->
            cb.query().setCharaGroupId_Equal(village.setting.charachip.charachipId)
            cb.query().notExistsVillagePlayer { villagePlayerCB ->
                villagePlayerCB.query().setVillageId_Equal(villageId)
                villagePlayerCB.query().setIsGone_Equal(false)
            }
            cb.fetchFirst(body.participateCount!!)
        }
        var playerId = 2
        for (chara in charaList) {
            // 希望役職をランダムに取得
            val randomSkill = village.setting.organizations.allRequestableSkillList().shuffled().first()
            val randomSkill2 = village.setting.organizations.allRequestableSkillList().shuffled().first()
            // 入村
            villageCoordinator.participate(
                villageId = villageId,
                playerId = playerId,
                charaId = chara.charaId,
                message = "テストアカウント入村 playerId: ${playerId}",
                isSpectate = false,
                firstRequestSkill = randomSkill.toCdef(),
                secondRequestSkill = randomSkill2.toCdef()
            )
            playerId++
        }
    }

    /**
     * 指定村参加者IDでログインする
     * @param villageId villageId
     * @param user user
     * @param body body
     */
    @PostMapping("/admin/village/{villageId}/dummy-login")
    fun dummyLogin(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: Wolf4busyUser,
        @RequestBody @Validated body: AdminDummyLoginBody
    ) {
        // TODO ローカルでだけ動作させる
        if (user.authority != CDef.Authority.管理者) throw Wolf4busyBusinessException("invalid user")
        // TODO 実装

    }
}