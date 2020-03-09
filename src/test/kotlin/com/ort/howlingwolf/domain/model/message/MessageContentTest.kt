package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.fw.exception.HowlingWolfBadRequestException
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class MessageContentTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertMessageLength_OK() {
        // ## Arrange ##
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            text = """
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
                1234567890\r\n
            """.trimIndent(),
            faceCode = CDef.FaceType.通常.code()
        )
        val maxLength = 200

        // ## Act ##
        // ## Assert ##
        messageContent.assertMessageLength(maxLength)
    }

    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertMessageLength_行数オーバー() {
        // ## Arrange ##
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            text = """
                1\r\n
                2\r\n
                3\r\n
                4\r\n
                5\r\n
                6\r\n
                7\r\n
                8\r\n
                9\r\n
                0\r\n
                1\r\n
                2\r\n
                3\r\n
                4\r\n
                5\r\n
                6\r\n
                7\r\n
                8\r\n
                9\r\n
                0\r\n
                1
            """.trimIndent(),
            faceCode = CDef.FaceType.通常.code()
        )
        val maxLength = 100

        // ## Act ##
        // ## Assert ##
        messageContent.assertMessageLength(maxLength)
    }

    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertMessageLength_文字数オーバー() {
        // ## Arrange ##
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            text = """
                12345678901234567890
                12345678901234567890
            """.trimIndent(),
            faceCode = CDef.FaceType.通常.code()
        )
        val maxLength = 19

        // ## Act ##
        // ## Assert ##
        messageContent.assertMessageLength(maxLength)
    }

    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertMessageLength_空() {
        // ## Arrange ##
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            text = "",
            faceCode = CDef.FaceType.通常.code()
        )
        val maxLength = 20

        // ## Act ##
        // ## Assert ##
        messageContent.assertMessageLength(maxLength)
    }

    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertMessageLength_改行のみ() {
        // ## Arrange ##
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            text = "\r\n\r\n",
            faceCode = CDef.FaceType.通常.code()
        )
        val maxLength = 20

        // ## Act ##
        // ## Assert ##
        messageContent.assertMessageLength(maxLength)
    }
}