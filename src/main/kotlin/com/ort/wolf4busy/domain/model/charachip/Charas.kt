package com.ort.wolf4busy.domain.model.charachip

data class Charas(
    val list: List<Chara>
) {
    fun chara(id: Int): Chara = list.first { it.id == id }
}

