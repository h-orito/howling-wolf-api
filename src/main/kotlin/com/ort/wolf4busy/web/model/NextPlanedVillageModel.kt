package com.ort.wolf4busy.web.model

import java.time.LocalDateTime
import java.time.LocalTime

data class NextPlanedVillageModel(
    /** 自動作成予定の村 */
    val nextVillage: NextPlanedVillageDetailModel
)

data class NextPlanedVillageDetailModel(
    /** 作成予定日時 */
    val createDatetime: LocalDateTime,
    /** 開始予定日時 */
    val startDatetime: LocalDateTime,
    /** 閲覧可能開始時間 */
    val viewableStartDatetime: LocalTime,
    /** 閲覧可能終了時間 */
    val viewableEndDatetime: LocalTime,
    /** 発言可能開始時間 */
    val sayableStartDatetime: LocalTime,
    /** 発言可能終了時間 */
    val sayableEndDatetime: LocalTime,
    /** 人数下限 */
    val personMin: Int,
    /** 人数上限 */
    val personMax: Int,
    /** 編成 */
    val organization: String,
    /** 現在の参加予定者数 */
    val participateNum: Int
)