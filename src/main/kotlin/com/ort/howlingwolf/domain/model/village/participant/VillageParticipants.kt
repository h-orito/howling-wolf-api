package com.ort.howlingwolf.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.skill.SkillRequest
import com.ort.howlingwolf.domain.model.village.VillageDay
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts

data class VillageParticipants(
    val count: Int, // 退村した人は含まない
    val memberList: List<VillageParticipant> = listOf()
) {
    fun assignSkill(villageParticipantId: Int, skill: Skill): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == villageParticipantId) it.assignSkill(skill)
                else it.copy()
            }
        )
    }

    fun addParticipant(
        charaId: Int,
        playerId: Int,
        skillRequest: SkillRequest,
        isSpectator: Boolean
    ): VillageParticipants {
        return this.copy(
            count = count + 1,
            memberList = memberList + VillageParticipant(
                id = -1, // dummy
                charaId = charaId,
                playerId = playerId,
                dead = null,
                isSpectator = isSpectator,
                isGone = false,
                skill = null,
                skillRequest = skillRequest,
                isWin = null,
                comingOuts = ComingOuts()
            )
        )
    }

    fun changeSkillRequest(participantId: Int, first: CDef.Skill, second: CDef.Skill): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.changeSkillRequest(first, second)
                else it.copy()
            }
        )
    }

    // 退村
    fun leave(participantId: Int): VillageParticipants {
        return this.copy(
            count = this.count - 1,
            memberList = this.memberList.map {
                if (it.id == participantId) it.gone() else it.copy()
            }
        )
    }

    // 突然死
    fun suddenlyDeath(participantId: Int, villageDay: VillageDay): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.suddenlyDeath(villageDay) else it.copy()
            }
        )
    }

    // 処刑
    fun execute(participantId: Int, villageDay: VillageDay): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.execute(villageDay) else it.copy()
            }
        )
    }

    // 襲撃
    fun attack(participantId: Int, villageDay: VillageDay): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.attack(villageDay) else it.copy()
            }
        )
    }

    // 呪殺
    fun divineKill(participantId: Int, villageDay: VillageDay): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.divineKill(villageDay) else it.copy()
            }
        )
    }

    // 後追い
    fun suicide(participantId: Int, villageDay: VillageDay): VillageParticipants {
        return this.copy(
            memberList = this.memberList.map {
                if (it.id == participantId) it.suicide(villageDay) else it.copy()
            }
        )
    }

    // 勝敗設定
    fun winLose(winCamo: Camp): VillageParticipants =
        this.copy(memberList = this.memberList.map { it.winLose(winCamo) })

    fun member(id: Int): VillageParticipant = memberList.first { it.id == id }

    fun filterAlive(): VillageParticipants {
        val aliveMembers = memberList.filter { it.isAlive() }
        return VillageParticipants(
            count = aliveMembers.size,
            memberList = aliveMembers
        )
    }

    fun filterBySkill(skill: Skill): VillageParticipants {
        val list = memberList.filter { it.skill?.code == skill.code }
        return copy(
            count = list.size,
            memberList = list
        )
    }

    fun findRandom(predicate: (VillageParticipant) -> Boolean): VillageParticipant? {
        return memberList.filter { predicate(it) }.shuffled().firstOrNull()
    }

    fun existsDifference(participant: VillageParticipants): Boolean {
        if (count != participant.count) return true
        if (memberList.size != participant.memberList.size) return true
        return memberList.any { member1 ->
            participant.memberList.none { member2 -> !member1.existsDifference(member2) }
        }
    }
}