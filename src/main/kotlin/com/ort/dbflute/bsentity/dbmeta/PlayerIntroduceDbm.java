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
 * The DB meta of player_introduce. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PlayerIntroduceDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PlayerIntroduceDbm _instance = new PlayerIntroduceDbm();
    private PlayerIntroduceDbm() {}
    public static PlayerIntroduceDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getPlayerIntroduceId(), (et, vl) -> ((PlayerIntroduce)et).setPlayerIntroduceId(cti(vl)), "playerIntroduceId");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getFromPlayerId(), (et, vl) -> ((PlayerIntroduce)et).setFromPlayerId(cti(vl)), "fromPlayerId");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getToPlayerId(), (et, vl) -> ((PlayerIntroduce)et).setToPlayerId(cti(vl)), "toPlayerId");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getRegisterDatetime(), (et, vl) -> ((PlayerIntroduce)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getRegisterTrace(), (et, vl) -> ((PlayerIntroduce)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getUpdateDatetime(), (et, vl) -> ((PlayerIntroduce)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((PlayerIntroduce)et).getUpdateTrace(), (et, vl) -> ((PlayerIntroduce)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((PlayerIntroduce)et).getPlayerByFromPlayerId(), (et, vl) -> ((PlayerIntroduce)et).setPlayerByFromPlayerId((OptionalEntity<Player>)vl), "playerByFromPlayerId");
        setupEfpg(_efpgMap, et -> ((PlayerIntroduce)et).getPlayerByToPlayerId(), (et, vl) -> ((PlayerIntroduce)et).setPlayerByToPlayerId((OptionalEntity<Player>)vl), "playerByToPlayerId");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "player_introduce";
    protected final String _tableDispName = "PLAYER_INTRODUCE";
    protected final String _tablePropertyName = "playerIntroduce";
    protected final TableSqlName _tableSqlName = new TableSqlName("PLAYER_INTRODUCE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPlayerIntroduceId = cci("PLAYER_INTRODUCE_ID", "PLAYER_INTRODUCE_ID", null, null, Integer.class, "playerIntroduceId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnFromPlayerId = cci("FROM_PLAYER_ID", "FROM_PLAYER_ID", null, null, Integer.class, "fromPlayerId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "playerByFromPlayerId", null, null, false);
    protected final ColumnInfo _columnToPlayerId = cci("TO_PLAYER_ID", "TO_PLAYER_ID", null, null, Integer.class, "toPlayerId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "playerByToPlayerId", null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPlayerIntroduceId() { return _columnPlayerIntroduceId; }
    /**
     * FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFromPlayerId() { return _columnFromPlayerId; }
    /**
     * TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnToPlayerId() { return _columnToPlayerId; }
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
        ls.add(columnPlayerIntroduceId());
        ls.add(columnFromPlayerId());
        ls.add(columnToPlayerId());
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
    protected UniqueInfo cpui() { return hpcpui(columnPlayerIntroduceId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    public UniqueInfo uniqueOf() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnFromPlayerId());
        ls.add(columnToPlayerId());
        return hpcui(ls);
    }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignPlayerByFromPlayerId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnFromPlayerId(), PlayerDbm.getInstance().columnPlayerId());
        return cfi("FK_PLAYER_INTRODUCE_PLAYER", "playerByFromPlayerId", this, PlayerDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "playerIntroduceByFromPlayerIdList", false);
    }
    /**
     * PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignPlayerByToPlayerId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnToPlayerId(), PlayerDbm.getInstance().columnPlayerId());
        return cfi("FK_PLAYER_INTRODUCE_TO_PLAYER", "playerByToPlayerId", this, PlayerDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "playerIntroduceByToPlayerIdList", false);
    }

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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.PlayerIntroduce"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.PlayerIntroduceCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.PlayerIntroduceBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PlayerIntroduce> getEntityType() { return PlayerIntroduce.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public PlayerIntroduce newEntity() { return new PlayerIntroduce(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((PlayerIntroduce)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((PlayerIntroduce)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
