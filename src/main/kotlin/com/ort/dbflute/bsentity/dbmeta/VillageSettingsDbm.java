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
 * The DB meta of village_settings. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VillageSettingsDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VillageSettingsDbm _instance = new VillageSettingsDbm();
    private VillageSettingsDbm() {}
    public static VillageSettingsDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VillageSettings)et).getVillageId(), (et, vl) -> ((VillageSettings)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getDummyCharaId(), (et, vl) -> ((VillageSettings)et).setDummyCharaId(cti(vl)), "dummyCharaId");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getStartPersonMinNum(), (et, vl) -> ((VillageSettings)et).setStartPersonMinNum(cti(vl)), "startPersonMinNum");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getPersonMaxNum(), (et, vl) -> ((VillageSettings)et).setPersonMaxNum(cti(vl)), "personMaxNum");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getStartDatetime(), (et, vl) -> ((VillageSettings)et).setStartDatetime(ctldt(vl)), "startDatetime");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getDayChangeIntervalSeconds(), (et, vl) -> ((VillageSettings)et).setDayChangeIntervalSeconds(cti(vl)), "dayChangeIntervalSeconds");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsOpenVote(), (et, vl) -> ((VillageSettings)et).setIsOpenVote((Boolean)vl), "isOpenVote");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsPossibleSkillRequest(), (et, vl) -> ((VillageSettings)et).setIsPossibleSkillRequest((Boolean)vl), "isPossibleSkillRequest");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsAvailableSpectate(), (et, vl) -> ((VillageSettings)et).setIsAvailableSpectate((Boolean)vl), "isAvailableSpectate");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsAvailableSameWolfAttack(), (et, vl) -> ((VillageSettings)et).setIsAvailableSameWolfAttack((Boolean)vl), "isAvailableSameWolfAttack");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsOpenSkillInGrave(), (et, vl) -> ((VillageSettings)et).setIsOpenSkillInGrave((Boolean)vl), "isOpenSkillInGrave");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsVisibleGraveSpectateMessage(), (et, vl) -> ((VillageSettings)et).setIsVisibleGraveSpectateMessage((Boolean)vl), "isVisibleGraveSpectateMessage");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsAvailableSuddonlyDeath(), (et, vl) -> ((VillageSettings)et).setIsAvailableSuddonlyDeath((Boolean)vl), "isAvailableSuddonlyDeath");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsAvailableCommit(), (et, vl) -> ((VillageSettings)et).setIsAvailableCommit((Boolean)vl), "isAvailableCommit");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getIsAvailableGuardSameTarget(), (et, vl) -> ((VillageSettings)et).setIsAvailableGuardSameTarget((Boolean)vl), "isAvailableGuardSameTarget");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getCharacterGroupId(), (et, vl) -> ((VillageSettings)et).setCharacterGroupId(cti(vl)), "characterGroupId");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getJoinPassword(), (et, vl) -> ((VillageSettings)et).setJoinPassword((String)vl), "joinPassword");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getOrganize(), (et, vl) -> ((VillageSettings)et).setOrganize((String)vl), "organize");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getAllowedSecretSayCode(), (et, vl) -> {
            CDef.AllowedSecretSay cls = (CDef.AllowedSecretSay)gcls(et, columnAllowedSecretSayCode(), vl);
            if (cls != null) {
                ((VillageSettings)et).setAllowedSecretSayCodeAsAllowedSecretSay(cls);
            } else {
                ((VillageSettings)et).mynativeMappingAllowedSecretSayCode((String)vl);
            }
        }, "allowedSecretSayCode");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getRegisterDatetime(), (et, vl) -> ((VillageSettings)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getRegisterTrace(), (et, vl) -> ((VillageSettings)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getUpdateDatetime(), (et, vl) -> ((VillageSettings)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((VillageSettings)et).getUpdateTrace(), (et, vl) -> ((VillageSettings)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((VillageSettings)et).getAllowedSecretSay(), (et, vl) -> ((VillageSettings)et).setAllowedSecretSay((OptionalEntity<AllowedSecretSay>)vl), "allowedSecretSay");
        setupEfpg(_efpgMap, et -> ((VillageSettings)et).getCharaGroup(), (et, vl) -> ((VillageSettings)et).setCharaGroup((OptionalEntity<CharaGroup>)vl), "charaGroup");
        setupEfpg(_efpgMap, et -> ((VillageSettings)et).getVillage(), (et, vl) -> ((VillageSettings)et).setVillage((OptionalEntity<Village>)vl), "village");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "village_settings";
    protected final String _tableDispName = "VILLAGE_SETTINGS";
    protected final String _tablePropertyName = "villageSettings";
    protected final TableSqlName _tableSqlName = new TableSqlName("VILLAGE_SETTINGS", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "village", null, null, false);
    protected final ColumnInfo _columnDummyCharaId = cci("DUMMY_CHARA_ID", "DUMMY_CHARA_ID", null, null, Integer.class, "dummyCharaId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStartPersonMinNum = cci("START_PERSON_MIN_NUM", "START_PERSON_MIN_NUM", null, null, Integer.class, "startPersonMinNum", null, false, false, false, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPersonMaxNum = cci("PERSON_MAX_NUM", "PERSON_MAX_NUM", null, null, Integer.class, "personMaxNum", null, false, false, false, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStartDatetime = cci("START_DATETIME", "START_DATETIME", null, null, java.time.LocalDateTime.class, "startDatetime", null, false, false, false, "DATETIME", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDayChangeIntervalSeconds = cci("DAY_CHANGE_INTERVAL_SECONDS", "DAY_CHANGE_INTERVAL_SECONDS", null, null, Integer.class, "dayChangeIntervalSeconds", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsOpenVote = cci("IS_OPEN_VOTE", "IS_OPEN_VOTE", null, null, Boolean.class, "isOpenVote", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsPossibleSkillRequest = cci("IS_POSSIBLE_SKILL_REQUEST", "IS_POSSIBLE_SKILL_REQUEST", null, null, Boolean.class, "isPossibleSkillRequest", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableSpectate = cci("IS_AVAILABLE_SPECTATE", "IS_AVAILABLE_SPECTATE", null, null, Boolean.class, "isAvailableSpectate", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableSameWolfAttack = cci("IS_AVAILABLE_SAME_WOLF_ATTACK", "IS_AVAILABLE_SAME_WOLF_ATTACK", null, null, Boolean.class, "isAvailableSameWolfAttack", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsOpenSkillInGrave = cci("IS_OPEN_SKILL_IN_GRAVE", "IS_OPEN_SKILL_IN_GRAVE", null, null, Boolean.class, "isOpenSkillInGrave", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsVisibleGraveSpectateMessage = cci("IS_VISIBLE_GRAVE_SPECTATE_MESSAGE", "IS_VISIBLE_GRAVE_SPECTATE_MESSAGE", null, null, Boolean.class, "isVisibleGraveSpectateMessage", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableSuddonlyDeath = cci("IS_AVAILABLE_SUDDONLY_DEATH", "IS_AVAILABLE_SUDDONLY_DEATH", null, null, Boolean.class, "isAvailableSuddonlyDeath", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableCommit = cci("IS_AVAILABLE_COMMIT", "IS_AVAILABLE_COMMIT", null, null, Boolean.class, "isAvailableCommit", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableGuardSameTarget = cci("IS_AVAILABLE_GUARD_SAME_TARGET", "IS_AVAILABLE_GUARD_SAME_TARGET", null, null, Boolean.class, "isAvailableGuardSameTarget", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCharacterGroupId = cci("CHARACTER_GROUP_ID", "CHARACTER_GROUP_ID", null, null, Integer.class, "characterGroupId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaGroup", null, null, false);
    protected final ColumnInfo _columnJoinPassword = cci("JOIN_PASSWORD", "JOIN_PASSWORD", null, null, String.class, "joinPassword", null, false, false, false, "VARCHAR", 12, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnOrganize = cci("ORGANIZE", "ORGANIZE", null, null, String.class, "organize", null, false, false, true, "VARCHAR", 400, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnAllowedSecretSayCode = cci("ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", null, null, String.class, "allowedSecretSayCode", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "allowedSecretSay", null, CDef.DefMeta.AllowedSecretSay, false);
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
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDummyCharaId() { return _columnDummyCharaId; }
    /**
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStartPersonMinNum() { return _columnStartPersonMinNum; }
    /**
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPersonMaxNum() { return _columnPersonMaxNum; }
    /**
     * START_DATETIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStartDatetime() { return _columnStartDatetime; }
    /**
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDayChangeIntervalSeconds() { return _columnDayChangeIntervalSeconds; }
    /**
     * IS_OPEN_VOTE: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsOpenVote() { return _columnIsOpenVote; }
    /**
     * IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsPossibleSkillRequest() { return _columnIsPossibleSkillRequest; }
    /**
     * IS_AVAILABLE_SPECTATE: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableSpectate() { return _columnIsAvailableSpectate; }
    /**
     * IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableSameWolfAttack() { return _columnIsAvailableSameWolfAttack; }
    /**
     * IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsOpenSkillInGrave() { return _columnIsOpenSkillInGrave; }
    /**
     * IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsVisibleGraveSpectateMessage() { return _columnIsVisibleGraveSpectateMessage; }
    /**
     * IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableSuddonlyDeath() { return _columnIsAvailableSuddonlyDeath; }
    /**
     * IS_AVAILABLE_COMMIT: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableCommit() { return _columnIsAvailableCommit; }
    /**
     * IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableGuardSameTarget() { return _columnIsAvailableGuardSameTarget; }
    /**
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharacterGroupId() { return _columnCharacterGroupId; }
    /**
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnJoinPassword() { return _columnJoinPassword; }
    /**
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnOrganize() { return _columnOrganize; }
    /**
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAllowedSecretSayCode() { return _columnAllowedSecretSayCode; }
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
        ls.add(columnDummyCharaId());
        ls.add(columnStartPersonMinNum());
        ls.add(columnPersonMaxNum());
        ls.add(columnStartDatetime());
        ls.add(columnDayChangeIntervalSeconds());
        ls.add(columnIsOpenVote());
        ls.add(columnIsPossibleSkillRequest());
        ls.add(columnIsAvailableSpectate());
        ls.add(columnIsAvailableSameWolfAttack());
        ls.add(columnIsOpenSkillInGrave());
        ls.add(columnIsVisibleGraveSpectateMessage());
        ls.add(columnIsAvailableSuddonlyDeath());
        ls.add(columnIsAvailableCommit());
        ls.add(columnIsAvailableGuardSameTarget());
        ls.add(columnCharacterGroupId());
        ls.add(columnJoinPassword());
        ls.add(columnOrganize());
        ls.add(columnAllowedSecretSayCode());
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
    protected UniqueInfo cpui() { return hpcpui(columnVillageId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * ALLOWED_SECRET_SAY by my ALLOWED_SECRET_SAY_CODE, named 'allowedSecretSay'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignAllowedSecretSay() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAllowedSecretSayCode(), AllowedSecretSayDbm.getInstance().columnAllowedSecretSayCode());
        return cfi("FK_VILLAGE_SETTINGS_ALLOWED_SECRET_SAY", "allowedSecretSay", this, AllowedSecretSayDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageSettingsList", false);
    }
    /**
     * CHARA_GROUP by my CHARACTER_GROUP_ID, named 'charaGroup'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaGroup() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharacterGroupId(), CharaGroupDbm.getInstance().columnCharaGroupId());
        return cfi("FK_VILLAGE_SETTINGS_CHARA_GROUP", "charaGroup", this, CharaGroupDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageSettingsList", false);
    }
    /**
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillage() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageId(), VillageDbm.getInstance().columnVillageId());
        return cfi("FK_VILLAGE_SETTINGS_VILLAGE", "village", this, VillageDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, true, false, false, false, null, null, false, "villageSettingsAsOne", false);
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.VillageSettings"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VillageSettingsCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VillageSettingsBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VillageSettings> getEntityType() { return VillageSettings.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VillageSettings newEntity() { return new VillageSettings(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VillageSettings)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VillageSettings)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
