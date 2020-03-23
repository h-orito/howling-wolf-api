package com.ort.howlingwolf.api.controller

import com.ort.dbflute.exbhv.CharaBhv
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillageSettingBhv
import com.ort.dbflute.exentity.Player
import com.ort.dbflute.exentity.VillageSetting
import com.ort.howlingwolf.api.body.AdminDummyLoginBody
import com.ort.howlingwolf.api.body.AdminParticipateBody
import com.ort.howlingwolf.api.view.debug.DebugVillageView
import com.ort.howlingwolf.application.coordinator.VillageCoordinator
import com.ort.howlingwolf.application.service.CharachipService
import com.ort.howlingwolf.application.service.PlayerService
import com.ort.howlingwolf.application.service.VillageService
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


/**
 * デバッグ用なのでDDDに拘らない
 */
@RestController
class DebugController(
    val charaBhv: CharaBhv,
    val playerBhv: PlayerBhv,
    val villageDayBhv: VillageDayBhv,
    val villageSettingBhv: VillageSettingBhv,

    val villageCoordinator: VillageCoordinator,

    val villageService: VillageService,
    val charachipService: CharachipService,
    val playerService: PlayerService
) {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Value("\${env: null}")
    private var env: String? = null

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
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: AdminParticipateBody
    ) {
        if ("local" != env) throw HowlingWolfBusinessException("この環境では使用できません")

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
        @AuthenticationPrincipal user: HowlingWolfUser,
        @RequestBody @Validated body: AdminDummyLoginBody
    ) {
        if ("local" != env) throw HowlingWolfBusinessException("この環境では使用できません")

        // 現在接続しているユーザのuidと、指定されたプレイヤーのuidを入れ替える
        val currentPlayer = playerBhv.selectEntityWithDeletedCheck {
            it.query().setUid_Equal(user.uid)
        }
        val toPlayer = playerBhv.selectEntityWithDeletedCheck {
            it.query().existsVillagePlayer { vpCB ->
                vpCB.query().setVillageId_Equal(villageId)
                vpCB.query().setVillagePlayerId_Equal(body.targetId!!)
                vpCB.query().setIsGone_Equal(false)
            }
        }
        val current = currentPlayer.uid
        val to = toPlayer.uid
        updatePlayerUid(currentPlayer.playerId, "dummy_uid")
        updatePlayerUid(toPlayer.playerId, current)
        updatePlayerUid(currentPlayer.playerId, to)
    }

    /**
     * 次の日へ
     * @param villageId villageId
     * @param user user
     */
    @PostMapping("/admin/village/{villageId}/change-day")
    fun changeDay(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser
    ) {
        if ("local" != env) throw HowlingWolfBusinessException("この環境では使用できません")

        val latestDay = villageDayBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
            it.query().addOrderBy_Day_Desc()
            it.query().queryNoonnight().addOrderBy_DispOrder_Desc()
            it.fetchFirst(1)
        }
        latestDay.daychangeDatetime = HowlingWolfDateUtil.currentLocalDateTime().minusSeconds(1L)
        villageDayBhv.update(latestDay)
    }

    /**
     * 村情報取得（役職やプレーヤーが全て見える状態）
     * @param villageId villageId
     */
    @GetMapping("/admin/village/{villageId}")
    fun village(@PathVariable("villageId") villageId: Int): DebugVillageView {
        if ("local" != env) throw HowlingWolfBusinessException("この環境では使用できません")

        val village: Village = villageService.findVillage(villageId)
        val charas: Charas = charachipService.findCharas(village.setting.charachip.charachipId)
        val players: Players = playerService.findPlayers(villageId)
        val createPlayer: com.ort.howlingwolf.domain.model.player.Player = playerService.findPlayer(village.creatorPlayerId)
        return DebugVillageView(
            village = village,
            charas = charas,
            players = players,
            createPlayer = createPlayer
        )
    }

    /**
     * 突然死なしにする
     * @param villageId villageId
     * @param user user
     */
    @PostMapping("/admin/village/{villageId}/no-suddenly-death")
    fun setNoSuddenlyDeath(
        @PathVariable("villageId") villageId: Int,
        @AuthenticationPrincipal user: HowlingWolfUser
    ) {
        if ("local" != env) throw HowlingWolfBusinessException("この環境では使用できません")

        val setting = VillageSetting()
        setting.villageId = villageId
        setting.setVillageSettingItemCode_突然死ありか()
        setting.villageSettingText = "0"
        villageSettingBhv.update(setting)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun updatePlayerUid(playerId: Int?, uid: String?) {
        val p = Player()
        p.playerId = playerId
        p.uid = uid
        playerBhv.update(p)
    }
}