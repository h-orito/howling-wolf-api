package com.ort.howlingwolf.domain.model.village.participant

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

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
        if (!isAvailableParticipate(player, village)) throw HowlingWolfBusinessException("参加できません")
        // 既にそのキャラが参加していたりパスワードを間違えていたらNG
        village.assertParticipate(charaId, password)
        // 役職希望無効の場合はおまかせのみ
        if (!isSpectate && !village.setting.rules.isValidSkillRequest(
                firstRequestSkill,
                secondRequestSkill
            )
        ) throw HowlingWolfBusinessException("希望役職が不正です")
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
        charaId: Int,
        charachipCharaNum: Int,
        password: String?
    ) {
        if (!isAvailableSpectate(player, village, charachipCharaNum)) throw HowlingWolfBusinessException("見学できません")
        // 既にそのキャラが参加していたりパスワードを間違えていたらNG
        village.assertParticipate(charaId, password)
    }

    /**
     * 参加メッセージ
     * @param village village
     * @param chara chara
     * @param isSpectate 見学か
     * @return 参加時のメッセージ e.g. {N}人目、{キャラ名}。
     */
    fun createParticipateMessage(village: Village, chara: Chara, isSpectate: Boolean): Message {
        // 何人目か
        val number = if (isSpectate) {
            village.spectator.count
        } else {
            village.participant.count
        }
        val text = if (isSpectate) {
            "（見学）${number}人目、${chara.charaName.name}。"
        } else {
            "${number}人目、${chara.charaName.name}。"
        }
        return Message.createPublicSystemMessage(text, village.day.prologueDay().id)
    }

    /**
     * @param village village
     * @param charas charas
     * @return 参加/見学できるキャラ
     */
    fun getSelectableCharaList(village: Village, charas: Charas): List<Chara> {
        return charas.list.filterNot { chara ->
            village.participant.memberList.any { it.charaId == chara.id }
                || village.spectator.memberList.any { it.charaId == chara.id }
        }
    }
}