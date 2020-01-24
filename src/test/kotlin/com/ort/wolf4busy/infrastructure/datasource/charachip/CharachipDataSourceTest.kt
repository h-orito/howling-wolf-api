package com.ort.wolf4busy.infrastructure.datasource.charachip

import com.ort.wolf4busy.Wolf4busyTest
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class CharachipDataSourceTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var charachipDataSource: CharachipDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findCharachips() {
        // ## Arrange ##
        // ## Act ##
        val charachips = charachipDataSource.findCharachips()

        // ## Assert ##
        assertThat(charachips.list).isNotEmpty
    }

    @Test
    fun test_findCharachip() {
        // ## Arrange ##
        // ## Act ##
        // ## Assert ##
        // エラーが出ないことだけ確認
        charachipDataSource.findCharachip(1)
    }
}