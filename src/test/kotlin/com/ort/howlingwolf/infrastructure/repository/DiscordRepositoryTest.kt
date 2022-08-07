package com.ort.howlingwolf.infrastructure.repository

import com.ort.howlingwolf.HowlingWolfTest
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class DiscordRepositoryTest : HowlingWolfTest() {

    @Autowired
    private lateinit var discordRepository: DiscordRepository

    @Test
    fun test_post() {
        discordRepository.post(1, "てすと")
    }
}