package com.ort.howlingwolf.infrastructure.repository

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class DiscordRepository {

    companion object {
        private val logger = LoggerFactory.getLogger(DiscordRepository::class.java)
    }

    @Value("\${discord.webhook-url:}")
    private lateinit var webhookUrl: String

    @Value("\${discord.master-userid:}")
    private lateinit var masterUserId: String

    fun post(villageId: Int, message: String) {
        if (webhookUrl.isEmpty()) return
        try {
            val restTemplate = RestTemplate()
            val request = Request(
                content = "<@!$masterUserId>\nhttps://howling-wolf.com/village?id=$villageId\n$message"
            )
            val formHeaders = HttpHeaders()
            formHeaders.contentType = MediaType.APPLICATION_JSON
            formHeaders.add(HttpHeaders.USER_AGENT, "RestTemplate")
            val formEntity = HttpEntity(request, formHeaders)
            restTemplate.exchange(webhookUrl, HttpMethod.POST, formEntity, String::class.java)
        } catch (e: Exception) {
            logger.error("discord投稿に失敗しました", e)
        }
    }

    data class Request(
        val content: String
    ) : java.io.Serializable
}