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
 * The DB meta of village_status. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VillageStatusDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VillageStatusDbm _instance = new VillageStatusDbm();
    private VillageStatusDbm() {}
    public static VillageStatusDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VillageStatus)et).getVillageStatusCode(), (et, vl) -> {
            CDef.VillageStatus cls = (CDef.VillageStatus)gcls(et, columnVillageStatusCode(), vl);
            if (cls != null) {
                ((VillageStatus)et).setVillageStatusCodeAsVillageStatus(cls);
            } else {
                ((VillageStatus)et).mynativeMappingVillageStatusCode((String)vl);
            }
        }, "villageStatusCode");
        setupEpg(_epgMap, et -> ((VillageStatus)et).getVillageStatusName(), (et, vl) -> ((VillageStatus)et).setVillageStatusName((String)vl), "villageStatusName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "village_status";
    protected final String _tableDispName = "VILLAGE_STATUS";
    protected final String _tablePropertyName = "villageStatus";
    protected final TableSqlName _tableSqlName = new TableSqlName("VILLAGE_STATUS", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageStatusCode = cci("VILLAGE_STATUS_CODE", "VILLAGE_STATUS_CODE", null, null, String.class, "villageStatusCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "villageList", CDef.DefMeta.VillageStatus, false);
    protected final ColumnInfo _columnVillageStatusName = cci("VILLAGE_STATUS_NAME", "VILLAGE_STATUS_NAME", null, null, String.class, "villageStatusName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageStatusCode() { return _columnVillageStatusCode; }
    /**
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageStatusName() { return _columnVillageStatusName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnVillageStatusCode());
        ls.add(columnVillageStatusName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnVillageStatusCode()); }
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
     * VILLAGE by VILLAGE_STATUS_CODE, named 'villageList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageStatusCode(), VillageDbm.getInstance().columnVillageStatusCode());
        return cri("FK_VILLAGE_VILLAGE_STATUS", "villageList", this, VillageDbm.getInstance(), mp, false, "villageStatus");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.VillageStatus"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VillageStatusCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VillageStatusBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VillageStatus> getEntityType() { return VillageStatus.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VillageStatus newEntity() { return new VillageStatus(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VillageStatus)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VillageStatus)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
