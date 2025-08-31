package com.ort.howlingwolf.domain.service.participate

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.myself.participant.VillageParticipateSituation
import com.ort.howlingwolf.domain.model.player.Player
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.springframework.stereotype.Service

@Service
class ParticipateDomainService {

    fun convertToSituation(
        village: Village,
        participant: VillageParticipant?,
        player: Player?,
        charas: Charas
    ): VillageParticipateSituation {
        return VillageParticipateSituation(
            isParticipating = participant != null,
            isAvailableParticipate = isAvailableParticipate(player, village),
            isAvailableSpectate = isAvailableSpectate(player, village, charas.list.size),
            selectableCharaList = getSelectableCharaList(village, charas),
            isAvailableLeave = isAvailableLeave(village, participant),
            myself = participant
        )
    }

    /**
     * 参加チェック
     * @param player player
     * @param village village
     * @param charaId charaId
     * @param firstRequestSkill 第1役職希望
     * @param secondRequestSkill 第2役職希望
     * @param password 入村パスワード
     */
    fun assertParticipate(
        player: Player?,
        village: Village,
        charaId: Int,
        firstRequestSkill: CDef.Skill,
        secondRequestSkill: CDef.Skill,
        password: String?
    ) {
        // 参加できない状況ならNG
        if (!isAvailableParticipate(player, village)) throw HowlingWolfBusinessException("参加できません")
        // 誰かに招待されていないとNG
        // いったん招待制を廃止
//        if (player!!.introducedPlayerIds.isEmpty()) throw HowlingWolfBusinessException("参加できません")
        // 既にそのキャラが参加していたりパスワードを間違えていたらNG
        village.assertParticipate(charaId, password)
        // 役職希望無効の場合はおまかせのみ
        if (!village.setting.rules.isValidSkillRequest(
                firstRequestSkill,
                secondRequestSkill
            )
        ) throw HowlingWolfBusinessException("希望役職が不正です")
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
        if (!isAvailableSpectate(
                player,
                village,
                charachipCharaNum
            )
        ) throw HowlingWolfBusinessException("見学できません")
        // 誰かに招待されていないとNG
        if (player!!.introducedPlayerIds.isEmpty()) throw HowlingWolfBusinessException("見学できません")
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
            "（見学）${number}人目、${chara.charaName.fullName()}。"
        } else {
            "${number}人目、${chara.charaName.fullName()}。"
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

    /**
     * @param village village
     * @param participant 参加者
     * @return 退村可能か
     */
    fun isAvailableLeave(
        village: Village,
        participant: VillageParticipant?
    ): Boolean {
        // 村として退村可能か
        if (!village.isAvailableLeave()) return false
        // 参加していない
        participant ?: return false

        return true
    }

    /**
     * 退村チェック
     * @param village village
     * @param participant 参加者
     */
    fun assertLeave(
        village: Village,
        participant: VillageParticipant?
    ) {
        if (!isAvailableLeave(village, participant)) throw HowlingWolfBusinessException("退村できません")
    }


    /**
     * 退村メッセージ
     * @param village village
     * @param chara chara
     * @return 退村時のメッセージ e.g. {キャラ名}は村を去った。
     */
    fun createLeaveMessage(village: Village, chara: Chara): Message =
        Message.createPublicSystemMessage(createLeaveMessageString(chara), village.day.latestDay().id)


    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    /**
     * @param player player
     * @return 参加可能な状況か
     */
    private fun isAvailableParticipate(
        player: Player?,
        village: Village
    ): Boolean {
        // プレイヤーとして参加可能か
        player ?: return false
        if (!player.isAvailableParticipate()) return false
        // 村として参加可能か
        if (!village.isAvailableParticipate()) return false
        // 複合条件：初心者村かつ1戦以上経験ありかつ1回目の更新時間を迎えていない場合NG
        if (village.setting.rules.forBeginner
            && player.participateFinishedVillageIdList.isNotEmpty()
            && village.setting.time.prologueStartDatetime.plusDays(1L)
                .isAfter(HowlingWolfDateUtil.currentLocalDateTime())
        ) {
            return false
        }
        // 複合条件：誰かにblacklist登録されている
        if (village.blacklistPlayers.list.any { it == player.id }) return false

        return true
    }

    /**
     * @param player player
     * @param charachipCharaNum 使用するキャラチップのキャラ数
     * @return 見学可能な状況か
     */
    private fun isAvailableSpectate(
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

    private fun createLeaveMessageString(chara: Chara): String =
        "${chara.charaName.fullName()}は村を去った。"
}