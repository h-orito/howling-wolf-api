package com.ort.howlingwolf.api.form

data class ReservedVillageListForm(
    val limit: Int?
) {
    constructor() : this(null)
}
