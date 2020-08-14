package com.ort.howlingwolf.api.body

data class VillageComingOutBody(
    val skillCode: List<String>?
) {
    constructor() : this(null)
}
