package com.ort.howlingwolf.fw.security

import com.ort.dbflute.allcommon.CDef
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.servlet.http.HttpServletRequest

data class HowlingWolfUser(
        val uid: String,
        val authority: CDef.Authority,
        var ipAddress: String? = null
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(this.authority.code()))
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.uid
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}

fun HttpServletRequest.getIpAddress(): String {
    val xForwardedFor = this.getHeader("X-Forwarded-For")
    return if (xForwardedFor.isNullOrEmpty()) this.remoteAddr
    else xForwardedFor
}