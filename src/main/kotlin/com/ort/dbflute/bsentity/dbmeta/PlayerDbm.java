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
 * The DB meta of PLAYER. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PlayerDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PlayerDbm _instance = new PlayerDbm();
    private PlayerDbm() {}
    public static PlayerDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Player)et).getPlayerId(), (et, vl) -> ((Player)et).setPlayerId(cti(vl)), "playerId");
        setupEpg(_epgMap, et -> ((Player)et).getUid(), (et, vl) -> ((Player)et).setUid((String)vl), "uid");
        setupEpg(_epgMap, et -> ((Player)et).getNickname(), (et, vl) -> ((Player)et).setNickname((String)vl), "nickname");
        setupEpg(_epgMap, et -> ((Player)et).getTwitterUserName(), (et, vl) -> ((Player)et).setTwitterUserName((String)vl), "twitterUserName");
        setupEpg(_epgMap, et -> ((Player)et).getAuthorityCode(), (et, vl) -> {
            CDef.Authority cls = (CDef.Authority)gcls(et, columnAuthorityCode(), vl);
            if (cls != null) {
                ((Player)et).setAuthorityCodeAsAuthority(cls);
            } else {
                ((Player)et).mynativeMappingAuthorityCode((String)vl);
            }
        }, "authorityCode");
        setupEpg(_epgMap, et -> ((Player)et).getIsRestrictedParticipation(), (et, vl) -> ((Player)et).setIsRestrictedParticipation((Boolean)vl), "isRestrictedParticipation");
        setupEpg(_epgMap, et -> ((Player)et).getRegisterDatetime(), (et, vl) -> ((Player)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Player)et).getRegisterTrace(), (et, vl) -> ((Player)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((Player)et).getUpdateDatetime(), (et, vl) -> ((Player)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Player)et).getUpdateTrace(), (et, vl) -> ((Player)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((Player)et).getAuthority(), (et, vl) -> ((Player)et).setAuthority((OptionalEntity<Authority>)vl), "authority");
        setupEfpg(_efpgMap, et -> ((Player)et).getPlayerDetailAsOne(), (et, vl) -> ((Player)et).setPlayerDetailAsOne((OptionalEntity<PlayerDetail>)vl), "playerDetailAsOne");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PLAYER";
    protected final String _tableDispName = "PLAYER";
    protected final String _tablePropertyName = "player";
    protected final TableSqlName _tableSqlName = new TableSqlName("PLAYER", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPlayerId = cci("PLAYER_ID", "PLAYER_ID", null, null, Integer.class, "playerId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, "villageList,villagePlayerList", null, false);
    protected final ColumnInfo _columnUid = cci("UID", "UID", null, null, String.class, "uid", null, false, false, true, "VARCHAR", 100, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnNickname = cci("NICKNAME", "NICKNAME", null, null, String.class, "nickname", null, false, false, true, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTwitterUserName = cci("TWITTER_USER_NAME", "TWITTER_USER_NAME", null, null, String.class, "twitterUserName", null, false, false, true, "VARCHAR", 15, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnAuthorityCode = cci("AUTHORITY_CODE", "AUTHORITY_CODE", null, null, String.class, "authorityCode", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "authority", null, CDef.DefMeta.Authority, false);
    protected final ColumnInfo _columnIsRestrictedParticipation = cci("IS_RESTRICTED_PARTICIPATION", "IS_RESTRICTED_PARTICIPATION", null, null, Boolean.class, "isRestrictedParticipation", null, false, false, true, "BIT", null, null, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPlayerId() { return _columnPlayerId; }
    /**
     * UID: {UQ, NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUid() { return _columnUid; }
    /**
     * NICKNAME: {NotNull, VARCHAR(50)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnNickname() { return _columnNickname; }
    /**
     * TWITTER_USER_NAME: {NotNull, VARCHAR(15)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTwitterUserName() { return _columnTwitterUserName; }
    /**
     * AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to AUTHORITY, classification=Authority}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAuthorityCode() { return _columnAuthorityCode; }
    /**
     * IS_RESTRICTED_PARTICIPATION: {NotNull, BIT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnIsRestrictedParticipation() { return _columnIsRestrictedParticipation; }
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
        ls.add(columnPlayerId());
        ls.add(columnUid());
        ls.add(columnNickname());
        ls.add(columnTwitterUserName());
        ls.add(columnAuthorityCode());
        ls.add(columnIsRestrictedParticipation());
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
    protected UniqueInfo cpui() { return hpcpui(columnPlayerId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    public UniqueInfo uniqueOf() { return hpcui(columnUid()); }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * AUTHORITY by my AUTHORITY_CODE, named 'authority'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignAuthority() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAuthorityCode(), AuthorityDbm.getInstance().columnAuthorityCode());
        return cfi("FK_PLAYER_AUTHORITY", "authority", this, AuthorityDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "playerList", false);
    }
    /**
     * PLAYER_DETAIL by PLAYER_ID, named 'playerDetailAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignPlayerDetailAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPlayerId(), PlayerDetailDbm.getInstance().columnPlayerId());
        return cfi("FK_PLAYER_DETAIL_PLAYER", "playerDetailAsOne", this, PlayerDetailDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, true, false, true, false, null, null, false, "player", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * VILLAGE by CREATE_PLAYER_ID, named 'villageList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPlayerId(), VillageDbm.getInstance().columnCreatePlayerId());
        return cri("FK_VILLAGE_PLAYER", "villageList", this, VillageDbm.getInstance(), mp, false, "player");
    }
    /**
     * VILLAGE_PLAYER by PLAYER_ID, named 'villagePlayerList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillagePlayerList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPlayerId(), VillagePlayerDbm.getInstance().columnPlayerId());
        return cri("FK_VILLAGE_PLAYER_PLAYER", "villagePlayerList", this, VillagePlayerDbm.getInstance(), mp, false, "player");
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Player"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.PlayerCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.PlayerBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Player> getEntityType() { return Player.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Player newEntity() { return new Player(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Player)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Player)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
