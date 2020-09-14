package com.ort.howlingwolf.domain.service.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Messages
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.service.ability.AbilityDomainService
import com.ort.howlingwolf.domain.service.participate.ParticipateDomainService
import com.ort.howlingwolf.domain.service.skill.SkillAssignDomainService
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import org.springframework.stereotype.Service

@Service
class PrologueDomainService(
    private val abilityDomainService: AbilityDomainService,
    private val skillAssignDomainService: SkillAssignDomainService,
    private val participateDomainService: ParticipateDomainService
) {

    fun leaveParticipantIfNeeded(
        dayChange: DayChange,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        // 開始2時間を切っていたら退村させない
        if (HowlingWolfDateUtil.currentLocalDateTime().isAfter(dayChange.village.setting.time.startDatetime.minusHours(2L))) {
            return dayChange
        }
        // 24時間以内の発言
        val recentMessageList =
            todayMessages.list.filter { it.time.datetime.isAfter(HowlingWolfDateUtil.currentLocalDateTime().minusDays(1L)) }
        // 24時間以内に発言していなかったら退村
        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.village.notDummyParticipant().memberList.forEach { member ->
            if (recentMessageList.none { message -> message.fromVillageParticipantId!! == member.id }) {
                village = village.leaveParticipant(member.id)
                messages = messages.add(participateDomainService.createLeaveMessage(village, charas.chara(member.charaId)))
            }
        }
        return dayChange.copy(
            village = village,
            messages = messages
        ).setIsChange(dayChange)
    }

    fun cancelOrExtendIfNeeded(dayChange: DayChange, isExistOtherPrologueVillage: Boolean): DayChange {
        // 開始時刻になっていない場合は何もしない
        if (!shouldForward(dayChange.village)) return dayChange
        // 参加人数が足りている場合は何もしない
        if (!isNotEnoughMemberCount(dayChange.village)) return dayChange
        // 他に村が建っていたら廃村
        return if (isExistOtherPrologueVillage) cancelVillage(dayChange).setIsChange(dayChange)
        // 建っていなかったら延長
        else extendPrologue(dayChange).setIsChange(dayChange)
    }

    fun addDayIfNeeded(
        dayChange: DayChange
    ): DayChange {
        // 開始時刻になっていない場合は何もしない
        if (!shouldForward(dayChange.village)) return dayChange
        // 新しい日付追加
        return dayChange.copy(village = dayChange.village.addNewDay()).setIsChange(dayChange)
    }

    fun dayChange(
        beforeDayChange: DayChange,
        charas: Charas
    ): DayChange {
        // 開始メッセージ追加
        var dayChange = addStartMessage(beforeDayChange)
        // 役職割り当て
        dayChange = skillAssignDomainService.assign(dayChange)
        // 役職構成メッセージ追加
        dayChange = addOrganizationMessage(dayChange)
        // 人狼系役職メッセージ追加
        dayChange = addWolfsConfirmMessage(dayChange, charas)
        // 共有がいれば役職メッセージ追加
        dayChange = addMasonsConfirmMessageIfNeeded(dayChange, charas)
        // ステータス変更
        dayChange = dayChange.copy(village = dayChange.village.changeStatus(CDef.VillageStatus.進行中))
        // デフォルト能力行使指定
        dayChange = abilityDomainService.addDefaultAbilities(dayChange)
        // ダミーキャラ発言
        dayChange = addDummyCharaFirstDayMessageIfNeeded(dayChange, charas)

        return dayChange.setIsChange(beforeDayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean =
        !HowlingWolfDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)

    // 参加者数が不足している場合に廃村にする
    private fun cancelVillage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.changeStatus(CDef.VillageStatus.廃村),
            messages = dayChange.messages.add(dayChange.village.createCancelVillageMessage())
        )
    }

    private fun extendPrologue(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.extendPrologue(),
            messages = dayChange.messages.add(dayChange.village.createExtendPrologueMessage())
        )
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min

    private fun addStartMessage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            messages = dayChange.messages.add(dayChange.village.createVillageDay1Message())
        )
    }

    private fun addOrganizationMessage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            messages = dayChange.messages.add(dayChange.village.createOrganizationMessage())
        )
    }

    private fun addWolfsConfirmMessage(dayChange: DayChange, charas: Charas): DayChange {
        return dayChange.copy(
            messages = dayChange.messages.add(dayChange.village.createWolfsConfirmMessage(charas))
        )
    }

    private fun addMasonsConfirmMessageIfNeeded(dayChange: DayChange, charas: Charas): DayChange {
        return dayChange.village.createMasonsConfirmMessage(charas)?.let {
            dayChange.copy(
                messages = dayChange.messages.add(it)
            )
        } ?: dayChange
    }

    private fun addDummyCharaFirstDayMessageIfNeeded(dayChange: DayChange, charas: Charas): DayChange {
        return dayChange.village.createDummyCharaFirstDayMessage(charas)?.let {
            dayChange.copy(
                messages = dayChange.messages.add(it)
            )
        } ?: dayChange
    }
}