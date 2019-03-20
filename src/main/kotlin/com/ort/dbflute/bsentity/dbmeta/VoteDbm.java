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
 * The DB meta of vote. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VoteDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VoteDbm _instance = new VoteDbm();
    private VoteDbm() {}
    public static VoteDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Vote)et).getVillageId(), (et, vl) -> ((Vote)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((Vote)et).getDay(), (et, vl) -> ((Vote)et).setDay(cti(vl)), "day");
        setupEpg(_epgMap, et -> ((Vote)et).getCharaId(), (et, vl) -> ((Vote)et).setCharaId(cti(vl)), "charaId");
        setupEpg(_epgMap, et -> ((Vote)et).getVoteCharaId(), (et, vl) -> ((Vote)et).setVoteCharaId(cti(vl)), "voteCharaId");
        setupEpg(_epgMap, et -> ((Vote)et).getRegisterDatetime(), (et, vl) -> ((Vote)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Vote)et).getRegisterTrace(), (et, vl) -> ((Vote)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((Vote)et).getUpdateDatetime(), (et, vl) -> ((Vote)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Vote)et).getUpdateTrace(), (et, vl) -> ((Vote)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((Vote)et).getCharaByCharaId(), (et, vl) -> ((Vote)et).setCharaByCharaId((OptionalEntity<Chara>)vl), "charaByCharaId");
        setupEfpg(_efpgMap, et -> ((Vote)et).getVillageDay(), (et, vl) -> ((Vote)et).setVillageDay((OptionalEntity<VillageDay>)vl), "villageDay");
        setupEfpg(_efpgMap, et -> ((Vote)et).getCharaByVoteCharaId(), (et, vl) -> ((Vote)et).setCharaByVoteCharaId((OptionalEntity<Chara>)vl), "charaByVoteCharaId");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "vote";
    protected final String _tableDispName = "VOTE";
    protected final String _tablePropertyName = "vote";
    protected final TableSqlName _tableSqlName = new TableSqlName("VOTE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villageDay", null, null, false);
    protected final ColumnInfo _columnDay = cci("DAY", "DAY", null, null, Integer.class, "day", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "villageDay", null, null, false);
    protected final ColumnInfo _columnCharaId = cci("CHARA_ID", "CHARA_ID", null, null, Integer.class, "charaId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaByCharaId", null, null, false);
    protected final ColumnInfo _columnVoteCharaId = cci("VOTE_CHARA_ID", "VOTE_CHARA_ID", null, null, Integer.class, "voteCharaId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "charaByVoteCharaId", null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageId() { return _columnVillageId; }
    /**
     * DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDay() { return _columnDay; }
    /**
     * CHARA_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaId() { return _columnCharaId; }
    /**
     * VOTE_CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVoteCharaId() { return _columnVoteCharaId; }
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
        ls.add(columnDay());
        ls.add(columnCharaId());
        ls.add(columnVoteCharaId());
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
        ls.add(columnDay());
        ls.add(columnCharaId());
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
     * CHARA by my CHARA_ID, named 'charaByCharaId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaByCharaId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaId(), CharaDbm.getInstance().columnCharaId());
        return cfi("FK_VOTE_CHARA", "charaByCharaId", this, CharaDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "voteByCharaIdList", false);
    }
    /**
     * VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillageDay() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMapSized(4);
        mp.put(columnVillageId(), VillageDayDbm.getInstance().columnVillageId());
        mp.put(columnDay(), VillageDayDbm.getInstance().columnDay());
        return cfi("FK_VOTE_VILLAGE_DAY", "villageDay", this, VillageDayDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "voteList", false);
    }
    /**
     * CHARA by my VOTE_CHARA_ID, named 'charaByVoteCharaId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCharaByVoteCharaId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVoteCharaId(), CharaDbm.getInstance().columnCharaId());
        return cfi("FK_VOTE_CHARA_TO", "charaByVoteCharaId", this, CharaDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "voteByVoteCharaIdList", false);
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Vote"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VoteCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VoteBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Vote> getEntityType() { return Vote.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Vote newEntity() { return new Vote(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Vote)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Vote)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
