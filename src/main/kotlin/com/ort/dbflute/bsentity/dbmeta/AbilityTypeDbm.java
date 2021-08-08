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
 * The DB meta of ABILITY_TYPE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class AbilityTypeDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final AbilityTypeDbm _instance = new AbilityTypeDbm();
    private AbilityTypeDbm() {}
    public static AbilityTypeDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((AbilityType)et).getAbilityTypeCode(), (et, vl) -> {
            CDef.AbilityType cls = (CDef.AbilityType)gcls(et, columnAbilityTypeCode(), vl);
            if (cls != null) {
                ((AbilityType)et).setAbilityTypeCodeAsAbilityType(cls);
            } else {
                ((AbilityType)et).mynativeMappingAbilityTypeCode((String)vl);
            }
        }, "abilityTypeCode");
        setupEpg(_epgMap, et -> ((AbilityType)et).getAbilityTypeName(), (et, vl) -> ((AbilityType)et).setAbilityTypeName((String)vl), "abilityTypeName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "ABILITY_TYPE";
    protected final String _tableDispName = "ABILITY_TYPE";
    protected final String _tablePropertyName = "abilityType";
    protected final TableSqlName _tableSqlName = new TableSqlName("ABILITY_TYPE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnAbilityTypeCode = cci("ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", null, null, String.class, "abilityTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "abilityList", CDef.DefMeta.AbilityType, false);
    protected final ColumnInfo _columnAbilityTypeName = cci("ABILITY_TYPE_NAME", "ABILITY_TYPE_NAME", null, null, String.class, "abilityTypeName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAbilityTypeCode() { return _columnAbilityTypeCode; }
    /**
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAbilityTypeName() { return _columnAbilityTypeName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnAbilityTypeCode());
        ls.add(columnAbilityTypeName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnAbilityTypeCode()); }
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
     * ABILITY by ABILITY_TYPE_CODE, named 'abilityList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerAbilityList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAbilityTypeCode(), AbilityDbm.getInstance().columnAbilityTypeCode());
        return cri("FK_ABILITY_ABILITY_TYPE", "abilityList", this, AbilityDbm.getInstance(), mp, false, "abilityType");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.AbilityType"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.AbilityTypeCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.AbilityTypeBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<AbilityType> getEntityType() { return AbilityType.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public AbilityType newEntity() { return new AbilityType(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((AbilityType)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((AbilityType)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
