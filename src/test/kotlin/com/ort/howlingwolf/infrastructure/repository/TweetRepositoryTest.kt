package com.ort.howlingwolf.infrastructure.repository

import com.ort.howlingwolf.HowlingWolfTest
import org.junit.Ignore
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
@Ignore
internal class TweetRepositoryTest : HowlingWolfTest() {

    @Autowired
    private lateinit var repository: TweetRepository

    @Test
    fun test_tweet() {
        repository.tweet("テストツイートです。")
    }

    @Test
    fun test_getUserIdByUsername() {
        println(repository.getUserIdByUsername("ort_dev"))
    }
}