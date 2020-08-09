package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.skill.Skill
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOut
import com.ort.howlingwolf.domain.model.village.participant.coming_out.ComingOuts
import com.ort.howlingwolf.infrastructure.datasource.coming_out.ComingOutDataSource
import org.springframework.stereotype.Service

@Service
class ComingOutService(
    private val comingOutDataSource: ComingOutDataSource
) {

    fun registerComingOut(
        participantId: Int,
        skillList: List<Skill>
    ) = comingOutDataSource.register(
        participantId,
        ComingOuts(list = skillList.map { ComingOut(it) })
    )

    fun deleteComingOut(participantId: Int) = comingOutDataSource.delete(participantId)
}