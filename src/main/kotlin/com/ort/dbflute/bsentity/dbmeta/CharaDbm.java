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
 * The DB meta of chara. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CharaDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CharaDbm _instance = new CharaDbm();
    private CharaDbm() {}
    public static CharaDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Chara)et).getCharaId(), (et, vl) -> ((Chara)et).setCharaId(cti(vl)), "charaId");
        setupEpg(_epgMap, et -> ((Chara)et).getCharaName(), (et, vl) -> ((Chara)et).setCharaName((String)vl), "charaName");
        setupEpg(_epgMap, et -> ((Chara)et).getCharaShortName(), (et, vl) -> ((Chara)et).setCharaShortName((String)vl), "charaShortName");
        setupEpg(_epgMap, et -> ((Chara)et).getCharaGroupId(), (et, vl) -> ((Chara)et).setCharaGroupId(cti(vl)), "charaGroupId");
        setupEpg(_epgMap, et -> ((Chara)et).getDefaultJoinMessage(), (et, vl) -> ((Chara)et).setDefaultJoinMessage((String)vl), "defaultJoinMessage");
        setupEpg(_epgMap, et -> ((Chara)et).getDefaultFirstdayMessage(), (et, vl) -> ((Chara)et).setDefaultFirstdayMessage((String)vl), "defaultFirstdayMessage");
        setupEpg(_epgMap, et -> ((Chara)et).getDisplayWidth(), (et, vl) -> ((Chara)et).setDisplayWidth(cti(vl)), "displayWidth");
        setupEpg(_epgMap, et -> ((Chara)et).getDisplayHeight(), (et, vl) -> ((Chara)et).setDisplayHeight(cti(vl)), "displayHeight");
        setupEpg(_epgMap, et -> ((Chara)et).getRegisterDatetime(), (et, vl) -> ((Chara)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Chara)et).getRegisterTrace(), (et, vl) -> ((Chara)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((Chara)et).getUpdateDatetime(), (et, vl) -> ((Chara)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Chara)et).getUpdateTrace(), (et, vl) -> ((Chara)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((Chara)et).getCharaGroup(), (et, vl) -> ((Chara)et).setCharaGroup((OptionalEntity<CharaGroup>)vl), "charaGroup");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "chara";
    protected final String _tableDispName = "CHARA";
    protected final String _tablePropertyName = "chara";
    protected final TableSqlName _tableSqlName = new TableSqlName("CHARA", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnCharaId = cci("CHARA_ID", "CHARA_ID", null, null, Integer.class, "charaId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, "charaImageList,villagePlayerList", null, false);
    protected final ColumnInfo _columnCharaName = cci("CHARA_NAME", "CHARA_NAME", null, null, String.class, "charaName", null, false, false, true, "VARCHAR", 40, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCharaShortName = cci("CHARA_SHORT_NAME", "CHARA_SHORT_NAME", null, null, String.class, "charaShortName", null, false, false, true, "CHAR", 1, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCharaGroupId = cci("CHARA_GROUP_ID", "CHARA_GROUP_ID", null, null, Integer.class, "charaGroupId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaGroup", null, null, false);
    protected final ColumnInfo _columnDefaultJoinMessage = cci("DEFAULT_JOIN_MESSAGE", "DEFAULT_JOIN_MESSAGE", null, null, String.class, "defaultJoinMessage", null, false, false, false, "VARCHAR", 200, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDefaultFirstdayMessage = cci("DEFAULT_FIRSTDAY_MESSAGE", "DEFAULT_FIRSTDAY_MESSAGE", null, null, String.class, "defaultFirstdayMessage", null, false, false, false, "VARCHAR", 200, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDisplayWidth = cci("DISPLAY_WIDTH", "DISPLAY_WIDTH", null, null, Integer.class, "displayWidth", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDisplayHeight = cci("DISPLAY_HEIGHT", "DISPLAY_HEIGHT", null, null, Integer.class, "displayHeight", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * CHARA_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaId() { return _columnCharaId; }
    /**
     * CHARA_NAME: {NotNull, VARCHAR(40)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaName() { return _columnCharaName; }
    /**
     * CHARA_SHORT_NAME: {NotNull, CHAR(1)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaShortName() { return _columnCharaShortName; }
    /**
     * CHARA_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaGroupId() { return _columnCharaGroupId; }
    /**
     * DEFAULT_JOIN_MESSAGE: {VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDefaultJoinMessage() { return _columnDefaultJoinMessage; }
    /**
     * DEFAULT_FIRSTDAY_MESSAGE: {VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDefaultFirstdayMessage() { return _columnDefaultFirstdayMessage; }
    /**
     * DISPLAY_WIDTH: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDisplayWidth() { return _columnDisplayWidth; }
    /**
     * DISPLAY_HEIGHT: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDisplayHeight() { return _columnDisplayHeight; }
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
        ls.add(columnCharaId());
        ls.add(columnCharaName());
        ls.add(columnCharaShortName());
        ls.add(columnCharaGroupId());
        ls.add(columnDefaultJoinMessage());
        ls.add(columnDefaultFirstdayMessage());
        ls.add(columnDisplayWidth());
        ls.add(columnDisplayHeight());
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
    protected UniqueInfo cpui() { return hpcpui(columnCharaId()); }
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
     * CHARA_GROUP by my CHARA_GROUP_ID, named 'charaGroup'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaGroup() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaGroupId(), CharaGroupDbm.getInstance().columnCharaGroupId());
        return cfi("FK_CHARA_CHARA_GROUP", "charaGroup", this, CharaGroupDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "charaList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * CHARA_IMAGE by CHARA_ID, named 'charaImageList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerCharaImageList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaId(), CharaImageDbm.getInstance().columnCharaId());
        return cri("FK_CHARA_IMAGE_CHARA", "charaImageList", this, CharaImageDbm.getInstance(), mp, false, "chara");
    }
    /**
     * VILLAGE_PLAYER by CHARA_ID, named 'villagePlayerList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillagePlayerList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaId(), VillagePlayerDbm.getInstance().columnCharaId());
        return cri("FK_VILLAGE_PLAYER_CHARA", "villagePlayerList", this, VillagePlayerDbm.getInstance(), mp, false, "chara");
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Chara"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.CharaCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.CharaBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Chara> getEntityType() { return Chara.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Chara newEntity() { return new Chara(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Chara)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Chara)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
