package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Prologue {

    fun leaveParticipantIfNeeded(
        dayChange: DayChange,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        // 24時間以内の発言
        val recentMessageList =
            todayMessages.messageList.filter { it.time.datetime.isAfter(Wolf4busyDateUtil.currentLocalDateTime().minusDays(1L)) }
        // 24時間以内に発言していなかったら退村
        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.village.participant.memberList.forEach { member ->
            if (recentMessageList.none { message -> message.fromVillageParticipantId!! == member.id }) {
                village = village.leaveParticipant(member.id)
                messages = messages.add(Message.createLeaveMessage(charas.chara(member.charaId), dayChange.village.day.latestDay().id))
            }
        }
        return dayChange.copy(
            village = village,
            messages = messages
        ).setIsChange(dayChange)
    }

    fun addDayIfNeeded(
        dayChange: DayChange
    ): DayChange {
        // 開始時刻になっていない場合は何もしない
        if (!shouldForward(dayChange.village)) return dayChange
        // 開始時刻になっているが参加者数が不足している場合は廃村にする
        if (isNotEnoughMemberCount(dayChange.village)) return cancelVillage(dayChange).setIsChange(dayChange)
        // 新しい日付追加
        return dayChange.copy(village = dayChange.village.addNewDay()).setIsChange(dayChange)
    }

    fun dayChange(
        dayChange: DayChange,
        charas: Charas
    ): DayChange {
        // 開始メッセージ追加
        var messages = dayChange.messages.add(Message.createVillageDay1Message(dayChange.village.day.latestDay().id))
        // 役職割り当て
        var village = dayChange.village.assignSkill()
        // 役職構成メッセージ追加
        messages = messages.add(Message.createOrganizationMessage(village))
        // ステータス変更
        village = village.changeStatus(CDef.VillageStatus.進行中)
        // デフォルト能力行使指定
        val abilities = dayChange.abilities.addDefaultAbilities(village)
        // ダミーキャラ発言
        Message.createDummyCharaFirstDayMessage(village, charas)?.let { messages = messages.add(it) }

        return dayChange.copy(
            village = village,
            messages = messages,
            abilities = abilities
        ).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean =
        !Wolf4busyDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)

    // 参加者数が不足している場合に廃村にする
    private fun cancelVillage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.changeStatus(CDef.VillageStatus.廃村),
            messages = dayChange.messages.add(Message.createCancelVillageMessage(dayChange.village.day.latestDay().id))
        )
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min
}