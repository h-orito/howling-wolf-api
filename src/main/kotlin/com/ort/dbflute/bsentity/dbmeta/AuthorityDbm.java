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
 * The DB meta of AUTHORITY. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class AuthorityDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final AuthorityDbm _instance = new AuthorityDbm();
    private AuthorityDbm() {}
    public static AuthorityDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Authority)et).getAuthorityCode(), (et, vl) -> {
            CDef.Authority cls = (CDef.Authority)gcls(et, columnAuthorityCode(), vl);
            if (cls != null) {
                ((Authority)et).setAuthorityCodeAsAuthority(cls);
            } else {
                ((Authority)et).mynativeMappingAuthorityCode((String)vl);
            }
        }, "authorityCode");
        setupEpg(_epgMap, et -> ((Authority)et).getAuthorityName(), (et, vl) -> ((Authority)et).setAuthorityName((String)vl), "authorityName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "AUTHORITY";
    protected final String _tableDispName = "AUTHORITY";
    protected final String _tablePropertyName = "authority";
    protected final TableSqlName _tableSqlName = new TableSqlName("AUTHORITY", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnAuthorityCode = cci("AUTHORITY_CODE", "AUTHORITY_CODE", null, null, String.class, "authorityCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "playerList", CDef.DefMeta.Authority, false);
    protected final ColumnInfo _columnAuthorityName = cci("AUTHORITY_NAME", "AUTHORITY_NAME", null, null, String.class, "authorityName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAuthorityCode() { return _columnAuthorityCode; }
    /**
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAuthorityName() { return _columnAuthorityName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnAuthorityCode());
        ls.add(columnAuthorityName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnAuthorityCode()); }
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
    /**
     * PLAYER by AUTHORITY_CODE, named 'playerList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerPlayerList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAuthorityCode(), PlayerDbm.getInstance().columnAuthorityCode());
        return cri("FK_PLAYER_AUTHORITY", "playerList", this, PlayerDbm.getInstance(), mp, false, "authority");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Authority"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.AuthorityCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.AuthorityBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Authority> getEntityType() { return Authority.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Authority newEntity() { return new Authority(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Authority)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Authority)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
