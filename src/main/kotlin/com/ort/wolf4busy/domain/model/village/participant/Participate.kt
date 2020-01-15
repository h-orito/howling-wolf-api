package com.ort.wolf4busy.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.player.Player
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException

object Participate {

    /**
     * @param player player
     * @return 参加可能な状況か
     */
    fun isAvailableParticipate(
        player: Player?,
        village: Village
    ): Boolean {
        // プレイヤーとして参加可能か
        player ?: return false
        if (!player.isAvailableParticipate()) return false
        // 村として参加可能か
        return village.isAvailableParticipate()
    }

    /**
     * 参加チェック
     * @param player player
     * @param village village
     * @param charaId charaId
     * @param firstRequestSkill 第1役職希望
     * @param secondRequestSkill 第2役職希望
     * @param isSpectate 見学か
     * @param password 入村パスワード
     */
    fun assertParticipate(
        player: Player?,
        village: Village,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        isSpectate: Boolean,
        password: String?
    ) {
        // 参加できない状況ならNG
        if (!isAvailableParticipate(player, village)) throw Wolf4busyBusinessException("参加できません")
        // 既にそのキャラが参加していたりパスワードを間違えていたらNG
        village.assertParticipate(charaId, password)
        // 役職希望無効の場合はおまかせのみ
        if (!isSpectate && !village.setting.rules.isValidSkillRequest(
                firstRequestSkill,
                secondRequestSkill
            )
        ) throw Wolf4busyBusinessException("希望役職が不正です")
    }

    /**
     * @param player player
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     * @return 見学可能な状況か
     */
    fun isAvailableSpectate(
        player: Player?,
        village: Village,
        charachipCharaNum: Int
    ): Boolean {
        // プレイヤーとして参加可能か
        player ?: return false
        if (!player.isAvailableParticipate()) return false
        // 村として見学可能か
        return village.isAvailableSpectate(charachipCharaNum)
    }

    /**
     * 見学チェック
     * @param player player
     * @param village village
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     */
    fun assertSpectate(
        player: Player?,
        village: Village,
        charachipCharaNum: Int
    ) {
        if (!isAvailableSpectate(player, village, charachipCharaNum)) throw Wolf4busyBusinessException("見学できません")
    }
}