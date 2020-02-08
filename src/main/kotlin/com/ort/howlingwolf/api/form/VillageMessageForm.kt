package com.ort.howlingwolf.api.form

data class VillageMessageForm(
    val from: Long?
) {
    constructor() : this(null)
}
