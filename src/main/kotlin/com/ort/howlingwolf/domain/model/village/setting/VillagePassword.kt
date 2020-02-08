package com.ort.howlingwolf.domain.model.village.setting

data class VillagePassword(
    val joinPasswordRequired: Boolean,
    val joinPassword: String?
) {
    companion object {

        operator fun invoke(
            joinPassword: String?
        ): VillagePassword {
            return VillagePassword(
                joinPasswordRequired = !joinPassword.isNullOrEmpty(),
                joinPassword = joinPassword
            )
        }
    }

    fun existsDifference(password: VillagePassword): Boolean {
        return joinPassword != password.joinPassword
    }
}