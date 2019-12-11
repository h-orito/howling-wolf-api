package com.ort.wolf4busy.application.coordinator

import com.ort.wolf4busy.application.service.*
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.message.Message
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.ability.VillageAbilities
import com.ort.wolf4busy.domain.model.village.action.VillageActionSituation
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVotes
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.stereotype.Service

/**
 * 自身の村参加状況、取れるアクションを取得するためのロジックを集約
 */
@Service
class ParticipateSituationCoordinator(
    val villageService: VillageService,
    val playerService: PlayerService,
    val charachipService: CharachipService,
    val messageService: MessageService,
    val abilityService: AbilityService,
    val voteService: VoteService
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
        val charas: Charas = charachipService.findCharaList(village.setting.charachip.charachipId)
        val skillRequest: SkillRequest? = villageService.findSkillRequest(participant)
        val abilities: VillageAbilities = abilityService.findVillageAbilities(villageId)
        val votes: VillageVotes = voteService.findVillageVotes(villageId)
        val commit: Commit? = villageService.findCommit(village, participant)
        val latestDayMessageList: List<Message> =
            messageService.findParticipateDayMessageList(villageId, village.day.latestDay(), participant)


        return VillageActionSituation(
            village,
            participant,
            user,
            isParticipatingProgressVillage,
            isRestrictedParticipatePlayer,
            charas,
            skillRequest,
            abilities,
            votes,
            commit,
            latestDayMessageList
        )
    }
}
