package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.charachip.Chara
import com.ort.wolf4busy.domain.model.charachip.Charachip
import com.ort.wolf4busy.domain.model.charachip.Charachips
import com.ort.wolf4busy.infrastructure.datasource.charachip.CharachipDataSource
import org.springframework.stereotype.Service

@Service
class CharachipService(
        val charachipDataSource: CharachipDataSource
) {

    fun findCharaChipList(): Charachips {
        return charachipDataSource.selectCharachips()
    }

    fun findCharaChip(charaChipId: Int): Charachip {
        return charachipDataSource.selectCharachip(charaChipId)
    }

    fun findChara(charaChipId: Int, charaId: Int): Chara {
        return charachipDataSource.selectChara(charaChipId, charaId)
    }

    fun findDummyChara(charaChipId: Int): Chara {
        return charachipDataSource.selectDummyChara(charaChipId)
    }
}