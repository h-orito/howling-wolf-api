package com.ort.wolf4busy.application.service

import com.ort.wolf4busy.domain.model.village.Village
import com.ort.wolf4busy.domain.model.village.Villages
import com.ort.wolf4busy.fw.security.Wolf4busyUser
import com.ort.wolf4busy.infrastructure.datasource.village.VillageDataSource
import org.springframework.stereotype.Service

@Service
class VillageService(
    val villageDataSource: VillageDataSource
) {

    /**
     * 村一覧取得
     * @param user 入力した場合、参加している村一覧
     * @return Villages
     */
    fun findVillages(user: Wolf4busyUser? = null): Villages = villageDataSource.findVillages(user)

    /**
     * 村一覧取得
     * @param villageIdList 村IDリスト
     * @return Villages
     */
    fun findVillages(villageIdList: List<Int>): Villages = villageDataSource.findVillages(villageIdList)

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
