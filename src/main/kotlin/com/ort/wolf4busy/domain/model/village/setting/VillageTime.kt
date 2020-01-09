package com.ort.wolf4busy.domain.model.village.setting

import com.ort.dbflute.allcommon.CDef
import java.time.LocalDateTime

data class VillageTime(
    val termType: String,
    val startDatetime: LocalDateTime,
    val dayChangeIntervalSeconds: Int
) {
    companion object {
        private const val DEFAULT_INTERVAL = 86400
        private const val INTERVAL_MIN: Int = 60 * 3
        private const val INTERVAL_MAX: Int = 60 * 60 * 48

        operator fun invoke(
            termType: String?,
            startDatetime: LocalDateTime?,
            dayChangeIntervalSeconds: Int?
        ): VillageTime {
            require(termType == null || CDef.Term.codeOf(termType) != null)
            requireNotNull(startDatetime)
            if (dayChangeIntervalSeconds != null) {
                require(INTERVAL_MIN <= dayChangeIntervalSeconds && dayChangeIntervalSeconds <= INTERVAL_MAX)
            }
            return VillageTime(
                termType = termType ?: CDef.Term.長期.code(),
                startDatetime = startDatetime,
                dayChangeIntervalSeconds = dayChangeIntervalSeconds ?: DEFAULT_INTERVAL
            )
        }
    }

    fun existsDifference(time: VillageTime): Boolean {
        return termType != time.termType
            || startDatetime != time.startDatetime
            || dayChangeIntervalSeconds != dayChangeIntervalSeconds
    }
}