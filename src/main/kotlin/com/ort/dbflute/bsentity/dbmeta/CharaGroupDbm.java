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
 * The DB meta of chara_group. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CharaGroupDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CharaGroupDbm _instance = new CharaGroupDbm();
    private CharaGroupDbm() {}
    public static CharaGroupDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((CharaGroup)et).getCharaGroupId(), (et, vl) -> ((CharaGroup)et).setCharaGroupId(cti(vl)), "charaGroupId");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getCharaGroupName(), (et, vl) -> ((CharaGroup)et).setCharaGroupName((String)vl), "charaGroupName");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getDesignerId(), (et, vl) -> ((CharaGroup)et).setDesignerId(cti(vl)), "designerId");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getDescriptionUrl(), (et, vl) -> ((CharaGroup)et).setDescriptionUrl((String)vl), "descriptionUrl");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getRegisterDatetime(), (et, vl) -> ((CharaGroup)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getRegisterTrace(), (et, vl) -> ((CharaGroup)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getUpdateDatetime(), (et, vl) -> ((CharaGroup)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((CharaGroup)et).getUpdateTrace(), (et, vl) -> ((CharaGroup)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((CharaGroup)et).getDesigner(), (et, vl) -> ((CharaGroup)et).setDesigner((OptionalEntity<Designer>)vl), "designer");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "chara_group";
    protected final String _tableDispName = "CHARA_GROUP";
    protected final String _tablePropertyName = "charaGroup";
    protected final TableSqlName _tableSqlName = new TableSqlName("CHARA_GROUP", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnCharaGroupId = cci("CHARA_GROUP_ID", "CHARA_GROUP_ID", null, null, Integer.class, "charaGroupId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, "charaList,villageSettingsList", null, false);
    protected final ColumnInfo _columnCharaGroupName = cci("CHARA_GROUP_NAME", "CHARA_GROUP_NAME", null, null, String.class, "charaGroupName", null, false, false, true, "VARCHAR", 40, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDesignerId = cci("DESIGNER_ID", "DESIGNER_ID", null, null, Integer.class, "designerId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "designer", null, null, false);
    protected final ColumnInfo _columnDescriptionUrl = cci("DESCRIPTION_URL", "DESCRIPTION_URL", null, null, String.class, "descriptionUrl", null, false, false, false, "TEXT", 65535, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaGroupId() { return _columnCharaGroupId; }
    /**
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaGroupName() { return _columnCharaGroupName; }
    /**
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDesignerId() { return _columnDesignerId; }
    /**
     * DESCRIPTION_URL: {TEXT(65535)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDescriptionUrl() { return _columnDescriptionUrl; }
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
        ls.add(columnCharaGroupId());
        ls.add(columnCharaGroupName());
        ls.add(columnDesignerId());
        ls.add(columnDescriptionUrl());
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
    protected UniqueInfo cpui() { return hpcpui(columnCharaGroupId()); }
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
     * DESIGNER by my DESIGNER_ID, named 'designer'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignDesigner() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnDesignerId(), DesignerDbm.getInstance().columnDesignerId());
        return cfi("FK_CHARA_GROUP_DESIGNER", "designer", this, DesignerDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "charaGroupList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * CHARA by CHARA_GROUP_ID, named 'charaList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerCharaList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaGroupId(), CharaDbm.getInstance().columnCharaGroupId());
        return cri("FK_CHARA_CHARA_GROUP", "charaList", this, CharaDbm.getInstance(), mp, false, "charaGroup");
    }
    /**
     * VILLAGE_SETTINGS by CHARACTER_GROUP_ID, named 'villageSettingsList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageSettingsList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaGroupId(), VillageSettingsDbm.getInstance().columnCharacterGroupId());
        return cri("FK_VILLAGE_SETTINGS_CHARA_GROUP", "villageSettingsList", this, VillageSettingsDbm.getInstance(), mp, false, "charaGroup");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.CharaGroup"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.CharaGroupCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.CharaGroupBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<CharaGroup> getEntityType() { return CharaGroup.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public CharaGroup newEntity() { return new CharaGroup(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((CharaGroup)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((CharaGroup)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
