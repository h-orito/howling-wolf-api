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
 * The DB meta of VILLAGE_SETTING_ITEM. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VillageSettingItemDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VillageSettingItemDbm _instance = new VillageSettingItemDbm();
    private VillageSettingItemDbm() {}
    public static VillageSettingItemDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VillageSettingItem)et).getVillageSettingItemCode(), (et, vl) -> {
            CDef.VillageSettingItem cls = (CDef.VillageSettingItem)gcls(et, columnVillageSettingItemCode(), vl);
            if (cls != null) {
                ((VillageSettingItem)et).setVillageSettingItemCodeAsVillageSettingItem(cls);
            } else {
                ((VillageSettingItem)et).mynativeMappingVillageSettingItemCode((String)vl);
            }
        }, "villageSettingItemCode");
        setupEpg(_epgMap, et -> ((VillageSettingItem)et).getVillageSettingItemName(), (et, vl) -> ((VillageSettingItem)et).setVillageSettingItemName((String)vl), "villageSettingItemName");
        setupEpg(_epgMap, et -> ((VillageSettingItem)et).getDispOrder(), (et, vl) -> ((VillageSettingItem)et).setDispOrder(cti(vl)), "dispOrder");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VILLAGE_SETTING_ITEM";
    protected final String _tableDispName = "VILLAGE_SETTING_ITEM";
    protected final String _tablePropertyName = "villageSettingItem";
    protected final TableSqlName _tableSqlName = new TableSqlName("VILLAGE_SETTING_ITEM", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageSettingItemCode = cci("VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", null, null, String.class, "villageSettingItemCode", null, true, false, true, "VARCHAR", 100, 0, null, null, false, null, null, null, "villageSettingList", CDef.DefMeta.VillageSettingItem, false);
    protected final ColumnInfo _columnVillageSettingItemName = cci("VILLAGE_SETTING_ITEM_NAME", "VILLAGE_SETTING_ITEM_NAME", null, null, String.class, "villageSettingItemName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDispOrder = cci("DISP_ORDER", "DISP_ORDER", null, null, Integer.class, "dispOrder", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);

    /**
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageSettingItemCode() { return _columnVillageSettingItemCode; }
    /**
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageSettingItemName() { return _columnVillageSettingItemName; }
    /**
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDispOrder() { return _columnDispOrder; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnVillageSettingItemCode());
        ls.add(columnVillageSettingItemName());
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
    protected UniqueInfo cpui() { return hpcpui(columnVillageSettingItemCode()); }
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
     * VILLAGE_SETTING by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerVillageSettingList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageSettingItemCode(), VillageSettingDbm.getInstance().columnVillageSettingItemCode());
        return cri("FK_VILLAGE_SETTING_VILLAGE_SETTING_ITEM", "villageSettingList", this, VillageSettingDbm.getInstance(), mp, false, "villageSettingItem");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.VillageSettingItem"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VillageSettingItemCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VillageSettingItemBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VillageSettingItem> getEntityType() { return VillageSettingItem.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VillageSettingItem newEntity() { return new VillageSettingItem(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VillageSettingItem)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VillageSettingItem)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
