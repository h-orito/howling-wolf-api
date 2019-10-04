package com.ort.wolf4busy.fw

import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.springframework.security.core.context.SecurityContextHolder


class Wolf4busyUserInfoUtil private constructor() {
    companion object {
        fun getUserInfo(): Wolf4busyUser? {
            val authentication = SecurityContextHolder.getContext().authentication ?: return null
            return if (authentication.principal is Wolf4busyUser) {
                Wolf4busyUser::class.java!!.cast(authentication.principal)
            } else null
        }
    }
}