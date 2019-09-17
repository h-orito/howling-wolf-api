package com.ort.wolf4busy.infrastructure.datasource.charachip

import com.ort.dbflute.exbhv.CharaBhv
import com.ort.dbflute.exbhv.CharaGroupBhv
import com.ort.dbflute.exentity.Chara
import com.ort.dbflute.exentity.CharaGroup
import com.ort.wolf4busy.domain.model.charachip.*
import org.springframework.stereotype.Repository
import java.util.stream.Collectors

@Repository
class CharachipDataSource(
        val charaGroupBhv: CharaGroupBhv,
        val charaBhv: CharaBhv
) {

    fun selectCharachips(): Charachips {
        val charaGroupList = charaGroupBhv.selectList {
            it.setupSelect_Designer()
            it.query().addOrderBy_CharaGroupId_Asc()
        }
        charaGroupBhv.load(charaGroupList) { loader ->
            loader.loadChara { charaCB ->
                charaCB.query().addOrderBy_DefaultJoinMessage_Asc().withNullsLast()
            }.withNestedReferrer { charaLoader ->
                charaLoader.loadCharaImage { charaImageCB -> charaImageCB.query().setFaceTypeCode_Equal_通常() }
            }
        }
        return convertCharaGroupListToCharaChips(charaGroupList)
    }

    fun selectCharachip(charaChipId: Int): Charachip {
        val charaGroup = charaGroupBhv.selectEntityWithDeletedCheck {
            it.setupSelect_Designer()
            it.query().setCharaGroupId_Equal(charaChipId)
        }
        charaGroupBhv.load(charaGroup) { loader ->
            loader.loadChara { charaCB ->
                charaCB.query().addOrderBy_DefaultJoinMessage_Asc().withNullsLast()
                charaCB.query().addOrderBy_CharaId_Asc()
            }.withNestedReferrer { charaLoader ->
                charaLoader.loadCharaImage {
                    it.query().queryFaceType().addOrderBy_DispOrder_Asc()
                }
            }
        }
        return convertCharaGroupToCharaChip(charaGroup)
    }

    fun selectChara(charaChipId: Int, charaId: Int): com.ort.wolf4busy.domain.model.charachip.Chara {
        val chara = charaBhv.selectEntityWithDeletedCheck {
            it.query().setCharaId_Equal(charaId)
            it.query().setCharaGroupId_Equal(charaChipId)
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
    private fun convertCharaGroupListToCharaChips(charaGroupList: List<CharaGroup>): Charachips {
        return Charachips(
                charachipList = charaGroupList.map { convertCharaGroupToCharaChip(it) }
        )
    }

    private fun convertCharaGroupToCharaChip(charaGroup: CharaGroup): Charachip {
        return Charachip(
                id = charaGroup.charaGroupId,
                name = charaGroup.charaGroupName,
                designerId = charaGroup.designerId,
                descriptionUtl = charaGroup.descriptionUrl,
                charaList = charaGroup.charaList.map { convertCharaToChara(it) }
        )
    }

    private fun convertCharaToChara(chara: Chara): com.ort.wolf4busy.domain.model.charachip.Chara {
        return com.ort.wolf4busy.domain.model.charachip.Chara(
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
                            imageUrl = image.charaImgUrl
                    )
                }
        )
    }
}