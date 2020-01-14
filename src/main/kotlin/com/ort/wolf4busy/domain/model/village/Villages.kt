package com.ort.wolf4busy.domain.model.village

data class Villages(
    val villageList: List<Village>
) {

    fun filterNotFinish(): Villages = Villages(villageList.filter { !it.status.isFinished() })

    fun filterFinish(): Villages = Villages(villageList.filter { it.status.isFinished() })
}