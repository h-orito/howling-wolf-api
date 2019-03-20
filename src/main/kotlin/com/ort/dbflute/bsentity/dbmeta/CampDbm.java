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
 * The DB meta of camp. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CampDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CampDbm _instance = new CampDbm();
    private CampDbm() {}
    public static CampDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Camp)et).getCampCode(), (et, vl) -> {
            CDef.Camp cls = (CDef.Camp)gcls(et, columnCampCode(), vl);
            if (cls != null) {
                ((Camp)et).setCampCodeAsCamp(cls);
            } else {
                ((Camp)et).mynativeMappingCampCode((String)vl);
            }
        }, "campCode");
        setupEpg(_epgMap, et -> ((Camp)et).getCampName(), (et, vl) -> ((Camp)et).setCampName((String)vl), "campName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "camp";
    protected final String _tableDispName = "CAMP";
    protected final String _tablePropertyName = "camp";
    protected final TableSqlName _tableSqlName = new TableSqlName("CAMP", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnCampCode = cci("CAMP_CODE", "CAMP_CODE", null, null, String.class, "campCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "skillList,villageList", CDef.DefMeta.Camp, false);
    protected final ColumnInfo _columnCampName = cci("CAMP_NAME", "CAMP_NAME", null, null, String.class, "campName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCampCode() { return _columnCampCode; }
    /**
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCampName() { return _columnCampName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnCampCode());
        ls.add(columnCampName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnCampCode()); }
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
     * SKILL by CAMP_CODE, named 'skillList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerSkillList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCampCode(), SkillDbm.getInstance().columnCampCode());
        return cri("FK_SKILL_CAMP", "skillList", this, SkillDbm.getInstance(), mp, false, "camp");
    }
    /**
     * VILLAGE by WIN_CAMP_CODE, named 'villageList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCampCode(), VillageDbm.getInstance().columnWinCampCode());
        return cri("FK_VILLAGE_CAMP", "villageList", this, VillageDbm.getInstance(), mp, false, "camp");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Camp"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.CampCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.CampBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Camp> getEntityType() { return Camp.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Camp newEntity() { return new Camp(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Camp)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Camp)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
