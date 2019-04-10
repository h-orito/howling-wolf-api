package com.ort.wolf4busy.web.controller

import com.ort.dbflute.exentity.Village
import com.ort.wolf4busy.web.assist.VillageListAssist
import com.ort.wolf4busy.web.body.VillageCreateBody
import com.ort.wolf4busy.web.form.VillageListForm
import com.ort.wolf4busy.web.model.VillageCreateModel
import com.ort.wolf4busy.web.model.VillageListModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/village/confirm")
    fun createConfirm(
        @RequestBody @Validated body: VillageCreateBody
    ): VillageCreateModel {
        return VillageCreateModel()
    }

}