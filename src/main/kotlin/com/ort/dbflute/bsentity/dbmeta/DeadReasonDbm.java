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
 * The DB meta of dead_reason. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class DeadReasonDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final DeadReasonDbm _instance = new DeadReasonDbm();
    private DeadReasonDbm() {}
    public static DeadReasonDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((DeadReason)et).getDeadReasonCode(), (et, vl) -> {
            CDef.DeadReason cls = (CDef.DeadReason)gcls(et, columnDeadReasonCode(), vl);
            if (cls != null) {
                ((DeadReason)et).setDeadReasonCodeAsDeadReason(cls);
            } else {
                ((DeadReason)et).mynativeMappingDeadReasonCode((String)vl);
            }
        }, "deadReasonCode");
        setupEpg(_epgMap, et -> ((DeadReason)et).getDeadReasonName(), (et, vl) -> ((DeadReason)et).setDeadReasonName((String)vl), "deadReasonName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "dead_reason";
    protected final String _tableDispName = "DEAD_REASON";
    protected final String _tablePropertyName = "deadReason";
    protected final TableSqlName _tableSqlName = new TableSqlName("DEAD_REASON", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnDeadReasonCode = cci("DEAD_REASON_CODE", "DEAD_REASON_CODE", null, null, String.class, "deadReasonCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "villagePlayerList", CDef.DefMeta.DeadReason, false);
    protected final ColumnInfo _columnDeadReasonName = cci("DEAD_REASON_NAME", "DEAD_REASON_NAME", null, null, String.class, "deadReasonName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDeadReasonCode() { return _columnDeadReasonCode; }
    /**
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDeadReasonName() { return _columnDeadReasonName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnDeadReasonCode());
        ls.add(columnDeadReasonName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnDeadReasonCode()); }
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
     * VILLAGE_PLAYER by DEAD_REASON_CODE, named 'villagePlayerList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillagePlayerList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnDeadReasonCode(), VillagePlayerDbm.getInstance().columnDeadReasonCode());
        return cri("FK_VILLAGE_PLAYER_DEAD_REASON", "villagePlayerList", this, VillagePlayerDbm.getInstance(), mp, false, "deadReason");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.DeadReason"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.DeadReasonCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.DeadReasonBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<DeadReason> getEntityType() { return DeadReason.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public DeadReason newEntity() { return new DeadReason(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((DeadReason)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((DeadReason)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
