package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of reserved_village. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ReservedVillageDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ReservedVillageDbm _instance = new ReservedVillageDbm();
    private ReservedVillageDbm() {}
    public static ReservedVillageDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getReservedVillageId(), (et, vl) -> ((ReservedVillage)et).setReservedVillageId(cti(vl)), "reservedVillageId");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getCreateDatetime(), (et, vl) -> ((ReservedVillage)et).setCreateDatetime(ctldt(vl)), "createDatetime");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getStartDatetime(), (et, vl) -> ((ReservedVillage)et).setStartDatetime(ctldt(vl)), "startDatetime");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getOrganization(), (et, vl) -> ((ReservedVillage)et).setOrganization((String)vl), "organization");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getSilentHours(), (et, vl) -> ((ReservedVillage)et).setSilentHours(cti(vl)), "silentHours");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getIsAvailableDummySkill(), (et, vl) -> ((ReservedVillage)et).setIsAvailableDummySkill((Boolean)vl), "isAvailableDummySkill");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getIsForBeginner(), (et, vl) -> ((ReservedVillage)et).setIsForBeginner((Boolean)vl), "isForBeginner");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getRegisterDatetime(), (et, vl) -> ((ReservedVillage)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getRegisterTrace(), (et, vl) -> ((ReservedVillage)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getUpdateDatetime(), (et, vl) -> ((ReservedVillage)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((ReservedVillage)et).getUpdateTrace(), (et, vl) -> ((ReservedVillage)et).setUpdateTrace((String)vl), "updateTrace");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "reserved_village";
    protected final String _tableDispName = "RESERVED_VILLAGE";
    protected final String _tablePropertyName = "reservedVillage";
    protected final TableSqlName _tableSqlName = new TableSqlName("RESERVED_VILLAGE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnReservedVillageId = cci("RESERVED_VILLAGE_ID", "RESERVED_VILLAGE_ID", null, null, Integer.class, "reservedVillageId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCreateDatetime = cci("CREATE_DATETIME", "CREATE_DATETIME", null, null, java.time.LocalDateTime.class, "createDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStartDatetime = cci("START_DATETIME", "START_DATETIME", null, null, java.time.LocalDateTime.class, "startDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnOrganization = cci("ORGANIZATION", "ORGANIZATION", null, null, String.class, "organization", null, false, false, true, "VARCHAR", 255, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnSilentHours = cci("SILENT_HOURS", "SILENT_HOURS", null, null, Integer.class, "silentHours", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsAvailableDummySkill = cci("IS_AVAILABLE_DUMMY_SKILL", "IS_AVAILABLE_DUMMY_SKILL", null, null, Boolean.class, "isAvailableDummySkill", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIsForBeginner = cci("IS_FOR_BEGINNER", "IS_FOR_BEGINNER", null, null, Boolean.class, "isForBeginner", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * RESERVED_VILLAGE_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnReservedVillageId() { return _columnReservedVillageId; }
    /**
     * CREATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCreateDatetime() { return _columnCreateDatetime; }
    /**
     * START_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStartDatetime() { return _columnStartDatetime; }
    /**
     * ORGANIZATION: {NotNull, VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnOrganization() { return _columnOrganization; }
    /**
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSilentHours() { return _columnSilentHours; }
    /**
     * IS_AVAILABLE_DUMMY_SKILL: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsAvailableDummySkill() { return _columnIsAvailableDummySkill; }
    /**
     * IS_FOR_BEGINNER: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsForBeginner() { return _columnIsForBeginner; }
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
        ls.add(columnReservedVillageId());
        ls.add(columnCreateDatetime());
        ls.add(columnStartDatetime());
        ls.add(columnOrganization());
        ls.add(columnSilentHours());
        ls.add(columnIsAvailableDummySkill());
        ls.add(columnIsForBeginner());
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
    protected UniqueInfo cpui() { return hpcpui(columnReservedVillageId()); }
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

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.ReservedVillage"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.ReservedVillageCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.ReservedVillageBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<ReservedVillage> getEntityType() { return ReservedVillage.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public ReservedVillage newEntity() { return new ReservedVillage(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((ReservedVillage)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((ReservedVillage)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
