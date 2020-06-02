package com.ort.howlingwolf.api.view.dead

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.village.VillageDay

data class DeadView(
    val code: String,
    val reason: String,
    val villageDay: VillageDay
) {

    constructor(
        dead: Dead,
        shouldHidePlayer: Boolean
    ) : this(
        code = if (shouldHidePlayer) convertToHideCode(dead) else dead.code,
        reason = if (shouldHidePlayer) convertToHideReason(dead) else dead.reason,
        villageDay = dead.villageDay
    )

    companion object {
        private fun convertToHideCode(dead: Dead): String {
            // 処刑、突然はそのまま出してok
            if (dead.code == CDef.DeadReason.処刑.code() || dead.code == CDef.DeadReason.突然.code()) {
                return dead.code
            }
            // それ以外は無惨
            return "MISERABLE"
        }

        private fun convertToHideReason(dead: Dead): String {
            // 処刑、突然はそのまま出してok
            if (dead.code == CDef.DeadReason.処刑.code() || dead.code == CDef.DeadReason.突然.code()) {
                return dead.reason
            }
            // それ以外は無惨
            return "無惨"
        }
    }
}