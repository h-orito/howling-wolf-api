package com.ort.howlingwolf.api.view.external

import com.ort.howlingwolf.domain.model.charachip.Charachips
import com.ort.howlingwolf.domain.model.reserved.ReservedVillage
import com.ort.howlingwolf.domain.model.village.Village
import java.time.format.DateTimeFormatter

data class RecruitingVillagesView(
    val villageList: List<RecruitingVillageView>,
    val reservedVillageList: List<RecruitingReservedVillageView>
) {

    constructor(
        villageList: List<Village>,
        reservedVillageList: List<ReservedVillage>,
        charachips: Charachips
    ) : this(
        villageList = villageList.map { RecruitingVillageView(it, charachips) },
        reservedVillageList = reservedVillageList.map { RecruitingReservedVillageView(it) }
    )
}

data class RecruitingVillageView(
    val id: Int,
    val name: String,
    val status: String,
    val participantCount: Int,
    val participantCapacity: Int,
    val dayChangeTime: String,
    val startDatetime: String,
    val charachipName: String,
    val sayableTime: String,
    val url: String,
    val organization: String
) {
    constructor(
        village: Village,
        charachips: Charachips
    ) : this(
        id = village.id,
        name = village.name,
        status = village.status.name,
        participantCount = village.participant.count,
        participantCapacity = village.setting.capacity.max,
        dayChangeTime = village.day.latestDay().dayChangeDatetime.toLocalTime()
            .format(DateTimeFormatter.ofPattern("HH:mm")),
        startDatetime = village.setting.time.startDatetime.format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm")),
        charachipName = charachips.list.first { it.id == village.setting.charachip.charachipId }.name,
        sayableTime =
        if (village.setting.time.silentHours == null || village.setting.time.silentHours == 0) "24時間"
        else village.setting.time.let {
            val start = it.startDatetime.plusHours(it.silentHours!!.toLong()).toLocalTime()
            val end = it.startDatetime.toLocalTime()
            val endPrefix = if (start.isAfter(end)) "翌" else ""
            "${start.format(DateTimeFormatter.ofPattern("HH:mm"))} - ${endPrefix}${
                end.format(
                    DateTimeFormatter.ofPattern(
                        "HH:mm"
                    )
                )
            }"
        },
        url = "https://howling-wolf.com/village?id=${village.id}",
        organization = village.setting.organizations.organization[village.setting.capacity.max] ?: ""
    )
}

data class RecruitingReservedVillageView(
    val name: String,
    val participantCapacity: Int,
    val dayChangeTime: String,
    val startDatetime: String,
    val charachipName: String,
    val sayableTime: String,
    val url: String,
    val organization: String
) {
    constructor(
        reservedVillage: ReservedVillage
    ) : this(
        name = "${reservedVillage.startTime.format(DateTimeFormatter.ofPattern("HH:mm"))}開始予定",
        participantCapacity = reservedVillage.organization.length,
        dayChangeTime = reservedVillage.startTime.format(DateTimeFormatter.ofPattern("HH:mm")),
        startDatetime = reservedVillage.startTime.format(DateTimeFormatter.ofPattern("HH:mm")),
        charachipName = "城下町の酒場",
        sayableTime =
        if (reservedVillage.silentHours == 0) "24時間"
        else reservedVillage.let {
            val start = it.startTime.plusHours(it.silentHours.toLong())
            val end = it.startTime
            val endPrefix = if (start.isAfter(end)) "翌" else ""
            "${start.format(DateTimeFormatter.ofPattern("HH:mm"))} - ${endPrefix}${
                end.format(
                    DateTimeFormatter.ofPattern(
                        "HH:mm"
                    )
                )
            }"
        },
        url = "https://howling-wolf.com",
        organization = reservedVillage.organization
    )
}