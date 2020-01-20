package com.ort.wolf4busy.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.domain.model.camp.Camp
import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.domain.model.commit.Commit
import com.ort.wolf4busy.domain.model.skill.Skill
import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.vote.VillageVote
import com.ort.wolf4busy.fw.Wolf4busyDateUtil

data class Message(
    val fromVillageParticipantId: Int?,
    val toVillageParticipantId: Int?,
    val time: MessageTime,
    val content: MessageContent
) {

    companion object {

        /**
         * コミットメッセージ
         * @param chara chara
         * @param doCommit コミット/取り消し
         * @param villageDayId 村日付ID
         * @return コミット時のメッセージ e.g. "{キャラ名}がコミットしました。"
         */
        fun createCommitMessage(chara: Chara, doCommit: Boolean, villageDayId: Int): Message =
            createPrivateSystemMessage(Commit.getCommitSetMessage(doCommit, chara), villageDayId)

        /**
         * 勝利陣営メッセージ
         * @param cdefWinCamp 勝利した陣営
         * @param villageDayId 村日付ID
         */
        fun createWinCampMessage(cdefWinCamp: CDef.Camp, villageDayId: Int): Message =
            createPublicSystemMessage(Camp.getWinCampMessage(cdefWinCamp), villageDayId)

        /**
         * 投票結果メッセージ
         * @param village village
         * @param charas charas
         * @param votedMap key: 非投票参加者ID, value: 投票
         * @return 投票結果メッセージ
         */
        fun createEachVoteMessage(
            village: Village,
            charas: Charas,
            votedMap: Map<Int, List<VillageVote>>
        ): Message {
            val maxFromCharaNameLength = votedMap.values.flatten().map { vote ->
                charas.chara(village.participant, vote.myselfId).charaName.name.length
            }.max()!!
            val maxToCharaNameLength = votedMap.values.flatten().map { vote ->
                charas.chara(village.participant, vote.targetId).charaName.name.length
            }.max()!!

            val text = votedMap.entries.sortedBy { it.value.size }.reversed().map { entry ->
                // 得票数が多い順
                entry.value.map { vote ->
                    val fromChara = charas.chara(village.participant, vote.myselfId)
                    val toChara = charas.chara(village.participant, vote.targetId)
                    createEachVoteResultString(
                        fromChara,
                        toChara,
                        maxFromCharaNameLength,
                        maxToCharaNameLength,
                        entry.value.size
                    )
                }
            }.flatten().joinToString(
                prefix = "投票結果は以下の通り。\n",
                separator = "\n"
            )

            return if (village.setting.rules.openVote) {
                createPublicSystemMessage(text, village.day.latestDay().id)
            } else {
                createPrivateSystemMessage(text, village.day.latestDay().id)
            }
        }

        /**
         * 処刑メッセージ
         * @param village village
         * @param participantId 処刑される村参加者ID
         * @param votedMap key: 非投票参加者ID, value: 投票
         * @param charas charas
         * @return 処刑メッセージ
         */
        fun createExecuteMessage(
            village: Village,
            participantId: Int,
            votedMap: Map<Int, List<VillageVote>>,
            charas: Charas
        ): Message {
            val executedCharaName = charas.chara(village.participant, participantId).charaName.name
            val message = votedMap.entries.sortedBy { it.value.size }.reversed().joinToString(
                separator = "\n",
                postfix = "\n\n${executedCharaName}は村人達の手により処刑された。"
            ) { entry ->
                val votedCharaName = charas.chara(village.participant, entry.key).charaName.name
                "${votedCharaName}、${entry.value.size}票"
            }
            return createPublicSystemMessage(
                message,
                village.day.latestDay().id
            )
        }

        /**
         * 無惨メッセージ
         * @param village village
         * @param charas 犠牲者キャラ
         * @return 無惨メッセージ
         */
        fun createMiserableDeathMessage(
            village: Village,
            charas: Charas
        ): Message {
            val text = if (charas.list.isEmpty()) {
                "今日は犠牲者がいないようだ。人狼は襲撃に失敗したのだろうか。"
            } else {
                charas.list.shuffled().joinToString(
                    prefix = "次の日の朝、以下の村人が無惨な姿で発見された。\n",
                    separator = "、\n"
                ) { it.charaName.name }
            }
            return createPublicSystemMessage(text, village.day.latestDay().id)
        }

        /**
         * 生存者メッセージ
         * @param village village
         * @param charas charas
         */
        fun createAliveMemberMessage(village: Village, charas: Charas): Message {
            val text = village.participant.filterAlive().memberList.joinToString(
                separator = "\n",
                prefix = "現在の生存者は以下の${village.participant.filterAlive().count}名。\n"
            ) { member ->
                charas.list.first { it.id == member.charaId }.charaName.name
            }
            return createPublicSystemMessage(text, village.day.latestDay().id)
        }

        /**
         * 構成メッセージ
         * @param village village
         */
        fun createOrganizationMessage(village: Village): Message {
            val skillCountMap = village.setting.organizations.mapToSkillCount(village.participant.count)
            val text = CDef.Skill.listAll().sortedBy { Integer.parseInt(it.order()) }.mapNotNull { cdefSkill ->
                val skill = Skill(cdefSkill)
                val count = skillCountMap[skill]
                if (count == null || count == 0) null else "${skill.name}が${count}人"
            }.joinToString(
                separator = "、\n",
                prefix = "この村には\n",
                postfix = "いるようだ。"
            )
            return createPublicSystemMessage(text, village.day.latestDay().id)
        }

        /**
         * ダミーキャラの1日目発言
         * @param village village
         * @param charas charas
         */
        fun createDummyCharaFirstDayMessage(village: Village, charas: Charas): Message? {
            val firstDayMessage = charas.chara(village.dummyChara().charaId).defaultMessage.firstDayMessage ?: return null
            val messageContent = MessageContent.invoke(
                messageType = CDef.MessageType.通常発言.code(),
                text = firstDayMessage,
                faceCode = CDef.FaceType.通常.code()
            )
            return createSayMessage(
                from = village.dummyChara(),
                villageDayId = village.day.latestDay().id,
                messageContent = messageContent
            )
        }

        /**
         * 襲撃メッセージ
         * @param chara 狼
         * @param targetChara 被襲撃者
         * @param villageDayId 村日付ID
         */
        fun createAttackMessage(chara: Chara, targetChara: Chara, villageDayId: Int): Message {
            val text = "${chara.charaName.name}達は、${targetChara.charaName.name}を襲撃した。"
            return createAttackPrivateMessage(text, villageDayId)
        }

        fun createSayMessage(
            from: VillageParticipant,
            villageDayId: Int,
            messageContent: MessageContent,
            to: VillageParticipant? = null
        ): Message = Message(
            fromVillageParticipantId = from.id,
            toVillageParticipantId = to?.id,
            time = MessageTime(
                villageDayId = villageDayId,
                datetime = Wolf4busyDateUtil.currentLocalDateTime(), // dummy
                unixTimeMilli = 0L // dummy
            ),
            content = messageContent
        )

        // 別途情報取得して表示させるので、参加者一覧であることだけわかればok
        fun createParticipantsMessage(villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.参加者一覧), "読み込み中...", villageDayId)

        // ===================================================================================
        //                                                                        Assist Logic
        //                                                                        ============
        private fun createSystemMessage(
            messageType: MessageType,
            text: String,
            villageDayId: Int,
            from: VillageParticipant? = null
        ): Message = Message(
            fromVillageParticipantId = from?.id,
            toVillageParticipantId = null,
            time = MessageTime(
                villageDayId = villageDayId,
                datetime = Wolf4busyDateUtil.currentLocalDateTime(), // dummy
                unixTimeMilli = 0L // dummy
            ),
            content = MessageContent(
                type = messageType,
                num = 0, // dummy
                text = text,
                faceCode = null
            )
        )

        fun createPublicSystemMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.公開システムメッセージ), text, villageDayId)

        fun createPrivateSystemMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.非公開システムメッセージ), text, villageDayId)

        fun createSeerPrivateMessage(text: String, villageDayId: Int, participant: VillageParticipant): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒占い結果), text, villageDayId, participant)

        fun createPsychicPrivateMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.白黒霊視結果), text, villageDayId)

        private fun createAttackPrivateMessage(text: String, villageDayId: Int): Message =
            createSystemMessage(MessageType(CDef.MessageType.襲撃結果), text, villageDayId)

        /**
         * @param fromChara 投票したキャラ
         * @param toChara 投票されたキャラ
         * @param maxFromCharaNameLength 投票したキャラの最大文字数
         * @param maxToCharaNameLength 投票されたキャラの最大文字数
         * @param count 得票数
         * @return {キャラ名} -> {キャラ名}（{N}票）
         */
        private fun createEachVoteResultString(
            fromChara: Chara,
            toChara: Chara,
            maxFromCharaNameLength: Int,
            maxToCharaNameLength: Int,
            count: Int
        ): String {
            return fromChara.charaName.name.padEnd(
                length = maxFromCharaNameLength,
                padChar = '　'
            ) +
                " → " +
                toChara.charaName.name.padEnd(
                    length = maxToCharaNameLength,
                    padChar = '　'
                ) +
                "(${count}票)"
        }
    }
}