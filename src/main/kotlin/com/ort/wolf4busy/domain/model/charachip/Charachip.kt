package com.ort.wolf4busy.domain.model.charachip

data class Charachip(
    val id: Int,
    val name: String,
    val designerId: Int,
    val descriptionUtl: String,
    val charaList: List<Chara>
) {
}