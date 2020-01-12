package com.ort.wolf4busy

import com.nhaarman.mockitokotlin2.whenever
import com.ort.wolf4busy.fw.Wolf4busyDateUtil
import com.ort.wolf4busy.fw.Wolf4busyUserInfoUtil
import com.ort.wolf4busy.fw.config.FirebaseConfig
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import org.dbflute.hook.AccessContext
import org.junit.Before
import org.springframework.boot.test.mock.mockito.MockBean


open class Wolf4busyTest {

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
        val accessLocalDateTime = Wolf4busyDateUtil.currentLocalDateTime()

        // [アクセスユーザ]
        val userInfo: Wolf4busyUser? = Wolf4busyUserInfoUtil.getUserInfo()
        val accessUser = userInfo?.username ?: "not login user"

        val context = AccessContext()
        context.accessLocalDateTime = accessLocalDateTime
        context.accessUser = accessUser
        AccessContext.setAccessContextOnThread(context)
    }
}