package com.ort.wolf4busy.domain.model.camp

import com.ort.dbflute.allcommon.CDef

object Camp {

    fun getWinCampMessage(cdefWinCamp: CDef.Camp): String {
        return when (cdefWinCamp) {
            CDef.Camp.村人陣営 -> "全ての人狼を退治した。人狼に怯える日々は去ったのだ！"
            CDef.Camp.人狼陣営 -> "もう人狼に抵抗できるほど村人は残っていない。\n人狼は残った村人を全て食らい、別の獲物を求めて村を去っていった。"
            CDef.Camp.狐陣営 -> "全ては終わったかのように見えた。\nだが、奴が生き残っていた。"
        }
    }
}