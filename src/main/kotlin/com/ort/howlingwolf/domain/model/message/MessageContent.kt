package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException

data class MessageContent(
    val type: MessageType,
    val num: Int?,
    val text: String,
    val faceCode: String?
) {
    companion object {

        const val defaultLengthMax = 400
        const val lineMax: Int = 20

        operator fun invoke(
            messageType: String,
            text: String,
            faceCode: String?
        ): MessageContent {
            val cdefMessageType = checkNotNull(CDef.MessageType.codeOf(messageType))
            return MessageContent(
                type = MessageType(cdefMessageType),
                num = null,
                text = removeSurrogate(text.trim()),
                faceCode = faceCode
            )
        }

        /**
         * 絵文字を除く文字列を返す
         * @param text
         * @return 4byte文字を除いた文字列
         */
        private fun removeSurrogate(text: String): String {
            return text.chunked(1).filter { c ->
                !c.matches("[\\uD800-\\uDFFF]".toRegex())
            }.joinToString(separator = "")
        }
    }

    fun assertMessageLength(maxLength: Int) {
        // 行数
        if (text.replace("\r\n", "\n").split("\n").size > lineMax) throw HowlingWolfBusinessException("行数オーバーです")
        // 文字数
        if (text.isEmpty()) throw HowlingWolfBusinessException("発言内容がありません")
        // 改行は文字数としてカウントしない
        val length = text.replace("\r\n", "").replace("\n", "").length
        if (length <= 0) throw HowlingWolfBusinessException("発言内容がありません") // 改行のみもNG
        if (maxLength < length) throw HowlingWolfBusinessException("文字数オーバーです length: $length")
    }
}