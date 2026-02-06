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
import com.ort.howlingwolf.infrastructure.repository.TweetRepository
import org.springframework.stereotype.Service

@Service
class PrologueDomainService(
    private val abilityDomainService: AbilityDomainService,
    private val skillAssignDomainService: SkillAssignDomainService,
    private val participateDomainService: ParticipateDomainService,
    private val tweetRepository: TweetRepository
) {

    fun leaveParticipantIfNeeded(
        dayChange: DayChange,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        // 開始72時間前よりも後、かつ開始2時間前よりも前の場合のみ自動で退村させる
        val now = HowlingWolfDateUtil.currentLocalDateTime()
        val startDatetime = dayChange.village.setting.time.startDatetime
        if (now.isBefore(startDatetime.minusHours(72L)) || now.isAfter(startDatetime.minusHours(2L))) {
            return dayChange
        }
        // 24時間以内に発言していなかったら退村
        val recentMessageList =
            todayMessages.list.filter {
                it.time.datetime.isAfter(
                    HowlingWolfDateUtil.currentLocalDateTime().minusDays(1L)
                )
            }
        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.village.notDummyParticipant().memberList.forEach { member ->
            if (recentMessageList.none { message -> message.fromVillageParticipantId!! == member.id }) {
                village = village.leaveParticipant(member.id)
                messages =
                    messages.add(participateDomainService.createLeaveMessage(village, charas.chara(member.charaId)))
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
        // 村建てから2週間後開始固定としたため、延長はしないで廃村確定にする
        return cancelVillage(dayChange).setIsChange(dayChange)
//        // 他に村が建っていたら廃村
//        return if (isExistOtherPrologueVillage) cancelVillage(dayChange).setIsChange(dayChange)
//        // 建っていなかったら延長
//        else extendPrologue(dayChange).setIsChange(dayChange)
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
        // 仲間把握メッセージ追加
        dayChange = abilityDomainService.addRecongnizeMessages(dayChange, charas)
        // ステータス変更
        dayChange = dayChange.copy(village = dayChange.village.changeStatus(CDef.VillageStatus.進行中))
        // デフォルト能力行使指定
        dayChange = abilityDomainService.addDefaultAbilities(dayChange)
        // ダミーキャラ発言
        dayChange = addDummyCharaFirstDayMessageIfNeeded(dayChange, charas)
        // 開始ツイート
        tweetRepository.tweet(dayChange.village.createStartVillageMessage())

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

    private fun addDummyCharaFirstDayMessageIfNeeded(dayChange: DayChange, charas: Charas): DayChange {
        return dayChange.village.createDummyCharaFirstDayMessage(charas)?.let {
            dayChange.copy(
                messages = dayChange.messages.add(it)
            )
        } ?: dayChange
    }
}