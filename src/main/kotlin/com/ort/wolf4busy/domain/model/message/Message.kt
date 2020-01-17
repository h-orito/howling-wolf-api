package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.ability.Ability
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.Leave
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

data class Message(
    val from: VillageParticipant?,
    val to: VillageParticipant?,
    val time: MessageTime,
    val content: MessageContent
) {

    companion object {

        /** 村作成時のメッセージ */
        fun createVillagePrologueMessage(villageDayId: Int): Message =
            createPublicSystemMessage(Village.getInitialMessage(), villageDayId)

        /**
         * @param village village
         * @param chara chara
         * @param isSpectate 見学か
         * @return 参加時のメッセージ e.g. {N}人目、{キャラ名}。
         */
        fun createParticipateMessage(village: Village, chara: Chara, isSpectate: Boolean): Message {
            // 何人目か
            val number = if (isSpectate) {
                village.spectator.count + 1
            } else {
                village.participant.count + 1
            }
            val text = if (isSpectate) {
                "（見学）${number}人目、${chara.charaName.name}。"
            } else {
                "${number}人目、${chara.charaName.name}。"
            }
            return createPublicSystemMessage(text, village.day.prologueDay().id)
        }

        /**
         * @param chara chara
         * @param villageDayId 村日付ID
         * @return 退村時のメッセージ e.g. {キャラ名}は村を去った。
         */
        fun createLeaveMessage(chara: Chara, villageDayId: Int): Message =
            createPublicSystemMessage(Leave.getLeaveMessage(chara), villageDayId)

        /**
         * @param village village
         * @param myChara セットするキャラ
         * @param targetChara セットされるキャラ
         * @param ability ability
         * @return 能力セット時のメッセージ e.g. "{キャラ名}が襲撃対象を{キャラ名}に設定しました。"
         */
        fun createAbilitySetMessage(
            village: Village,
            myChara: Chara,
            targetChara: Chara?,
            ability: Ability
        ): Message {
            val text = ability.getAbilitySetMessage(myChara, targetChara)
            return createPrivateSystemMessage(text, village.day.latestDay().id)
        }

        /**
         * @param chara chara
         * @param doCommit コミット/取り消し
         * @param villageDayId 村日付ID
         * @return コミット時のメッセージ e.g. "{キャラ名}がコミットしました。"
         */
        fun createCommitMessage(chara: Chara, doCommit: Boolean, villageDayId: Int): Message =
            createPrivateSystemMessage(Commit.getCommitSetMessage(doCommit, chara), villageDayId)

        fun createSayMessage(
            from: VillageParticipant,
            villageDayId: Int,
            messageContent: MessageContent,
            to: VillageParticipant? = null
        ): Message = Message(
            from = from,
            to = to,
            time = MessageTime(
                villageDayId = villageDayId,
                day = 0, // dummy
                datetime = Wolf4busyDateUtil.currentLocalDateTime(), // dummy
                unixTimeMilli = 0L // dummy
            ),
            content = messageContent
        )

        // 登録用
        fun createPublicSystemMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.公開システムメッセージ), text, villageDayId)

        fun createPrivateSystemMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.非公開システムメッセージ), text, villageDayId)

        fun createSeerPrivateMessage(text: String, villageDayId: Int, participant: VillageParticipant): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒占い結果), text, villageDayId, participant)

        fun createPsychicPrivateMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒霊視結果), text, villageDayId)

        fun createAttackPrivateMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.襲撃結果), text, villageDayId)

        fun createParticipantsMessage(villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.襲撃結果), "読み込み中...", villageDayId)


        // 目的をはっきりさせるためコンストラクタにはしない
        fun createDummy(): Message {
            return Message(
                from = VillageParticipant(
                    id = 1,
                    charaId = 1,
                    playerId = null,
                    dead = null,
                    isSpectator = false,
                    isGone = false,
                    skill = null,
                    skillRequest = SkillRequest(
                        first = Skill(
                            code = "",
                            name = ""
                        ),
                        second = Skill(
                            code = "",
                            name = ""
                        )
                    ),
                    isWin = null
                ),
                to = null,
                time = MessageTime(
                    villageDayId = 1,
                    day = 1,
                    datetime = Wolf4busyDateUtil.currentLocalDateTime(),
                    unixTimeMilli = 1L
                ),
                content = MessageContent(
                    type = MessageType(
                        code = "",
                        name = ""
                    ),
                    num = 1,
                    text = "dummy",
                    faceCode = "dummy"
                )
            )
        }

        // ===================================================================================
        //                                                                        Assist Logic
        //                                                                        ============
        private fun createSystemMessage(
            messageType: MessageType,
            text: String,
            villageDayId: Int,
            from: VillageParticipant? = null
        ): Message = Message(
            from = from,
            to = null,
            time = MessageTime(
                villageDayId = villageDayId,
                day = 0, // dummy
                datetime = Wolf4busyDateUtil.currentLocalDateTime(), // dummy
                unixTimeMilli = 0L // dummy
            ),
            content = MessageContent(
                type = messageType,
                num = 0, // dummy
                text = text,
                faceCode = null
            )
        )
    }
}