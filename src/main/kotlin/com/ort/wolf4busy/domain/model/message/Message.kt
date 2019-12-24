package com.ort.wolf4busy.domain.model.message

import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

data class Message(
    val from: VillageParticipant?,
    val to: VillageParticipant?,
    val time: MessageTime,
    val content: MessageContent
) {

    companion object {

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


    }

}