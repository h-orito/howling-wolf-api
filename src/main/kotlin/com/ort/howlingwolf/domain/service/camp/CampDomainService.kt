package com.ort.howlingwolf.domain.service.camp

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.message.Message
import org.springframework.stereotype.Service

@Service
class CampDomainService {

    /**
     * 勝利陣営メッセージ
     * @param cdefWinCamp 勝利した陣営
     * @param villageDayId 村日付ID
     */
    fun createWinCampMessage(cdefWinCamp: CDef.Camp, villageDayId: Int): Message =
        Message.createPublicSystemMessage(getWinCampMessage(cdefWinCamp), villageDayId)

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun getWinCampMessage(cdefWinCamp: CDef.Camp): String {
        return when (cdefWinCamp) {
            CDef.Camp.村人陣営 -> "全ての人狼を退治した。人狼に怯える日々は去ったのだ！"
            CDef.Camp.人狼陣営 -> "もう人狼に抵抗できるほど村人は残っていない。\n人狼は残った村人を全て食らい、別の獲物を求めて村を去っていった。"
            CDef.Camp.狐陣営 -> "全ては終わったかのように見えた。\nだが、奴が生き残っていた。"
        }
    }
}