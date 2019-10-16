package com.ort.wolf4busy.api.view.village

import com.ort.wolf4busy.domain.model.village.message.VillageMessage

data class VillageMessageView(
        val messageList: List<VillageMessage>
) {
}