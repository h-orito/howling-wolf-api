package com.ort.howlingwolf.infrastructure.datasource.message

import com.ort.dbflute.allcommon.CDef
import com.ort.dbflute.exbhv.MessageBhv
import com.ort.dbflute.exbhv.VillageDayBhv
import com.ort.dbflute.exbhv.VillagePlayerBhv
import com.ort.dbflute.exentity.VillageDay
import com.ort.dbflute.exentity.VillagePlayer
import com.ort.howlingwolf.HowlingWolfTest
import com.ort.howlingwolf.domain.model.message.Message
import com.ort.howlingwolf.domain.model.message.MessageContent
import com.ort.howlingwolf.domain.model.message.MessageType
import com.ort.howlingwolf.domain.model.village.VillageDays
import com.ort.howlingwolf.domain.model.village.VillageStatus
import com.ort.howlingwolf.domain.model.village.participant.VillageParticipants
import com.ort.howlingwolf.domain.model.village.setting.*
import com.ort.howlingwolf.infrastructure.datasource.village.VillageDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class MessageDataSourceTest : HowlingWolfTest() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    lateinit var villagePlayerBhv: VillagePlayerBhv
    @Autowired
    lateinit var villageDayBhv: VillageDayBhv
    @Autowired
    lateinit var messageBhv: MessageBhv
    @Autowired
    lateinit var messageDataSource: MessageDataSource
    @Autowired
    lateinit var villageDataSource: VillageDataSource

    // ===================================================================================
    //                                                                                Test
    //                                                                           =========
    @Test
    fun test_registerMessage() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village.id)
        village = villageDataSource.findVillage(village.id)
        val participant = village.participant.memberList[0]
        val message = Message.createSayMessage(
            from = participant,
            villageDayId = village.day.latestDay().id,
            messageContent = MessageContent(
                type = MessageType(CDef.MessageType.通常発言),
                num = 1,
                text = "dummy message text",
                faceCode = CDef.FaceType.通常.code()
            )
        )

        // ## Act ##
        messageDataSource.registerMessage(village.id, message)

        // ## Assert ##
        val list = messageBhv.selectList { it.query().setVillageId_Equal(village.id) }
        assertThat(list).isNotEmpty
    }

    @Test
    fun test_findMessages() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village.id)
        insertVillageDay(village.id)
        village = villageDataSource.findVillage(village.id)
        val participant = village.participant.memberList[0]
        val message = Message.createSayMessage(
            from = participant,
            villageDayId = village.day.latestDay().id,
            messageContent = MessageContent(
                type = MessageType(CDef.MessageType.通常発言),
                num = 1,
                text = "dummy message text",
                faceCode = CDef.FaceType.通常.code()
            )
        )
        messageDataSource.registerMessage(village.id, message)

        // ## Act ##
        var messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = null
        )

        // ## Assert ##
        assertThat(messages.list).isNotEmpty
        val unixTimeMilli = messages.list.first().time.unixTimeMilli

        // ## Act ##
        messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.prologueDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = null
        )

        // ## Assert ##
        assertThat(messages.list).`as`("別の日なので取得できない").isEmpty()

        // ## Act ##
        messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.死者の呻き),
            participant = null,
            from = null
        )

        // ## Assert ##
        assertThat(messages.list).`as`("通常発言は取得できない").isEmpty()

        // ## Act ##
        messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = unixTimeMilli
        )

        // ## Assert ##
        assertThat(messages.list).`as`("より新しい発言はないので取得できない").isEmpty()

        // ## Act ##
        messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = unixTimeMilli - 1
        )

        // ## Assert ##
        assertThat(messages.list).isNotEmpty
    }

    @Test
    fun test_findMessage() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village.id)
        village = villageDataSource.findVillage(village.id)
        val participant = village.participant.memberList[0]
        messageDataSource.registerMessage(
            village.id, Message.createSayMessage(
                from = participant,
                villageDayId = village.day.latestDay().id,
                messageContent = MessageContent(
                    type = MessageType(CDef.MessageType.通常発言),
                    num = 1,
                    text = "dummy message text",
                    faceCode = CDef.FaceType.通常.code()
                )
            )
        )
        val messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = null
        )
        val num = messages.list.first().content.num

        // ## Act ##
        val message = messageDataSource.findMessage(village.id, CDef.MessageType.通常発言, num!!)

        // ## Assert ##
        assertThat(message).isNotNull
    }

    @Test
    fun test_selectParticipateDayMessageList() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village.id)
        insertVillagePlayer(village.id)
        village = villageDataSource.findVillage(village.id)
        val participant = village.participant.memberList[0]
        val participant2 = village.participant.memberList[1]
        messageDataSource.registerMessage(
            village.id, Message.createSayMessage(
                from = participant,
                villageDayId = village.day.latestDay().id,
                messageContent = MessageContent(
                    type = MessageType(CDef.MessageType.通常発言),
                    num = 1,
                    text = "dummy message text",
                    faceCode = CDef.FaceType.通常.code()
                )
            )
        )

        // ## Act ##
        var messageList = messageDataSource.selectParticipateDayMessageList(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            participant = participant
        )

        // ## Assert ##
        assertThat(messageList).isNotEmpty

        // ## Act ##
        messageList = messageDataSource.selectParticipateDayMessageList(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            participant = participant2
        )

        // ## Assert ##
        assertThat(messageList).isEmpty()
    }

    @Test
    fun test_updateDifference() {
        // ## Arrange ##
        var village = villageDataSource.registerVillage(createDummyVillageParam())
        insertVillagePlayer(village.id)
        village = villageDataSource.findVillage(village.id)
        val participant = village.participant.memberList[0]
        val message = Message.createSayMessage(
            from = participant,
            villageDayId = village.day.latestDay().id,
            messageContent = MessageContent(
                type = MessageType(CDef.MessageType.通常発言),
                num = 1,
                text = "dummy message text",
                faceCode = CDef.FaceType.通常.code()
            )
        )
        messageDataSource.registerMessage(village.id, message)
        val before = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = null
        )
        val after = before.copy(list = before.list + message)

        // ## Act ##
        messageDataSource.updateDifference(village.id, before, after)

        // ## Assert ##
        val messages = messageDataSource.findMessages(
            villageId = village.id,
            villageDayId = village.day.latestDay().id,
            messageTypeList = listOf(CDef.MessageType.通常発言),
            participant = null,
            from = null
        )
        assertThat(messages.list.size).isEqualTo(2)
    }

    // ===================================================================================
    //                                                                        Assist Logic
    //                                                                        ============
    private fun insertVillagePlayer(villageId: Int): Int {
        val villagePlayer = VillagePlayer()
        villagePlayer.villageId = villageId
        villagePlayer.playerId = 1
        villagePlayer.charaId = 1
        villagePlayer.requestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.secondRequestSkillCodeAsSkill = CDef.Skill.おまかせ
        villagePlayer.isSpectator = false
        villagePlayer.isGone = false
        villagePlayer.isDead = false
        villagePlayerBhv.insert(villagePlayer)
        return villagePlayer.villagePlayerId
    }

    private fun insertVillageDay(villageId: Int): Int {
        val villageDay = VillageDay()
        villageDay.villageId = villageId
        villageDay.day = 1
        villageDay.noonnightCodeAsNoonnight = CDef.Noonnight.昼
        villageDay.daychangeDatetime = LocalDateTime.now()
        villageDayBhv.insert(villageDay)
        return villageDay.villageDayId
    }

    private fun createDummyVillageParam(): com.ort.howlingwolf.domain.model.village.Village {
        return com.ort.howlingwolf.domain.model.village.Village(
            id = 1,
            name = "dummy_village_name",
            creatorPlayerId = 1,
            status = VillageStatus(CDef.VillageStatus.プロローグ),
            setting = VillageSettings(
                capacity = PersonCapacity(
                    min = 10,
                    max = 16
                ),
                time = VillageTime(
                    termType = CDef.Term.長期.code(),
                    startDatetime = LocalDateTime.now().plusDays(1L).withNano(0),
                    dayChangeIntervalSeconds = 24 * 60 * 60
                ),
                charachip = VillageCharachip(
                    dummyCharaId = 1,
                    charachipId = 1
                ),
                organizations = VillageOrganizations(),
                rules = VillageRules(
                    openVote = false,
                    availableSkillRequest = true,
                    availableSpectate = false,
                    openSkillInGrave = false,
                    visibleGraveMessage = false,
                    availableSuddenlyDeath = true,
                    availableCommit = false,
                    messageRestrict = VillageMessageRestricts()
                ),
                password = VillagePassword(
                    joinPasswordRequired = false,
                    joinPassword = null
                )
            ),
            participant = VillageParticipants(
                count = 1,
                memberList = listOf()
            ),
            spectator = VillageParticipants(
                count = 0,
                memberList = listOf()
            ),
            day = VillageDays(
                dayList = listOf()
            ),
            winCamp = null
        )
    }
}