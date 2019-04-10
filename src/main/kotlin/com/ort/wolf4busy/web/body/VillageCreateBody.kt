package com.ort.wolf4busy.web.body

import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class VillageCreateBody(

    // ===================================================================================
    //                                                                                 基本
    //                                                                           =========
    /** 村表示名  */
    @field:Length(min = 5, max = 40)
    @field:NotNull
    val villageName: String?,

    /** 最低開始人数  */
    @field:Min(5)
    @field:NotNull
    val personMinNum: Int?,

    /** 定員  */
    @field:Max(20)
    @field:NotNull
    val personMaxNum: Int?,

    /** 更新間隔秒  */
    @Min(0)
    @Max(172800)
    @field:NotNull
    val dayChangeIntervalSeconds: Int?,

    /** 開始年月日 */
    @field:NotNull
    val startDatetime: LocalDateTime?,

    /** 記名投票か  */
    @field:NotNull
    var isOpenVote: Boolean?,

    /** 役職希望有効か  */
    @field:NotNull
    val isPossibleSkillRequest: Boolean?,

    /** 連続襲撃ありか  */
    @field:NotNull
    val isAvailableSameWolfAttack: Boolean?,

    /** 墓下役職公開ありか  */
    @field:NotNull
    val isOpenSkillInGrave: Boolean?,

    /** 墓下見学発言を地上から見られるか  */
    @field:NotNull
    val isVisibleGraveSpectateMessage: Boolean?,

    /** キャラセットID  */
    @field:NotNull
    val characterSetId: Int?,

    /** ダミーキャラID  */
    val dummyCharaId: Int?,

    /** ダミーキャラ入村発言  */
    @Length(min = 1, max = 400)
    @field:NotNull
    val dummyJoinMessage: String?,

    /** 入村パスワード  */
    val joinPassword: String?,

    /** 観戦を可能にするか  */
    @field:NotNull
    val isAvailableSpectate: Boolean?,

    /** 突然死ありか  */
    @field:NotNull
    val isAvailableSuddonlyDeath: Boolean?,

    /** コミット可能か  */
    @field:NotNull
    val isAvailableCommit: Boolean?,

    /** 連続ガードありか  */
    @field:NotNull
    val isAvailableGuardSameTarget: Boolean?,

    /** 構成  */
    @field:NotNull
    val organization: String?,

    /** 秘話可能範囲  */
    @field:NotNull
    val allowedSecretSayCode: String?,

    /** 発言制限  */
    @field:NotNull
    val sayRestrictList: List<VillageSayRestrictDto>?

) {

    inner class VillageSayRestrictDto(
        val skillName: String?,
        val skillCode: String?,
        val detailList: List<VillageSayRestrictDetailDto>?
    ) {
        inner class VillageSayRestrictDetailDto(
            val messageTypeName: String?,
            val messageTypeCode: String?,
            val isRestrict: Boolean?,
            val count: Int?
        ) {
        }
    }
}