package com.ort.wolf4busy.web.assist

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exentity.Village
import com.ort.wolf4busy.web.form.VillageListForm
import com.ort.wolf4busy.web.model.VillageListModel
import com.ort.wolf4busy.web.model.inner.VillageListVillageModel
import org.apache.commons.lang3.BooleanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class VillageListAssist {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageBhv: VillageBhv

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    fun selectVillageList(form: VillageListForm): List<Village> {
        val statusList: List<CDef.VillageStatus> = listOf(CDef.VillageStatus.廃村, CDef.VillageStatus.終了)
        return villageBhv.selectList { cb ->
            cb.setupSelect_VillageSettingsAsOne()
            if (BooleanUtils.isTrue(form.isOnlyComplete)) {
                cb.query().setVillageStatusCode_InScope_AsVillageStatus(statusList)
            } else {
                cb.query().setVillageStatusCode_NotInScope_AsVillageStatus(statusList)
            }
            cb.query().addOrderBy_RegisterDatetime_Desc()
        }
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    fun mappingToModel(villageList: List<Village>): VillageListModel {
        return VillageListModel(villageList.map { village ->
            VillageListVillageModel(
                    id = village.villageId,
                    name = village.villageDisplayName,
                    status = village.villageStatusCodeAsVillageStatus.alias(),
                    talkType = "BBS形式",
                    dayProgress = "1日目",
                    participateNum = 1,
                    participateCapacity = 1,
                    spectateNum = 1,
                    creatorName = "ort",
                    comment = ""
            )
        })
    }

}