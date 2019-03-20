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
 * The DB meta of allowed_secret_say. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class AllowedSecretSayDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final AllowedSecretSayDbm _instance = new AllowedSecretSayDbm();
    private AllowedSecretSayDbm() {}
    public static AllowedSecretSayDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((AllowedSecretSay)et).getAllowedSecretSayCode(), (et, vl) -> {
            CDef.AllowedSecretSay cls = (CDef.AllowedSecretSay)gcls(et, columnAllowedSecretSayCode(), vl);
            if (cls != null) {
                ((AllowedSecretSay)et).setAllowedSecretSayCodeAsAllowedSecretSay(cls);
            } else {
                ((AllowedSecretSay)et).mynativeMappingAllowedSecretSayCode((String)vl);
            }
        }, "allowedSecretSayCode");
        setupEpg(_epgMap, et -> ((AllowedSecretSay)et).getAllowedSecretSayName(), (et, vl) -> ((AllowedSecretSay)et).setAllowedSecretSayName((String)vl), "allowedSecretSayName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "allowed_secret_say";
    protected final String _tableDispName = "ALLOWED_SECRET_SAY";
    protected final String _tablePropertyName = "allowedSecretSay";
    protected final TableSqlName _tableSqlName = new TableSqlName("ALLOWED_SECRET_SAY", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnAllowedSecretSayCode = cci("ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", null, null, String.class, "allowedSecretSayCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "villageSettingsList", CDef.DefMeta.AllowedSecretSay, false);
    protected final ColumnInfo _columnAllowedSecretSayName = cci("ALLOWED_SECRET_SAY_NAME", "ALLOWED_SECRET_SAY_NAME", null, null, String.class, "allowedSecretSayName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAllowedSecretSayCode() { return _columnAllowedSecretSayCode; }
    /**
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAllowedSecretSayName() { return _columnAllowedSecretSayName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnAllowedSecretSayCode());
        ls.add(columnAllowedSecretSayName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnAllowedSecretSayCode()); }
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
     * VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageSettingsList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAllowedSecretSayCode(), VillageSettingsDbm.getInstance().columnAllowedSecretSayCode());
        return cri("FK_VILLAGE_SETTINGS_ALLOWED_SECRET_SAY", "villageSettingsList", this, VillageSettingsDbm.getInstance(), mp, false, "allowedSecretSay");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.AllowedSecretSay"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.AllowedSecretSayCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.AllowedSecretSayBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<AllowedSecretSay> getEntityType() { return AllowedSecretSay.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public AllowedSecretSay newEntity() { return new AllowedSecretSay(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((AllowedSecretSay)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((AllowedSecretSay)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
