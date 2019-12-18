package com.ort.wolf4busy.infrastructure.datasource.village.converter

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exentity.*
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.VillageDays
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.setting.*
import org.dbflute.cbean.result.ListResultBean
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object VillageDataConverter {

    const val FLG_TRUE = "1"
    const val FLG_FALSE = "0"
    val DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")

    fun convertVillageListToVillages(villageList: ListResultBean<Village>): Villages {
        return Villages(
            villageList = villageList.map { convertVillageToSimpleVillage(it) }
        )
    }

    fun convertVillageToVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        val participantList = village.villagePlayerList.filter { vp -> vp.isParticipant }
        val visitorList = village.villagePlayerList.filter { vp -> vp.isVisitor }
        val hasEpilogue: Boolean = hasEpilogue(village.epilogueDay, village.villageDayList)
        return com.ort.wolf4busy.domain.model.village.Village(
            id = village.villageId,
            name = village.villageDisplayName,
            creatorPlayerName = village.createPlayerName,
            status = VillageStatus(
                code = village.villageStatusCodeAsVillageStatus.code(),
                name = village.villageStatusCodeAsVillageStatus.alias()
            ),
            setting = convertVillageSettingListToVillageSetting(village.villageSettingList, village.messageRestrictionList),
            participant = VillageParticipants(
                count = participantList.size,
                memberList = participantList.map { convertVillagePlayerToParticipant(it, hasEpilogue) }
            ),
            spectator = VillageParticipants(
                count = visitorList.size,
                memberList = visitorList.map { convertVillagePlayerToParticipant(it, hasEpilogue) }
            ),
            day = VillageDays(
                dayList = village.villageDayList.map { convertVillageDayToVillageDay(it, village.epilogueDay) }
            )
        )
    }

    fun convertVillageDayToVillageDay(villageDay: VillageDay, epilogueDay: Int?): com.ort.wolf4busy.domain.model.village.VillageDay {
        val day: Int = villageDay.day
        return com.ort.wolf4busy.domain.model.village.VillageDay(
            id = villageDay.villageDayId,
            day = day,
            noonnight = villageDay.noonnightCode,
            dayChangeDatetime = villageDay.daychangeDatetime,
            isUpdating = villageDay.isUpdating,
            isPrologue = day == 0,
            isEpilogue = epilogueDay != null && epilogueDay == day
        )
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun convertVillageToSimpleVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        return com.ort.wolf4busy.domain.model.village.Village(
            id = village.villageId,
            name = village.villageDisplayName,
            creatorPlayerName = village.createPlayerName,
            status = VillageStatus(
                code = village.villageStatusCodeAsVillageStatus.code(),
                name = village.villageStatusCodeAsVillageStatus.alias()
            ),
            setting = convertVillageSettingListToVillageSetting(village.villageSettingList, village.messageRestrictionList),
            participant = VillageParticipants(
                count = village.participantCount
            ),
            spectator = VillageParticipants(
                count = village.visitorCount
            ),
            day = VillageDays( // 最新の1日だけ
                dayList = village.villageDayList.firstOrNull()?.let {
                    listOf(
                        convertVillageDayToVillageDay(
                            it,
                            village.epilogueDay
                        )
                    )
                }.orEmpty()
            )
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
                dayChangeIntervalSeconds = detectItemText(settingList, CDef.VillageSettingItem.更新間隔秒)?.toInt()
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
                messageRestrict = VillageMessageRestricts(
                    existRestricts = restrictList.isNotEmpty(),
                    restrictList = restrictList.map {
                        VillageMessageRestrict(
                            type = com.ort.wolf4busy.domain.model.message.MessageType(
                                code = it.messageTypeCode,
                                name = CDef.MessageType.codeOf(it.messageTypeCode).alias()
                            ),
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

    fun convertVillagePlayerToParticipant(vp: VillagePlayer, hasEpilogue: Boolean): VillageParticipant {
        return VillageParticipant(
            id = vp.villagePlayerId,
            charaId = vp.charaId,
            playerId = if (!hasEpilogue) null else vp.playerId,
            dead = if (vp.isDead) convertToDeadReasonToDead(vp) else null,
            isSpectator = vp.isSpectator,
            isGone = vp.isGone,
            skill = if (!hasEpilogue || vp.skillCodeAsSkill == null) null else Skill(
                code = vp.skillCodeAsSkill.code(),
                name = vp.skillCodeAsSkill.alias()
            ),
            skillRequest = SkillRequest(
                first = Skill(
                    code = vp.requestSkillCodeAsSkill.code(),
                    name = vp.requestSkillCodeAsSkill.alias()
                ),
                second = Skill(
                    code = vp.secondRequestSkillCodeAsSkill.code(),
                    name = vp.secondRequestSkillCodeAsSkill.alias()
                )
            )
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

    private fun hasEpilogue(epilogueDay: Int?, villageDayList: List<VillageDay>): Boolean {
        epilogueDay ?: return false
        return villageDayList.any { it.day == epilogueDay }
    }
}