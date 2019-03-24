package com.ort.wolf4busy.web.controller

import com.ort.dbflute.exbhv.VillageBhv
import com.ort.wolf4busy.web.model.IndexModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class IndexController {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villageBhv: VillageBhv

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @CrossOrigin
    @GetMapping("/")
    fun init(): IndexModel {
        val villageNum: Int = villageBhv.selectList({ cb ->
            cb.query().addOrderBy_RegisterDatetime_Asc()
        }).size
        return IndexModel(villageNum)
    }
}