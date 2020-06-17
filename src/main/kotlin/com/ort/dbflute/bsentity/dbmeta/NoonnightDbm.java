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
 * The DB meta of NOONNIGHT. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class NoonnightDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final NoonnightDbm _instance = new NoonnightDbm();
    private NoonnightDbm() {}
    public static NoonnightDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((Noonnight)et).getNoonnightCode(), (et, vl) -> {
            CDef.Noonnight cls = (CDef.Noonnight)gcls(et, columnNoonnightCode(), vl);
            if (cls != null) {
                ((Noonnight)et).setNoonnightCodeAsNoonnight(cls);
            } else {
                ((Noonnight)et).mynativeMappingNoonnightCode((String)vl);
            }
        }, "noonnightCode");
        setupEpg(_epgMap, et -> ((Noonnight)et).getNoonnightName(), (et, vl) -> ((Noonnight)et).setNoonnightName((String)vl), "noonnightName");
        setupEpg(_epgMap, et -> ((Noonnight)et).getDispOrder(), (et, vl) -> ((Noonnight)et).setDispOrder(cti(vl)), "dispOrder");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "NOONNIGHT";
    protected final String _tableDispName = "NOONNIGHT";
    protected final String _tablePropertyName = "noonnight";
    protected final TableSqlName _tableSqlName = new TableSqlName("NOONNIGHT", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnNoonnightCode = cci("NOONNIGHT_CODE", "NOONNIGHT_CODE", null, null, String.class, "noonnightCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "villageDayList", CDef.DefMeta.Noonnight, false);
    protected final ColumnInfo _columnNoonnightName = cci("NOONNIGHT_NAME", "NOONNIGHT_NAME", null, null, String.class, "noonnightName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDispOrder = cci("DISP_ORDER", "DISP_ORDER", null, null, Integer.class, "dispOrder", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);

    /**
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnNoonnightCode() { return _columnNoonnightCode; }
    /**
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnNoonnightName() { return _columnNoonnightName; }
    /**
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDispOrder() { return _columnDispOrder; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnNoonnightCode());
        ls.add(columnNoonnightName());
        ls.add(columnDispOrder());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnNoonnightCode()); }
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
     * VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageDayList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnNoonnightCode(), VillageDayDbm.getInstance().columnNoonnightCode());
        return cri("FK_VILLAGE_DAY_NOONNIGHT", "villageDayList", this, VillageDayDbm.getInstance(), mp, false, "noonnight");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.Noonnight"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.NoonnightCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.NoonnightBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Noonnight> getEntityType() { return Noonnight.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Noonnight newEntity() { return new Noonnight(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Noonnight)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Noonnight)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
