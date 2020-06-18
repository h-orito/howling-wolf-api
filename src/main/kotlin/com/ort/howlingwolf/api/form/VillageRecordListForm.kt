package com.ort.howlingwolf.api.form

data class VillageRecordListForm(
    val vid: List<Int>?
) {
    constructor() : this(null)
}
