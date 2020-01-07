package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef

data class VillageStatus(
    val code: String,
    val name: String
) {

    constructor(
        cdefStatus: CDef.VillageStatus
    ) : this(
        code = cdefStatus.code(),
        name = cdefStatus.name
    )

    // ===================================================================================
    //                                                                              status
    //                                                                           =========
    fun isCompleted(): Boolean {
        return CDef.VillageStatus.codeOf(this.code).isFinishedVillage
    }

    fun isPrologue(): Boolean {
        return CDef.VillageStatus.codeOf(this.code) == CDef.VillageStatus.プロローグ
    }

    fun isProgress(): Boolean {
        return CDef.VillageStatus.codeOf(this.code) == CDef.VillageStatus.進行中
    }

    fun toCdef(): CDef.VillageStatus = CDef.VillageStatus.codeOf(code)
}