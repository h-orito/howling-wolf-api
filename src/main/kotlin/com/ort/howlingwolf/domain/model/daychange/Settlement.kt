package com.ort.howlingwolf.domain.model.daychange

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.camp.Camp
import com.ort.howlingwolf.domain.model.village.Village

/**
 * 決着
 */
data class Settlement(
    val village: Village
) {

    fun isSettled(): Boolean {
        val wolfCount = wolfCount()
        return wolfCount <= 0 || villagerCount() <= wolfCount
    }

    fun winCamp(): Camp? {
        if (!this.isSettled()) return null
        if (foxCount() > 0) return Camp(CDef.Camp.狐陣営)
        if (wolfCount() > 0) return Camp(CDef.Camp.人狼陣営)
        return Camp(CDef.Camp.村人陣営)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun villagerCount(): Int =
        this.village.participant.memberList.count { it.isAlive() && !it.skill!!.toCdef().isCountWolf && !it.skill.toCdef().isNoCount }

    private fun wolfCount(): Int = this.village.participant.memberList.count { it.isAlive() && it.skill!!.toCdef().isCountWolf }

    private fun foxCount(): Int = this.village.participant.memberList.count { it.isAlive() && it.skill!!.toCdef().isNoCount }
}