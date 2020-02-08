package com.ort.howlingwolf.infrastructure.datasource.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ort.dbflute.allcommon.CDef
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.time.ZoneOffset

@Repository
class MessageLatestDatetimeDataSource {

    fun initSet(villageId: Int, datetime: LocalDateTime) {
        val ref: DatabaseReference = getDatabaseReference(villageId)

        val epocMilli: Long = datetime.toInstant(ZoneOffset.ofHours(+9)).toEpochMilli()
        val datetimes: Map<String, Long> = mapOf(
            CDef.MessageType.通常発言.code() to epocMilli,
            CDef.MessageType.人狼の囁き.code() to epocMilli
        )
        ref.setValueAsync(datetimes)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun getDatabaseReference(villageId: Int): DatabaseReference {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        return database.getReference("message_datetime/${getVillageIdString(villageId)}/")
    }

    private fun getVillageIdString(villageId: Int): String {
        return String.format("village%05d", villageId)
    }

}