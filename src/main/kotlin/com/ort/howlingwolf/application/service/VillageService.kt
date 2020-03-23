package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.Villages
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import com.ort.howlingwolf.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service

@Service
class VillageService(
    val villageDataSource: VillageDataSource
) {

    /**
     * 村一覧取得
     * @param user 入力した場合、参加している村一覧
     * @param villageStatusList 入力した場合、そのステータスで絞り込む
     * @param isAutoGenerate 指定した場合、自動生成村orそれ以外で絞り込む
     * @return Villages
     */
    fun findVillages(
        user: HowlingWolfUser? = null,
        villageStatusList: List<VillageStatus>? = listOf(),
        isAutoGenerate: Boolean? = null
    ): Villages = villageDataSource.findVillages(user, villageStatusList, isAutoGenerate)

    /**
     * 村一覧取得
     * @param villageIdList 村IDリスト
     * @return Villages
     */
    fun findVillages(villageIdList: List<Int>): Villages = villageDataSource.findVillages(villageIdList)

    /**
     * 村一覧（詳細）取得
     * @param villageIdList 村IDリスト
     * @return Villages
     */
    fun findVillagesAsDetail(villageIdList: List<Int>): Villages = villageDataSource.findVillagesAsDetail(villageIdList)

    /**
     * 村取得
     * @param villageId villageId
     * @return Village
     */
    fun findVillage(villageId: Int, excludeGonePlayer: Boolean = true): Village =
        villageDataSource.findVillage(villageId, excludeGonePlayer)

    /**
     * 村登録
     * @param village village
     * @return villageId
     */
    fun registerVillage(village: Village): Village = villageDataSource.registerVillage(village)

    /**
     * 差分更新
     *
     * @param before village
     * @param after village
     */
    fun updateVillageDifference(before: Village, after: Village): Village = villageDataSource.updateDifference(before, after)
}
