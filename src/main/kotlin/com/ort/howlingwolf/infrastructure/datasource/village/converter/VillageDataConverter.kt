package com.ort.howlingwolf.infrastructure.datasource.village.converter

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exentity.MessageRestriction
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.dbflute.exentity.VillageSetting
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.PersonCapacity
import com.ort.howlingwolf.domain.model.village.setting.VillageCharachip
import com.ort.howlingwolf.domain.model.village.setting.VillageMessageRestrict
import com.ort.howlingwolf.domain.model.village.setting.VillageMessageRestricts
import com.ort.howlingwolf.domain.model.village.setting.VillageOrganizations
import com.ort.howlingwolf.domain.model.village.setting.VillagePassword
import com.ort.howlingwolf.domain.model.village.setting.VillageRules
import com.ort.howlingwolf.domain.model.village.setting.VillageSettings
import com.ort.howlingwolf.domain.model.village.setting.VillageTime
import org.dbflute.cbean.result.ListResultBean
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object VillageDataConverter {

    const val FLG_TRUE = "1"
    const val FLG_FALSE = "0"
    val DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")

    fun convertVillageListToVillages(villageList: ListResultBean<Village>): Villages {
        return Villages(
            list = villageList.map { convertVillageToSimpleVillage(it) }
        )
    }

    fun convertVillageToVillage(village: Village): com.ort.howlingwolf.domain.model.village.Village {
        val participantList = village.villagePlayerList.filter { vp -> vp.isParticipant }
        val visitorList = village.villagePlayerList.filter { vp -> vp.isVisitor }
        return com.ort.howlingwolf.domain.model.village.Village(
            id = village.villageId,
            name = village.villageDisplayName,
            creatorPlayerId = village.createPlayerId,
            status = VillageStatus(village.villageStatusCodeAsVillageStatus),
            setting = convertVillageSettingListToVillageSetting(village.villageSettingList, village.messageRestrictionList),
            participant = VillageParticipants(
                count = participantList.size,
                memberList = participantList.map { convertVillagePlayerToParticipant(it, village) }
            ),
            spectator = VillageParticipants(
                count = visitorList.size,
                memberList = visitorList.map { convertVillagePlayerToParticipant(it) }
            ),
            day = VillageDays(
                dayList = village.villageDayList.map { convertVillageDayToVillageDay(it) }
            ),
            winCamp = village.winCampCodeAsCamp?.let { com.ort.howlingwolf.domain.model.camp.Camp(it) }
        )
    }

    fun convertVillageDayToVillageDay(villageDay: VillageDay): com.ort.howlingwolf.domain.model.village.VillageDay {
        val day: Int = villageDay.day
        return com.ort.howlingwolf.domain.model.village.VillageDay(
            id = villageDay.villageDayId,
            day = day,
            noonnight = villageDay.noonnightCode,
            dayChangeDatetime = villageDay.daychangeDatetime
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertVillageToSimpleVillage(village: Village): com.ort.howlingwolf.domain.model.village.Village {
        return com.ort.howlingwolf.domain.model.village.Village(
            id = village.villageId,
            name = village.villageDisplayName,
            creatorPlayerId = village.createPlayerId,
            status = VillageStatus(village.villageStatusCodeAsVillageStatus),
            setting = convertVillageSettingListToVillageSetting(village.villageSettingList, village.messageRestrictionList),
            participant = VillageParticipants(count = village.participantCount),
            spectator = VillageParticipants(count = village.visitorCount),
            day = VillageDays( // 最新の1日だけ
                dayList = village.villageDayList.firstOrNull()?.let {
                    listOf(convertVillageDayToVillageDay(it))
                }.orEmpty()
            ),
            winCamp = village.winCampCodeAsCamp?.let { com.ort.howlingwolf.domain.model.camp.Camp(it) }
        )
    }

    private fun convertVillageSettingListToVillageSetting(
        settingList: List<VillageSetting>,
        restrictList: List<MessageRestriction>
    ): VillageSettings {
        return VillageSettings(
            capacity = PersonCapacity.invoke(
                min = detectItemText(settingList, CDef.VillageSettingItem.最低人数)?.toInt(),
                max = detectItemText(settingList, CDef.VillageSettingItem.最大人数)?.toInt()
            ),
            time = VillageTime.invoke(
                termType = detectItemText(settingList, CDef.VillageSettingItem.期間形式),
                startDatetime = detectItemText(settingList, CDef.VillageSettingItem.開始予定日時)?.let {
                    LocalDateTime.parse(
                        it,
                        DATETIME_FORMATTER
                    )
                },
                dayChangeIntervalSeconds = detectItemText(settingList, CDef.VillageSettingItem.更新間隔秒)?.toInt(),
                silentHours = detectItemText(settingList, CDef.VillageSettingItem.沈黙時間)?.toInt()
            ),
            charachip = VillageCharachip.invoke(
                dummyCharaId = detectItemText(settingList, CDef.VillageSettingItem.ダミーキャラid)?.toInt(),
                charachipId = detectItemText(settingList, CDef.VillageSettingItem.キャラクターグループid)?.toInt()
            ),
            organizations = VillageOrganizations(
                organization = detectItemText(settingList, CDef.VillageSettingItem.構成)?.let { convertOrganizeToOrganizationMap(it) }
            ),
            rules = VillageRules.invoke(
                openVote = detectItemText(settingList, CDef.VillageSettingItem.記名投票か)?.let { it == FLG_TRUE },
                availableSkillRequest = detectItemText(settingList, CDef.VillageSettingItem.役職希望可能か)?.let { it == FLG_TRUE },
                availableSpectate = detectItemText(settingList, CDef.VillageSettingItem.見学可能か)?.let { it == FLG_TRUE },
                openSkillInGrave = detectItemText(settingList, CDef.VillageSettingItem.墓下役職公開ありか)?.let { it == FLG_TRUE },
                visibleGraveMessage = detectItemText(settingList, CDef.VillageSettingItem.墓下見学発言を生存者が見られるか)?.let { it == FLG_TRUE },
                availableSuddenlyDeath = detectItemText(settingList, CDef.VillageSettingItem.突然死ありか)?.let { it == FLG_TRUE },
                availableCommit = detectItemText(settingList, CDef.VillageSettingItem.コミット可能か)?.let { it == FLG_TRUE },
                autoGenerated = detectItemText(settingList, CDef.VillageSettingItem.自動生成村か)?.let { it == FLG_TRUE },
                messageRestrict = VillageMessageRestricts(
                    existRestricts = restrictList.isNotEmpty(),
                    restrictList = restrictList.map {
                        VillageMessageRestrict(
                            type = com.ort.howlingwolf.domain.model.message.MessageType(CDef.MessageType.codeOf(it.messageTypeCode)),
                            count = it.messageMaxNum,
                            length = it.messageMaxLength
                        )
                    }
                )
            ),
            password = VillagePassword(
                joinPassword = detectItemText(settingList, CDef.VillageSettingItem.入村パスワード)
            )
        )
    }

    fun convertVillagePlayerToParticipant(vp: VillagePlayer, village: Village? = null): VillageParticipant {
        return VillageParticipant(
            id = vp.villagePlayerId,
            charaId = vp.charaId,
            playerId = vp.playerId,
            dead = if (vp.isDead) convertToDeadReasonToDead(vp) else null,
            isSpectator = vp.isSpectator,
            isGone = vp.isGone,
            skill = if (vp.skillCodeAsSkill == null) null else Skill(vp.skillCodeAsSkill),
            skillRequest = SkillRequest(
                first = Skill(vp.requestSkillCodeAsSkill),
                second = Skill(vp.secondRequestSkillCodeAsSkill)
            ),
            isWin = if (village?.winCampCode == null || vp.skillCodeAsSkill == null) null else village.winCampCode == vp.skillCodeAsSkill.campCode()
        )
    }

    private fun convertToDeadReasonToDead(vp: VillagePlayer): Dead {
        return Dead(vp.deadReasonCodeAsDeadReason, convertVillageDayToVillageDay(vp.villageDay.get()))
    }

    private fun detectItemText(settingList: List<VillageSetting>, item: CDef.VillageSettingItem): String? {
        return settingList.find { setting -> setting.villageSettingItemCodeAsVillageSettingItem == item }?.villageSettingText
    }

    private fun convertOrganizeToOrganizationMap(organize: String): Map<Int, String> {
        return organize.replace("\r\n", "\n").split("\n").map { it.length to it }.toMap()
    }
}