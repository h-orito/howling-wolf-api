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
 * The DB meta of VILLAGE_SETTING. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VillageSettingDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VillageSettingDbm _instance = new VillageSettingDbm();
    private VillageSettingDbm() {}
    public static VillageSettingDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((VillageSetting)et).getVillageId(), (et, vl) -> ((VillageSetting)et).setVillageId(cti(vl)), "villageId");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getVillageSettingItemCode(), (et, vl) -> {
            CDef.VillageSettingItem cls = (CDef.VillageSettingItem)gcls(et, columnVillageSettingItemCode(), vl);
            if (cls != null) {
                ((VillageSetting)et).setVillageSettingItemCodeAsVillageSettingItem(cls);
            } else {
                ((VillageSetting)et).mynativeMappingVillageSettingItemCode((String)vl);
            }
        }, "villageSettingItemCode");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getVillageSettingText(), (et, vl) -> ((VillageSetting)et).setVillageSettingText((String)vl), "villageSettingText");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getRegisterDatetime(), (et, vl) -> ((VillageSetting)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getRegisterTrace(), (et, vl) -> ((VillageSetting)et).setRegisterTrace((String)vl), "registerTrace");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getUpdateDatetime(), (et, vl) -> ((VillageSetting)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((VillageSetting)et).getUpdateTrace(), (et, vl) -> ((VillageSetting)et).setUpdateTrace((String)vl), "updateTrace");
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
        setupEfpg(_efpgMap, et -> ((VillageSetting)et).getVillage(), (et, vl) -> ((VillageSetting)et).setVillage((OptionalEntity<Village>)vl), "village");
        setupEfpg(_efpgMap, et -> ((VillageSetting)et).getVillageSettingItem(), (et, vl) -> ((VillageSetting)et).setVillageSettingItem((OptionalEntity<VillageSettingItem>)vl), "villageSettingItem");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VILLAGE_SETTING";
    protected final String _tableDispName = "VILLAGE_SETTING";
    protected final String _tablePropertyName = "villageSetting";
    protected final TableSqlName _tableSqlName = new TableSqlName("VILLAGE_SETTING", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVillageId = cci("VILLAGE_ID", "VILLAGE_ID", null, null, Integer.class, "villageId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "village", null, null, false);
    protected final ColumnInfo _columnVillageSettingItemCode = cci("VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", null, null, String.class, "villageSettingItemCode", null, true, false, true, "VARCHAR", 100, 0, null, null, false, null, null, "villageSettingItem", null, CDef.DefMeta.VillageSettingItem, false);
    protected final ColumnInfo _columnVillageSettingText = cci("VILLAGE_SETTING_TEXT", "VILLAGE_SETTING_TEXT", null, null, String.class, "villageSettingText", null, false, false, false, "VARCHAR", 1000, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterTrace = cci("REGISTER_TRACE", "REGISTER_TRACE", null, null, String.class, "registerTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateTrace = cci("UPDATE_TRACE", "UPDATE_TRACE", null, null, String.class, "updateTrace", null, false, false, true, "VARCHAR", 64, 0, null, null, true, null, null, null, null, null, false);

    /**
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageId() { return _columnVillageId; }
    /**
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageSettingItemCode() { return _columnVillageSettingItemCode; }
    /**
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVillageSettingText() { return _columnVillageSettingText; }
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
        ls.add(columnVillageId());
        ls.add(columnVillageSettingItemCode());
        ls.add(columnVillageSettingText());
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
    protected UniqueInfo cpui() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnVillageId());
        ls.add(columnVillageSettingItemCode());
        return hpcpui(ls);
    }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return true; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillage() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageId(), VillageDbm.getInstance().columnVillageId());
        return cfi("FK_VILLAGE_SETTINGS_VILLAGE", "village", this, VillageDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageSettingList", false);
    }
    /**
     * VILLAGE_SETTING_ITEM by my VILLAGE_SETTING_ITEM_CODE, named 'villageSettingItem'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignVillageSettingItem() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnVillageSettingItemCode(), VillageSettingItemDbm.getInstance().columnVillageSettingItemCode());
        return cfi("FK_VILLAGE_SETTING_VILLAGE_SETTING_ITEM", "villageSettingItem", this, VillageSettingItemDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "villageSettingList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
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
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.VillageSetting"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.VillageSettingCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.VillageSettingBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VillageSetting> getEntityType() { return VillageSetting.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public VillageSetting newEntity() { return new VillageSetting(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VillageSetting)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VillageSetting)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
