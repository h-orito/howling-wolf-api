package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commits
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.message.Messages
import com.ort.wolf4busy.domain.model.player.Players
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes

data class DayChange(
    // 何かしらの変更があったか
    val isChange: Boolean,
    // 更新後のdomain model
    val village: Village,
    val messages: Messages,
    val votes: VillageVotes,
    val abilities: VillageAbilities,
    val players: Players
) {
    companion object {
        operator fun invoke(
            village: Village,
            votes: VillageVotes,
            abilities: VillageAbilities,
            commits: Commits,
            todayMessages: Messages,
            charas: Charas,
            players: Players
        ): DayChange {
            return when {
                // プロローグ
                village.status.isPrologue() -> Prologue.dayChange(village, todayMessages, charas, players)
                // 進行中
                village.status.isProgress() -> Progress.dayChange(village, votes, abilities, commits, todayMessages, charas, players)
                // エピローグ
                village.status.code == CDef.VillageStatus.エピローグ.code() -> {
                    DayChange(
                        isChange = false,
                        village = village,
                        messages = Messages(listOf()),
                        votes = votes,
                        abilities = abilities,
                        players = players
                    )
                }
                // 終了後
                else -> {
                    DayChange(
                        isChange = false,
                        village = village,
                        messages = Messages(listOf()),
                        votes = votes,
                        abilities = abilities,
                        players = players
                    )
                }
            }
        }

        /**
         * 更新時登録用の公開メッセージ
         *
         * @param text メッセージ内容
         * @param day 何日目か
         */
        fun createPublicSystemMessage(text: String, day: Int): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.公開システムメッセージ),
                    text = text
                )
            )
        }

        /**
         * 更新時登録用の非公開メッセージ
         *
         * @param text メッセージ内容
         * @param day 何日目か
         */
        fun createPrivateSystemMessage(text: String, day: Int): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.非公開システムメッセージ),
                    text = text
                )
            )
        }

        fun createNormalSayMessage(text: String, day: Int, participant: VillageParticipant): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                from = participant,
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.通常発言),
                    text = text
                )
            )
        }

        fun createSeerPrivateMessage(text: String, day: Int, participant: VillageParticipant): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                from = participant,
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.白黒占い結果),
                    text = text
                )
            )
        }

        fun createPsychicPrivateMessage(text: String, day: Int): Message {
            val dummy = Message.createDummy()
            return dummy.copy(
                time = dummy.time.copy(
                    day = day
                ),
                content = dummy.content.copy(
                    type = MessageType(CDef.MessageType.白黒霊視結果),
                    text = text
                )
            )
        }
    }

    fun setIsChange(beforeDayChange: DayChange): DayChange {
        return this.copy(isChange = existsDifference(beforeDayChange))

    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun existsDifference(beforeDayChange: DayChange): Boolean {
        // village
        if (village.existsDifference(beforeDayChange.village)) return true
        // message
        if (messages.existsDifference(beforeDayChange.messages)) return true
        // votes
        if (votes.existsDifference(beforeDayChange.votes)) return true
        // abilities
        return abilities.existsDifference(beforeDayChange.abilities)
    }
}