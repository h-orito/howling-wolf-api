package com.ort.wolf4busy.infrastructure.datasource.village

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exbhv.VillageSettingBhv
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.dbflute.exentity.VillageSetting
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
import com.ort.wolf4busy.infrastructure.datasource.village.converter.VillageDataConverter
import org.springframework.stereotype.Repository

@Repository
class VillageDataSource(
    val villageBhv: VillageBhv,
    val villageSettingBhv: VillageSettingBhv,
    val villageDayBhv: VillageDayBhv,
    val villagePlayerBhv: VillagePlayerBhv
) {

    /**
     * 村一覧取得
     */
    fun selectVillages(): Villages {
        val villageList = villageBhv.selectList {
            it.specify().derivedVillagePlayer().count({ vpCB ->
                vpCB.specify().columnVillagePlayerId()
                vpCB.query().setIsGone_Equal(false)
                vpCB.query().setIsSpectator_Equal(false)
            }, Village.ALIAS_participantCount)
            it.specify().derivedVillagePlayer().count({ vpCB ->
                vpCB.specify().columnVillagePlayerId()
                vpCB.query().setIsGone_Equal(false)
                vpCB.query().setIsSpectator_Equal(true)
            }, Village.ALIAS_visitorCount)
            it.query().addOrderBy_VillageId_Desc()
        }
        villageBhv.load(villageList) { loader ->
            loader.loadVillageSetting { }
        }
        return VillageDataConverter.convertVillageListToVillages(villageList)
    }

    /**
     * 村情報取得
     * @param villageId villageId
     */
    fun selectVillage(villageId: Int): com.ort.wolf4busy.domain.model.village.Village {
        val village = villageBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
        }
        villageBhv.load(village) { loader ->
            loader.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Player()
            }
            loader.loadVillageSetting { }
        }

        return VillageDataConverter.convertVillageToVillage(village)
    }

    /**
     * 村登録
     */
    fun insertVillage(v: com.ort.wolf4busy.domain.model.village.Village): Int {
        val village = Village()
        village.villageDisplayName = v.name
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.codeOf(v.status.code)
        village.createPlayerName = v.creatorPlayerName
        villageBhv.insert(village)
        return village.villageId
    }


    /**
     * 村設定登録
     * @param villageId villageId
     * @param settings model settings
     * @param password password
     */
    fun insertVillageSettings(villageId: Int, settings: VillageSettings, password: String?) {
        insertVillageSetting(villageId, CDef.VillageSettingItem.最低人数, settings.capacity.min.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.最大人数, settings.capacity.max.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.期間形式, settings.time.termType)
        insertVillageSetting(villageId, CDef.VillageSettingItem.開始予定日時, settings.time.startDatetime.format(VillageDataConverter.DATETIME_FORMATTER))
        insertVillageSetting(villageId, CDef.VillageSettingItem.更新間隔秒, settings.time.dayChangeIntervalSeconds.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.ダミーキャラid, settings.charachip.dummyCharaId.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.キャラクターグループid, settings.charachip.charachipId.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.構成, settings.organizations.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.記名投票か, toFlg(settings.rules.openVote))
        insertVillageSetting(villageId, CDef.VillageSettingItem.役職希望可能か, toFlg(settings.rules.availableSkillRequest))
        insertVillageSetting(villageId, CDef.VillageSettingItem.見学可能か, toFlg(settings.rules.availableSpectate))
        insertVillageSetting(villageId, CDef.VillageSettingItem.墓下役職公開ありか, toFlg(settings.rules.visibleGraveMessage))
        insertVillageSetting(villageId, CDef.VillageSettingItem.突然死ありか, toFlg(settings.rules.availableSuddenlyDeath))
        insertVillageSetting(villageId, CDef.VillageSettingItem.コミット可能か, toFlg(settings.rules.availableCommit))
        insertVillageSetting(villageId, CDef.VillageSettingItem.入村パスワード, password ?: "")
    }

    /**
     * 村日付取得
     * @param villageId villageId
     * @param day 何日目か
     * @param noonnightCode 昼夜
     */
    fun selectVillageDay(villageId: Int, day: Int, noonnightCode: String): com.ort.wolf4busy.domain.model.village.VillageDay {
        val villageDay: VillageDay = villageDayBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
            it.query().setDay_Equal(day)
            it.query().setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.codeOf(noonnightCode))
        }
        return VillageDataConverter.convertVillageDayToVillageDay(villageDay)
    }

    /**
     * 村日付登録
     * @param villageId villageId
     * @param day 村日付
     * @return 村日付id
     */
    fun insertVillageDay(villageId: Int, day: com.ort.wolf4busy.domain.model.village.VillageDay): Int {
        val villageDay = VillageDay()
        villageDay.villageId = villageId
        villageDay.day = day.day
        villageDay.noonnightCodeAsNoonnight = CDef.Noonnight.codeOf(day.noonnight)
        villageDay.daychangeDatetime = day.startDatetime
        villageDay.isUpdating = true
        villageDayBhv.insert(villageDay)
        return villageDay.villageDayId
    }

    /**
     * 村日付を更新完了にする
     * @param villageDayId 村日付ID
     */
    fun updateVillageDayUpdateComplete(villageDayId: Int) {
        val villageDay = VillageDay()
        villageDay.villageDayId = villageDayId
        villageDay.isUpdating = false
        villageDayBhv.update(villageDay)
    }

    /**
     * 村参加者人数取得
     * @param villageId villageId
     * @param isSpectate 見学か
     * @return 参加人数
     */
    fun selectVillagePlayerCount(villageId: Int, isSpectate: Boolean): Int {
        return villagePlayerBhv.selectCount {
            it.query().setVillageId_Equal(villageId)
            it.query().setIsGone_Equal(false)
            it.query().setIsSpectator_Equal(isSpectate)
        }
    }

    /**
     * 村参加者登録
     * @param villageId villageId
     * @param playerId playerId
     * @param charaId charaId
     * @param firstRequestSkill 役職第1希望
     * @param secondRequestSkill 役職第2希望
     * @param message 入村時発言
     * @param isSpectate 見学か
     */
    fun insertVillagePlayer(
        villageId: Int,
        playerId: Int,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        message: String,
        isSpectate: Boolean
    ): Int {
        val vp = VillagePlayer()
        vp.villageId = villageId
        vp.playerId = playerId
        vp.charaId = charaId
        vp.isDead = false
        vp.isSpectator = isSpectate
        vp.isGone = false
        vp.requestSkillCodeAsSkill = firstRequestSkill
        vp.secondRequestSkillCodeAsSkill = secondRequestSkill
        villagePlayerBhv.insert(vp)
        return vp.villagePlayerId
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    private fun insertVillageSetting(villageId: Int, item: CDef.VillageSettingItem, value: String) {
        val setting = VillageSetting()
        setting.villageId = villageId
        setting.villageSettingItemCodeAsVillageSettingItem = item
        setting.villageSettingText = value
        villageSettingBhv.insert(setting)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun toFlg(bool: Boolean): String {
        return if (bool) VillageDataConverter.FLG_TRUE else VillageDataConverter.FLG_FALSE
    }
}