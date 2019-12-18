package com.ort.wolf4busy.infrastructure.datasource.village

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.*
import com.ort.dbflute.exentity.*
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.setting.VillageSettings
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

    /**
     * 村一覧取得
     * @return 村一覧
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
    fun selectVillage(villageId: Int, excludeGonePlayer: Boolean = true): com.ort.wolf4busy.domain.model.village.Village {
        val village = villageBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
        }
        villageBhv.load(village) { loader ->
            loader.loadVillagePlayer { vpCB ->
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
     * 村登録
     * @param villageModel 村
     * @return 村ID
     */
    fun insertVillage(villageModel: com.ort.wolf4busy.domain.model.village.Village): Int {
        val village = Village()
        village.villageDisplayName = villageModel.name
        village.villageStatusCodeAsVillageStatus = CDef.VillageStatus.codeOf(villageModel.status.code)
        village.createPlayerName = villageModel.creatorPlayerName
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

    /**
     * 発言制限登録
     * @param villageId villageId
     * @param setting 村設定
     */
    fun insertMessageRestrictionList(villageId: Int, setting: VillageSettings) {
        setting.rules.messageRestrict.restrictList.forEach {
            insertMessageRestriction(villageId, it.type.code, it.count, it.length)
        }
    }

    /**
     * 村日付取得
     * @param villageId villageId
     * @param day 何日目か
     * @param noonnightCode 昼夜
     * @return 村日付
     */
    fun selectVillageDay(villageId: Int, day: Int, noonnightCode: String): com.ort.wolf4busy.domain.model.village.VillageDay {
        val villageDay: VillageDay = villageDayBhv.selectEntityWithDeletedCheck {
            it.query().setVillageId_Equal(villageId)
            it.query().setDay_Equal(day)
            it.query().setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.codeOf(noonnightCode))
        }
        val village: Village = villageBhv.selectByPK(villageId).get()
        return VillageDataConverter.convertVillageDayToVillageDay(villageDay, village.epilogueDay)
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
        villageDay.daychangeDatetime = day.dayChangeDatetime
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
     * 村参加者取得
     * @param villageId villageId
     * @param uid uid
     * @return 村参加者
     */
    fun selectVillagePlayer(villageId: Int, uid: String): VillageParticipant? {
        return villagePlayerBhv.selectEntity {
            it.setupSelect_Chara()
            it.setupSelect_Player()
            it.query().setVillageId_Equal(villageId)
            it.query().queryPlayer().setUid_Equal(uid)
        }.map { VillageDataConverter.convertVillagePlayerToParticipant(it, true) }.orElse(null)
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
     * @return 村参加ID
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

    /**
     * 村パスワード検索
     * 大文字小文字も一致しなければいけないので取得してから比較する
     *
     * @param villageId villageId
     * @return 村パスワード
     */
    fun selectVillagePassword(villageId: Int): String {
        return villageSettingBhv.selectByPK(villageId, CDef.VillageSettingItem.入村パスワード).get().villageSettingText
    }

    /**
     * いずれかの進行中の村に参加しているか
     * @param uid uid
     * @return いずれかの進行中の村に参加しているか
     */
    fun isParticipatingAnyProgressVillage(uid: String): Boolean {
        return villagePlayerBhv.selectCount {
            it.query().queryPlayer().setUid_Equal(uid)
            it.query().queryVillage().setVillageStatusCode_InScope_AsVillageStatus(
                listOf(CDef.VillageStatus.募集中, CDef.VillageStatus.開始待ち, CDef.VillageStatus.進行中)
            )
            it.query().setIsGone_Equal(false)
        } > 0
    }

    /**
     * 役職希望を取得
     * @param participant 参加情報
     * @return 役職希望
     */
    fun selectSkillRequest(participant: VillageParticipant): SkillRequest? {
        val villagePlayer = villagePlayerBhv.selectEntityWithDeletedCheck {
            it.query().setVillagePlayerId_Equal(participant.id)
        }

        return SkillRequest(
            first = villagePlayer.requestSkillCodeAsSkill.let { Skill(it.code(), it.name) },
            second = villagePlayer.secondRequestSkillCodeAsSkill.let { Skill(it.code(), it.name) }
        )
    }

    /**
     * 希望役職を更新
     * @param participant 村参加者
     * @param firstRequest 第1希望
     * @param secondRequest 第2希望
     */
    fun updateSkillRequest(participant: VillageParticipant, firstRequest: Skill, secondRequest: Skill) {
        val villagePlayer = VillagePlayer()
        villagePlayer.villagePlayerId = participant.id
        villagePlayer.requestSkillCodeAsSkill = CDef.Skill.codeOf(firstRequest.code)
        villagePlayer.secondRequestSkillCodeAsSkill = CDef.Skill.codeOf(secondRequest.code)
        villagePlayerBhv.update(villagePlayer)
    }

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