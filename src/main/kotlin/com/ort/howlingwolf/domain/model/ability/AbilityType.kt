package com.ort.howlingwolf.domain.model.ability

import com.ort.dbflute.allcommon.CDef

data class AbilityType(
    val code: String,
    val name: String
) {

    constructor(
        cdef: CDef.AbilityType
    ) : this(
        code = cdef.code(),
        name = cdef.alias()
    )

    companion object {
        operator fun invoke(abilityTypeCode: String): AbilityType {
            val cdefAbility = checkNotNull(CDef.AbilityType.codeOf(abilityTypeCode))
            return AbilityType(cdefAbility)
        }
    }

    fun toCdef(): CDef.AbilityType = CDef.AbilityType.codeOf(code)
}