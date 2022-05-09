package com.ort.howlingwolf.domain.service.admin

import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.myself.participant.VillageAdminSituation
import com.ort.howlingwolf.domain.model.myself.participant.VillageParticipantSituation
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.springframework.stereotype.Service

@Service
class AdminDomainService {

    fun convertToSituation(
        village: Village,
        myself: VillageParticipant?,
        players: Players,
        charas: Charas
    ): VillageAdminSituation {
        if (myself?.playerId != 1) return VillageAdminSituation(
            admin = false,
            availableKick = false,
            participantList = listOf()
        )
        return VillageAdminSituation(
            admin = true,
            availableKick = isAvailableKick(village, myself),
            participantList = village.participant.memberList.map { participant ->
                VillageParticipantSituation(
                    name = charas.chara(participant.charaId).charaName.fullName(),
                    nickname = players.list.find { it.id == participant.playerId }!!.nickname,
                    twitterUserName = players.list.find { it.id == participant.playerId }!!.twitterUserName,
                    skillName = participant.skill?.name
                )
            }
        )
    }

    private fun isAvailableKick(village: Village, myself: VillageParticipant): Boolean {
        return village.status.isPrologue() && myself.isAdmin()
    }
}