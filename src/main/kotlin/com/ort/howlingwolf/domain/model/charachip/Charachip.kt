package com.ort.howlingwolf.domain.model.charachip

data class Charachip(
    val id: Int,
    val name: String,
    val designer: Designer,
    val descriptionUrl: String,
    val charaIdList: List<Int>
) {
}