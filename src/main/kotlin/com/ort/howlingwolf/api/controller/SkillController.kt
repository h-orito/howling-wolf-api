package com.ort.howlingwolf.api.controller

import com.ort.howlingwolf.api.view.skill.SkillsView
import com.ort.howlingwolf.application.service.SkillService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SkillController(
    val skillService: SkillService
) {

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @GetMapping("/skill/list")
    fun skills(): SkillsView {
        return SkillsView(
            list = skillService.findSkills().list
        )
    }
}
