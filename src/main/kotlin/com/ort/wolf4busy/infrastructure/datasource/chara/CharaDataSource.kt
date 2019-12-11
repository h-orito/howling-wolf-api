package com.ort.wolf4busy.infrastructure.datasource.chara

import com.ort.dbflute.exbhv.CharaBhv
import com.ort.dbflute.exentity.Chara
import com.ort.wolf4busy.domain.model.charachip.*
import org.springframework.stereotype.Repository

@Repository
class CharaDataSource(
    val charaBhv: CharaBhv
) {
    fun selectCharaList(charachipId: Int): Charas {
        val charaList = charaBhv.selectList {
            it.query().setCharaGroupId_Equal(charachipId)
        }
        charaBhv.loadCharaImage(charaList) {
            it.query().queryFaceType().addOrderBy_DispOrder_Asc()
        }
        return Charas(charaList.map { convertCharaToChara(it) })
    }

    fun selectCharaList(charachips: Charachips): Charas {
        val charaList = charaBhv.selectList {
            it.query().setCharaGroupId_InScope(charachips.list.map { charachip -> charachip.id })
        }
        charaBhv.loadCharaImage(charaList) {
            it.query().queryFaceType().addOrderBy_DispOrder_Asc()
        }
        return Charas(charaList.map { convertCharaToChara(it) })
    }

    fun selectChara(charaId: Int): com.ort.wolf4busy.domain.model.charachip.Chara {
        val chara = charaBhv.selectEntityWithDeletedCheck {
            it.query().setCharaId_Equal(charaId)
        }
        charaBhv.loadCharaImage(chara) {
            it.query().queryFaceType().addOrderBy_DispOrder_Asc()
        }
        return convertCharaToChara(chara)
    }

    fun selectDummyChara(charaChipId: Int): com.ort.wolf4busy.domain.model.charachip.Chara {
        val chara = charaBhv.selectEntityWithDeletedCheck {
            it.query().setCharaGroupId_Equal(charaChipId)
            it.query().addOrderBy_DefaultJoinMessage_Asc().withNullsLast()
            it.query().addOrderBy_CharaId_Asc()
            it.fetchFirst(1)
        }
        charaBhv.loadCharaImage(chara) {
            it.query().queryFaceType().addOrderBy_DispOrder_Asc()
        }
        return convertCharaToChara(chara)
    }

    // ===================================================================================
    //                                                                             Convert
    //                                                                           =========
    private fun convertCharaToChara(chara: Chara): com.ort.wolf4busy.domain.model.charachip.Chara {
        return Chara(
            id = chara.charaId,
            charaName = CharaName(
                name = chara.charaName,
                shortName = chara.charaShortName
            ),
            charachipId = chara.charaGroupId,
            defaultMessage = CharaDefaultMessage(
                joinMessage = chara.defaultJoinMessage,
                firstDayMessage = chara.defaultFirstdayMessage
            ),
            display = CharaSize(
                width = chara.displayWidth,
                height = chara.displayHeight
            ),
            faceList = chara.charaImageList.map { image ->
                CharaFace(
                    type = image.faceTypeCode,
                    name = image.faceTypeCodeAsFaceType.alias(),
                    imageUrl = image.charaImgUrl
                )
            }
        )
    }
}