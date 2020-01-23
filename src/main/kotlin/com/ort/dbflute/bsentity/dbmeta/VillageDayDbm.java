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
 * The DB meta of village_day. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VillageDayDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VillageDayDbm _instance = new VillageDayDbm();
    private VillageDayDbm() {}
    public static VillageDayDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VillageDay)et).getVillageDayId(), (et, vl) -> ((VillageDay)et).setVillageDayId(cti(vl)), "villageDayId");
        setupEpg(_epgMap, et -> ((VillageDay)et).getVillageId(), (et, vl) -> ((VillageDay)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((VillageDay)et).getDay(), (et, vl) -> ((VillageDay)et).setDay(cti(vl)), "day");
        setupEpg(_epgMap, et -> ((VillageDay)et).getNoonnightCode(), (et, vl) -> {
            CDef.Noonnight cls = (CDef.Noonnight)gcls(et, columnNoonnightCode(), vl);
            if (cls != null) {
                ((VillageDay)et).setNoonnightCodeAsNoonnight(cls);
            } else {
                ((VillageDay)et).mynativeMappingNoonnightCode((String)vl);
            }
        }, "noonnightCode");
        setupEpg(_epgMap, et -> ((VillageDay)et).getDaychangeDatetime(), (et, vl) -> ((VillageDay)et).setDaychangeDatetime(ctldt(vl)), "daychangeDatetime");
        setupEpg(_epgMap, et -> ((VillageDay)et).getRegisterDatetime(), (et, vl) -> ((VillageDay)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((VillageDay)et).getRegisterTrace(), (et, vl) -> ((VillageDay)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((VillageDay)et).getUpdateDatetime(), (et, vl) -> ((VillageDay)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((VillageDay)et).getUpdateTrace(), (et, vl) -> ((VillageDay)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((VillageDay)et).getNoonnight(), (et, vl) -> ((VillageDay)et).setNoonnight((OptionalEntity<Noonnight>)vl), "noonnight");
        setupEfpg(_efpgMap, et -> ((VillageDay)et).getVillage(), (et, vl) -> ((VillageDay)et).setVillage((OptionalEntity<Village>)vl), "village");
        setupEfpg(_efpgMap, et -> ((VillageDay)et).getVoteAsOne(), (et, vl) -> ((VillageDay)et).setVoteAsOne((OptionalEntity<Vote>)vl), "voteAsOne");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "village_day";
    protected final String _tableDispName = "VILLAGE_DAY";
    protected final String _tablePropertyName = "villageDay";
    protected final TableSqlName _tableSqlName = new TableSqlName("VILLAGE_DAY", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageDayId = cci("VILLAGE_DAY_ID", "VILLAGE_DAY_ID", null, null, Integer.class, "villageDayId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, "abilityList,commitList,villagePlayerList", null, false);
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "village", null, null, false);
    protected final ColumnInfo _columnDay = cci("DAY", "DAY", null, null, Integer.class, "day", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnNoonnightCode = cci("NOONNIGHT_CODE", "NOONNIGHT_CODE", null, null, String.class, "noonnightCode", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "noonnight", null, CDef.DefMeta.Noonnight, false);
    protected final ColumnInfo _columnDaychangeDatetime = cci("DAYCHANGE_DATETIME", "DAYCHANGE_DATETIME", null, null, java.time.LocalDateTime.class, "daychangeDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageDayId() { return _columnVillageDayId; }
    /**
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageId() { return _columnVillageId; }
    /**
     * DAY: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDay() { return _columnDay; }
    /**
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnNoonnightCode() { return _columnNoonnightCode; }
    /**
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDaychangeDatetime() { return _columnDaychangeDatetime; }
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
        ls.add(columnVillageDayId());
        ls.add(columnVillageId());
        ls.add(columnDay());
        ls.add(columnNoonnightCode());
        ls.add(columnDaychangeDatetime());
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
    protected UniqueInfo cpui() { return hpcpui(columnVillageDayId()); }
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
     * NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignNoonnight() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnNoonnightCode(), NoonnightDbm.getInstance().columnNoonnightCode());
        return cfi("FK_VILLAGE_DAY_NOONNIGHT", "noonnight", this, NoonnightDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageDayList", false);
    }
    /**
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillage() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageId(), VillageDbm.getInstance().columnVillageId());
        return cfi("FK_VILLAGE_DAY_VILLAGE", "village", this, VillageDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageDayList", false);
    }
    /**
     * vote by VILLAGE_DAY_ID, named 'voteAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignVoteAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageDayId(), VoteDbm.getInstance().columnVillageDayId());
        return cfi("FK_VOTE_VILLAGE_DAY", "voteAsOne", this, VoteDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, true, false, true, false, null, null, false, "villageDay", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerAbilityList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageDayId(), AbilityDbm.getInstance().columnVillageDayId());
        return cri("FK_ABILITY_VILLAGE_DAY", "abilityList", this, AbilityDbm.getInstance(), mp, false, "villageDay");
    }
    /**
     * COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerCommitList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageDayId(), CommitDbm.getInstance().columnVillageDayId());
        return cri("FK_COMMIT_VILLAGE_DAY", "commitList", this, CommitDbm.getInstance(), mp, false, "villageDay");
    }
    /**
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillagePlayerList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageDayId(), VillagePlayerDbm.getInstance().columnDeadVillageDayId());
        return cri("FK_VILLAGE_PLAYER_VILLAGE_DAY", "villagePlayerList", this, VillagePlayerDbm.getInstance(), mp, false, "villageDay");
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.VillageDay"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VillageDayCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VillageDayBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VillageDay> getEntityType() { return VillageDay.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VillageDay newEntity() { return new VillageDay(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VillageDay)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VillageDay)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
