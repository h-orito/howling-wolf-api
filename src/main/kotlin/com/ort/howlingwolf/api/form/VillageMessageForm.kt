package com.ort.howlingwolf.api.form

data class VillageMessageForm(
    val message_type_list: List<String>?,
    val participant_id_list: List<Int>?,
    val from: Long?,
    val keyword: String?,
    val page_size: Int?,
    val page_num: Int?
) {
    constructor() : this(null, null, null, null, null, null)
}
