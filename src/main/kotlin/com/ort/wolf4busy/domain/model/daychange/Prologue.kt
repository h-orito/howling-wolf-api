package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.player.Players
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
        charas: Charas,
        players: Players
    ): DayChange {
        var beforeDayChange = DayChange(
            isChange = false, // あとで更新
            village = village.copy(),
            messages = Messages(listOf()),
            votes = VillageVotes(listOf()),
            abilities = VillageAbilities(listOf()),
            players = players.copy()
        )
        // 長時間発言していない人を退村させる
        var dayChange = leaveVillageIfNeeded(beforeDayChange, todayMessages, charas)
        // 開始時刻になっていない場合は何もしない
        if (!shouldForward(dayChange.village)) return dayChange
        // 開始時刻になっているが参加者数が不足している場合は廃村にする
        if (isNotEnoughMemberCount(village)) return cancelVillage(dayChange)
        // 日付を切り替える
        dayChange = startVillage(dayChange, charas)

        return dayChange.setIsChange(beforeDayChange)
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
        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.village.participant.memberList.forEach { member ->
            if (recentMessageList.none { message -> message.from!!.id == member.id }) {
                village = village.leaveParticipant(member.id)
                messages = messages.add(createLeaveMessage(member, charas, dayChange.village.day.latestDay()))
            }
        }
        return dayChange.copy(
            village = village,
            messages = messages
        )
    }

    private fun createLeaveMessage(participant: VillageParticipant, charas: Charas, day: VillageDay): Message {
        val chara = charas.list.find { it.id == participant.charaId }!!
        val message = "${chara.charaName.name}は村を去った。"
        return DayChange.createPublicSystemMessage(message, day.day)
    }

    // 日付を進める必要があるか
    private fun shouldForward(village: Village): Boolean =
        !Wolf4busyDateUtil.currentLocalDateTime().isBefore(village.day.latestDay().dayChangeDatetime)

    // 参加者数が不足している場合に廃村にする
    private fun cancelVillage(dayChange: DayChange): DayChange {
        return dayChange.copy(
            village = dayChange.village.changeStatus(CDef.VillageStatus.廃村),
            messages = dayChange.messages.add(
                DayChange.createPublicSystemMessage(
                    "人数が不足しているため廃村しました。",
                    dayChange.village.day.latestDay().day
                )
            )
        )
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min

    private fun startVillage(dayChange: DayChange, charas: Charas): DayChange {
        // 新しい日付追加
        var village = dayChange.village.addNewDay()
        // 開始メッセージ追加
        var messages = dayChange.messages.add(createProgressStartMessage(dayChange.village.day.latestDay().day))
        // 役職割り当て
        village = village.assignSkill()
        // ステータス変更
        village = village.changeStatus(CDef.VillageStatus.進行中)
        // デフォルト能力行使指定
        var abilities = dayChange.abilities.addDefaultAbilities(village)
        // ダミーキャラ発言
        createDummyCharaFirstDayMessage(village, charas)?.let { messages = messages.add(it) }

        return dayChange.copy(
            village = village,
            messages = messages,
            abilities = abilities
        )
    }

    private fun createDummyCharaFirstDayMessage(village: Village, charas: Charas): Message? {
        val firstDayMessage = charas.list.find { it.id == village.dummyChara().id }!!.defaultMessage.firstDayMessage ?: return null
        return DayChange.createNormalSayMessage(
            text = firstDayMessage,
            day = village.day.latestDay().day,
            participant = village.dummyChara()
        )
    }

    private fun createProgressStartMessage(day: Int): Message {
        return DayChange.createPublicSystemMessage(
            text = "さあ、自らの姿を鏡に映してみよう。\nそこに映るのはただの村人か、それとも血に飢えた人狼か。\n\n例え人狼でも、多人数で立ち向かえば怖くはない。\n問題は、だれが人狼なのかという事だ。\n占い師の能力を持つ人間ならば、それを見破れるだろう。",
            day = day
        )
    }
}