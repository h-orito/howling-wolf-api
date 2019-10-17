package com.ort.wolf4busy.infrastructure.datasource.message

import com.ort.dbflute.exbhv.MessageBhv
import com.ort.dbflute.exentity.Message
import com.ort.wolf4busy.fw.Wolf4busyDateUtil
import com.ort.wolf4busy.fw.exception.Wolf4busyBusinessException
import org.springframework.stereotype.Repository
import java.time.ZoneOffset

@Repository
class MessageDataSource(
    val messageBhv: MessageBhv
) {

    fun insertMessage(
        villageId: Int,
        dayId: Int,
        messageType: String,
        text: String,
        villagePlayerId: Int? = null,
        targetVillagePlayerId: Int? = null,
        playerId: Int? = null,
        faceType: String? = null
    ) {
        val mes = Message()
        mes.villageId = villageId
        mes.villageDayId = dayId
        mes.messageTypeCode = messageType
        mes.messageContent = text
        mes.villagePlayerId = villagePlayerId
        mes.toVillagePlayerId = targetVillagePlayerId
        mes.playerId = playerId
        mes.faceTypeCode = faceType
        mes.isConvertDisable = true
        val now = Wolf4busyDateUtil.currentLocalDateTime()
        mes.messageDatetime = now
        mes.messageUnixtimestampMilli = now.toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()

        // 発言番号の採番 & insert (3回チャレンジする)
        for (i in 1..3) {
            try {
                mes.messageNumber = selectNextMessageNumber(villageId, messageType)
                messageBhv.insert(mes)
                return
            } catch (e: RuntimeException) {
                e.printStackTrace()
                // 握りつぶす
            }
        }
        throw Wolf4busyBusinessException("混み合っているため発言に失敗しました。再度発言してください。")
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun selectNextMessageNumber(villageId: Int, messageType: String): Int {
        val maxNumber: Int = messageBhv.selectScalar(Int::class.java).max {
            it.specify().columnMessageNumber()
            it.query().setVillageId_Equal(villageId)
            it.query().setMessageTypeCode_Equal(messageType)
        }.orElse(0)
        return maxNumber + 1
    }

}