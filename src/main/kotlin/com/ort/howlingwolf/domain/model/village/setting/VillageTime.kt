package com.ort.howlingwolf.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import java.time.LocalDateTime

data class VillageTime(
    val termType: String,
    val prologueStartDatetime: LocalDateTime,
    val epilogueDay: Int?,
    val epilogueStartDatetime: LocalDateTime?,
    val startDatetime: LocalDateTime,
    val dayChangeIntervalSeconds: Int,
    val silentHours: Int?
) {
    companion object {
        private const val DEFAULT_INTERVAL = 86400
        private const val INTERVAL_MIN: Int = 60 * 3
        private const val INTERVAL_MAX: Int = 60 * 60 * 48

        operator fun invoke(
            termType: String?,
            prologueStartDatetime: LocalDateTime?,
            epilogueDay: Int?,
            epilogueStartDatetime: LocalDateTime?,
            startDatetime: LocalDateTime?,
            dayChangeIntervalSeconds: Int?,
            silentHours: Int?
        ): VillageTime {
            require(termType == null || CDef.Term.codeOf(termType) != null)
            requireNotNull(startDatetime)
            requireNotNull(prologueStartDatetime)
            if (dayChangeIntervalSeconds != null) {
                require(INTERVAL_MIN <= dayChangeIntervalSeconds && dayChangeIntervalSeconds <= INTERVAL_MAX)
            }
            return VillageTime(
                termType = termType ?: CDef.Term.長期.code(),
                prologueStartDatetime = prologueStartDatetime,
                epilogueDay = epilogueDay,
                epilogueStartDatetime = epilogueStartDatetime,
                startDatetime = startDatetime,
                dayChangeIntervalSeconds = dayChangeIntervalSeconds ?: DEFAULT_INTERVAL,
                silentHours = silentHours
            )
        }
    }

    fun existsDifference(time: VillageTime): Boolean {
        return termType != time.termType
                || startDatetime != time.startDatetime
                || dayChangeIntervalSeconds != time.dayChangeIntervalSeconds
                || silentHours != time.silentHours
    }

    fun isSilentTime(dayStartDatetime: LocalDateTime): Boolean {
        silentHours ?: return false
        val now = HowlingWolfDateUtil.currentLocalDateTime()
        return now.isBefore(dayStartDatetime.plusHours(silentHours.toLong()))
    }

    fun extendPrologue(): VillageTime {
        var startDatetime = this.startDatetime
        while (true) {
            startDatetime = startDatetime.plusDays(1L)
            if (startDatetime.isAfter(HowlingWolfDateUtil.currentLocalDateTime())) {
                return this.copy(
                    startDatetime = startDatetime
                )
            }
        }
    }

    fun toEpilogue(villageDays: VillageDays): VillageTime {
        return this.copy(
            epilogueDay = villageDays.latestDay().day,
            epilogueStartDatetime = HowlingWolfDateUtil.currentLocalDateTime()
        )
    }
}