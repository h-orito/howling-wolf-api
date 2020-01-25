package com.ort.wolf4busy.domain.model.village.setting

data class PersonCapacity(
    val min: Int,
    val max: Int
) {

    companion object {

        private const val DEFAULT_MIN = 10
        private const val DEFAULT_MAX = 16
        private const val MIN_MIN: Int = 1
        private const val MAX_MAX: Int = 999

        operator fun invoke(
            min: Int?,
            max: Int?
        ): PersonCapacity {
            val minimum = min ?: DEFAULT_MIN
            val maximum = max ?: DEFAULT_MAX
            require(MIN_MIN <= minimum) { "min must be greater than 0." }
            require(maximum <= MAX_MAX) { "max must be less than 1000." }
            require(minimum <= maximum) { "max must be greater than or equal to min." }
            return PersonCapacity(minimum, maximum)
        }
    }

    fun existsDifference(capacity: PersonCapacity): Boolean {
        return min != capacity.min || max != capacity.max
    }
}