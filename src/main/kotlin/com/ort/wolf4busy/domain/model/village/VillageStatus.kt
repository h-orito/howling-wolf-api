package com.ort.wolf4busy.domain.model.village

import com.ort.dbflute.allcommon.CDef

data class VillageStatus(
    val code: String,
    val name: String
) {

    // ===================================================================================
    //                                                                              status
    //                                                                           =========
    fun isCompleted(): Boolean {
        return CDef.VillageStatus.codeOf(this.code).isFinishedVillage
    }

    fun isPrologue(): Boolean {
        return CDef.VillageStatus.codeOf(this.code).isPrologue
    }

    fun isProgress(): Boolean {
        return CDef.VillageStatus.codeOf(this.code) == CDef.VillageStatus.進行中
    }

}