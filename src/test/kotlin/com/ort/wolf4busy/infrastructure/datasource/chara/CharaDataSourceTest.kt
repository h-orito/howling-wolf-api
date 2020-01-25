package com.ort.wolf4busy.infrastructure.datasource.chara

import com.ort.wolf4busy.Wolf4busyTest
import com.ort.wolf4busy.infrastructure.datasource.charachip.CharachipDataSource
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
class CharaDataSourceTest : Wolf4busyTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var charaDataSource: CharaDataSource
    @Autowired
    lateinit var charachipDataSource: CharachipDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_findCharasByCharachipId() {
        // ## Arrange ##
        // ## Act ##
        val charas = charaDataSource.findCharas(1)

        // ## Assert ##
        assertThat(charas.list).isNotEmpty
    }

    @Test
    fun test_findCharasByCharachips() {
        // ## Arrange ##
        // ## Act ##
        val charachips = charachipDataSource.findCharachips()
        val charas = charaDataSource.findCharas(charachips)

        // ## Assert ##
        assertThat(charas.list).isNotEmpty
    }

    @Test
    fun test_findChara() {
        // ## Arrange ##
        // ## Act ##
        // ## Assert ##
        // エラーが出ないことだけ確認
        charaDataSource.findChara(1)
    }

    @Test
    fun test_findDummyChara() {
        // ## Arrange ##
        // ## Act ##
        val chara = charaDataSource.findDummyChara(1)

        // ## Assert ##
        assertThat(chara.defaultMessage.joinMessage).isNotEmpty()
    }
}