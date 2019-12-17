package com.ort.wolf4busy.application.coordinator

import com.ort.dbflute.allcommon.CDef
import com.ort.wolf4busy.application.service.MessageService
import com.ort.wolf4busy.domain.model.village.Village
import org.springframework.stereotype.Service

@Service
class DayChangeCoordinator(
    val messageService: MessageService
) {

    /**
     * 必要あれば日付更新
     *
     * @param village village
     */
    fun dayChangeIfNeeded(village: Village) {
        // 最新日の通常発言
        val messageList = messageService.findMessageList(village.id, village.day.latestDay().id, listOf(CDef.MessageType.通常発言), null, null)

        // 必要があれば日付更新
        val (changedVillage, changedMessages) = village.dayChangeIfNeeded(messageList)

        // 更新があれば更新
        // TODO
    }
}