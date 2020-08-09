package com.ort.howlingwolf.infrastructure.datasource.coming_out

import com.ort.dbflute.exbhv.ComingOutBhv
import com.ort.dbflute.exentity.ComingOut
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts
import org.springframework.stereotype.Repository

@Repository
class ComingOutDataSource(
    private val comingOutBhv: ComingOutBhv
) {

    fun register(villageParticipantId: Int, comingOuts: ComingOuts) {
        delete(villageParticipantId)
        comingOuts.list.forEach {
            val entity = ComingOut()
            entity.villagePlayerId = villageParticipantId
            entity.skillCodeAsSkill = it.skill.toCdef()
            comingOutBhv.insert(entity)
        }
    }

    fun delete(villageParticipantId: Int) {
        comingOutBhv.queryDelete {
            it.query().setVillagePlayerId_Equal(villageParticipantId)
        }
    }
}