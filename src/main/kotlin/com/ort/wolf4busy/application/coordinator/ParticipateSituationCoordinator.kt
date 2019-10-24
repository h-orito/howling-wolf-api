package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.application.service.CharachipService
import com.ort.wolf4busy.application.service.PlayerService
import com.ort.wolf4busy.application.service.VillageService
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.action.VillageActionSituation
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service

/**
 * 自身の村参加状況、取れるアクションを取得するためのロジックを集約
 */
@Service
class ParticipateSituationCoordinator(
    val villageService: VillageService,
    val playerService: PlayerService,
    val charachipService: CharachipService
) {
    /**
     * 参加状況や可能なアクションを取得
     * @param villageId villageId
     * @param user user
     */
    fun findParticipateSituation(villageId: Int, user: Wolf4busyUser?): VillageActionSituation {
        val village: Village = villageService.findVillage(villageId)
        val participant: VillageParticipant? = if (user == null) null else villageService.findParticipantByUid(villageId, user.uid)
        val isParticipatingProgressVillage: Boolean = user != null && villageService.isParticipatingAnyProgressVillage(user.uid)
        val isRestrictedParticipatePlayer: Boolean = user != null && playerService.isRestrictedParticipatePlayer(user)
        val charachipCharaNum = charachipService.findCharaChip(village.setting.charachip.charachipId).charaList.size
        val skillRequest: SkillRequest? = villageService.findSkillRequest(participant)
        val commit: Commit? = villageService.findCommit(village, participant)

        return VillageActionSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charachipCharaNum,
            skillRequest,
            commit
        )
    }
}
