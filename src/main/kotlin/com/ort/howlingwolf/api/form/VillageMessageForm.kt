package com.ort.howlingwolf.api.form

data class VillageMessageForm(
    val message_type_list: List<String>? = null,
    val participant_id_list: List<Int>? = null,
    val from: Long? = null,
    val keyword: String? = null,
    val page_size: Int? = null,
    val page_num: Int? = null,
    val is_disp_latest: Boolean? = null
)
