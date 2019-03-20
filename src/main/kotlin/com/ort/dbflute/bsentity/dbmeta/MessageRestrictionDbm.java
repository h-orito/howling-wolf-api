package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of message_restriction. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MessageRestrictionDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MessageRestrictionDbm _instance = new MessageRestrictionDbm();
    private MessageRestrictionDbm() {}
    public static MessageRestrictionDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getVillageId(), (et, vl) -> ((MessageRestriction)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getSkillCode(), (et, vl) -> {
            CDef.Skill cls = (CDef.Skill)gcls(et, columnSkillCode(), vl);
            if (cls != null) {
                ((MessageRestriction)et).setSkillCodeAsSkill(cls);
            } else {
                ((MessageRestriction)et).mynativeMappingSkillCode((String)vl);
            }
        }, "skillCode");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getMessageTypeCode(), (et, vl) -> {
            CDef.MessageType cls = (CDef.MessageType)gcls(et, columnMessageTypeCode(), vl);
            if (cls != null) {
                ((MessageRestriction)et).setMessageTypeCodeAsMessageType(cls);
            } else {
                ((MessageRestriction)et).mynativeMappingMessageTypeCode((String)vl);
            }
        }, "messageTypeCode");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getMessageMaxNum(), (et, vl) -> ((MessageRestriction)et).setMessageMaxNum(cti(vl)), "messageMaxNum");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getMessageMaxLength(), (et, vl) -> ((MessageRestriction)et).setMessageMaxLength(cti(vl)), "messageMaxLength");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getRegisterDatetime(), (et, vl) -> ((MessageRestriction)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getRegisterTrace(), (et, vl) -> ((MessageRestriction)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getUpdateDatetime(), (et, vl) -> ((MessageRestriction)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((MessageRestriction)et).getUpdateTrace(), (et, vl) -> ((MessageRestriction)et).setUpdateTrace((String)vl), "updateTrace");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((MessageRestriction)et).getMessageType(), (et, vl) -> ((MessageRestriction)et).setMessageType((OptionalEntity<MessageType>)vl), "messageType");
        setupEfpg(_efpgMap, et -> ((MessageRestriction)et).getSkill(), (et, vl) -> ((MessageRestriction)et).setSkill((OptionalEntity<Skill>)vl), "skill");
        setupEfpg(_efpgMap, et -> ((MessageRestriction)et).getVillage(), (et, vl) -> ((MessageRestriction)et).setVillage((OptionalEntity<Village>)vl), "village");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "message_restriction";
    protected final String _tableDispName = "MESSAGE_RESTRICTION";
    protected final String _tablePropertyName = "messageRestriction";
    protected final TableSqlName _tableSqlName = new TableSqlName("MESSAGE_RESTRICTION", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "village", null, null, false);
    protected final ColumnInfo _columnSkillCode = cci("SKILL_CODE", "SKILL_CODE", null, null, String.class, "skillCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "skill", null, CDef.DefMeta.Skill, false);
    protected final ColumnInfo _columnMessageTypeCode = cci("MESSAGE_TYPE_CODE", "MESSAGE_TYPE_CODE", null, null, String.class, "messageTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "messageType", null, CDef.DefMeta.MessageType, false);
    protected final ColumnInfo _columnMessageMaxNum = cci("MESSAGE_MAX_NUM", "MESSAGE_MAX_NUM", null, null, Integer.class, "messageMaxNum", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnMessageMaxLength = cci("MESSAGE_MAX_LENGTH", "MESSAGE_MAX_LENGTH", null, null, Integer.class, "messageMaxLength", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageId() { return _columnVillageId; }
    /**
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to skill, classification=Skill}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSkillCode() { return _columnSkillCode; }
    /**
     * MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to message_type, classification=MessageType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageTypeCode() { return _columnMessageTypeCode; }
    /**
     * MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageMaxNum() { return _columnMessageMaxNum; }
    /**
     * MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageMaxLength() { return _columnMessageMaxLength; }
    /**
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterTrace() { return _columnRegisterTrace; }
    /**
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateTrace() { return _columnUpdateTrace; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnVillageId());
        ls.add(columnSkillCode());
        ls.add(columnMessageTypeCode());
        ls.add(columnMessageMaxNum());
        ls.add(columnMessageMaxLength());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterTrace());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateTrace());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnVillageId());
        ls.add(columnSkillCode());
        ls.add(columnMessageTypeCode());
        return hpcpui(ls);
    }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return true; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMessageType() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMessageTypeCode(), MessageTypeDbm.getInstance().columnMessageTypeCode());
        return cfi("FK_MESSAGE_RESTRICTION_MESSAGE_TYPE", "messageType", this, MessageTypeDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "messageRestrictionList", false);
    }
    /**
     * SKILL by my SKILL_CODE, named 'skill'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignSkill() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnSkillCode(), SkillDbm.getInstance().columnSkillCode());
        return cfi("FK_MESSAGE_RESTRICTION_SKILL", "skill", this, SkillDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "messageRestrictionList", false);
    }
    /**
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillage() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageId(), VillageDbm.getInstance().columnVillageId());
        return cfi("FK_MESSAGE_RESTRICTION_VILLAGE", "village", this, VillageDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "messageRestrictionList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterTrace(), columnUpdateDatetime(), columnUpdateTrace()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterTrace(), columnUpdateDatetime(), columnUpdateTrace()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateTrace()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.MessageRestriction"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.MessageRestrictionCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.MessageRestrictionBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MessageRestriction> getEntityType() { return MessageRestriction.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public MessageRestriction newEntity() { return new MessageRestriction(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MessageRestriction)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MessageRestriction)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
