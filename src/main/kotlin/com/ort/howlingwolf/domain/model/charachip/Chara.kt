package com.ort.howlingwolf.domain.model.charachip

data class Chara(
    val id: Int,
    val charaName: CharaName,
    val charachipId: Int,
    val defaultMessage: CharaDefaultMessage,
    val display: CharaSize,
    val faceList: List<CharaFace>
) {
}