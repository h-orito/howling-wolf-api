package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

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
    val includePrivateAbility: Boolean,
    val isLatest: Boolean
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
        includePrivateAbility = false,
        isLatest = false
    )

    companion object {
        val personalPrivateAbilityList = listOf(CDef.MessageType.白黒占い結果)
    }

    fun isPaging(): Boolean = pageSize != null || pageNum != null
}