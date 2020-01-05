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
            if (min != null && min < MIN_MIN) {
                throw IllegalArgumentException("min must be greater than 0.")
            }
            if (max != null && max > MAX_MAX) {
                throw IllegalArgumentException("max must be less than 1000.")
            }
            if (min != null && max != null && max < min) {
                throw IllegalArgumentException("max must be greater than or equal to min.")
            }

            return PersonCapacity(min ?: DEFAULT_MIN, max ?: DEFAULT_MAX)
        }
    }
}