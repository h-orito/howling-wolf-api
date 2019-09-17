package com.ort.wolf4busy.infrastructure.datasource.charachip

import com.ort.dbflute.exbhv.VillageBhv
import com.ort.dbflute.exentity.Village
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.wolf4busy.domain.model.dead.Dead
import com.ort.wolf4busy.domain.model.village.VillageStatus
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipant
import com.ort.wolf4busy.domain.model.village.participant.VillageParticipants
import com.ort.wolf4busy.domain.model.village.participant.VillageVisitor
import com.ort.wolf4busy.domain.model.village.participant.VillageVisitors
import org.dbflute.cbean.result.ListResultBean
import org.springframework.stereotype.Repository

@Repository
class VillageDataSource(
        val villageBhv: VillageBhv
) {

    fun selectVillages(): Villages {
        val villageList = villageBhv.selectList {
            it.specify().derivedVillagePlayer().count({ vpCB ->
                vpCB.specify().columnVillagePlayerId()
                vpCB.query().setIsGone_Equal(false)
                vpCB.query().setIsSpectator_Equal(false)
            }, Village.ALIAS_participantCount)
            it.specify().derivedVillagePlayer().count({ vpCB ->
                vpCB.specify().columnVillagePlayerId()
                vpCB.query().setIsGone_Equal(false)
                vpCB.query().setIsSpectator_Equal(true)
            }, Village.ALIAS_visitorCount)
            it.query().addOrderBy_VillageId_Desc()
        }
        return convertVillageListToVillages(villageList)
    }

    fun selectVillage(villageId: Int): com.ort.wolf4busy.domain.model.village.Village {
        val village = villageBhv.selectEntityWithDeletedCheck {
            it.setupSelect_VillageSettingsAsOne()
            it.query().setVillageId_Equal(villageId)
        }
        villageBhv.load(village) { loader ->
            loader.loadVillagePlayer { vpCB ->
                vpCB.setupSelect_Player()
            }
        }

        return convertVillageToVillage(village)
    }

    // ===================================================================================
    //                                                                             Convert
    //                                                                           =========
    private fun convertVillageListToVillages(villageList: ListResultBean<Village>): Villages {
        return Villages(
                villageList = villageList.map { convertVillageToSimpleVillage(it) }
        )
    }

    private fun convertVillageToSimpleVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        return com.ort.wolf4busy.domain.model.village.Village(
                id = village.villageId,
                name = village.villageDisplayName,
                creatorPlayerId = 1, // TODO
                status = VillageStatus(
                        code = village.villageStatusCodeAsVillageStatus.code(),
                        name = village.villageStatusCodeAsVillageStatus.alias()
                ),
                setting = null,
                participant = VillageParticipants(
                        count = village.participantCount
                ),
                visitor = VillageVisitors(
                        count = village.visitorCount
                )
        )
    }

    private fun convertVillageToVillage(village: Village): com.ort.wolf4busy.domain.model.village.Village {
        val participantList = village.villagePlayerList.filter { vp -> vp.isParticipant }
        val visitorList = village.villagePlayerList.filter { vp -> vp.isVisitor }
        return com.ort.wolf4busy.domain.model.village.Village(
                id = village.villageId,
                name = village.villageDisplayName,
                creatorPlayerId = 1, // TODO
                status = VillageStatus(
                        code = village.villageStatusCodeAsVillageStatus.code(),
                        name = village.villageStatusCodeAsVillageStatus.alias()
                ),
                setting = null,
                participant = VillageParticipants(
                        count = participantList.size,
                        memberList = participantList.map { convertVillagePlayerToParticipant(it) }
                ),
                visitor = VillageVisitors(
                        count = visitorList.size,
                        memberList = visitorList.map { convertVillagePlayerToVisitor(it) }
                )
        )
    }

    private fun convertVillagePlayerToParticipant(vp: VillagePlayer): VillageParticipant {
        return VillageParticipant(
                id = vp.villagePlayerId,
                charaId = vp.charaId,
                dead = if (vp.isDead) convertToDeadReasonToDead(vp) else null
        )
    }

    private fun convertVillagePlayerToVisitor(vp: VillagePlayer): VillageVisitor {
        return VillageVisitor(
                id = vp.villagePlayerId,
                charaId = vp.charaId
        )
    }

    private fun convertToDeadReasonToDead(vp: VillagePlayer): Dead {
        val deadReason = vp.deadReasonCodeAsDeadReason
        return Dead(
                code = deadReason.code(),
                reason = deadReason.alias(),
                day = vp.deadDay
        )
    }
}