package com.ort.howlingwolf.infrastructure.repository

import io.github.redouane59.twitter.TwitterClient
import io.github.redouane59.twitter.signature.TwitterCredentials
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class TweetRepository {

    private val logger = LoggerFactory.getLogger(TweetRepository::class.java)

    @Value("\${twitter.oauth.consumer-key:}")
    private val consumerKey: String? = null

    @Value("\${twitter.oauth.consumer-secret:}")
    private val consumerSecret: String? = null

    @Value("\${twitter.oauth.access-token:}")
    private val accessToken: String? = null

    @Value("\${twitter.oauth.access-token-secret:}")
    private val accessTokenSecret: String? = null

    fun tweet(msg: String) {
        if (consumerKey.isNullOrEmpty()) return
        try {
            val client = createClient()
            client.postTweet("[HOWLING WOLF] $msg")
        } catch (e: Exception) {
            // 失敗してもスルー
            logger.warn("fail tweet", e)
        }
    }

    fun getUserIdByUsername(username: String): String? {
        if (consumerKey.isNullOrEmpty()) return null
        val client = createClient()
        return client.getUserFromUserName(username)?.id
    }

    private fun createClient(): TwitterClient {
        return TwitterClient(
            TwitterCredentials.builder()
                .accessToken(accessToken)
                .accessTokenSecret(accessTokenSecret)
                .apiKey(consumerKey)
                .apiSecretKey(consumerSecret)
                .build()
        )
    }
}