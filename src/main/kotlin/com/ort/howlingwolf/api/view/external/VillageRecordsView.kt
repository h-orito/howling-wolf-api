package com.ort.howlingwolf.api.view.external

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.player.Players
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant
import java.time.format.DateTimeFormatter

data class VillageRecordsView(
    val list: List<VillageRecordView>
) {
    constructor(
        villages: Villages,
        charas: Charas,
        players: Players
    ) : this(
        list = villages.list.map { VillageRecordView(it, charas, players) }
    )
}

data class VillageRecordView(
    val id: Int,
    val name: String,
    val organization: String,
    val startDatetime: String,
    val prologueDatetime: String,
    val epilogueDatetime: String,
    val epilogueDay: Int,
    val url: String,
    val winCampName: String,
    val participantList: List<VillageParticipantRecordView>
) {
    companion object {
        private val datetimePattern = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm")
    }

    constructor(
        village: Village,
        charas: Charas,
        players: Players
    ) : this(
        id = village.id,
        name = village.name,
        organization = village.setting.organizations.organization[village.setting.capacity.max] ?: "",
        startDatetime = village.setting.time.startDatetime.format(datetimePattern),
        prologueDatetime = village.setting.time.prologueStartDatetime.format(datetimePattern),
        epilogueDatetime = village.setting.time.epilogueStartDatetime!!.format(datetimePattern),
        epilogueDay = village.setting.time.epilogueDay!!,
        url = "https://howling-wolf.com/village?id=${village.id}",
        winCampName = village.winCamp!!.name,
        participantList = village.participant.memberList.map {
            val charaList = charas.list.filter { chara -> chara.charachipId == village.setting.charachip.charachipId }
            VillageParticipantRecordView(it, charaList, players)
        }
    )
}

data class VillageParticipantRecordView(
    val twitterUserId: String,
    val otherSiteUserId: String?,
    val characterName: String,
    val skillName: String,
    val isWin: Boolean,
    val isDead: Boolean,
    val deadDay: Int?,
    val deadReason: String?
) {
    constructor(
        participant: VillageParticipant,
        charaList: List<Chara>,
        players: Players
    ) : this(
        twitterUserId = players.list.first { it.id == participant.playerId }.twitterUserName,
        otherSiteUserId = players.list.first { it.id == participant.playerId }.otherSiteName,
        characterName = charaList.first { it.id == participant.charaId }.charaName.name,
        skillName = participant.skill!!.name,
        isWin = participant.isWin!!,
        isDead = participant.dead != null,
        deadDay = participant.dead?.villageDay?.day,
        deadReason = participant.dead?.let { it.reason + "死" }
    )
}