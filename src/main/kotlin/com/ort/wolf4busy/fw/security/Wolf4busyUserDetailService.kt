package com.ort.wolf4busy.fw.security

import com.ort.dbflute.exbhv.PlayerBhv
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service("wolf4busyUserDetailsService")
class Wolf4busyUserDetailService(
        val playerBhv: PlayerBhv
) : UserDetailsService {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    override fun loadUserByUsername(userId: String?): UserDetails {
        userId ?: throw UsernameNotFoundException("userId is empty")

        val optPlayer = playerBhv.selectEntity { cb -> cb.query().setPlayerName_Equal(userId) }

        return optPlayer.map {
            Wolf4busyUser(
                    userName = it.playerName,
                    pass = it.playerPassword,
                    authority = it.authorityCodeAsAuthority
            )
        }.orElseThrow {
            UsernameNotFoundException("User not found for userId: $userId")
        }
    }
}