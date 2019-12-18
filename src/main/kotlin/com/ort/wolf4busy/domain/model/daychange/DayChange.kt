package com.ort.wolf4busy.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.message.MessageContent
import com.ort.wolf4busy.domain.model.message.MessageTime
import com.ort.wolf4busy.domain.model.message.MessageType
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

object DayChange {

    /**
     * 更新時登録用の公開メッセージ
     *
     * @param text メッセージ内容
     */
    fun createOpenSystemMessage(text: String, day: Int): Message {
        return Message(
            from = VillageParticipant(
                id = 1, // dummy
                charaId = 1, // dummy
                playerId = null, // dummy
                dead = null, // dummy
                isSpectator = false, // dummy
                isGone = false, // dummy
                skill = null, // dummy
                skillRequest = SkillRequest(
                    first = Skill(
                        code = "", // dummy
                        name = "" // dummy
                    ),
                    second = Skill(
                        code = "", // dummy
                        name = "" // dummy
                    )
                )
            ), // dummy
            to = null, // dummy
            time = MessageTime(
                day = day,
                datetime = Wolf4busyDateUtil.currentLocalDateTime(), // dummy
                unixTimeMilli = 1L // dummy
            ),
            content = MessageContent(
                type = MessageType(
                    code = CDef.MessageType.公開システムメッセージ.code(),
                    name = CDef.MessageType.公開システムメッセージ.alias()
                ),
                num = 1, // dummy
                text = text,
                faceCode = "dummy"
            )
        )
    }

}