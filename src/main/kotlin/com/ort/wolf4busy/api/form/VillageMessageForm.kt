package com.ort.wolf4busy.api.form

data class VillageMessageForm(
    val from: Long?
) {
    constructor() : this(null)
}
