package com.ort.howlingwolf.fw.security

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.PlayerBhv
import com.ort.dbflute.exentity.Player
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import org.dbflute.hook.AccessContext
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service("howlingWolfUserDetailsService")
class HowlingWolfUserDetailService(
    val playerBhv: PlayerBhv
) : UserDetailsService {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    override fun loadUserByUsername(uid: String?): UserDetails {
        uid ?: throw UsernameNotFoundException("uid is empty")

        val optPlayer = playerBhv.selectEntity { cb -> cb.query().setUid_Equal(uid) }

        return optPlayer.map {
            HowlingWolfUser(
                uid = it.uid,
                authority = it.authorityCodeAsAuthority
            )
        }.orElseThrow {
            UsernameNotFoundException("User not found for userId: $uid")
        }
    }

    fun insertUser(uid: String): UserDetails {
        val context = AccessContext()
        context.accessUser = uid
        context.accessLocalDateTime = HowlingWolfDateUtil.currentLocalDateTime()
        AccessContext.setAccessContextOnThread(context)

        val player = Player()
        player.uid = uid
        player.authorityCodeAsAuthority = CDef.Authority.プレイヤー
        player.nickname = "名無し"
        player.twitterUserName = "未設定"
        player.isRestrictedParticipation = false
        playerBhv.insert(player)
        return HowlingWolfUser(
            uid = uid,
            authority = CDef.Authority.プレイヤー
        )
    }
}