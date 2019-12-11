package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charachip
import com.ort.wolf4busy.domain.model.charachip.Charachips
import com.ort.wolf4busy.domain.model.charachip.Charas
import com.ort.wolf4busy.infrastructure.datasource.chara.CharaDataSource
import com.ort.wolf4busy.infrastructure.datasource.charachip.CharachipDataSource
import org.springframework.stereotype.Service

@Service
class CharachipService(
    val charachipDataSource: CharachipDataSource,
    val charaDataSource: CharaDataSource
) {

    fun findCharaChipList(): Charachips {
        return charachipDataSource.selectCharachips()
    }

    fun findCharaChip(charachipId: Int): Charachip {
        return charachipDataSource.selectCharachip(charachipId)
    }

    fun findChara(charaId: Int): Chara {
        return charaDataSource.selectChara(charaId)
    }

    fun findCharaList(charachips: Charachips): Charas {
        return charaDataSource.selectCharaList(charachips)
    }

    fun findCharaList(charachipId: Int): Charas {
        return charaDataSource.selectCharaList(charachipId)
    }

    fun findDummyChara(charaChipId: Int): Chara {
        return charaDataSource.selectDummyChara(charaChipId)
    }
}