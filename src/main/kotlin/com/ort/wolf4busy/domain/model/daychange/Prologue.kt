package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object Prologue {

    fun dayChange(
        village: Village,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        var dayChange = DayChange(
            isChange = false, // あとで更新
            village = village.copy(),
            messages = Messages(listOf()),
            votes = VillageVotes(listOf()),
            abilities = VillageAbilities(listOf())
        )
        // 長時間発言していない人を退村させる
        dayChange = leaveVillageIfNeeded(dayChange, todayMessages, charas)
        // 開始時刻になっていない場合は何もしない
        if (!shouldForward(dayChange.village)) return dayChange
        // 開始時刻になっているが参加者数が不足している場合は廃村にする
        if (isNotEnoughMemberCount(village)) return cancelVillage(dayChange)
        // 日付を切り替える
        return startVillage(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * 長時間発言していない人を退村させる
     *
     * @param dayChange 更新用情報
     * @param todayMessages 当日の通常発言
     * @param charas キャラ
     */
    private fun leaveVillageIfNeeded(
        dayChange: DayChange,
        todayMessages: Messages,
        charas: Charas
    ): DayChange {
        // 24時間以内の発言
        val recentMessageList =
            todayMessages.messageList.filter { it.time.datetime.isAfter(Wolf4busyDateUtil.currentLocalDateTime().minusDays(1L)) }
        // 24時間以内に発言していなかったら退村
        var changedVillage = dayChange.village.copy()
        var changedMessages = dayChange.messages.copy()
        dayChange.village.participant.memberList.forEach { member ->
            if (recentMessageList.none { message -> message.from!!.id == member.id }) {
                changedVillage = changedVillage.leaveParticipant(member.id)
                changedMessages = changedMessages.add(createLeaveMessage(member, charas, dayChange.village.day.latestDay()))
            }
        }
        return dayChange.copy(
            village = changedVillage,
            messages = changedMessages
        )
    }

    private fun createLeaveMessage(participant: VillageParticipant, charas: Charas, day: VillageDay): Message {
        val chara = charas.list.find { it.id == participant.charaId }!!
        val message = "${chara.charaName.name}は村を去った。"
        return DayChange.createOpenSystemMessage(message, day.day)
    }

    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean =
        Wolf4busyDateUtil.currentLocalDateTime().isAfter(village.day.latestDay().dayChangeDatetime)


    // 参加者数が不足している場合に廃村にする
    private fun cancelVillage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.changeStatus(CDef.VillageStatus.廃村),
            messages = dayChange.messages.add(
                DayChange.createOpenSystemMessage(
                    "人数が不足しているため廃村しました。",
                    dayChange.village.day.latestDay().day
                )
            )
        )
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min

    private fun startVillage(dayChange: DayChange): DayChange {
        // 新しい日付追加
        var changedVillage = dayChange.village.addNewDay()
        // 開始メッセージ追加
        var changedMessages = dayChange.messages.add(createProgressStartMessage(dayChange.village.day.latestDay().day))
        // 役職割り当て
        changedVillage = changedVillage.assignSkill()
        // ステータス変更
        changedVillage = changedVillage.changeStatus(CDef.VillageStatus.進行中)
        // デフォルト投票先指定
        // var votes = dayChange.votes.addDefaultVote(changedVillage)
        // デフォルト能力行使指定
        var abilities = dayChange.abilities.addDefaultAbilities(changedVillage)


        return dayChange.copy(
            village = changedVillage,
            messages = changedMessages
        )
    }

    private fun createProgressStartMessage(day: Int): Message {
        return DayChange.createOpenSystemMessage(
            text = "さあ、自らの姿を鏡に映してみよう。\nそこに映るのはただの村人か、それとも血に飢えた人狼か。\n\n例え人狼でも、多人数で立ち向かえば怖くはない。\n問題は、だれが人狼なのかという事だ。\n占い師の能力を持つ人間ならば、それを見破れるだろう。",
            day = day
        )
    }
}