package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Prologue {

    fun dayChange(village: Village, todayMessages: Messages, charas: Charas): Pair<Village, Messages> {
        val changeMessages = Messages(listOf())
        // 長時間発言していない人を退村させる
        var villageAndMessages = leaveVillageIfNeeded(village, changeMessages, todayMessages, charas)
        // 開始時刻になっていない場合は終了
        if (!shouldForward(village)) return villageAndMessages
        // 開始時刻になっているが参加者数が不足している場合は廃村にする
        if (isNotEnoughMemberCount(village)) return cancelVillage(villageAndMessages.first, villageAndMessages.second)
        // 日付を切り替える
        return startVillage(villageAndMessages.first, villageAndMessages.second)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * 長時間発言していない人を退村させる
     *
     * @param village village
     * @param messages 更新に際してのメッセージ。ここに追加していく。
     * @param todayMessages 当日の通常発言
     * @param charas キャラ
     */
    private fun leaveVillageIfNeeded(village: Village, messages: Messages, todayMessages: Messages, charas: Charas): Pair<Village, Messages> {
        // 24時間以内の発言
        val recentMessageList = todayMessages.messageList.filter { it.time.datetime.isAfter(Wolf4busyDateUtil.currentLocalDateTime().minusDays(1L)) }
        // 24時間以内に発言していなかったら退村
        val memberList = village.participant.memberList.map { member ->
            if (recentMessageList.none { message -> message.from!!.id == member.id }) {
                messages.add(createLeaveMessage(member, charas))
                member.copy(isGone = true)
            } else {
                member.copy()
            }
        }
        val changedVillage = village.copy(participant = village.participant.copy(memberList = memberList))
        return changedVillage to Messages(listOf())
    }

    private fun createLeaveMessage(participant: VillageParticipant, charas: Charas): Message {
        val chara = charas.list.find { it.id == participant.charaId }!!
        val message = "${chara.charaName.name}は村を去った。"
        return DayChange.createOpenSystemMessage(message)
    }

    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean =
        Wolf4busyDateUtil.currentLocalDateTime().isAfter(village.day.latestDay().dayChangeDatetime)


    // 参加者数が不足している場合に廃村にする
    private fun cancelVillage(village: Village, messages: Messages): Pair<Village, Messages> {
        val changedVillage = village.copy(status = VillageStatus(
            code = CDef.VillageStatus.廃村.code(),
            name = CDef.VillageStatus.廃村.alias()
        ))
        messages.add(DayChange.createOpenSystemMessage("人数が不足しているため廃村しました。"))
        return changedVillage to messages
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min

    private fun startVillage(village: Village, messages: Messages): Pair<Village, Messages> {
        // TODO
        return village to messages
    }
}