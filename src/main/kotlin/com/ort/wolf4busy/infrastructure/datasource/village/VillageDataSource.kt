package com.ort.wolf4busy.infrastructure.datasource.village

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.dbflute.exentity.VillageSetting
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.participant.VillageVisitor
import com.ort.wolf4busy.domain.model.village.participant.VillageVisitors
import com.ort.wolf4busy.domain.model.village.setting.*
import org.dbflute.cbean.result.ListResultBean
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Repository
class VillageDataSource(
        val villageBhv: VillageBhv
) {

    companion object {
        private const val FLG_TRUE = "1"
        private val DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")
    }

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
        return convertVillageListToVillages(villageList)
    }

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

        return convertVillageToVillage(village)
    }

    // ===================================================================================
    //                                                                             Convert
    //                                                                           =========
    private fun convertVillageListToVillages(villageList: ListResultBean<Village>): Villages {
        return Villages(
                villageList = villageList.map { convertVillageToSimpleVillage(it) }
        )
    }

    private fun convertVillageToSimpleVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        return com.ort.wolf4busy.domain.model.village.Village(
                id = village.villageId,
                name = village.villageDisplayName,
                creatorPlayerName = village.createPlayerName,
                status = VillageStatus(
                        code = village.villageStatusCodeAsVillageStatus.code(),
                        name = village.villageStatusCodeAsVillageStatus.alias()
                ),
                setting = village.villageSettingList.convertVillageSettingListToVillageSetting(),
                participant = VillageParticipants(
                        count = village.participantCount
                ),
                visitor = VillageVisitors(
                        count = village.visitorCount
                )
        )
    }

    private fun convertVillageToVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        val participantList = village.villagePlayerList.filter { vp -> vp.isParticipant }
        val visitorList = village.villagePlayerList.filter { vp -> vp.isVisitor }
        return com.ort.wolf4busy.domain.model.village.Village(
                id = village.villageId,
                name = village.villageDisplayName,
                creatorPlayerName = village.createPlayerName,
                status = VillageStatus(
                        code = village.villageStatusCodeAsVillageStatus.code(),
                        name = village.villageStatusCodeAsVillageStatus.alias()
                ),
                setting = village.villageSettingList.convertVillageSettingListToVillageSetting(),
                participant = VillageParticipants(
                        count = participantList.size,
                        memberList = participantList.map { convertVillagePlayerToParticipant(it) }
                ),
                visitor = VillageVisitors(
                        count = visitorList.size,
                        memberList = visitorList.map { convertVillagePlayerToVisitor(it) }
                )
        )
    }

    private fun List<VillageSetting>.convertVillageSettingListToVillageSetting(): VillageSettings {
        return VillageSettings(
                capacity = PersonCapacity.invoke(
                        min = detectItemText(this, CDef.VillageSettingItem.最低人数)?.toInt(),
                        max = detectItemText(this, CDef.VillageSettingItem.最大人数)?.toInt()
                ),
                time = VillageTime.invoke(
                        termType = detectItemText(this, CDef.VillageSettingItem.期間形式),
                        startDatetime = detectItemText(this, CDef.VillageSettingItem.開始予定日時)?.let { LocalDateTime.parse(it, DATETIME_FORMATTER) },
                        dayChangeIntervalSeconds = detectItemText(this, CDef.VillageSettingItem.更新間隔秒)?.toInt()
                ),
                charachip = VillageCharachip.invoke(
                        dummyCharaId = detectItemText(this, CDef.VillageSettingItem.ダミーキャラid)?.toInt(),
                        charachipId = detectItemText(this, CDef.VillageSettingItem.キャラクターグループid)?.toInt()
                ),
                organizations = VillageOrganizations(
                        organization = detectItemText(this, CDef.VillageSettingItem.構成)?.let { convertOrganizeToOrganizationMap(it) }
                ),
                rules = VillageRules.invoke(
                    openVote = detectItemText(this, CDef.VillageSettingItem.記名投票か)?.let { it == FLG_TRUE },
                    availableSkillRequest = detectItemText(this, CDef.VillageSettingItem.役職希望可能か)?.let { it == FLG_TRUE },
                    availableSpectate = detectItemText(this, CDef.VillageSettingItem.見学可能か)?.let { it == FLG_TRUE },
                    openSkillInGrave = detectItemText(this, CDef.VillageSettingItem.墓下役職公開ありか)?.let { it == FLG_TRUE },
                    visibleGraveMessage = detectItemText(this, CDef.VillageSettingItem.墓下見学発言を生存者が見られるか)?.let { it == FLG_TRUE },
                    availableSuddenlyDeath = detectItemText(this, CDef.VillageSettingItem.突然死ありか)?.let { it == FLG_TRUE },
                    availableCommit = detectItemText(this, CDef.VillageSettingItem.コミット可能か)?.let { it == FLG_TRUE }
                ),
                password = VillagePassword(
                    joinPassword = detectItemText(this, CDef.VillageSettingItem.入村パスワード)
                )
        )
    }

    private fun convertVillagePlayerToParticipant(vp: VillagePlayer): VillageParticipant {
        return VillageParticipant(
                id = vp.villagePlayerId,
                charaId = vp.charaId,
                dead = if (vp.isDead) convertToDeadReasonToDead(vp) else null
        )
    }

    private fun convertVillagePlayerToVisitor(vp: VillagePlayer): VillageVisitor {
        return VillageVisitor(
                id = vp.villagePlayerId,
                charaId = vp.charaId
        )
    }

    private fun convertToDeadReasonToDead(vp: VillagePlayer): Dead {
        val deadReason = vp.deadReasonCodeAsDeadReason
        return Dead(
                code = deadReason.code(),
                reason = deadReason.alias(),
                day = vp.deadDay
        )
    }

    private fun detectItemText(settingList: List<VillageSetting>, item: CDef.VillageSettingItem): String? {
        return settingList.find { setting -> setting.villageSettingItemCodeAsVillageSettingItem == item }?.villageSettingText
    }

    private fun convertOrganizeToOrganizationMap(organize: String): Map<Int, String> {
        return organize.replace("\r\n", "\n").split("\n").map { it.length to it }.toMap()
    }
}