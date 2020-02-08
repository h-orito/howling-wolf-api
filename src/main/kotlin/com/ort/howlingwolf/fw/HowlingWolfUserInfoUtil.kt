package com.ort.howlingwolf.fw

import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.springframework.security.core.context.SecurityContextHolder


class HowlingWolfUserInfoUtil private constructor() {
    companion object {
        fun getUserInfo(): HowlingWolfUser? {
            val authentication = SecurityContextHolder.getContext().authentication ?: return null
            return if (authentication.principal is HowlingWolfUser) {
                HowlingWolfUser::class.java!!.cast(authentication.principal)
            } else null
        }
    }
}