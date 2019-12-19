package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes

data class DayChange(
    // 何かしらの変更があったか
    val isChange: Boolean,
    // 更新後のdomain model
    val village: Village,
    val messages: Messages,
    val votes: VillageVotes,
    val abilities: VillageAbilities
) {

    companion object {
        operator fun invoke(
            village: Village,
            votes: VillageVotes,
            abilities: VillageAbilities,
            commits: Commits,
            todayMessages: Messages,
            charas: Charas
        ): DayChange {
            return if (village.status.isPrologue()) { // プロローグ
                Prologue.dayChange(village, todayMessages, charas)
            } else if (village.status.isProgress() && village.day.latestDay().day == 1) { // 進行中で1日目
                DayChange(
                    isChange = false,
                    village = village,
                    messages = Messages(listOf()),
                    votes = votes,
                    abilities = abilities
                )
            } else if (village.status.isProgress()) { // 進行中で2日目以降
                DayChange(
                    isChange = false,
                    village = village,
                    messages = Messages(listOf()),
                    votes = votes,
                    abilities = abilities
                )
            } else if (village.status.code == CDef.VillageStatus.エピローグ.code()) {
                DayChange(
                    isChange = false,
                    village = village,
                    messages = Messages(listOf()),
                    votes = votes,
                    abilities = abilities
                )
            } else {
                DayChange(
                    isChange = false,
                    village = village,
                    messages = Messages(listOf()),
                    votes = votes,
                    abilities = abilities
                )
            }
        }

        /**
         * 更新時登録用の公開メッセージ
         *
         * @param text メッセージ内容
         * @param day 何日目か
         */
        fun createOpenSystemMessage(text: String, day: Int): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.通常発言),
                    text = text
                )
            )
        }
    }
}