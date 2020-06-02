package com.ort.howlingwolf.infrastructure.datasource.charachip

import com.ort.dbflute.exbhv.CharaGroupBhv
import com.ort.dbflute.exentity.CharaGroup
import com.ort.howlingwolf.domain.model.charachip.Charachip
import com.ort.howlingwolf.domain.model.charachip.Charachips
import com.ort.howlingwolf.domain.model.charachip.Designer
import org.springframework.stereotype.Repository

@Repository
class CharachipDataSource(
    val charaGroupBhv: CharaGroupBhv
) {
    fun findCharachips(): Charachips {
        val charaGroupList = charaGroupBhv.selectList {
            it.setupSelect_Designer()
            it.query().addOrderBy_CharaGroupId_Asc()
        }
        return convertCharaGroupListToCharaChips(charaGroupList)
    }

    fun findCharachip(charaChipId: Int): Charachip {
        val charaGroup = charaGroupBhv.selectEntityWithDeletedCheck {
            it.setupSelect_Designer()
            it.query().setCharaGroupId_Equal(charaChipId)
        }
        return convertCharaGroupToCharaChip(charaGroup)
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    private fun convertCharaGroupListToCharaChips(charaGroupList: List<CharaGroup>): Charachips {
        return Charachips(
            list = charaGroupList.map { convertCharaGroupToCharaChip(it) }
        )
    }

    private fun convertCharaGroupToCharaChip(charaGroup: CharaGroup): Charachip {
        return Charachip(
            id = charaGroup.charaGroupId,
            name = charaGroup.charaGroupName,
            designer = Designer(
                id = charaGroup.designer.get().designerId,
                name = charaGroup.designer.get().designerName
            ),
            descriptionUrl = charaGroup.descriptionUrl,
            charaIdList = listOf() // dummy
        )
    }
}