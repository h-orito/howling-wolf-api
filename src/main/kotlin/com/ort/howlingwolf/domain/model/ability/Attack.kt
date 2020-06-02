package com.ort.howlingwolf.domain.model.ability

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.domain.model.charachip.Chara
import com.ort.howlingwolf.domain.model.charachip.Charas
import com.ort.howlingwolf.domain.model.daychange.DayChange
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.village.Village
import com.ort.howlingwolf.domain.model.village.ability.VillageAbilities
import com.ort.howlingwolf.domain.model.village.ability.VillageAbility
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipant

object Attack {

    private val ABILITY_TYPE = Ability(CDef.AbilityType.襲撃)

    fun getSelectableTargetList(
        village: Village,
        participant: VillageParticipant?
    ): List<VillageParticipant> {
        participant ?: return listOf()

        return if (village.day.latestDay().day == 1) {
            // ダミーキャラ固定
            listOf(village.dummyChara())
        } else {
            // 襲撃対象に選べる & 生存している
            village.participant.memberList.filter {
                !it.skill!!.toCdef().isNotSelectableAttack && it.isAlive()
            }
        }
    }

    fun getSelectingTarget(
        village: Village,
        participant: VillageParticipant?,
        villageAbilities: VillageAbilities
    ): VillageParticipant? {
        participant ?: return null

        // 襲撃能力のある参加者のID
        val attackableParticipantIdList =
            village.participant.memberList.filter { it.skill!!.toCdef().isHasAttackAbility }.map { it.id }

        val targetVillageParticipantId = villageAbilities.list.find {
            it.villageDayId == village.day.latestDay().id
                && it.ability.code == ABILITY_TYPE.code
                && attackableParticipantIdList.contains(it.myselfId)
        }?.targetId
        targetVillageParticipantId ?: return null
        return village.participant.member(targetVillageParticipantId)
    }

    fun getSetMessage(myChara: Chara, targetChara: Chara?): String {
        return "${myChara.charaName.name}が襲撃対象を${targetChara?.charaName?.name ?: "なし"}に設定しました。"
    }

    fun getDefaultAbility(village: Village): VillageAbility? {
        // 進行中のみ
        if (!village.status.isProgress()) return null
        // 最新日id
        val latestVillageDay = village.day.latestDay()
        // 襲撃者は生存している人狼からランダムに
        val wolf = village.participant.filterAlive().findRandom {
            it.skill!!.toCdef().isHasAttackAbility
        } ?: return null // 生存している人狼がいないので襲撃なし

        return if (latestVillageDay.day == 1) { // 1日目はダミー固定
            VillageAbility(
                villageDayId = latestVillageDay.id,
                myselfId = wolf.id,
                targetId = village.dummyChara().id,
                ability = ABILITY_TYPE
            )
        } else { // 2日目以降は生存者からランダム
            val target = village.participant.filterAlive().findRandom {
                !it.skill!!.toCdef().isHasAttackAbility
            } ?: return null // 生存している対象がいないので襲撃なし
            return VillageAbility(
                villageDayId = latestVillageDay.id,
                myselfId = wolf.id,
                targetId = target.id,
                ability = ABILITY_TYPE
            )
        }
    }

    fun process(dayChange: DayChange, charas: Charas): DayChange {
        val latestDay = dayChange.village.day.latestDay()
        val aliveWolf = dayChange.village.participant.findRandom {
            it.isAlive() && it.skill!!.toCdef().isHasAttackAbility
        } ?: return dayChange

        var village = dayChange.village.copy()
        var messages = dayChange.messages.copy()
        dayChange.abilities.list.find {
            it.ability.code == CDef.AbilityType.襲撃.code() && it.targetId != null && it.villageDayId == village.day.yesterday().id
        }?.let { ability ->
            // 襲撃メッセージ
            messages = messages.add(createAttackMessage(village, charas, aliveWolf, ability))
            // 襲撃成功したら死亡
            if (isAttackSuccess(dayChange, ability.targetId!!)) village = village.attackParticipant(ability.targetId, latestDay)
        } ?: return dayChange

        return dayChange.copy(
            village = village,
            messages = messages
        ).setIsChange(dayChange)
    }

    fun isAvailableNoTarget(village: Village): Boolean = village.day.latestDay().day !== 1 // 1日目はダミー固定

    /**
     * 能力行使できるか
     * @param participant 村参加者
     */
    fun isUsable(participant: VillageParticipant): Boolean {
        // 生存していたら行使できる
        return participant.isAlive()
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun isAttackSuccess(dayChange: DayChange, targetId: Int): Boolean {
        // 対象が既に死亡していたら失敗
        if (!dayChange.village.participant.member(targetId).isAlive()) return false
        // 対象が護衛されていたら失敗
        if (dayChange.abilities.list.any { villageAbility ->
                villageAbility.ability.code == CDef.AbilityType.護衛.code()
                    && villageAbility.targetId == targetId
                    && villageAbility.villageDayId == dayChange.village.day.yesterday().id
                    && dayChange.village.participant.member(villageAbility.myselfId).isAlive()
            }) {
            return false
        }
        // TODO 襲撃を耐える役職
        return true
    }

    /**
     * 襲撃メッセージ
     * @param village village
     * @param charas charas
     * @param wolf 狼
     * @param ability ability
     */
    private fun createAttackMessage(
        village: Village,
        charas: Charas,
        wolf: VillageParticipant,
        ability: VillageAbility
    ): Message {
        val fromChara = charas.chara(wolf.charaId)
        val targetChara = charas.chara(village.participant, ability.targetId!!)
        val text = createAttackMessageString(fromChara, targetChara)
        return Message.createAttackPrivateMessage(text, village.day.latestDay().id)
    }

    /**
     * 襲撃メッセージ
     * @param chara 狼
     * @param targetChara 被襲撃者
     */
    private fun createAttackMessageString(chara: Chara, targetChara: Chara): String =
        "${chara.charaName.fullName()}達は、${targetChara.charaName.fullName()}を襲撃した。"
}