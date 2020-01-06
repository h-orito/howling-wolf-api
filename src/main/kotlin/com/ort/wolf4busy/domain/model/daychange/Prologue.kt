package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
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
            if (recentMessageList.none { message -> message.from!!.id == member.id }) {
                village = village.leaveParticipant(member.id)
                messages = messages.add(createLeaveMessage(member, charas, dayChange.village.day.latestDay()))
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
        var messages = dayChange.messages.add(createProgressStartMessage(dayChange.village.day.latestDay()))
        // 役職割り当て
        var village = dayChange.village.assignSkill()
        // 役職構成メッセージ追加
        messages = messages.add(createOrganizationMessage(village))
        // ステータス変更
        village = village.changeStatus(CDef.VillageStatus.進行中)
        // デフォルト能力行使指定
        val abilities = dayChange.abilities.addDefaultAbilities(village)
        // ダミーキャラ発言
        createDummyCharaFirstDayMessage(village, charas)?.let { messages = messages.add(it) }

        return dayChange.copy(
            village = village,
            messages = messages,
            abilities = abilities
        ).setIsChange(dayChange)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun createLeaveMessage(participant: VillageParticipant, charas: Charas, day: VillageDay): Message {
        val chara = charas.list.first { it.id == participant.charaId }
        val message = "${chara.charaName.name}は村を去った。"
        return DayChange.createPublicSystemMessage(message, day)
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
                    dayChange.village.day.latestDay()
                )
            )
        )
    }

    private fun isNotEnoughMemberCount(village: Village) =
        village.participant.memberList.count { !it.isGone } < village.setting.capacity.min

    private fun createDummyCharaFirstDayMessage(village: Village, charas: Charas): Message? {
        val firstDayMessage = charas.list.first { it.id == village.dummyChara().id }.defaultMessage.firstDayMessage ?: return null
        return DayChange.createNormalSayMessage(
            text = firstDayMessage,
            day = village.day.latestDay(),
            participant = village.dummyChara()
        )
    }

    private fun createProgressStartMessage(day: VillageDay): Message {
        return DayChange.createPublicSystemMessage(
            text = "さあ、自らの姿を鏡に映してみよう。\nそこに映るのはただの村人か、それとも血に飢えた人狼か。\n\n例え人狼でも、多人数で立ち向かえば怖くはない。\n問題は、だれが人狼なのかという事だ。\n占い師の能力を持つ人間ならば、それを見破れるだろう。",
            day = day
        )
    }

    private fun createOrganizationMessage(village: Village): Message {
        val skillCountMap = village.setting.organizations.mapToSkillCount(village.participant.count)
        val text = CDef.Skill.listAll().sortedBy { Integer.parseInt(it.order()) }.mapNotNull { cdefSkill ->
            val skill = Skill(cdefSkill)
            val count = skillCountMap[skill]
            if (count == null || count == 0) null else "${skill.name}が${count}人"
        }.joinToString(
            separator = "、\n",
            prefix = "この村には\n",
            postfix = "いるようだ。"
        )
        return DayChange.createPublicSystemMessage(text, village.day.latestDay())
    }
}