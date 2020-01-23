package com.ort.wolf4busy.application.service

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.myself.participant.VillageSkillRequestSituation
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.skill.SkillRequest
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service

@Service
class VillageService(
    val villageDataSource: VillageDataSource
) {

    /**
     * 村一覧取得
     * @param user 入力した場合、参加している村一覧
     * @return Villages
     */
    fun findVillages(user: Wolf4busyUser? = null): Villages = villageDataSource.findVillages(user)

    /**
     * 村一覧取得
     * @param villageIdList 村IDリスト
     * @return Villages
     */
    fun findVillages(villageIdList: List<Int>): Villages = villageDataSource.findVillages(villageIdList)

    /**
     * 村取得
     * @param villageId villageId
     * @return Village
     */
    fun findVillage(villageId: Int, excludeGonePlayer: Boolean = true): Village =
        villageDataSource.findVillage(villageId, excludeGonePlayer)

    /**
     * 村登録
     * @param village village
     * @return villageId
     */
    fun registerVillage(village: Village, password: String?): Village {
        return villageDataSource.registerVillage(village, password)
    }

    /**
     * 村日付を更新完了にする
     * @param villageDayId 村日付ID
     */
    fun updateVillageDayUpdateComplete(villageDayId: Int) = villageDataSource.updateVillageDayUpdateComplete(villageDayId)

    /**
     * 村参加者登録
     * @param villageId villageId
     * @param playerId playerId
     * @param charaId charaId
     * @param message 参加時発言
     * @param firstRequestSkill 役職第1希望
     * @param secondRequestSkill 役職第2希望
     * @param isSpectate 見学か
     * @return 村参加者ID
     */
    fun registerVillageParticipant(
        villageId: Int,
        playerId: Int,
        charaId: Int,
        firstRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        secondRequestSkill: CDef.Skill = CDef.Skill.おまかせ,
        isSpectate: Boolean = false
    ): Int {
        val participant = VillageParticipant(
            id = 1, // dummy
            charaId = charaId,
            playerId = playerId,
            dead = null,
            isSpectator = isSpectate,
            isGone = false,
            skill = null,
            skillRequest = SkillRequest(Skill(firstRequestSkill), Skill(secondRequestSkill)),
            isWin = null
        )
        return villageDataSource.registerVillageParticipant(villageId, participant)
    }

    /**
     * 退村
     * @param participant 村参加者
     */
    fun leaveVillage(participant: VillageParticipant) = villageDataSource.updateVillagePlayerLeave(participant)

    /**
     * 差分更新
     *
     * @param before village
     * @param after village
     */
    fun updateVillageDifference(before: Village, after: Village) = villageDataSource.updateDifference(before, after)

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun findSkillRequestSituation(village: Village, participant: VillageParticipant?): VillageSkillRequestSituation {
        return VillageSkillRequestSituation(
            village,
            participant,
            null
        )
    }
}
