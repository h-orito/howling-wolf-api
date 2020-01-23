package com.ort.wolf4busy.infrastructure.datasource.village

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.*
import com.ort.dbflute.exentity.*
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.village.converter.VillageDataConverter
import org.springframework.stereotype.Repository

@Repository
class VillageDataSource(
    val villageBhv: VillageBhv,
    val villageSettingBhv: VillageSettingBhv,
    val villageDayBhv: VillageDayBhv,
    val villagePlayerBhv: VillagePlayerBhv,
    val messageRestrictionBhv: MessageRestrictionBhv
) {
    // TODO updateは全てdomain objectを受け取って差分更新が良いのでは

    // ===================================================================================
    //                                                                             village
    //                                                                           =========
    /**
     * 村登録
     * @param paramVillage village
     * @param password 入村パスワード
     * @return 村ID
     */
    fun registerVillage(
        paramVillage: com.ort.wolf4busy.domain.model.village.Village,
        password: String?
    ): com.ort.wolf4busy.domain.model.village.Village {
        // 村
        val villageId = insertVillage(paramVillage)
        // 村設定
        insertVillageSettings(villageId, paramVillage.setting, password)
        // 発言制限
        insertMessageRestrictionList(villageId, paramVillage.setting)
        // 村日付
        insertVillageDay(
            villageId,
            com.ort.wolf4busy.domain.model.village.VillageDay(
                id = 1, // dummy
                day = 0,
                noonnight = CDef.Noonnight.昼.code(),
                dayChangeDatetime = paramVillage.setting.time.startDatetime,
                isUpdating = true // dummy
            )
        )

        return findVillage(villageId)
    }

    /**
     * 村一覧取得
     * @param user 指定した場合は自分が参加した村一覧
     * @return 村一覧
     */
    fun findVillages(user: Wolf4busyUser? = null): Villages {
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

            if (user != null) {
                it.query().existsVillagePlayer { vpCB ->
                    vpCB.query().setIsGone_Equal(false)
                    vpCB.query().queryPlayer().setUid_Equal(user.uid)
                }
            }

            it.query().addOrderBy_VillageId_Desc()
        }
        villageBhv.load(villageList) { loader ->
            loader.loadVillageSetting { }
            loader.loadVillageDay {
                it.query().addOrderBy_Day_Desc()
                it.query().queryNoonnight().addOrderBy_DispOrder_Desc()
            }
            loader.loadMessageRestriction { }
        }
        return VillageDataConverter.convertVillageListToVillages(villageList)
    }

    /**
     * 村一覧取得
     * @param villageIdList 村IDリスト
     * @return 村一覧
     */
    fun findVillages(villageIdList: List<Int>): Villages {
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

            it.query().setVillageId_InScope(villageIdList)
            it.query().addOrderBy_VillageId_Desc()
        }
        villageBhv.load(villageList) { loader ->
            loader.loadVillageSetting { }
            loader.loadVillageDay {
                it.query().addOrderBy_Day_Desc()
                it.query().queryNoonnight().addOrderBy_DispOrder_Desc()
            }
            loader.loadMessageRestriction { }
        }
        return VillageDataConverter.convertVillageListToVillages(villageList)
    }

    /**
     * 村情報取得
     * @param villageId villageId
     * @return 村情報
     */
    fun findVillage(villageId: Int, excludeGonePlayer: Boolean = true): com.ort.wolf4busy.domain.model.village.Village {
        val village = villageBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
        }
        villageBhv.load(village) { loader ->
            loader.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_VillageDay()
                if (excludeGonePlayer) {
                    vpCB.query().setIsGone_Equal(false)
                }
            }.withNestedReferrer {
                it.pulloutChara().loadCharaImage { }
            }
            loader.loadVillageSetting { }
            loader.loadVillageDay {
                it.query().addOrderBy_Day_Asc()
                it.query().queryNoonnight().addOrderBy_DispOrder_Asc()
            }
            loader.loadMessageRestriction { }
        }

        return VillageDataConverter.convertVillageToVillage(village)
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
     * 村参加者登録
     * @param villageId villageId
     * @param participant participant
     * @return 村参加ID
     */
    fun registerVillageParticipant(
        villageId: Int,
        participant: VillageParticipant
    ): Int {
        val vp = VillagePlayer()
        vp.villageId = villageId
        vp.playerId = participant.playerId
        vp.charaId = participant.charaId
        vp.isDead = false
        vp.isSpectator = participant.isSpectator
        vp.isGone = false
        vp.requestSkillCodeAsSkill = participant.skillRequest.first.toCdef()
        vp.secondRequestSkillCodeAsSkill = participant.skillRequest.second.toCdef()
        villagePlayerBhv.insert(vp)
        return vp.villagePlayerId
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    /**
     * 退村
     * @param participant 村参加者
     */
    fun updateVillagePlayerLeave(participant: VillageParticipant) {
        val villagePlayer = VillagePlayer()
        villagePlayer.villagePlayerId = participant.id
        villagePlayer.isGone = true
        villagePlayerBhv.update(villagePlayer)
    }

    /**
     * 差分更新
     * @param before village
     * @param after village
     */
    fun updateDifference(
        before: com.ort.wolf4busy.domain.model.village.Village,
        after: com.ort.wolf4busy.domain.model.village.Village
    ) {
        // village
        updateVillageDifference(before, after)
        // village_day
        upsertVillageDay(before, after)
        // village_player
        updateVillagePlayerDifference(before, after)
    }

    private fun updateVillageDifference(
        before: com.ort.wolf4busy.domain.model.village.Village,
        after: com.ort.wolf4busy.domain.model.village.Village
    ) {
        if (before.status.code != after.status.code
            || before.winCamp?.code != after.winCamp?.code
        ) {
            val village = Village()
            village.villageId = after.id
            village.villageStatusCodeAsVillageStatus = after.status.toCdef()
            village.winCampCodeAsCamp = after.winCamp?.toCdef()
            villageBhv.update(village)
        }
    }

    private fun upsertVillageDay(
        before: com.ort.wolf4busy.domain.model.village.Village,
        after: com.ort.wolf4busy.domain.model.village.Village
    ) {
        if (!before.day.existsDifference(after.day)) return
        after.day.dayList
            .filterNot { afterDay -> before.day.dayList.any { it.id == afterDay.id } }
            .forEach {
                insertVillageDay(after.id, it)
            }
        after.day.dayList
            .filter { afterDay -> before.day.dayList.any { it.id == afterDay.id } }
            .forEach { afterDay ->
                val beforeDay = before.day.dayList.first { it.id == afterDay.id }
                if (afterDay.existsDifference(beforeDay)) {
                    updateVillageDay(afterDay)
                }
            }
    }

    /**
     * 村日付登録
     * @param villageId villageId
     * @param day 村日付
     * @return 村日付id
     */
    private fun insertVillageDay(
        villageId: Int,
        day: com.ort.wolf4busy.domain.model.village.VillageDay
    ): com.ort.wolf4busy.domain.model.village.VillageDay {
        val villageDay = VillageDay()
        villageDay.villageId = villageId
        villageDay.day = day.day
        villageDay.noonnightCodeAsNoonnight = CDef.Noonnight.codeOf(day.noonnight)
        villageDay.daychangeDatetime = day.dayChangeDatetime
        villageDay.isUpdating = true
        villageDayBhv.insert(villageDay)
        return VillageDataConverter.convertVillageDayToVillageDay(villageDay)
    }

    private fun updateVillageDay(
        day: com.ort.wolf4busy.domain.model.village.VillageDay
    ) {
        val villageDay = VillageDay()
        villageDay.villageDayId = day.id
        villageDay.daychangeDatetime = day.dayChangeDatetime
        villageDay.isUpdating = day.isUpdating
        villageDayBhv.update(villageDay)
    }

    private fun updateVillagePlayerDifference(
        before: com.ort.wolf4busy.domain.model.village.Village,
        after: com.ort.wolf4busy.domain.model.village.Village
    ) {
        if (!before.participant.existsDifference(after.participant)) return
        // 増減はないはずなので更新だけ
        after.participant.memberList.forEach {
            val beforeMember = before.participant.member(it.id)
            if (it.existsDifference(beforeMember)) {
                val villagePlayer = VillagePlayer()
                villagePlayer.villagePlayerId = it.id
                villagePlayer.isDead = it.dead != null
                villagePlayer.deadReasonCodeAsDeadReason = it.dead?.toCdef()
                villagePlayer.deadVillageDayId = it.dead?.villageDay?.id
                villagePlayer.isGone = it.isGone
                villagePlayer.skillCodeAsSkill = it.skill?.toCdef()
                villagePlayer.requestSkillCodeAsSkill = it.skillRequest.first.toCdef()
                villagePlayer.secondRequestSkillCodeAsSkill = it.skillRequest.second.toCdef()
                villagePlayerBhv.update(villagePlayer)
            }
        }
    }

    /**
     * 村登録
     * @param villageModel 村
     * @return villageId
     */
    private fun insertVillage(villageModel: com.ort.wolf4busy.domain.model.village.Village): Int {
        val village = Village()
        village.villageDisplayName = villageModel.name
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.codeOf(villageModel.status.code)
        village.createPlayerId = villageModel.creatorPlayerId
        villageBhv.insert(village)
        return village.villageId
    }

    /**
     * 村設定登録
     * @param villageId villageId
     * @param settings model settings
     * @param password password
     */
    private fun insertVillageSettings(villageId: Int, settings: VillageSettings, password: String?) {
        insertVillageSetting(villageId, CDef.VillageSettingItem.最低人数, settings.capacity.min.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.最大人数, settings.capacity.max.toString())
        insertVillageSetting(villageId, CDef.VillageSettingItem.期間形式, settings.time.termType)
        insertVillageSetting(
            villageId,
            CDef.VillageSettingItem.開始予定日時,
            settings.time.startDatetime.format(VillageDataConverter.DATETIME_FORMATTER)
        )
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

    private fun insertVillageSetting(villageId: Int, item: CDef.VillageSettingItem, value: String) {
        val setting = VillageSetting()
        setting.villageId = villageId
        setting.villageSettingItemCodeAsVillageSettingItem = item
        setting.villageSettingText = value
        villageSettingBhv.insert(setting)
    }

    /**
     * 発言制限登録
     * @param villageId villageId
     * @param setting 村設定
     */
    private fun insertMessageRestrictionList(villageId: Int, setting: VillageSettings) {
        setting.rules.messageRestrict.restrictList.forEach {
            insertMessageRestriction(villageId, it.type.code, it.count, it.length)
        }
    }

    private fun insertMessageRestriction(villageId: Int, messageTypeCode: String, count: Int, length: Int) {
        val restrict = MessageRestriction()
        restrict.villageId = villageId
        restrict.messageTypeCodeAsMessageType = CDef.MessageType.codeOf(messageTypeCode)
        restrict.messageMaxNum = count
        restrict.messageMaxLength = length
        messageRestrictionBhv.insert(restrict)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun toFlg(bool: Boolean): String {
        return if (bool) VillageDataConverter.FLG_TRUE else VillageDataConverter.FLG_FALSE
    }
}