package com.ort.wolf4busy.web.controller

import com.ort.dbflute.exentity.Village
import com.ort.wolf4busy.web.assist.VillageListAssist
import com.ort.wolf4busy.web.body.VillageCreateBody
import com.ort.wolf4busy.web.form.VillageListForm
import com.ort.wolf4busy.web.model.NextPlanedVillageDetailModel
import com.ort.wolf4busy.web.model.NextPlanedVillageModel
import com.ort.wolf4busy.web.model.VillageCreateModel
import com.ort.wolf4busy.web.model.VillageListModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.LocalTime

@CrossOrigin
@RestController
class VillageController {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageListAssist: VillageListAssist

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    /**
     * 村一覧
     */
    @GetMapping("/village/list")
    fun list(form: VillageListForm): VillageListModel {
        val villageList: List<Village> = villageListAssist.selectVillageList(form)
        return villageListAssist.mappingToModel(villageList)
    }

    /**
     * 村作成
     */
    @PostMapping("/village/confirm")
    @CrossOrigin
    fun createConfirm(
        @RequestBody @Validated body: VillageCreateBody
    ): VillageCreateModel {
        return VillageCreateModel()
    }

    @GetMapping("/village/next-planed")
    fun getNextPlanedVillage(): NextPlanedVillageModel {
        val nextVillage: NextPlanedVillageDetailModel = NextPlanedVillageDetailModel(
            createDatetime = LocalDateTime.of(2019, 4, 8, 21, 0),
            startDatetime = LocalDateTime.of(2019, 4, 8, 22, 0),
            viewableStartDatetime = LocalTime.of(21, 30, 0),
            viewableEndDatetime = LocalTime.of(23, 30, 0),
            sayableStartDatetime = LocalTime.of(22, 0, 0),
            sayableEndDatetime = LocalTime.of(23, 0, 0),
            personMin = 10,
            personMax = 16,
            organization = "人狼BBS: G",
            participateNum = 12
        )
        return NextPlanedVillageModel(nextVillage)
    }


}