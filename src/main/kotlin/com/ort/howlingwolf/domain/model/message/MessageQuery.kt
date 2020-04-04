package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import org.apache.commons.collections4.CollectionUtils

data class MessageQuery(
    val from: Long?,
    val pageSize: Int?,
    val pageNum: Int?,
    val keyword: String?,
    val participant: VillageParticipant?,
    val messageTypeList: List<CDef.MessageType>,
    val participantIdList: List<Int>?,
    val includeMonologue: Boolean,
    val includeSecret: Boolean,
    val includePrivateAbility: Boolean
) {
    constructor(
        messageTypeList: List<CDef.MessageType>
    ) : this(
        from = null,
        pageSize = null,
        pageNum = null,
        keyword = null,
        participant = null,
        messageTypeList = messageTypeList,
        participantIdList = null,
        includeSecret = false,
        includeMonologue = false,
        includePrivateAbility = false
    )

    companion object {

        val personalPrivateAbilityList = listOf(CDef.MessageType.白黒占い結果)

        operator fun invoke(
            village: Village,
            participant: VillageParticipant?,
            day: Int,
            authority: CDef.Authority?,
            messageTypeList: List<CDef.MessageType>?,
            from: Long?,
            pageSize: Int?,
            pageNum: Int?,
            keyword: String?,
            participantIdList: List<Int>?
        ): MessageQuery {
            val availableMessageTypeList: List<CDef.MessageType> = village.viewableMessageTypeList(participant, day, authority)
            val requestMessageTypeList = if (CollectionUtils.isEmpty(messageTypeList)) CDef.MessageType.listAll() else messageTypeList!!
            val queryMessageTypeList = requestMessageTypeList.filter { availableMessageTypeList.contains(it) }
            return MessageQuery(
                from = from,
                pageSize = pageSize,
                pageNum = pageNum,
                keyword = if (keyword.isNullOrBlank()) null else keyword,
                participant = participant,
                messageTypeList = queryMessageTypeList,
                participantIdList = participantIdList,
                includeMonologue = isIncludeMonologue(participant, participantIdList, requestMessageTypeList, queryMessageTypeList),
                includeSecret = false, // TODO 秘話実装する際に実装
                includePrivateAbility = isIncludePrivateAbility(participant, requestMessageTypeList)
            )
        }

        private fun isIncludeMonologue(
            participant: VillageParticipant?,
            participantIdList: List<Int>?,
            requestMessageTypeList: List<CDef.MessageType>,
            queryMessageTypeList: List<CDef.MessageType>
        ): Boolean {
            // 既に取得対象になっていれば不要
            if (queryMessageTypeList.contains(CDef.MessageType.独り言)) return false
            // 自分が取得対象になっていなければ不要
            participant ?: return false
            if (participantIdList != null && !participantIdList.contains(participant.id)) return false
            // 求めていなければ不要
            if (!requestMessageTypeList.contains(CDef.MessageType.独り言)) return false

            return true
        }

        // 霊視や襲撃でなく、占いなどの個別のが対象
        private fun isIncludePrivateAbility(
            participant: VillageParticipant?,
            requestMessageTypeList: List<CDef.MessageType>
        ): Boolean {
            participant ?: return false
            return requestMessageTypeList.contains(CDef.MessageType.公開システムメッセージ)
        }
    }

    fun isPaging(): Boolean = pageSize != null && pageNum != null
}