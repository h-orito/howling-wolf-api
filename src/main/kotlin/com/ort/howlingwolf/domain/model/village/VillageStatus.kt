package com.ort.howlingwolf.domain.model.village

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
    fun isSolved(): Boolean = this.toCdef().isSolvedVillage

    fun isPrologue(): Boolean = this.toCdef() == CDef.VillageStatus.プロローグ

    fun isProgress(): Boolean = this.toCdef() == CDef.VillageStatus.進行中

    fun isEpilogue(): Boolean = this.toCdef() == CDef.VillageStatus.エピローグ

    fun isFinished(): Boolean = this.toCdef().isFinishedVillage

    fun isCanceled(): Boolean = this.toCdef() == CDef.VillageStatus.廃村

    fun toCdef(): CDef.VillageStatus = CDef.VillageStatus.codeOf(code)
}