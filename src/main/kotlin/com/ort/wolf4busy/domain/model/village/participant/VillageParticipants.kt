package com.ort.wolf4busy.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.VillageDay

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

    // 勝敗設定
    fun winLose(cdefWinCamp: CDef.Camp): VillageParticipants = this.copy(memberList = this.memberList.map { it.winLose(cdefWinCamp) })

    fun filterAlive(): VillageParticipants {
        val aliveMembers = memberList.filter { it.isAlive() }
        return VillageParticipants(
            count = aliveMembers.size,
            memberList = aliveMembers
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