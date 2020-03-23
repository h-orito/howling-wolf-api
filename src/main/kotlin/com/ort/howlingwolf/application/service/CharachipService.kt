package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charachip
import com.ort.howlingwolf.domain.model.charachip.Charachips
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.infrastructure.datasource.chara.CharaDataSource
import com.ort.howlingwolf.infrastructure.datasource.charachip.CharachipDataSource
import org.springframework.stereotype.Service

@Service
class CharachipService(
    val charachipDataSource: CharachipDataSource,
    val charaDataSource: CharaDataSource
) {

    fun findCharaChips(): Charachips = charachipDataSource.findCharachips()

    fun findCharaChip(charachipId: Int): Charachip = charachipDataSource.findCharachip(charachipId)

    fun findChara(charaId: Int): Chara = charaDataSource.findChara(charaId)

    fun findCharas(charachips: Charachips): Charas = charaDataSource.findCharas(charachips)

    fun findCharas(charachipId: Int): Charas = charaDataSource.findCharas(charachipId)

    fun findCharas(charachipIdList: List<Int>): Charas = charaDataSource.findCharas(charachipIdList)

    fun findDummyChara(charaChipId: Int): Chara = charaDataSource.findDummyChara(charaChipId)
}