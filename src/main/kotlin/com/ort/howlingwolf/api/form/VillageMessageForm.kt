package com.ort.howlingwolf.api.form

data class VillageMessageForm(
    val from: Long?,
    val page_size: Int?,
    val page_num: Int?

) {
    constructor() : this(null, null, null)
}
