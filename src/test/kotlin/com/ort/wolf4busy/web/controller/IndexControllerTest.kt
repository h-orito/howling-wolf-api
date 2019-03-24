package com.ort.wolf4busy.web.controller

import com.ort.wolf4busy.Wolf4busyApplication
import com.ort.wolf4busy.web.model.IndexModel
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@ContextConfiguration(classes = [Wolf4busyApplication::class])
@RunWith(SpringRunner::class)
@SpringBootTest
class IndexControllerTest {

    @Autowired
    lateinit var controller: IndexController

    @Test
    fun test_init() {

        val model: IndexModel = controller.init()

        Assertions.assertThat(model.hoge).isEqualTo(0)
    }
}
