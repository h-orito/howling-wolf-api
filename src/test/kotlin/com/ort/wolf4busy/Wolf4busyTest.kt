package com.ort.wolf4busy

import com.nhaarman.mockitokotlin2.whenever
import com.ort.wolf4busy.fw.config.FirebaseConfig
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
    }
}