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
 * The DB meta of player_detail. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PlayerDetailDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PlayerDetailDbm _instance = new PlayerDetailDbm();
    private PlayerDetailDbm() {}
    public static PlayerDetailDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((PlayerDetail)et).getPlayerId(), (et, vl) -> ((PlayerDetail)et).setPlayerId(cti(vl)), "playerId");
        setupEpg(_epgMap, et -> ((PlayerDetail)et).getOtherSiteName(), (et, vl) -> ((PlayerDetail)et).setOtherSiteName((String)vl), "otherSiteName");
        setupEpg(_epgMap, et -> ((PlayerDetail)et).getIntroduction(), (et, vl) -> ((PlayerDetail)et).setIntroduction((String)vl), "introduction");
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
        setupEfpg(_efpgMap, et -> ((PlayerDetail)et).getPlayer(), (et, vl) -> ((PlayerDetail)et).setPlayer((OptionalEntity<Player>)vl), "player");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "player_detail";
    protected final String _tableDispName = "PLAYER_DETAIL";
    protected final String _tablePropertyName = "playerDetail";
    protected final TableSqlName _tableSqlName = new TableSqlName("PLAYER_DETAIL", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPlayerId = cci("PLAYER_ID", "PLAYER_ID", null, null, Integer.class, "playerId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "player", null, null, false);
    protected final ColumnInfo _columnOtherSiteName = cci("OTHER_SITE_NAME", "OTHER_SITE_NAME", null, null, String.class, "otherSiteName", null, false, false, false, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnIntroduction = cci("INTRODUCTION", "INTRODUCTION", null, null, String.class, "introduction", null, false, false, false, "VARCHAR", 2000, 0, null, null, false, null, null, null, null, null, false);

    /**
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to player}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPlayerId() { return _columnPlayerId; }
    /**
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnOtherSiteName() { return _columnOtherSiteName; }
    /**
     * INTRODUCTION: {VARCHAR(2000)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIntroduction() { return _columnIntroduction; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnPlayerId());
        ls.add(columnOtherSiteName());
        ls.add(columnIntroduction());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnPlayerId()); }
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
     * PLAYER by my PLAYER_ID, named 'player'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignPlayer() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPlayerId(), PlayerDbm.getInstance().columnPlayerId());
        return cfi("FK_PLAYER_DETAIL_PLAYER", "player", this, PlayerDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, true, false, false, false, null, null, false, "playerDetailAsOne", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.PlayerDetail"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.PlayerDetailCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.PlayerDetailBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PlayerDetail> getEntityType() { return PlayerDetail.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public PlayerDetail newEntity() { return new PlayerDetail(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((PlayerDetail)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((PlayerDetail)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
