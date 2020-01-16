package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.VillageDay
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

data class Message(
    val from: VillageParticipant?,
    val to: VillageParticipant?,
    val time: MessageTime,
    val content: MessageContent
) {

    companion object {

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
        fun createPublicSystemMessage(text: String, villageDay: VillageDay): Message =
            createSystemMessage(MessageType(CDef.MessageType.公開システムメッセージ), text, villageDay)

        fun createPrivateSystemMessage(text: String, villageDay: VillageDay): Message =
            createSystemMessage(MessageType(CDef.MessageType.非公開システムメッセージ), text, villageDay)

        fun createSeerPrivateMessage(text: String, villageDay: VillageDay, participant: VillageParticipant): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒占い結果), text, villageDay, participant)

        fun createPsychicPrivateMessage(text: String, villageDay: VillageDay): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒霊視結果), text, villageDay)

        fun createAttackPrivateMessage(text: String, villageDay: VillageDay): Message =
            createSystemMessage(MessageType(CDef.MessageType.襲撃結果), text, villageDay)

        fun createParticipantsMessage(villageDay: VillageDay): Message =
            createSystemMessage(MessageType(CDef.MessageType.襲撃結果), "読み込み中...", villageDay)


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
            villageDay: VillageDay,
            from: VillageParticipant? = null
        ): Message = Message(
            from = from,
            to = null,
            time = MessageTime(
                villageDayId = villageDay.id,
                day = villageDay.day,
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