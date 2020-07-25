package com.ort.howlingwolf

import com.nhaarman.mockitokotlin2.whenever
import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.HowlingWolfUserInfoUtil
import com.ort.howlingwolf.fw.config.FirebaseConfig
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.dbflute.hook.AccessContext
import org.junit.Before
import org.springframework.boot.test.mock.mockito.MockBean


open class HowlingWolfTest {

    @MockBean
    lateinit var firebaseConfig: FirebaseConfig

    @Before
    fun setUp() {
        // firebase関連はmockにする
        whenever(firebaseConfig.init()).then { }
        whenever(firebaseConfig.firebaseDatabase()).thenReturn(null)
        // set access context
        setAccessContext()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun setAccessContext() {
        if (AccessContext.isExistAccessContextOnThread()) {
            // 既に設定されていたら何もしないで次へ
            // (二度呼び出しされたときのために念のため)
            return
        }
        // [アクセス日時]
        val accessLocalDateTime = HowlingWolfDateUtil.currentLocalDateTime()

        // [アクセスユーザ]
        val userInfo: HowlingWolfUser? = HowlingWolfUserInfoUtil.getUserInfo()
        val accessUser = userInfo?.username ?: "not login user"

        val context = AccessContext()
        context.accessLocalDateTime = accessLocalDateTime
        context.accessUser = accessUser
        AccessContext.setAccessContextOnThread(context)
    }
}