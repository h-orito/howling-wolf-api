package com.ort.howlingwolf.application.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import twitter4j.TwitterException
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder


@Service
class TweetService {

    private val logger = LoggerFactory.getLogger(TweetService::class.java)

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
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret(consumerSecret)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessTokenSecret)
        val tf = TwitterFactory(cb.build())
        val twitter = tf.instance
        try {
            twitter.updateStatus("[HOWLING WOLF] $msg")
        } catch (e: TwitterException) {
            // 失敗してもスルー
            logger.warn("fail tweet", e)
        }
    }
}