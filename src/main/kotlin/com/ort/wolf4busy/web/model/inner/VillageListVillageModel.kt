package com.ort.wolf4busy.web.model.inner

data class VillageListVillageModel(
        val id: Int,
        val name: String,
        val status: String,
        val talkType: String,
        val dayProgress: String,
        val participateNum: Int,
        val participateCapacity: Int,
        val spectateNum: Int,
        val creatorName: String,
        val comment: String
) {
}