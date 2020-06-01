package com.ort.howlingwolf.domain.model.message

import com.ort.dbflute.allcommon.CDef
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.charachip.CharaFace
import com.ort.howlingwolf.domain.model.dead.Dead
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.setting.VillageMessageRestrict
import com.ort.howlingwolf.domain.model.village.setting.VillageMessageRestricts
import com.ort.howlingwolf.dummy.DummyDomainModelCreator
import com.ort.howlingwolf.fw.exception.HowlingWolfBadRequestException
import com.ort.howlingwolf.fw.exception.HowlingWolfBusinessException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class SayTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_isAvailableSay_参加していない() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage()
        val participant = null

        // ## Act ##
        val isAvailableSay = Say.isAvailableSay(village, participant)

        // ## Assert ##
        assertThat(isAvailableSay).isFalse()
    }

    @Test
    fun test_isAvailableSay_生存() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()

        // ## Act ##
        val isAvailableSay = Say.isAvailableSay(village, participant)

        // ## Assert ##
        assertThat(isAvailableSay).isTrue()
    }

    @Test
    fun test_isAvailableSay_突然死_進行中() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中)
        )
        val participant = DummyDomainModelCreator.createDummyDeadWolf().copy(
            dead = Dead(CDef.DeadReason.突然, DummyDomainModelCreator.createDummyVillageDay())
        )

        // ## Act ##
        val isAvailableSay = Say.isAvailableSay(village, participant)

        // ## Assert ##
        assertThat(isAvailableSay).isFalse()
    }

    @Test
    fun test_isAvailableSay_突然死_エピローグ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.エピローグ)
        )
        val participant = DummyDomainModelCreator.createDummyDeadWolf().copy(
            dead = Dead(CDef.DeadReason.突然, DummyDomainModelCreator.createDummyVillageDay())
        )

        // ## Act ##
        val isAvailableSay = Say.isAvailableSay(village, participant)

        // ## Assert ##
        assertThat(isAvailableSay).isTrue()
    }

    @Test
    fun test_isAvailableSay_廃村() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.廃村)
        )
        val participant = DummyDomainModelCreator.createDummyDeadWolf()

        // ## Act ##
        val isAvailableSay = Say.isAvailableSay(village, participant)

        // ## Assert ##
        assertThat(isAvailableSay).isFalse()
    }

    @Test
    fun test_assertSay_発言制限OK() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                    messageRestrict = VillageMessageRestricts()
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().minusMinutes(30L)
                    ),
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val chara = DummyDomainModelCreator.createDummyChara().copy(
            id = participant.charaId,
            faceList = listOf(
                CharaFace(CDef.FaceType.通常.code(), CDef.FaceType.通常.alias(), "url")
            )
        )
        val latestDayMesasgeList = (1..19).map {
            DummyDomainModelCreator.createDummyMessage().copy(
                content = DummyDomainModelCreator.createDummyMessageContent().copy(
                    type = MessageType(CDef.MessageType.通常発言)
                )
            )
        }
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            count = null,
            text = "hoge",
            faceCode = CDef.FaceType.通常.code()
        )

        // ## Act ##
        // ## Assert ##
        Say.assertSay(village, participant, chara, latestDayMesasgeList, messageContent)
    }

    @Test(expected = HowlingWolfBusinessException::class)
    fun test_assertSay_発言制限NG_回数() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                    messageRestrict = VillageMessageRestricts()
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().minusMinutes(30L)
                    ),
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val chara = DummyDomainModelCreator.createDummyChara().copy(
            id = participant.charaId,
            faceList = listOf(
                CharaFace(CDef.FaceType.通常.code(), CDef.FaceType.通常.alias(), "url")
            )
        )
        val latestDayMesasgeList = (1..20).map {
            DummyDomainModelCreator.createDummyMessage().copy(
                content = DummyDomainModelCreator.createDummyMessageContent().copy(
                    type = MessageType(CDef.MessageType.通常発言)
                )
            )
        }
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            count = null,
            text = "hoge",
            faceCode = CDef.FaceType.通常.code()
        )

        // ## Act ##
        // ## Assert ##
        Say.assertSay(village, participant, chara, latestDayMesasgeList, messageContent)
    }

    @Test(expected = HowlingWolfBadRequestException::class)
    fun test_assertSay_発言制限NG_長さ() {
        // ## Arrange ##
        val village = DummyDomainModelCreator.createDummyVillage().copy(
            status = VillageStatus(CDef.VillageStatus.進行中),
            setting = DummyDomainModelCreator.createDummyVillageSettings().copy(
                rules = DummyDomainModelCreator.createDummyVillageRules().copy(
                    messageRestrict = VillageMessageRestricts(
                        true,
                        listOf(
                            VillageMessageRestrict(
                                type = MessageType(CDef.MessageType.通常発言),
                                count = 20,
                                length = 10
                            ),
                            VillageMessageRestrict(
                                type = MessageType(CDef.MessageType.人狼の囁き),
                                count = 40,
                                length = 200
                            )
                        )
                    )
                )
            ),
            day = VillageDays(
                listOf(
                    DummyDomainModelCreator.createDummyVillageDay().copy(
                        dayChangeDatetime = LocalDateTime.now().minusMinutes(30L)
                    ),
                    DummyDomainModelCreator.createDummyVillageDay()
                )
            )
        )
        val participant = DummyDomainModelCreator.createDummyAliveVillager()
        val chara = DummyDomainModelCreator.createDummyChara().copy(
            id = participant.charaId,
            faceList = listOf(
                CharaFace(CDef.FaceType.通常.code(), CDef.FaceType.通常.alias(), "url")
            )
        )
        val latestDayMessageList = (1..19).map {
            DummyDomainModelCreator.createDummyMessage().copy(
                content = DummyDomainModelCreator.createDummyMessageContent().copy(
                    type = MessageType(CDef.MessageType.通常発言)
                )
            )
        }
        val messageContent = MessageContent(
            type = MessageType(CDef.MessageType.通常発言),
            num = null,
            count = null,
            text = "12345678901",
            faceCode = CDef.FaceType.通常.code()
        )

        // ## Act ##
        // ## Assert ##
        Say.assertSay(village, participant, chara, latestDayMessageList, messageContent)
    }
}